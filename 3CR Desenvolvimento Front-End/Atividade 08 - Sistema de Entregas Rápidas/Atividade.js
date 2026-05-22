// Lista de entregas
const entregas = [
  { id: 1, cliente: "João Silva", endereco: "Rua A, 123", status: "pendente" },
  { id: 2, cliente: "Maria Oliveira", endereco: "Av. B, 456", status: "pendente" },
  { id: 3, cliente: "Carlos Souza", endereco: "Rua C, 789", status: "pendente" }
];

// Função para simular busca no "banco de dados"
function buscarEntregas() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(entregas);
    }, 1000); // Simula 1 segundo de busca
  });
}

// Função para atualizar o status de uma entrega após 3 segundos
function atualizarStatus(entregaId) {
  setTimeout(() => {
    const entrega = entregas.find(e => e.id === entregaId);
    if (entrega) {
      entrega.status = "entregue";
      console.log("\nEntrega atualizada:");
      console.log(entrega);
    } else {
      console.log(`Entrega com ID ${entregaId} não encontrada.`);
    }
  }, 3000);
}

// Execução principal
buscarEntregas().then((dados) => {
  console.log("Lista de entregas:");
  console.table(dados); // Mostra em forma de tabela
  atualizarStatus(2); // Atualiza a entrega de ID 2 após 3 segundos
});
