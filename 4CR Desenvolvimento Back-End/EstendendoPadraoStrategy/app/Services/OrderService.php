<?php

// app/Services/OrderService.php
namespace App\Services;

use App\Discount\DiscountContext;
use App\Discount\Strategies\FixedDiscount;
use App\Discount\Strategies\PercentageDiscount;
use App\Discount\Strategies\VipDiscount;
use App\Discount\Strategies\SeasonalDiscount;
use App\Discount\DiscountStrategy;
use InvalidArgumentException;

class OrderService
{
    protected DiscountContext $discountContext;

    public function __construct(DiscountContext $discountContext)
    {
        $this->discountContext = $discountContext;
    }

    public function processOrder(float $orderAmount, string $discountType): array
    {
        $strategy = $this->getStrategyInstance($discountType);
        $this->discountContext->setStrategy($strategy);
        $discountAmount = $this->discountContext->calculateDiscount($orderAmount);
        $finalAmount = $orderAmount - $discountAmount;

        return [
            'original_amount' => $orderAmount,
            'discount_type'   => $discountType,
            'discount_amount' => round($discountAmount, 2),
            'final_amount'    => round($finalAmount, 2),
        ];
    }

    /**
     * Mapeia o tipo de string para a Strategy concreta
     * @throws \InvalidArgumentException
     */
    private function getStrategyInstance(string $type): DiscountStrategy
    {
        return match (strtolower($type)) {
            'fixed'      => new FixedDiscount(),
            'percentage' => new PercentageDiscount(),
            'vip'        => new VipDiscount(),
            'seasonal'   => new SeasonalDiscount(),
            default      => throw new InvalidArgumentException("Tipo de desconto inválido."),
        };
    }
}