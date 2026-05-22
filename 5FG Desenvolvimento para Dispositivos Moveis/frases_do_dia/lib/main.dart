/*Versao Aline

import 'package:flutter/material.dart';
import 'dart:math';

void main() {
  runApp(const MaterialApp(
    debugShowCheckedModeBanner: false,
    home: FrasesDoDia(),
  ));
}
class FrasesDoDia extends StatefulWidget {
  const FrasesDoDia({super.key});

  @override
  State<FrasesDoDia> createState() => _FrasesDoDiaState();
}
class _FrasesDoDiaState extends State<FrasesDoDia> {
  final List<String> _frases = [
    "A persistência é o caminho do êxito. 🚀",
    "Não pare quando estiver cansado, pare quando tiver terminado. 🏁",
    "O sucesso é a soma de pequenos esforços repetidos dia após dia. 💧",
  ];

  String _fraseAtual = "Clique abaixo para gerar uma frase!";

  void _gerarFrase() {
    var numeroSorteado = Random().nextInt(_frases.length);

    setState(() {
      _fraseAtual = _frases[numeroSorteado];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Scaffold é a "página em branco". Ele nos dá uma barra no topo e o corpo da tela.
      appBar: AppBar(
        title: const Text('Frases do Dia'),
        backgroundColor: Colors.green, // Cor da barra no topo
      ),
      body: Container(
        // O Container é como uma caixa. Usamos para dar espaço (padding) nas bordas.
        padding: const EdgeInsets.all(16),
        width: double.infinity, // Ocupa toda a largura da tela
        child: Column(
          // Column empilha os itens verticalmente, um embaixo do outro.
          mainAxisAlignment: MainAxisAlignment.spaceEvenly, // Espalha os itens de forma igual
          crossAxisAlignment: CrossAxisAlignment.center, // Centraliza os itens horizontalmente
          children: [
            // 1º Item: Um ícone de livro
            //Image.asset('assets/images/logo.png', height: 120,),
            
            GestureDetector(
              child: Image.asset('assets/images/logo.png'),
              onDoubleTap: _gerarFrase,
            ),

            // 2º Item: O texto que vai mudar
            Text(
              _fraseAtual, // <-- Aqui passamos a variável de estado que criamos!
              textAlign: TextAlign.center,
              style: const TextStyle(fontSize: 25, fontStyle: FontStyle.italic),
            ),
            
            // 3º Item: O botão que chama a função
            ElevatedButton(
              onPressed: _gerarFrase, // <-- Passamos o nome da função (sem os parênteses)
              style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
              child: const Text('Nova Frase', style: TextStyle(color: Colors.white)),
            ),
          ],
        ),
      ),
    );
  }
}
*/
import 'dart:math';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(title: 'Frases do Dia'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String valorTela = 'Clique aqui abaixo para gerar uma frase!';

  void alterarFrase() {
    var lista = [
      "O sucesso é a soma de pequenos esforços diários.",
      "A persistência é o caminho do êxito.",
      "Aprender nunca é demais.",
      "A prática leva à perfeição.",
      "Grandes jornadas começam com um pequeno passo.",
      "A disciplina é a ponte entre metas e realizações.",
      "O conhecimento é poder.",
      "A paciência é a chave para grandes conquistas.",
      "Cada erro é uma oportunidade de aprendizado.",
      "A motivação é o que te faz começar.",
      "A constância é o que te faz continuar.",
      "O tempo é o recurso mais valioso que temos.",
      "A criatividade é a inteligência se divertindo.",
      "Sonhar grande dá o mesmo trabalho que sonhar pequeno.",
      "A gratidão transforma o que temos em suficiente.",
      "A coragem é a resistência ao medo.",
      "O foco é a arte de dizer não.",
      "A humildade é a base de toda virtude.",
      "A ação é a chave fundamental para todo sucesso.",
      "A determinação supera qualquer obstáculo.",
    ];

    setState(() {
      valorTela = lista[Random().nextInt(lista.length)];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xFF4CAF50),
        title: const Text('Frases do dia'),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              GestureDetector(
                onTap: alterarFrase,
                onLongPress: () {
                  setState(() {
                    valorTela = 'Gere novamente';
                  });
                },
                child: Image.asset('images/logo.png'),
              ),
              Text(
                valorTela,
                textAlign: TextAlign.center,
                style: const TextStyle(
                  fontSize: 25,
                  fontStyle: FontStyle.italic,
                ),
              ),
              ElevatedButton(
                onPressed: alterarFrase,
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.green,
                ),
                child: const Text(
                  'Nova frase',
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}