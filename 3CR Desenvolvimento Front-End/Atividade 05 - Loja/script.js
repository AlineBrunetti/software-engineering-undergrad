window.onload = function () {
    let saldo = 200.00;
    let carrinho = [];
    let totalCompra = 0;
  
    // Função para adicionar produtos ao carrinho
    window.adicionarProduto = function () {
      const select = document.getElementById("produto");
      const valor = parseFloat(select.value);
      const texto = select.options[select.selectedIndex].text;
  
      carrinho.push(valor);
      totalCompra += valor;
  
      // Adiciona o item à lista do carrinho na tela
      const item = document.createElement("li");
      item.textContent = texto;
      document.getElementById("carrinho").appendChild(item);
  
      // Atualiza o total da compra na tela
      document.getElementById("total").textContent = totalCompra.toFixed(2);
      document.getElementById("mensagem").textContent = "";
    };
  
    // Função para finalizar a compra
    window.finalizarCompra = function () {
      const mensagem = document.getElementById("mensagem");
  
      // Verifica se o saldo é suficiente para a compra
      const podeComprar = totalCompra <= saldo;
  
      // Exibe a mensagem de sucesso ou erro
      mensagem.textContent = podeComprar
        ? `Compra realizada com sucesso! Saldo restante: R$${(saldo - totalCompra).toFixed(2)}`
        : `Saldo insuficiente! Total da compra: R$${totalCompra.toFixed(2)} | Saldo disponível: R$${saldo.toFixed(2)}`;
  
      mensagem.className = podeComprar ? "success" : "error";
  
      // Se a compra for realizada, atualiza o saldo e limpa o carrinho
      if (podeComprar) {
        saldo -= totalCompra;
        document.getElementById("saldo").textContent = saldo.toFixed(2);
        carrinho = [];
        totalCompra = 0;
        document.getElementById("carrinho").innerHTML = "";
        document.getElementById("total").textContent = "0.00";
      }
    };
  };
  