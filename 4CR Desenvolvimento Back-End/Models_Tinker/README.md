# Guia Aula
Sempre ativamos o Wamp e criamos o banco de dados utilizado no projeto à ser clonado.
## Clonando o repositório do professor
Entrar no repositório do professor:
```
https://github.com/giovanegalvao-tech/mao-na-massa/tree/main/backend/aula_04_modelos/projeto?authuser=0
```

No CMD, criar uma pasta, abrir nela e executar:
```bash
git clone https://github.com/giovanegalvao-tech/mao-na-massa.git
```

Abrir no VS Code:
```
C:\Users\Aluno\Desktop\aula\mao-na-massa\backend\aula_04_modelos\projeto
```

No terminal, instalar dependências:
```bash
composer install
```

Se der erro de PHP, abrir o `php.ini` e remover o `;` da linha do `zip`.

---

## Criando um Model
```bash
php artisan make:model Carro
```

---

## Criando um Produto no Tinker
```bash
php artisan tinker
```
```php
$produto = new App\Models\Produto();
$produto->nome = 'Cadeira Gamer';
$produto->descricao = 'Cadeira ergonômica para longas horas de jogo.';
$produto->preco = 899.90;
$produto->quantidade_estoque = 30;
$produto->save();
```

Se ocorrer erro `Illuminate\Database\QueryException`:
1. Criar o banco de dados no **phpMyAdmin**.
2. No arquivo `.env.example`, remover o `.example`, configurar a conexão do banco.

Repetir o processo acima para salvar o produto.

---

## Listar todos os produtos
```bash
php artisan tinker
```
```php
$todosProdutos = App\Models\Produto::all();
```
**Resultado esperado:**
```php
Illuminate\Database\Eloquent\Collection {
    all: [
      App\Models\Produto {
        id: 1,
        nome: "Teclado Mecânico",
        descricao: "Teclado RGB com switches azuis.",
        preco: "350.00",
        quantidade_estoque: 50,
        created_at: "2025-08-11 22:28:52",
        updated_at: "2025-08-11 22:28:52",
      },
      App\Models\Produto {
        id: 2,
        nome: "Mouse Gamer",
        descricao: "Mouse com alta precisão e botões programáveis.",
        preco: "120.00",
        quantidade_estoque: 120,
        created_at: "2025-08-11 22:28:52",
        updated_at: "2025-08-11 22:28:52",
      },
    ],
}
```

---

## Atualizar produto
```php
$produtoAtualizado = App\Models\Produto::find(1);
$produtoAtualizado->preco = 99.90;
$produtoAtualizado->save();
```

---

## Deletar produto
```php
$produtoDeletado = App\Models\Produto::find(1);
$produtoDeletado->delete();
$produtoDeletado = App\Models\Produto::find(1); // null
```

---

## Buscar produto específico
```php
$giovano = App\Models\Produto::where('nome', 'Mouse Gamer')->first();
```

---

## Order By e filtro
```php
$estoque = App\Models\Produto::where('quantidade_estoque', '>', '50')
            ->orderBy('preco', 'desc')
            ->get();
```
