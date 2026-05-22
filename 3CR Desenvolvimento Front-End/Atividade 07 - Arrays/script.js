// Exercício 1: Soma de todos os elementos do array
function somarArray(numeros) {
  return numeros.reduce((soma, numero) => soma + numero, 0);
}
// Exemplo:
console.log(somarArray([1, 2, 3, 4])); // Saída: 10

// Exercício 2: Converter todas as strings para maiúsculas
function paraMaiusculas(array) {
  return array.map(str => str.toUpperCase());
}
// Exemplo:
console.log(paraMaiusculas(["olá", "mundo"])); // Saída: ["OLÁ", "MUNDO"]

// Exercício 3: Adicionar item ao final do array
function adicionarItem(array, item) {
  array.push(item);
  return array;
}
// Exemplo:
console.log(adicionarItem([1, 2], 3)); // Saída: [1, 2, 3]

// Exercício 4: Remover o primeiro elemento do array
function removerPrimeiro(array) {
  array.shift();
  return array;
}
// Exemplo:
console.log(removerPrimeiro([10, 20, 30])); // Saída: [20, 30]

// Exercício 5: Filtrar números pares do array
function filtrarPares(array) {
  return array.filter(num => num % 2 === 0);
}
// Exemplo:
console.log(filtrarPares([1, 2, 3, 4, 5, 6])); // Saída: [2, 4, 6]

// Exercício 6: Contar palavras com mais de 5 letras
function contarPalavrasLongas(array) {
  return array.filter(palavra => palavra.length > 5).length;
}
// Exemplo:
console.log(contarPalavrasLongas(["casa", "computador", "sol", "universidade"])); // Saída: 2

// Exercício 7: Retornar o maior número do array
function maiorNumero(array) {
  return Math.max(...array);
}
// Exemplo:
console.log(maiorNumero([10, 20, 5, 80])); // Saída: 80

// Exercício 8: Juntar nomes em uma string separada por vírgulas
function juntarNomes(array) {
  return array.join(", ");
}
// Exemplo:
console.log(juntarNomes(["Ana", "Bruno", "Carlos"])); // Saída: "Ana, Bruno, Carlos"

// Exercício 9: Retornar array em ordem reversa
function inverterArray(array) {
  return [...array].reverse();
}
// Exemplo:
console.log(inverterArray([1, 2, 3])); // Saída: [3, 2, 1]

// Exercício 10: Retornar array com quadrados dos números
function quadrados(array) {
  return array.map(num => num * num);
}
// Exemplo:
console.log(quadrados([2, 3, 4])); // Saída: [4, 9, 16]
