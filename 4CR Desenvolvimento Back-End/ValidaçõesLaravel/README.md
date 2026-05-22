# O que fizemos na Aula

Analisamos os slides, foi uma aula mais teórica e menos interativa.

Sempre ativamos o Wamp e criamos o banco de dados utilizado no projeto à ser clonado.
## Clonando o repositório do professor
Entrar no repositório do professor:
```
https://github.com/giovanegalvao-tech/mao-na-massa/tree/main/backend/aula_05_validacoes/projeto?authuser=0
```

No CMD, criar uma pasta, abrir nela e executar:
```bash
git clone https://github.com/giovanegalvao-tech/mao-na-massa.git
cd C:\Users\Aluno\Desktop\Nova pasta (2)\mao-na-massa\backend\aula_05_validacao
composer install
code .
```
No VS Code:
```
php artisan migrate:fresh
php artisan migrate:fresh --seed
```

#Começando a aula
1. Abre o routes/web.php
   - Aqui ta implementada as duas primeiras operações do CRUD (Create e Ready)
   - Post processa os dados do formulario
   - Get mostra o que esta cadastrado

2. Em app\http\controllers\produtoController.php podemos observar:
   - as regras de validação conforme os campos
   - mensagens de erro customizadas (opcional)

3. Em resources\views\produtos temos as nossas paginas
   
5. Basicamente:
   - Criamos as rotas com get e post
   - Configura as rotas
   - Adiciona o controller (dentro do controller temos a implementação da validação)
   - Cria as views
   
