import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class Telalogin extends StatefulWidget {
  const Telalogin({super.key});

  @override
  State<Telalogin> createState() => _TelaloginState();
}

class _TelaloginState extends State<Telalogin> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 80,
        backgroundColor: Color(0xFFFFF159),
        title: Row(
          children: [
            Image.asset('assets/images/logo.png', height: 50,)
          ],
        ),
      ),
      body: Padding(
        padding: EdgeInsetsGeometry.all(20),
        child: Column(
          children: [
            Text('Digite seu e-mail ou telefone para iniciar a sessão',
              style: GoogleFonts.lato(
                fontSize: 23,
                fontWeight: .bold
              ),
            ),
            Row(
              children: [
                Column(
                  crossAxisAlignment: .start,
                  children: [
                    SizedBox(height: 10,),
                    Text(
                        'E-mail ou telefone'
                    ),
                    Container(
                      height: 50,
                      width: 350,
                      child: TextField(
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                        ),
                      ),
                    )
                  ],
                )
              ],
            ),
            
          ],
        ),
      )
    );
  }
}
