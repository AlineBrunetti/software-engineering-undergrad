import 'package:flutter/material.dart';

class ConfirmacaoScreen extends StatelessWidget {
  final String nome;
  final int idade;
  final String email;
  final String sexo;
  final bool termos;

  const ConfirmacaoScreen({
    super.key,
    required this.nome,
    required this.idade,
    required this.email,
    required this.sexo,
    required this.termos
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey[100],
      appBar: AppBar(title: const Text('Confirmação')),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text('Nome: $nome', style: const TextStyle(fontSize: 18)),
              Text('Idade: $idade', style: const TextStyle(fontSize: 18)),
              Text('Email: $email', style: const TextStyle(fontSize: 18)),
              Text('Sexo: $sexo', style: const TextStyle(fontSize: 18)),
              Text('Termos aceitos: ${termos ? "Sim" : "Não"}', style: const TextStyle(fontSize: 18)),

              const SizedBox(height: 30),

              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  ElevatedButton(onPressed: () => Navigator.pop(context), child: const Text('Voltar')),
                  ElevatedButton(onPressed: () => Navigator.pop(context), child: const Text('Editar')),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}