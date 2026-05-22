let tentativas = 3;

function validarLogin() {
  const usuario = document.getElementById("username").value.trim();
  const senha = document.getElementById("password").value;
  const mensagem = document.getElementById("mensagem");

  if (usuario === "" || senha === "") {
    mensagem.innerHTML = "Por favor, preencha todos os campos.";
    mensagem.className = "error";
    return false;
  }

  if (tentativas <= 0) {
    mensagem.innerHTML = "Usuário bloqueado. Número de tentativas excedido.";
    mensagem.className = "error";
    return false;
  }

  if (senha === "12345") {
    mensagem.innerHTML = `Bem-vindo, ${usuario}!`;
    mensagem.className = "success";
    return false;
  } else {
    tentativas--;
    if (tentativas > 0) {
      mensagem.innerHTML = `Senha incorreta. Tente novamente. (${tentativas} tentativa(s) restante(s))`;
    } else {
      mensagem.innerHTML = "Usuário bloqueado. Número de tentativas excedido.";
    }
    mensagem.className = "error";
    return false;
  }
}

function mostrarSenha() {
  const campoSenha = document.getElementById("password");
  campoSenha.type = campoSenha.type === "password" ? "text" : "password";
}
