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
      title: 'Flutter Demo',
      theme: ThemeData(colorScheme: .fromSeed(seedColor: Colors.deepPurple)),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
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
  void _alterarFrase() {
    List<String> listaFrases = [
      "A persistência é o caminho do êxito.",
      "O sucesso é a soma de pequenos esforços repetidos dia após dia.",
      "Acredite em si próprio e todo o resto virá naturalmente.",
      "Não espere por oportunidades, crie-as.",
      "O que não nos mata, nos torna mais fortes.",
      "Sua única limitação é aquela que você impõe em sua própria mente.",
      "A simplicidade é o último grau de sofisticação.",
      "O impossível é apenas uma opinião.",
      "Seja a mudança que você deseja ver no mundo.",
      "A vida é 10% o que acontece comigo e 90% como eu reajo a isso.",
      "O conhecimento é poder.",
      "Feito é melhor que perfeito.",
      "A imaginação é mais importante que o conhecimento.",
      "Grandes jornadas começam com um pequeno passo.",
      "Onde há vontade, há um caminho.",
      "A coragem não é a ausência do medo, mas o triunfo sobre ele.",
      "O tempo é o recurso mais escasso e valioso.",
      "Foque no progresso, não na perfeição.",
      "Tudo o que você sempre quis está do outro lado do medo.",
      "A disciplina é a ponte entre metas e realizações.",
      "A melhor maneira de prever o futuro é criá-lo.",
      "Erros são provas de que você está tentando.",
      "Se você cansar, aprenda a descansar, não a desistir.",
      "Trabalhe duro em silêncio, deixe seu sucesso ser o seu barulho.",
      "Sorte é o que acontece quando a preparação encontra a oportunidade.",
      "Não conte os dias, faça os dias contarem.",
      "Quem planta cortesia, colhe amizade.",
      "O segredo para progredir é começar.",
      "Mudar de opinião é sinal de inteligência.",
      "Siga seus sonhos, eles conhecem o caminho.",
      "A criatividade é a inteligência se divertindo.",
      "Nada é tão nosso quanto os nossos sonhos.",
      "Cada dia é uma nova oportunidade para ser melhor.",
      "Pense grande, comece pequeno, aprenda rápido.",
      "O otimismo é a fé em ação.",
      "Seja humilde para aprender e resiliente para vencer.",
      "A paciência é amarga, mas seu fruto é doce.",
      "O fracasso é apenas a oportunidade de começar de novo com mais inteligência.",
      "Nunca é tarde demais para ser quem você poderia ter sido.",
      "Vibre na frequência da gratidão.",
      "A ação é a chave fundamental para todo sucesso.",
      "Não deixe o barulho das opiniões alheias abafar sua voz interior.",
      "Sua atitude determina sua altitude.",
      "A alegria de fazer o bem é a única felicidade verdadeira.",
      "Nada substitui o trabalho duro.",
      "Encontre algo que você ame fazer e você nunca precisará trabalhar um dia.",
      "A vida começa onde termina sua zona de conforto.",
      "O que você faz hoje pode melhorar todos os seus amanhãs.",
      "Grandes mentes discutem ideias; mentes comuns discutem eventos.",
      "Mantenha seus olhos nas estrelas e seus pés no chão.",
    ];
    Random random = new Random();
    setState(() {
      textoTela = listaFrases[random.nextInt(listaFrases.length)];
    });
  }

  var textoTela = 'Clique abaixo para gerar uma frase!';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xFF4CAF50),
        title: Text('Frases do dia'),
      ),
      body: Padding(
        padding: EdgeInsetsGeometry.all(10),
        child: Center(
          child: Column(
            mainAxisAlignment: .spaceAround,
            children: [
              Image.asset('images/logo.png'),
              Text(
                textoTela,
                style: TextStyle(fontSize: 25, fontStyle: .italic),
              ),
              ElevatedButton(
                onPressed: _alterarFrase,
                child: Text(
                  'Nova Frase',
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.white,
                    fontWeight: .bold,
                  ),
                ),
                style: ButtonStyle(
                  backgroundColor: WidgetStatePropertyAll<Color>(
                    Color(0xFF4CAF50),
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
