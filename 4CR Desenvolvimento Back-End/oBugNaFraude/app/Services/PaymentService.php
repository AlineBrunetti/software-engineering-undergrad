<?php

namespace App\Services;

use App\Repositories\Contracts\PaymentRepositoryInterface;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Str;

class PaymentService
{
    protected $paymentRepository;

    public function __construct(PaymentRepositoryInterface $paymentRepository)
    {
        $this->paymentRepository = $paymentRepository;
    }

    
    public function processTransaction(array $data): array
    {
        
        $fraudResponse = Http::post('https://api.fraudedetect.falsa/detect', [
            'amount' => $data['amount'],
            'card_number' => $data['card_number'],
        ]);

        if ($fraudResponse->successful() && $fraudResponse->json('is_fraudulent') === true) {
            return [
                'status' => 'recusado',
                'message' => 'Transação recusada por suspeita de fraude.'
            ];
        }

        
        $apiResponse = Http::post('https://api.pagamentos.falsa/process', [
            'amount' => $data['amount'],
            'card' => $data['card_number'],
        ]);

        $status = $apiResponse->successful() ? 'aprovado' : 'recusado'; 

        
        $paymentData = [
            'amount' => $data['amount'], 
            'card_number' => Str::substr($data['card_number'], -4), 
            'status' => $status, 
        ];

        
        $payment = $this->paymentRepository->create($paymentData); 

        return [
            'message' => 'Transação processada com sucesso.', 
            'status' => $status, 
            'payment_id' => $payment->id 
        ];
    }
}