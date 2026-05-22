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
        Schema::create('tarefas', function(Blueprint $table){
            $table->id();
            $table->foreignId('projeto_id')->constrained('projetos');
            $table->string('titulo',150);
            $table->text('descricao')->nullable();
            $table->string('prioridade',20)->default('baixa');
            $table->string('status',50)->default('a fazer');
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
