const inputNome = document.getElementById('nomeUsuario');
const saudacao = document.getElementById('saudacao');
const botaoCurtir = document.getElementById('likeButton');
const contadorSpan = document.getElementById('contador');

let contador = 0;
let nomeAtual = '';

// Evento de digitação no campo de nome
inputNome.addEventListener('keydown', function(event) {
  console.log(`Tecla pressionada: ${event.key}`);
});

// Evento para atualizar o nome em tempo real
inputNome.addEventListener('input', function(event) {
  nomeAtual = event.target.value;
  saudacao.innerText = nomeAtual ? `Olá, ${nomeAtual}!` : 'Olá! Digite seu nome acima 👆';
});

// Evento de clique no botão
botaoCurtir.addEventListener('click', function() {
  contador++;
  contadorSpan.innerText = contador;
  if (nomeAtual) {
    saudacao.innerText = `Obrigado pelo like, ${nomeAtual}! ❤️`;
  } else {
    saudacao.innerText = 'Por favor, digite seu nome para personalizar a saudação!';
  }
});

// Evento de mouseover
botaoCurtir.addEventListener('mouseover', function() {
  console.log("Mouse sobre o botão de curtir");
});
