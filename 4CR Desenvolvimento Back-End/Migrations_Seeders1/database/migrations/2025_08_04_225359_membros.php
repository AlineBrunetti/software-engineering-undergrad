<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('membros', function(Blueprint $table){
            $table->id();
            $table->foreignId('equipes_id')->constrained('equipes');
            $table->string('nome',100);
            $table->string('email',150)->unique();
            $table->string('cargo',50);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        //
    }
};
