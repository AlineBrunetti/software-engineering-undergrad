# Guia de Estilização do Login (Laravel Breeze + TailwindCSS)

Este guia ensina passo a passo como estilizar o **Login** no Laravel Breeze, aplicando TailwindCSS e componentes personalizados.  

---

## 1) Defina paleta e fontes no Tailwind

### 1.1 `tailwind.config.js`

Abra `tailwind.config.js` e adicione a paleta e fonte (mantenha o resto do arquivo como está):

```js
// tailwind.config.js
export default {
  content: [
    "./resources/**/*.blade.php",
    "./resources/**/*.js",
    "./resources/**/*.vue",
  ],
  theme: {
    extend: {
      colors: {
        brand: {
          DEFAULT: "#4F46E5", // cor principal (mude se quiser)
          600: "#4F46E5",
          700: "#4338CA",
        },
      },
      fontFamily: {
        sans: ["Inter", "ui-sans-serif", "system-ui", "Segoe UI", "Roboto"],
      },
      borderRadius: {
        xl: "0.875rem",
        "2xl": "1rem",
      },
    },
  },
  plugins: [require("@tailwindcss/forms")],
}
```

---

### 1.2 `resources/css/app.css`

Substitua o conteúdo por:

```css
@tailwind base;
@tailwind components;
@tailwind utilities;

/* Fonte opcional via CDN/import */
@layer base {
  body {
    @apply bg-gray-50 text-gray-900 font-sans antialiased;
  }
}

/* Utilitários de design */
@layer components {
  .card {
    @apply bg-white/90 backdrop-blur rounded-2xl shadow-xl ring-1 ring-black/5;
  }
  .input {
    @apply block w-full rounded-xl border-gray-300 focus:border-brand focus:ring-brand;
  }
  .btn-primary {
    @apply inline-flex w-full items-center justify-center gap-2 rounded-2xl px-4 py-3
           font-semibold ring-1 ring-inset ring-brand/20
           bg-brand text-white hover:bg-brand/90 transition;
  }
  .link {
    @apply text-brand hover:underline;
  }
}
```

---

## 2) Ajuste o layout de convidado (estrutura/base do login)

### `resources/views/layouts/guest.blade.php`

Troque o conteúdo inteiro por:

```blade
<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="csrf-token" content="{{ csrf_token() }}">
    <title>{{ config('app.name', 'Laravel') }}</title>

    {{-- Fonte Inter (opcional) --}}
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">

    @vite(['resources/css/app.css', 'resources/js/app.js'])
</head>
<body class="font-sans antialiased">
    <div class="min-h-screen grid place-items-center bg-gradient-to-br from-gray-50 via-white to-gray-100 p-6">
        {{ $slot }}
    </div>
</body>
</html>
```

---

## 3) Estilize o login (página em si)

### `resources/views/auth/login.blade.php`

Substitua o conteúdo por:

```blade
<x-guest-layout>
    <div class="w-full max-w-[420px] card p-8">
        {{-- Cabeçalho com logo e título --}}
        <div class="mb-6 text-center">
            <a href="{{ url('/') }}" class="inline-flex items-center gap-3 justify-center">
                <x-application-logo class="h-10 w-10" />
                <span class="text-xl font-extrabold tracking-tight">
                    {{ config('app.name', 'Laravel') }}
                </span>
            </a>
            <p class="mt-2 text-sm text-gray-500">Acesse sua conta para continuar</p>
        </div>

        {{-- Status de sessão --}}
        <x-auth-session-status class="mb-4" :status="session('status')" />

        <form method="POST" action="{{ route('login') }}" class="space-y-5">
            @csrf

            {{-- E-mail --}}
            <div>
                <x-input-label for="email" :value="__('E-mail')" />
                <x-text-input id="email"
                    type="email"
                    name="email"
                    :value="old('email')"
                    required
                    autofocus
                    autocomplete="username"
                    class="mt-2 input" />
                <x-input-error :messages="$errors->get('email')" class="mt-2" />
            </div>

            {{-- Senha + link "Esqueceu?" --}}
            <div>
                <div class="flex items-center justify-between">
                    <x-input-label for="password" :value="__('Senha')" />
                    @if (Route::has('password.request'))
                        <a href="{{ route('password.request') }}" class="text-sm font-medium link">
                            {{ __('Esqueceu a senha?') }}
                        </a>
                    @endif
                </div>
                <x-text-input id="password"
                    type="password"
                    name="password"
                    required
                    autocomplete="current-password"
                    class="mt-2 input" />
                <x-input-error :messages="$errors->get('password')" class="mt-2" />
            </div>

            {{-- Lembrar-me --}}
            <label for="remember_me" class="flex items-center gap-2 text-sm">
                <input id="remember_me" type="checkbox"
                       class="rounded border-gray-300 text-brand focus:ring-brand"
                       name="remember">
                <span>{{ __('Manter conectado') }}</span>
            </label>

            {{-- Botão Entrar --}}
            <x-primary-button class="btn-primary">
                {{ __('Entrar') }}
            </x-primary-button>
        </form>

        {{-- Rodapé com link de registro --}}
        @if (Route::has('register'))
        <p class="mt-6 text-center text-sm text-gray-500">
            {{ __('Novo por aqui?') }}
            <a href="{{ route('register') }}" class="font-semibold link">
                {{ __('Crie sua conta') }}
            </a>
        </p>
        @endif
    </div>
</x-guest-layout>
```

---

## 4) Padronize inputs e botões nos componentes Breeze

### 4.1 `resources/views/components/text-input.blade.php`

```blade
@props(['disabled' => false])

<input {{ $disabled ? 'disabled' : '' }}
    {!! $attributes->merge(['class' => 'input']) !!} >
```

### 4.2 `resources/views/components/primary-button.blade.php`

```blade
<button {{ $attributes->merge(['class' => 'btn-primary']) }}>
    {{ $slot }}
</button>
```

### 4.3 (Opcional) `resources/views/components/input-label.blade.php`

```blade
@props(['value'])

<label {{ $attributes->merge(['class' => 'block text-sm font-medium text-gray-700']) }}>
    {{ $value ?? $slot }}
</label>
```

---

## 5) (Opcional) Personalize o logo

### `resources/views/components/application-logo.blade.php`

Exemplo em SVG minimalista:

```blade
<svg {{ $attributes->merge(['viewBox' => '0 0 24 24', 'fill' => 'none']) }}>
  <circle cx="12" cy="12" r="10" class="stroke-current" stroke-width="2"></circle>
  <path d="M7 13l3 3 7-7" class="stroke-current" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
</svg>
```

Ou usando imagem:

```blade
<img {{ $attributes->merge(['alt' => config('app.name'), 'src' => asset('images/logo.svg')]) }}>
```

Coloque seu arquivo em `public/images/logo.svg`.

---

## 6) Compile e teste

### Modo desenvolvimento (auto reload):

```bash
npm run dev
php artisan serve
# acesse http://127.0.0.1:8000/login
```

### Build estático:

```bash
npm run build
php artisan serve
```

⚠️ Se aparecer o erro do `manifest.json`, é porque você não rodou `npm run dev` ou `npm run build`.

---

## 7) Dicas rápidas de personalização

- **Cor de marca** → edite `brand` no `tailwind.config.js`.  
- **Cantos arredondados** → troque `rounded-2xl` para `rounded-xl`.  
- **Glassmorphism** → use `bg-white/70` em vez de `bg-white/90`.  
- **Sombra** → troque `shadow-xl` por `shadow-lg`.  
- **Links** → `.link` centraliza a cor e hover.
