<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TarefaController;

Route::resource('tarefas', TarefaController::class);

Route::get('/', function () {
    return view('welcome');
});
