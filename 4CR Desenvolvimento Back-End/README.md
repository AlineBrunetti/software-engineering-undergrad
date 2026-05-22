# Desenvolvimento Back-end (DSWM II)
## Clonar projetos
1. Ativa o Wamp
2. No projeto o qual quer clonar, vai no arquivo .env e verifica o nome do banco de dados
3. Vai em phpmyadmin e cria um banco de dados com o mesmo nome
4. Com a pasta do projetoClone aberta no CMD rode
   ```CMD
   composer install
   npm install
   npm run dev
   ```
   Se der erro, tente entrar no CMD como administrador
   ou
   Entregue permissão para edição da pasta pelo CMD
   ```CMD
   icacls "C:\Caminho\da\Pasta" /grant Todos:(OI)(CI)F /T /C
   ```
6. Abra a pasta do projetoClone no VSCode para rodas as migrations e seeders
   ```bash
   php artisan migrate:fresh
   php artisan migrate:fresh --seed
   ```
   ou
   ```bash
   php artisan migrate
   php artisan db:seed
   ```
7. Crie a chave de criptografia da aplicação
   ```bash
   php artisan key:generate
   ```
9. Se necessário, retire o .exemple do arquivo .env
   
