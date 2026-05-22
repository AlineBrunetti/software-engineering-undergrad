# Guia aula

1. clona o git do prof - atividade 5
2. cria banco, migrate, seed, bla bla bla

3. Breeze
    - Criando breeze - baixou a dependencia do breeze do composer
      ```bash
      composer require laravel/breeze --dev
      ```
    - Instalando breeze
      ```bash
      php artisan breeze:install blade
      ```
      abre a pasta com cmd como adm e roda
      ```cmd
      npm install
      npm run dev
      ```
      atualiza as migrate e seed
  
4. Middleware
    -  caminhos
        ```bash
        C:\Users\Alunos\Desktop\Nova pasta\mao-na-massa\backend\aula_05_validacao\projeto\app\Http\Middleware
        C:\Users\Alunos\Desktop\Nova pasta\mao-na-massa\backend\aula_05_validacao\projeto\app\Http\Controllers\Auth
        C:\Users\Alunos\Desktop\Nova pasta\mao-na-massa\backend\aula_05_validacao\projeto\routes\auth
        ```
    - vamos testar
        ```bash
        php artisan key:generate
        php artisan serve
        ```
      no navegador
        ```bash
        http://127.0.0.1:8000/register
        http://127.0.0.1:8000/dashboard
        http://127.0.0.1:8000/login
        ```
5. Adicionando rota
     - vamos no arquivo web.php
         ```bash
        Route::get('/apenas-convidado', function(){
        return 'Esta pagina é apenas para visitantes';
        })->middleware('guest');//ou auth
        ```
     - no navegador
       ```bash
        http://127.0.0.1:8000/apenas-convidado
        ```

6. Atividade
     - abrir o projeto
     - baixar o breeze
     - estilizar o login
       
7. OBS
     - npm run dev → sobe o Vite em modo desenvolvimento (fica assistindo alterações em tempo real). Você precisa deixar esse comando aberto em uma aba do terminal enquanto usa php artisan serve.
     - npm run build → gera os arquivos otimizados em public/build/ (inclusive o manifest.json) e depois você pode fechar o Vite, só rodar php artisan serve.
