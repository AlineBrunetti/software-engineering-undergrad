# Guia da Aula

No CMD:
```bash
C:\Users\Alunos>composer --version
Composer version 2.8.9 2025-05-13 14:01:37
PHP version 8.3.9 (C:\php\php.exe)
Run the "diagnose" command to get more detailed diagnostics output.
```

Criar projeto:
```bash
C:\Users\Alunos>composer create-project laravel/laravel nome-do-projeto
```

Depois de instalar tudo, no CMD:
```bash
code .
```
para abrir com o VS Code.

No terminal, criar um controller:
```bash
php artisan make:controller SaudacaoController
```

Criar rota simples no `web.php`:
// rota simples
```php
Route::get('/ola', function(){
    return "Olá, Mundo do Laravel";
});
```

Rodar o servidor:
```bash
php artisan serve
```

Caminho e rota:
```
caminho: http://127.0.0.1:8000
rota: /ola
http://127.0.0.1:8000/ola
```

Criar rota com parâmetro:
```php
Route::get('/usuario/{id}', function($id){
    return 'Detalhes do Usuário ID:'.$id;
});
```

Rota para controller (ainda no `web.php`):
```php
use App\Http\Controllers\SaudacaoController;

// rota que chama um controller
Route::get('/saudacao-controller', [SaudacaoController::class, 'exibirMensagem']);
```

No `SaudacaoController`:
```php
<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class SaudacaoController extends Controller
{
    public function exibirMensagem(){
        return "Olá do Controller! Que bom te ver aqui.";
    }
}
```

Criar uma página em `resources/views`, arquivo `minha-primeira-view.blade.php`:
```html
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Minha Primeira View Laravel</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #333;
        }
        p {
            color: #666;
            font-size: 1.1em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Olá, {{$nomeUsuario}} </h1>
    </div>
</body>
</html>
```

Rota para acessar a view:
```php
// rota que retorna uma view
Route::get('/minha-view', function(){
    $nome = "Aline";
    return view('minha-primeira-view', ['nomeUsuario' => $nome]);
});
```
