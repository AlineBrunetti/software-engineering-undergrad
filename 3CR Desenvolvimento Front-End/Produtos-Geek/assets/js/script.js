document.addEventListener('DOMContentLoaded', () => {
  // ======== LOGIN ========
  const formLogin = document.querySelector('form'); 
  if (formLogin) {
    formLogin.addEventListener('submit', (e) => {
      e.preventDefault();

      const usuario = document.getElementById('email').value.trim();
      const senha = document.getElementById('senha').value.trim();

      if (usuario === 'teste' && senha === '1234') {
        localStorage.setItem('logado', 'true');
        alert('Login realizado com sucesso!');
        window.location.href = 'index.html'; 
      } else {
        alert('Usuário ou senha inválidos! Use teste / 1234');
      }
    });
  }

  // ======== CONTROLE DE LINKS DO HEADER ========
  const linkCarrinho = document.getElementById('link-carrinho');
  const linkEntrar = document.querySelector('a[href="./entrar.html"]');
  const linkLogout = document.getElementById('link-logout');

  const estaLogado = localStorage.getItem('logado') === 'true';

  if (linkCarrinho) linkCarrinho.style.display = estaLogado ? 'block' : 'none';
  if (linkLogout) linkLogout.style.display = estaLogado ? 'block' : 'none';
  if (linkEntrar) linkEntrar.style.display = estaLogado ? 'none' : 'block';

  if (linkLogout) {
    linkLogout.addEventListener('click', (e) => {
      e.preventDefault();
      localStorage.removeItem('logado');
      localStorage.removeItem('carrinho'); 
      alert('Você saiu da conta.');
      window.location.href = 'index.html'; 
    });
  }

  // ======== ADICIONAR AO CARRINHO ========
  function aplicarEventosCarrinho() {
    document.querySelectorAll('.adicionar-carrinho').forEach(botao => {
      botao.addEventListener('click', () => {
        const estaLogado = localStorage.getItem('logado') === 'true';
        if (!estaLogado) {
          alert('É necessário estar logado para realizar compras.\n(Usuário: teste | Senha: 1234)');
          return;
        }

        const nome = botao.getAttribute('data-nome');
        const preco = parseFloat(botao.getAttribute('data-preco'));

        const carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
        carrinho.push({ nome, preco });
        localStorage.setItem('carrinho', JSON.stringify(carrinho));

        const aviso = document.createElement('div');
        aviso.className = 'alert alert-success mt-2';
        aviso.textContent = `${nome} adicionado ao carrinho!`;
        botao.parentElement.appendChild(aviso);
        setTimeout(() => aviso.remove(), 2000);
      });
    });
  }

  aplicarEventosCarrinho();

  // ======== ATUALIZAR CARRINHO ========
  const containerItens = document.getElementById('itens-carrinho');
  const subtotalElemento = document.getElementById('subtotal');
  const totalElemento = document.getElementById('total');
  const btnFinalizar = document.getElementById('btn-finalizar');

  if (containerItens && subtotalElemento && totalElemento && btnFinalizar) {
    function atualizarCarrinho() {
      const carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
      containerItens.innerHTML = '';
      let subtotal = 0;

      carrinho.forEach((produto, index) => {
        subtotal += produto.preco;

        const item = document.createElement('div');
        item.className = 'cart-item d-flex justify-content-between align-items-center py-3 border-bottom';

        const infoDiv = document.createElement('div');
        infoDiv.className = 'd-flex flex-column';

        const nome = document.createElement('h5');
        nome.className = 'mb-1';
        nome.textContent = produto.nome;

        infoDiv.appendChild(nome);

        const acoesDiv = document.createElement('div');
        acoesDiv.className = 'text-right';

        const preco = document.createElement('p');
        preco.className = 'mb-2';
        preco.textContent = `R$ ${produto.preco.toFixed(2)}`;

        const btnRemover = document.createElement('button');
        btnRemover.className = 'btn btn-outline-danger btn-sm';
        btnRemover.innerHTML = `<i class="fas fa-trash"></i> Remover`;
        btnRemover.setAttribute('data-index', index);

        acoesDiv.appendChild(preco);
        acoesDiv.appendChild(btnRemover);

        item.appendChild(infoDiv);
        item.appendChild(acoesDiv);

        containerItens.appendChild(item);
      });

      subtotalElemento.textContent = `R$ ${subtotal.toFixed(2)}`;
      totalElemento.textContent = `R$ ${subtotal.toFixed(2)}`;

      document.querySelectorAll('.btn-outline-danger').forEach(btn => {
        btn.addEventListener('click', () => {
          const index = parseInt(btn.getAttribute('data-index'));
          const carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
          carrinho.splice(index, 1);
          localStorage.setItem('carrinho', JSON.stringify(carrinho));
          atualizarCarrinho();
        });
      });
    }

    atualizarCarrinho();

    btnFinalizar.addEventListener('click', () => {
      const carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
      if (carrinho.length === 0) {
        alert('Seu carrinho está vazio!');
        return;
      }

      alert('Processando pagamento...');
      setTimeout(() => {
        alert('Compra finalizada com sucesso!');
        localStorage.removeItem('carrinho');
        atualizarCarrinho();
      }, 2000);
    });
  }

  // ======== FILTROS DE PRODUTOS ========
  const filtroCategoria = document.getElementById('filtroCategoria');
  const filtroPreco = document.getElementById('filtroPreco');
  const listaProdutos = document.getElementById('lista-produtos');

  if (filtroCategoria && filtroPreco && listaProdutos) {
    const produtosOriginais = Array.from(listaProdutos.querySelectorAll('.produto'));

    function filtrarProdutos() {
      const categoriaSelecionada = filtroCategoria.value;
      const ordemPreco = filtroPreco.value;

      let produtosFiltrados = produtosOriginais;

      if (categoriaSelecionada !== 'todos') {
        produtosFiltrados = produtosFiltrados.filter(produto =>
          produto.getAttribute('data-categoria') === categoriaSelecionada
        );
      }

      produtosFiltrados.sort((a, b) => {
        const precoA = parseFloat(a.getAttribute('data-preco'));
        const precoB = parseFloat(b.getAttribute('data-preco'));
        return ordemPreco === 'asc' ? precoA - precoB : precoB - precoA;
      });

      listaProdutos.innerHTML = '';
      produtosFiltrados.forEach(produto => {
        const clone = produto.cloneNode(true);
        listaProdutos.appendChild(clone);
      });

      aplicarEventosCarrinho();
    }

    filtroCategoria.addEventListener('change', filtrarProdutos);
    filtroPreco.addEventListener('change', filtrarProdutos);

    const params = new URLSearchParams(window.location.search);
    const filtroURL = params.get('categoria');
    if (filtroURL) {
      filtroCategoria.value = filtroURL;
      filtrarProdutos();
    }
  }
});
