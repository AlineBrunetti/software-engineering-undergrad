<?php
$sujeitos = ["astronauta","criança","robô","detetive","bibliotecária","cachorro","pintor","chef","feiticeira","taxista","médico","viajante","bailarina","cientista","jornalista","mago","piloto","arqueólogo","fotógrafo","estilista","Alice","Carlos","Beatriz","Felipe","Luciana","Ricardo","Mariana","João","Fernanda","Eduardo","Sofia","Lucas","Isabela","Pedro","Gabriela","Thiago","Larissa","Rafael","Amanda","Gabriel"
];


$verbos = ["correr","saltar","pensar","voar","escrever","gritar","nadar","comer","observar","fugir","dançar","estudar","criar","ajudar","ler","trabalhar","viajar","aprender","ensinar","desenhar"
];


$objetos = ["cadeira","caneta","telefone","livro","chave","óculos","relógio","mochila","espelho","lâmpada","mesa","computador","ferramenta","janela","copo","garrafa","chaveiro","banco","pente","maçã"];


$adjetivo = ["rápido","silencioso","alegre","sombrio","forte","frágil","misterioso","lento","corajoso","brilhante","inteligente","gentil","criativo","calmo","romântico","sábio","vibrante","sincero","curioso","teimoso"
];


$linha_bonus = ["O astronauta explorou novas galáxias.","A criança perguntou sobre as estrelas.","O robô ajudou a resolver um mistério.","O detetive encontrou uma pista crucial.","A bibliotecária organizou todos os livros.","O cachorro correu pelo parque.","O pintor criou uma obra-prima.","O chef preparou um prato delicioso.","A feiticeira lançou um feitiço poderoso.","O taxista levou o passageiro até o destino.","O médico salvou uma vida com rapidez.","O viajante descobriu um novo continente.","A bailarina dançou com graça e precisão.","O cientista fez uma grande descoberta.","O jornalista relatou os eventos ao vivo.","O mago conjurou uma magia antiga.","O piloto sobreviveu a uma grande tempestade.","O arqueólogo desenterrou um tesouro perdido.","O fotógrafo capturou a beleza do pôr do sol.","A estilista apresentou sua nova coleção."
];


$sujeito_aleatorio = $sujeitos[array_rand(array:$sujeitos)];
$verbos_aleatorio = $verbos[array_rand(array:$verbos)];
$objeto_aleatorio = $objetos[array_rand(array:$objetos)];
$adjetivo_aleatorio = $adjetivo[array_rand(array:$adjetivo)];


$incluir_frase = rand(0, 1);
$linha_especial = "";


if($incluir_frase ==1){
    $linha_especial = $linha_bonus[array_rand(array: $linha_bonus)];
}


$poemas_linhas = [];


for( $i = 0; $i < 5; $i++){
    $linha_gerada =
        $sujeitos[array_rand(array:$sujeitos)]." ".
        $verbos[array_rand(array:$verbos)]." ".
        $objetos[array_rand(array:$objetos)]." ".
        $adjetivo[array_rand(array:$adjetivo)].".";
    $poemas_linhas[] = $linha_gerada;
}


$poema_final = implode(separator: "<br>", array:$poemas_linhas);


if($linha_especial != ""){
    $poema_final .= "<br><br>".
    $linha_especial;
}


/*$poema_gerado = $sujeito_aleatorio." ".
                $verbos_aleatorio." ".
                $objeto_aleatorio." ".
                $adjetivo_aleatorio.".";*/
               


?>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gerador de Poemas Aleatórios</title>
        <style>
            body{
                font-family:'Times New Roman', Times, serif;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                margin: 0;
                background: linear-gradient(to right, #6a11cb 0%, #2575fc 100%);
                color: #fff;
                text-align: center;
                padding: 20px;  
            }
        </style>
    </head>
    <body>
        <div>
            <h1>Gerador de Poemas</h1>
            <div>
                <?php echo $poema_final; ?>
            </div>
            <button onclick="window.location.reload()">Gerar Poema</button>


        </div>
    </body>
</html>