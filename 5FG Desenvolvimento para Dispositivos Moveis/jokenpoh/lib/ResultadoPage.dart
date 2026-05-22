import 'package:flutter/material.dart';
import 'JogoResultado.dart';

class ResultadoPage extends StatefulWidget {
  final String title;
  final JogoResultado resultado;

  const ResultadoPage({
    super.key,
    required this.title,
    required this.resultado,
  });

  @override
  State<ResultadoPage> createState() => _ResultadoPageState();
}

class _ResultadoPageState extends State<ResultadoPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: SizedBox(
        width: double.infinity,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            const SizedBox(height: 20),
            Image.network(
              widget.resultado.imagemOponente,
              height: 120,
            ),
            const Text(
              "Escolha do APP",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 30),
            Image.network(
              widget.resultado.imagemJogador,
              height: 120,
            ),
            const Text(
              "Sua escolha",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 40),
            SizedBox(
              height: 150,
              width: 150,
              child: Image.network(
                widget.resultado.imagemStatus,
                fit: BoxFit.contain,
              ),
            ),
            Text(
              widget.resultado.resultado,
              style: const TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
              ),
            ),
            const Spacer(),
            Padding(
              padding: const EdgeInsets.only(bottom: 40),
              child: ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.red,
                  foregroundColor: Colors.white,
                  padding: const EdgeInsets.symmetric(horizontal: 40, vertical: 15),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(4),
                  ),
                ),
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text(
                  "Jogar novamente",
                  style: TextStyle(fontSize: 18),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}