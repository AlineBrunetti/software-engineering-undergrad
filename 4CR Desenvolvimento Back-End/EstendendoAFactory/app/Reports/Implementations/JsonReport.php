<?php
// app/Reports/Implementations/JsonReport.php

namespace App\Reports\Implementations;

use App\Interfaces\ReportInterface;

class JsonReport implements ReportInterface
{
    /**
     * Gera o conteúdo do relatório em formato JSON.
     *
     * @param array $data Os dados para o relatório.
     * @return string O conteúdo em formato JSON.
     */
    public function generate(array $data): string
    {
        // Lógica real: formatar dados para JSON.
        // Usamos JSON_PRETTY_PRINT para que o arquivo seja legível.
        return json_encode($data, JSON_PRETTY_PRINT);
    }

    /**
     * Retorna o tipo de arquivo para o cabeçalho da resposta.
     *
     * @return string
     */
    public function getFileType(): string
    {
        return 'json';
    }
}