# Serviço de Auditoria de DLQ (Dead Letter Queue)

Este projeto é um serviço independente criado para consumir mensagens que falharam no processamento e foram parar na DLQ do AWS SQS. O objetivo dele é "pescar" essas mensagens, fazer uma triagem para ver a gravidade do problema e salvar no banco de dados para auditoria.

## Decisão Arquitetural (Justificativa)

Para estruturar esse serviço, optei por usar a **Arquitetura em Camadas**, separando bem as responsabilidades do código. O projeto ficou dividido assim:

- **`consumer`**: É a porta de entrada. Fica só escutando a fila da AWS. Ele não tem nenhuma lógica de negócio, só pega a mensagem e passa para a frente.
- **`service`**: É o coração da aplicação. Aqui fica a regra de negócio que calcula a severidade do erro.
- **`model` e `dto`**: As classes que representam os dados puros (o que vem do JSON e o que vai para a tabela).
- **`repository`**: A interface que conversa direto com o banco de dados.

**Por que eu organizei o projeto dessa forma?**
O foco foi o **desacoplamento**. Ao isolar a regra de negócio (triagem) da parte de infraestrutura (AWS SQS e Banco de Dados), o código fica muito mais limpo e fácil de dar manutenção. Se amanhã o projeto precisar trocar a fila da AWS por um RabbitMQ, ou o banco H2 por um Postgres, a regra de cálculo de severidade continua intacta e não precisa ser reescrita. Além disso, essa separação facilita muito a criação de testes unitários no futuro.

## Regra de Negócio (Triagem)

O serviço não salva o erro no banco de qualquer jeito. Antes de persistir, ele lê a lista de `orderItems` do JSON, soma a quantidade total de produtos e define o nível de alerta:

- **HIGH:** Se o erro envolver mais de 100 itens.
- **MEDIUM:** Se envolver entre 50 e 100 itens (inclusive).
- **LOW:** Se for um erro menor, com menos de 50 itens.

## Como rodar o projeto na sua máquina

1. Clone este repositório.
2. Como medida de segurança, o projeto não possui as chaves da AWS "chumbadas" no código. Você precisa configurar as seguintes variáveis de ambiente na sua IDE:
   - `AWS_ACCESS_KEY`
   - `AWS_SECRET_KEY`
3. Dê o run na classe principal `DlqServiceApplication`.
4. O console do banco de dados vai ficar acessível em `http://localhost:8080/h2-console` usando a URL `jdbc:h2:mem:auditdb` e o usuário `sa` (deixe a senha em branco).

## Evidências de Funcionamento

- **Print 1:** Console do Java interceptando a mensagem do SQS.
![alt text](<Prints_de_Funcionamento/Captura de tela 2026-05-21 164855.png>)

- **Print 2:** Banco de dados H2 comprovando que a mensagem foi persistida com os campos exigidos.
![alt text](<Prints_de_Funcionamento/Captura de tela 2026-05-21 165022.png>)