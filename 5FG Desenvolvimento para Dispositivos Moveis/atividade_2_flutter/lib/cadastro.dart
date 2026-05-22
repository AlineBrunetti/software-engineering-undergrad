import 'package:flutter/material.dart';
import 'confirmacao.dart';

class CadastroScreen extends StatefulWidget {
  const CadastroScreen({super.key});

  @override
  State<CadastroScreen> createState() => _CadastroScreenState();
}

class _CadastroScreenState extends State<CadastroScreen> {
  final _nome = TextEditingController();
  final _idade = TextEditingController();
  final _email = TextEditingController();
  String? _sexo;
  bool _termos = false;

  void _cadastrar() {
    if (_nome.text.trim().isEmpty) return _erro('Nome não pode ser vazio');

    final idade = int.tryParse(_idade.text);
    if (idade == null || idade < 18) return _erro('Idade deve ser número e >= 18');

    if (_email.text.isEmpty || !_email.text.contains('@') || !_email.text.contains('.')) return _erro('Email inválido');

    if (_sexo == null) return _erro('Selecione um sexo');

    if (!_termos) return _erro('Aceite os termos de uso');

    Navigator.push(context, MaterialPageRoute(
        builder: (_) => ConfirmacaoScreen(
            nome: _nome.text,
            idade: idade,
            email: _email.text,
            sexo: _sexo!,
            termos: _termos
        )
    ));
  }

  void _erro(String msg) {
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(msg)));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey[100],
      appBar: AppBar(title: const Text('Cadastro de Usuário')),
      body: Center(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text('Preencha os campos abaixo', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 20),

              TextField(
                controller: _nome,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(hintText: 'Nome', border: OutlineInputBorder(borderRadius: BorderRadius.circular(8))),
              ),
              const SizedBox(height: 10),

              TextField(
                controller: _idade,
                keyboardType: TextInputType.number,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(hintText: 'Idade', border: OutlineInputBorder(borderRadius: BorderRadius.circular(8))),
              ),
              const SizedBox(height: 10),

              TextField(
                controller: _email,
                keyboardType: TextInputType.emailAddress,
                textInputAction: TextInputAction.done,
                decoration: InputDecoration(hintText: 'Email', border: OutlineInputBorder(borderRadius: BorderRadius.circular(8))),
              ),
              const SizedBox(height: 10),

              DropdownButtonFormField<String>(
                decoration: InputDecoration(labelText: 'Sexo', border: OutlineInputBorder(borderRadius: BorderRadius.circular(8))),
                value: _sexo,
                items: ['Masculino', 'Feminino', 'Outro'].map((s) => DropdownMenuItem(value: s, child: Text(s))).toList(),
                onChanged: (val) => setState(() => _sexo = val),
              ),
              const SizedBox(height: 10),

              Row(
                children: [
                  Checkbox(value: _termos, onChanged: (val) => setState(() => _termos = val ?? false)),
                  const Text('Aceito os termos de uso'),
                ],
              ),
              const SizedBox(height: 20),

              ElevatedButton(
                style: ElevatedButton.styleFrom(backgroundColor: Colors.blue, foregroundColor: Colors.white),
                onPressed: _cadastrar,
                child: const Text('Cadastrar'),
              )
            ],
          ),
        ),
      ),
    );
  }
}