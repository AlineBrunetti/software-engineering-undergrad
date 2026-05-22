<?php

namespace Tests\Feature;

use PHPUnit\Framework\Attributes\Test;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Support\Facades\Http;
use Tests\TestCase;

class PaymentProcessTest extends TestCase
{
    use RefreshDatabase;

    #[Test]
    public function it_rejects_a_fraudulent_transaction_and_does_not_save_to_database()
    {
        Http::fake([
            'https://api.fraudedetect.falsa/detect' => Http::response(['is_fraudulent' => true], 200),
            'https://api.pagamentos.falsa/*' => Http::response([], 200),
        ]);

        $data = [
            'amount' => 100.00,
            'card_number' => '1234123412341234',
            'card_holder' => 'Test Holder',
        ];

        $response = $this->postJson('/api/payments', $data);

        $response->assertStatus(200);
        $response->assertJson([
            'status' => 'recusado',
            'message' => 'Transação recusada por suspeita de fraude.'
        ]);

        $this->assertDatabaseMissing('payments', [
            'amount' => 100.00,
        ]);
    }
}