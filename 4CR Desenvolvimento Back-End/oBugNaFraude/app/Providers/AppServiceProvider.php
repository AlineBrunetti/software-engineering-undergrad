<?php

namespace App\Providers;

use Illuminate\Support\Facades\Schema;
use Illuminate\Support\ServiceProvider; 
use App\Repositories\Contracts\PaymentRepositoryInterface; 
use App\Repositories\Eloquent\EloquentPaymentRepository; 

class AppServiceProvider extends ServiceProvider 
{
    
    public function register() 
    {
        
        $this->app->bind(
            PaymentRepositoryInterface::class, 
            EloquentPaymentRepository::class 
        );
    }

    
    public function boot(): void
    {
        Schema::defaultStringLength(191); 
    }
}