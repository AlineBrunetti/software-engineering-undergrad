<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class MembroSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('membros')->insert([
            [
                'equipes_id' => 1,
                'nome' => "Vinicius",
                'email' => "vinicius@vingadores.com",
                'cargo' => "Thor",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 1,
                'nome' => "Nicolas",
                'email' => "nicolas@vingadores.com",
                'cargo' => "Capitão America",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 1,
                'nome' => "Aline",
                'email' => "aline@vingadores.com",
                'cargo' => "Stark",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 2,
                'nome' => "Alisson",
                'email' => "alisson@viloes.com",
                'cargo' => "Loki",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 2,
                'nome' => "Biel",
                'email' => "biel@viloes.com",
                'cargo' => "Ultron",
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'equipes_id' => 2,
                'nome' => "Caio",
                'email' => "caio@viloes.com",
                'cargo' => "Thanos",
                'created_at' => now(),
                'updated_at' => now(),
            ],
        ]);
    }
}
