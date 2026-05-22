Passo 1: Criar um Novo Projeto Laravel
Abra o terminal e execute:
composer create-project --prefer-dist laravel/laravel GerenciadorTarefas

Acesse o diretório do projeto:
cd GerenciadorTarefas

Inicie o servidor:
php artisan serve

Passo 2: Criar a Model e Migration

Crie a model Tarefa e sua migration correspondente:
php artisan make:model Tarefa -m

Isso criará:
• app/Models/Tarefa.php (Model)
• database/migrations/xxxx_xx_xx_xxxxxx_create_tarefas_table.php (Migration)
Edite a migration para definir os campos da tabela:
public function up()
{
Schema::create('tarefas', function (Blueprint $table) {
$table->id(); // Cria um campo ID autoincrementável
$table->string('titulo'); // Define um campo de texto para o título
$table->text('descricao')->nullable(); // Define um campo de texto que pode ser nulo
$table->timestamps(); // Cria os campos created_at e updated_at automaticamente
});
}

Execute a migration para criar a tabela no banco:
php artisan migrate

Passo 3: Criar o Controller
Crie um controller para gerenciar as tarefas:
php artisan make:controller TarefaController –resource

Isso cria o arquivo app/Http/Controllers/TarefaController.php.
Agora, implemente os métodos do CRUD no controller:
namespace App\Http\Controllers;

use App\Models\Tarefa;
use Illuminate\Http\Request;

class TarefaController extends Controller
{
public function index()
{
$tarefas = Tarefa::all();
return view('tarefas.index', compact('tarefas'));
}

public function create()
{
return view('tarefas.create');
}

public function store(Request $request)
{
$request->validate(['titulo' => 'required']);
Tarefa::create($request->all());
return redirect()->route('tarefas.index')->with('success', 'Tarefa criada com sucesso!');
}

public function show(Tarefa $tarefa)
{
return view('tarefas.show', compact('tarefa'));
}

public function edit(Tarefa $tarefa)
{
return view('tarefas.edit', compact('tarefa'));
}

public function update(Request $request, Tarefa $tarefa)
{
$request->validate(['titulo' => 'required']);
$tarefa->update($request->all());
return redirect()->route('tarefas.index')->with('success', 'Tarefa atualizada!');
}

public function destroy(Tarefa $tarefa)
{
$tarefa->delete();
return redirect()->route('tarefas.index')->with('success', 'Tarefa excluída!');
}
} }

Passo 4: Criar as Rotas
Abra o arquivo routes/web.php e adicione:
use App\Http\Controllers\TarefaController;

Route::resource('tarefas', TarefaController::class);

Isso criará automaticamente as rotas para todas as operações do CRUD.

Passo 5: Criar as Views
Criar o arquivo:
resources/views/layout.blade.php
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>@yield('title', 'Minha Aplicação')</title>
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
@yield('content')
</div>
</body>
</html>

Crie o diretório resources/views/tarefas e adicione os seguintes arquivos:
resources/views/tarefas/index.blade.php
@extends('layout')

@section('title', 'Lista de Tarefas')

@section('content')
<h1>Lista de Tarefas</h1>

<a href="{{ route('tarefas.create') }}" class="btn btn-primary mb-3">Criar Nova Tarefa</a>

<ul class="list-group">

@foreach($tarefas as $tarefa)
<li class="list-group-item d-flex justify-content-between align-items-center">
{{ $tarefa->titulo }}
<div>
<a href="{{ route('tarefas.show', $tarefa->id) }}" class="btn btn-sm btn-info">Ver</a>

<a href="{{ route('tarefas.edit', $tarefa->id) }}" class="btn btn-sm btn-
warning">Editar</a>

<form action="{{ route('tarefas.destroy', $tarefa->id) }}" method="POST"
style="display:inline;">
@csrf
@method('DELETE')
<button type="submit" class="btn btn-sm btn-danger">Excluir</button>
</form>
</div>
</li>
@endforeach
</ul>
@endsection

resources/views/tarefas/create.blade.php
@extends('layout')

@section('title', 'Criar Tarefa')

@section('content')
<h1>Criar Nova Tarefa</h1>

<form action="{{ route('tarefas.store') }}" method="POST">
@csrf
<div class="mb-3">
<label for="titulo" class="form-label">Título:</label>
<input type="text" name="titulo" id="titulo" class="form-control" required>

</div>
<button type="submit" class="btn btn-success">Salvar</button>
<a href="{{ route('tarefas.index') }}" class="btn btn-secondary">Voltar</a>
</form>
@endsection

resources/views/tarefas/edit.blade.php

@extends('layout')

@section('title', 'Editar Tarefa')

@section('content')
<h1>Editar Tarefa</h1>

<form action="{{ route('tarefas.update', $tarefa->id) }}" method="POST">
@csrf
@method('PUT')
<div class="mb-3">
<label for="titulo" class="form-label">Título:</label>
<input type="text" name="titulo" id="titulo" class="form-control" value="{{ $tarefa-
>titulo }}" required>
</div>
<button type="submit" class="btn btn-primary">Atualizar</button>
<a href="{{ route('tarefas.index') }}" class="btn btn-secondary">Cancelar</a>
</form>
@endsection

resources/views/tarefas/show.blade.php
@extends('layout')

@section('title', 'Detalhes da Tarefa')

@section('content')
<h1>Detalhes da Tarefa</h1>

<p><strong>ID:</strong> {{ $tarefa->id }}</p>
<p><strong>Título:</strong> {{ $tarefa->titulo }}</p>

<a href="{{ route('tarefas.index') }}" class="btn btn-secondary">Voltar</a>
@endsection

app/Models/Tarefa.php
namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tarefa extends Model
{
use HasFactory;

protected $fillable = ['titulo'];
}

Conclusão
Criamos um CRUD completo usando o Laravel.
Utilizamos MVC, migrations, e o ORM Eloquent.
Implementamos as rotas automáticas com Route::resource().
Criamos views dinâmicas utilizando Blade Templates.
Laravel facilita o desenvolvimento de sistemas robustos e escaláveis!
