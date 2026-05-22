<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class ProjetoSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('projetos')->insert([
            [
                'equipes_id' => 1,
                'titulo' => "Projeto Escudo Digital",
                'status' => "em andamento",
                'prazo' => "2025-08-06",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 1,
                'titulo' => "Radar do Mjölnir",
                'status' => "concluido",
                'prazo' => "2025-08-01",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 2,
                'titulo' => "Projeto Ultron Jr.",
                'status' => "pendente",
                'prazo' => "2025-08-12",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 2,
                'titulo' => "Caos de Loki",
                'status' => "em andamento",
                'prazo' => "2025-08-06",
                'created_at' => now(),
                'updated_at' => now(),
            ],
        ]);
    }
}
