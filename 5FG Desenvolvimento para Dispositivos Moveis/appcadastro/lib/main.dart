import 'package:flutter/material.dart';

void main() {
  runApp(const AppCadastro());
}

// Este é o widget raiz da sua aplicação.
// Ele configura o tema geral e diz qual é a primeira tela.
class AppCadastro extends StatelessWidget {
  const AppCadastro({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'App de Cadastro',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const TelaCadastro(), // Nossa tela que vamos criar abaixo!
    );
  }
}

class TelaCadastro extends StatefulWidget {
  const TelaCadastro({super.key});

  @override
  State<TelaCadastro> createState() => _TelaCadastroState();
}

class _TelaCadastroState extends State<TelaCadastro> {
  // ==========================================
  // 1. AQUI FICAM AS VARIÁVEIS E CONTROLADORES
  // ==========================================

  // Controladores para ler o que foi digitado nos TextFields
  final TextEditingController _nomeController = TextEditingController();
  final TextEditingController _idadeController = TextEditingController();

  // Variáveis para os outros campos
  DateTime? _dataNascimento;
  bool _aceitaTermos = false;
  bool _receberNotificacoes = false;
  String? _estadoCivil;

  final List<String> _opcoesEstadoCivil = ['Solteiro(a)', 'Casado(a)', 'Divorciado(a)', 'Viúvo(a)'];

  // ==========================================
  // 2. AQUI FICA O VISUAL (A ÁRVORE DE WIDGETS)
  // ==========================================
  @override
  Widget build(BuildContext context) {
    // Scaffold é a "tela em branco". Ele dá suporte para AppBar, Body, etc.
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mão na Massa: App de Cadastro'),
      ),
      // ListView é ótimo para formulários, pois permite rolar a tela se o teclado abrir
      body: ListView(
        padding: const EdgeInsets.all(16.0), // Dá um respiro nas bordas
        children: [

          // --- CAMPO: NOME ---
          TextField(
            controller: _nomeController,
            decoration: const InputDecoration(labelText: 'Nome'),
          ),
          const SizedBox(height: 16), // Espaçamento entre os campos

          // --- CAMPO: IDADE ---
          TextField(
            controller: _idadeController,
            keyboardType: TextInputType.number, // Abre o teclado numérico
            decoration: const InputDecoration(labelText: 'Idade'),
          ),
          const SizedBox(height: 16),

          // --- CAMPO: DATA DE NASCIMENTO ---
          // Usamos um botão que, ao ser clicado, abre o calendário
          ElevatedButton(
            onPressed: () async {
              DateTime? dataEscolhida = await showDatePicker(
                context: context,
                initialDate: DateTime.now(),
                firstDate: DateTime(1900),
                lastDate: DateTime.now(),
              );
              if (dataEscolhida != null) {
                setState(() { // setState avisa a tela para se redesenhar com a nova data
                  _dataNascimento = dataEscolhida;
                });
              }
            },
            child: Text(_dataNascimento == null
                ? 'Selecionar Data de Nascimento'
                : 'Data: ${_dataNascimento!.day}/${_dataNascimento!.month}/${_dataNascimento!.year}'),
          ),
          const SizedBox(height: 16),

          // --- CAMPO: ACEITA OS TERMOS (Checkbox) ---
          CheckboxListTile(
            title: const Text('Aceita os termos?'),
            value: _aceitaTermos,
            onChanged: (bool? valor) {
              setState(() { _aceitaTermos = valor ?? false; });
            },
          ),

          // --- CAMPO: RECEBER NOTIFICAÇÕES (Switch) ---
          SwitchListTile(
            title: const Text('Receber notificações?'),
            value: _receberNotificacoes,
            onChanged: (bool valor) {
              setState(() { _receberNotificacoes = valor; });
            },
          ),

          // --- CAMPO: ESTADO CIVIL (Dropdown) ---
          DropdownButtonFormField<String>(
            decoration: const InputDecoration(labelText: 'Estado Civil'),
            value: _estadoCivil,
            items: _opcoesEstadoCivil.map((String estado) {
              return DropdownMenuItem<String>(
                value: estado,
                child: Text(estado),
              );
            }).toList(),
            onChanged: (String? novoValor) {
              setState(() { _estadoCivil = novoValor; });
            },
          ),
          const SizedBox(height: 32),

          // --- BOTÃO: SALVAR ---
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              padding: const EdgeInsets.symmetric(vertical: 16), // Deixa o botão mais altinho
            ),
            onPressed: _validarESalvar, // Chamamos a função de validação aqui
            child: const Text('Salvar', style: TextStyle(fontSize: 18)),
          ),
        ],
      ),
    );
  }

  // ==========================================
  // 3. AQUI FICAM AS FUNÇÕES DE LÓGICA
  // ==========================================
  void _validarESalvar() {
    String nome = _nomeController.text;
    String idade = _idadeController.text;

    // Validação solicitada no desafio
    if (nome.isEmpty || idade.isEmpty) {
      // Mostra uma barrinha de erro embaixo
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Por favor, preencha nome e idade!'),
          backgroundColor: Colors.red,
        ),
      );
    } else {
      // Sucesso! Mostra o resultado na tela
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: const Text('Sucesso!'),
          content: Text('Dados salvos com sucesso.\n\nNome: $nome\nIdade: $idade\nTermos aceitos: $_aceitaTermos'),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context), // Fecha o popup
              child: const Text('OK'),
            )
          ],
        ),
      );
    }
  }
}