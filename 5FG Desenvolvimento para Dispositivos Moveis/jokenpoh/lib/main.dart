import 'package:atividade1/SelecionarPage.dart';
import 'package:flutter/material.dart';

import 'ResultadoPage.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Selecionar',
      theme: ThemeData(
        appBarTheme: const AppBarTheme(
          backgroundColor: Colors.red,
          foregroundColor: Colors.white,
        )
      ),
      home: const SelecionarPage (title: 'Pedra, Papel, Tesoura'),
    );
  }
}
