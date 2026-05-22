@extends('layout')

@section('title', 'Editar Tarefa')

@section('content')
<h1>Editar Tarefa</h1>

<form action="{{ route('tarefas.update', $tarefa->id) }}" method="POST">
    @csrf
    @method('PUT')
    <div class="mb-3">
        <label for="titulo" class="form-label">Título:</label>
        <input type="text" name="titulo" id="titulo" class="form-control" value="{{ $tarefa->titulo }}" required>
    </div>
        <div class="mb-3">
        <label for="descricao" class="form-label">Descrição:</label>
        <textarea name="descricao" id="descricao" class="form-control">{{ $tarefa->descricao }}</textarea>
    </div>

    <button type="submit" class="btn btn-primary">Atualizar</button>
    <a href="{{ route('tarefas.index') }}" class="btn btn-secondary">Cancelar</a>
</form>
@endsection