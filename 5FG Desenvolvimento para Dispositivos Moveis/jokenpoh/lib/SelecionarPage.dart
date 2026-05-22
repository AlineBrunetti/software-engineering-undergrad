import 'package:flutter/material.dart';
import 'dart:math'; // Necessário para o Random
import 'JogoResultado.dart';
import 'ResultadoPage.dart';

class SelecionarPage extends StatefulWidget {
  final String title;
  const SelecionarPage({super.key, required this.title});

  @override
  State<SelecionarPage> createState() => _SelecionarPageState();
}

class _SelecionarPageState extends State<SelecionarPage> {

  void _jogar(String imagemJogador) {
    final opcoes = ["pedra", "papel", "tesoura"];
    final numeroAleatorio = Random().nextInt(3);
    final escolhaApp = opcoes[numeroAleatorio];

    final String imagemOponente = "assets/$escolhaApp.png";

    final escolhaJogador = imagemJogador.split('/').last.split('.').first;

    String resultadoFinal;
    String imagemStatus;

    if (escolhaJogador == escolhaApp) {
      resultadoFinal = "Empatamos! 🤝";
      imagemStatus = "assets/empate.png";
    } else if (
    (escolhaJogador == "pedra" && escolhaApp == "tesoura") ||
        (escolhaJogador == "papel" && escolhaApp == "pedra") ||
        (escolhaJogador == "tesoura" && escolhaApp == "papel")
    ) {
      resultadoFinal = "Você Ganhou! 🎉";
      imagemStatus = "assets/vitoria.png";
    } else {
      resultadoFinal = "Você Perdeu! 😢";
      imagemStatus = "assets/derrota.png";
    }

    var dadosDoJogo = JogoResultado(
      imagemJogador: imagemJogador,
      imagemOponente: imagemOponente,
      resultado: resultadoFinal,
      imagemStatus: imagemStatus
    );

    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => ResultadoPage(
          title: "Pedra, Papel, Tesoura",
          resultado: dadosDoJogo,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(widget.title)),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          const SizedBox(height: 20),
          Image.network('assets/padrao.png', height: 200),
          const Text(
            "Escolha do APP",
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 80),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              _buildOpcoes("assets/pedra.png", 100),
              const SizedBox(width: 20),
              _buildOpcoes("assets/papel.png", 100),
              const SizedBox(width: 20),
              _buildOpcoes("assets/tesoura.png", 100),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildOpcoes(String image, double height) {
    return InkWell(
      onTap: () => _jogar(image),
      hoverColor: Colors.transparent,
      splashColor: Colors.transparent,
      highlightColor: Colors.transparent,
      mouseCursor: SystemMouseCursors.click,
      child: Column(
        children: [
          Image.network(image, height: height),
        ],
      ),
    );
  }
}