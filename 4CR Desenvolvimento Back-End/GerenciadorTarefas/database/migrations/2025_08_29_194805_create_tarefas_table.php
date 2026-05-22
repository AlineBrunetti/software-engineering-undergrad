<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up()
        {
        Schema::create('tarefas', function (Blueprint $table) {
        $table->id(); // Cria um campo ID autoincrementável
        $table->string('titulo'); // Define um campo de texto para o título
        $table->text('descricao')->nullable(); // Define um campo de texto que pode ser nulo
        $table->timestamps(); // Cria os campos created_at e updated_at automaticamente
        });
        }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tarefas');
    }
};
