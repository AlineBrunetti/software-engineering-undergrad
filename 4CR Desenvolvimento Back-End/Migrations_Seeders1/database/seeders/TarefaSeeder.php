<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class TarefaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('tarefas')->insert([
            [
                'projeto_id' => 1,
                'titulo' => 'Configuração do Escudo',
                'descricao' => 'Ajustar o sistema de defesa inspirado no escudo do Capitão América.',
                'prioridade' => 'alta',
                'status' => 'em andamento',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'projeto_id' => 1,
                'titulo' => 'Teste de Resistência',
                'descricao' => 'Executar testes de resistência e estabilidade do escudo digital.',
                'prioridade' => 'média',
                'status' => 'a fazer',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'projeto_id' => 2,
                'titulo' => 'Programar Radar',
                'descricao' => 'Desenvolver a lógica para identificar usuários “dignos”.',
                'prioridade' => 'alta',
                'status' => 'a fazer',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'projeto_id' => 2,
                'titulo' => 'Interface do Radar',
                'descricao' => 'Criar uma interface amigável para exibir resultados do radar Mjölnir.',
                'prioridade' => 'baixa',
                'status' => 'pendente',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'projeto_id' => 3,
                'titulo' => 'Programar Respostas Sarcásticas',
                'descricao' => 'Configurar o Ultron Jr. para responder mensagens de forma irônica.',
                'prioridade' => 'média',
                'status' => 'em andamento',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'projeto_id' => 3,
                'titulo' => 'Sistema de Interrupção',
                'descricao' => 'Implementar função para interromper conversas em momentos aleatórios.',
                'prioridade' => 'baixa',
                'status' => 'a fazer',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'projeto_id' => 4,
                'titulo' => 'Gerador de Apelidos',
                'descricao' => 'Desenvolver função para criar apelidos aleatórios para confundir usuários.',
                'prioridade' => 'alta',
                'status' => 'pendente',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'projeto_id' => 4,
                'titulo' => 'Troca de Avatares',
                'descricao' => 'Sistema que altera automaticamente imagens de perfil dos usuários rivais.',
                'prioridade' => 'média',
                'status' => 'a fazer',
                'created_at' => now(),
                'updated_at' => now(),
            ],

        ]);
    }
}
