O DIP reduz o acoplamento ao fazer com que as classes dependam de abstrações, e não de implementações concretas.
Vantagens:
Acoplamento: Reduzido, pois permite trocar implementações (ex: mudar o banco de dados) sem alterar o código que usa a abstração.
Testes: Melhorados, pois as implementações reais podem ser facilmente substituídas por mocks (versões falsas) durante o teste, facilitando o isolamento e a simulação de cenários.