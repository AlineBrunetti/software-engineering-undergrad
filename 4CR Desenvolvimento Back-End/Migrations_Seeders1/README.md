# Guia da Aula

Ativa o wamp, vai pro phpmyadmin, vai pra sql e cria um banco de dados

cria uma pasta em um lugar qualquer, entra nela pelo cmd e roda:
```bash
composer create-project laravel/laravel banco
```
abre a pasta que criou(banco) e abre com vscode:
```bash
code .
```
abre o .env e edita a parte:
```env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=laravel_bd
DB_USERNAME=root
DB_PASSWORD=
```
agora vamos criar a migration, normalmente 1 por tabela, no terminal coloca:
```bash
php artisan make:migration produto
```
isso vai criar a migration dentro de database/migrations

dentro de `public function up(): void` nós vamos criar uma tabela:
```php
public function up(): void
{
    Schema::create('produtos', function(Blueprint $table){
        $table->id();
        $table->string('nome',100);
        $table->text('descricao')->nullable();
        $table->decimal('preco',8,2);
        $table->integer('quantidade_estoque')->default(0);
        $table->timestamps();
    });
}
```
para rodar a migration, no terminal vamos rodar:
```bash
php artisan migrate
```
Em caso de erro `Illuminate\Database\QueryException` vamos no arquivo `app/Providers/AppServiceProvider.php` e colocamos:
```php
use Illuminate\Support\Facades\Schema;

public function boot(): void
{
    Schema::defaultStringLength(191);
}
```
```bash
php artisan migrate:fresh
```
Colocando dados na tabela no terminal coloca:
```bash
php artisan make:seeder ProdutoSeeder
```
no `DatabaseSeeder.php`:
```php
public function run(): void
{
    $this->call(ProdutoSeeder::class);
    User::factory()->create([
        'name' => 'Test User',
        'email' => 'test@example.com',
    ]);
}
```
no seeder que criamos colocamos:
```php
use Illuminate\Support\Facades\DB;

class ProdutoSeeder extends Seeder
{
    public function run(): void
    {
        DB::table('produtos')->insert([
            'nome' => "Mouse Gamer",
            'descricao' => "Mouse com alta precisão",
            'preco' => 120.00,
            'quantidade_estoque' => 120,
            'created_at' => now(),
            'updated_at' => now(),
        ]);
    }
}
```
e no terminal:
```bash
php artisan db:seed
```
quando vai adicionando um seeder por vez:
```bash
php artisan migrate:fresh --seed
```
para importar o arquivo zip, cria o banco no wamp, ai depois coloca o zip descompactado na pasta `www` da pasta do wamp, depois acessa o projeto laravel no cmd e roda:
```bash
composer install
php artisan migrate
php artisan db:seed
```
e se tiver seeders:
```bash
php artisan migrate:fresh --seed
```
