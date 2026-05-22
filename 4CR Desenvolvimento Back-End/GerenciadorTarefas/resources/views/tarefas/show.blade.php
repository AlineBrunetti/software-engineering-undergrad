@extends('layout')

@section('title', 'Detalhes da Tarefa')

@section('content')
<h1>Detalhes da Tarefa</h1>

<p><strong>ID:</strong> {{ $tarefa->id }}</p>
<p><strong>Título:</strong> {{ $tarefa->titulo }}</p>
<p><strong>Descrição:</strong> {{ $tarefa->descricao }}</p>
<p><strong>Status:</strong> {{ $tarefa->concluida ? 'Concluída' : 'Pendente' }}</p>


<a href="{{ route('tarefas.index') }}" class="btn btn-secondary">Voltar</a>
@endsection