# 🧠 Revisão Rápida – Validação de Dados no Laravel

---

## 📦 CRUD com Eloquent ORM

- **Create:**  
  `Model::create($dados)` ou `$model->save()`
- **Read:**  
  `Model::all()`, `Model::find()`, `Model::where()`
- **Update:**  
  `$model->update($dados)` ou `$model->save()`
- **Delete:**  
  `$model->delete()` ou `Model::destroy()`

---

## ❓ Pergunta Central

**Como garantir que os dados enviados pelos usuários são válidos, completos e seguros?**

---

## ⚠️ Riscos Sem Validação

- Dados inconsistentes/incompletos  
- Vulnerabilidades (SQL Injection, XSS)  
- Erros de processamento  
- Experiência de usuário ruim

---

## ✅ O Que é Validação de Dados?

### Objetivos:
- **Segurança:** Previne ataques como SQL Injection e XSS.
- **Integridade:** Garante consistência e formato dos dados.
- **Experiência do Usuário:** Fornece feedback claro.
- **Regras de Negócio:** Impede violações (ex: idade mínima).

---

## 🖥️ Client-Side vs. Server-Side

### Validação no Cliente (Front-End)
- Implementada com HTML5/JS  
- Rápida, melhora a UX  
- Fácil de burlar ❌

### Validação no Servidor (Back-End)
- Realizada no Controller ou Form Request  
- Não pode ser ignorada ✅  
- Essencial para segurança

---

## 🧰 Validação no Laravel

### Exemplo com `validate()`:

```php
$request->validate([
    'nome' => 'required|min:3|max:255',
    'preco' => 'required|numeric|min:0.01',
    'quantidade_estoque' => 'required|integer|min:0',
    'descricao' => 'nullable|string|max:1000',
    'email_contato' => 'sometimes|email|unique:users,email'
]);
```

---

## 🔤 Regras Comuns

### 1. Presença  
`required`, `nullable`, `sometimes`

### 2. Tamanho  
`min`, `max`, `size`

### 3. Tipo  
`string`, `integer`, `numeric`, `boolean`

### 4. Especiais  
`email`, `url`, `date`, `unique:tabela,coluna`

---

## 📝 Mensagens de Erro Personalizadas

```php
$request->validate([
    'nome' => 'required|min:3',
    'email' => 'required|email|unique:users,email'
], [
    'nome.required' => 'O campo nome é obrigatório!',
    'nome.min' => 'O nome deve ter no mínimo :min caracteres.',
    'email.unique' => 'Este e-mail já está em uso.'
]);
```

---

## 🧩 Regras Customizadas

```bash
php artisan make:rule CPFValido
```

```php
// App\Rules\CPFValido.php

public function passes($attribute, $value) {
    return $this->validarCPF($value);
}

public function message() {
    return 'O :attribute não é um CPF válido.';
}
```

### Uso no controller:

```php
$request->validate([
    'cpf' => ['required', new CPFValido]
]);
```

---

## 📄 Form Requests

```bash
php artisan make:request StoreProdutoRequest
```

```php
// App\Http\Requests\StoreProdutoRequest.php
public function rules() {
    return [
        'nome' => 'required|min:3|max:255',
        'preco' => 'required|numeric|min:0.01',
        'categoria_id' => 'required|exists:categorias,id',
    ];
}
```

```php
// Controller
public function store(StoreProdutoRequest $request) {
    Produto::create($request->validated());
}
```

✅ Benefícios: organização, reutilização e encapsulamento.

---

## 💬 Exibindo Erros na UI (Blade)

### Todos os erros:
```blade
@if ($errors->any())
    @foreach ($errors->all() as $error)
        {{ $error }}
    @endforeach
@endif
```

### Erro por campo:
```blade
@error('nome')
    {{ $message }}
@enderror
```

### Manter dados preenchidos:
```blade
<input type="text" name="nome" value="{{ old('nome') }}">
```

---

## 🔐 Segurança

- **Sempre use validação server-side**
- **Proteja seus formulários com @csrf**
- **Considere registrar falhas de validação suspeitas**

```blade
<form method="POST" action="/rota">
    @csrf
    <!-- campos -->
</form>
```

---

## 🔁 Fluxo de Validação no Laravel

1. **Formulário:** Usuário envia dados  
2. **Validação:** Controller ou Form Request  
3. **Decisão:**  
   - Válido → Processa  
   - Inválido → Retorna com erros  
4. **Processamento:** Salva no banco

---

## 📚 Próximos Passos

- **Próxima aula:** Autenticação e Autorização  
- **Tarefa:**  
  1. Escolha um formulário do seu projeto  
  2. Implemente validação para todos os campos  
  3. Exiba mensagens de erro corretamente  
  4. **Desafio:** Crie uma regra customizada

---

> **"A validação não é apenas um recurso, é uma responsabilidade. Proteja seus usuários e sua aplicação validando todos os dados de entrada."**



