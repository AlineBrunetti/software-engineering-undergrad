<?php

// app/Discount/Strategies/SeasonalDiscount.php
namespace App\Discount\Strategies;

use App\Discount\DiscountStrategy;

class SeasonalDiscount implements DiscountStrategy
{
    public function calculate(float $orderAmount): float
    {
        if ($orderAmount > 300.00) {
            return 45.00;
        }

        return 10.00;
    }
}