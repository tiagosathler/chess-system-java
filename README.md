# Chess System Java

## Introdução

Projeto assistido e desenvolvido durante o Curso de [Java Completo](https://www.udemy.com/course/java-curso-completo/) da plataforma Udemy através do [![Linkedin](https://i.stack.imgur.com/gVE0j.png) Prof. Dr. Nelio Alves](https://br.linkedin.com/in/nelio-alves). O repositório das minhas atividades no curso podem ser acessados [aqui](https://github.com/tiagosathler/udemy-java-complete-course).

Este projeto consolida os conhecimentos adquiridos até o momento do curso (cerca da metade), que incluí, mas não se limitando a:

* Classes: construtores padrões, atributos, encapsulamento, getters e setters, métodos da instância e da classe (estático), sobrecargas, classes reais e abstratas, etc;
* Programação orientada a projetos, lógica e organização: herança, polimorfismo, sobrescrita de métodos, injeção de dependência, associações, encapsulamento, enumeração, downcasting, upcasting, padrão de camadas, tratamento de exceções, listas, matrizes, estruturas sequenciais, repetitivas (`for` e `while`) e condicionais (`if-else` e ternários), diagrama UML, versionamento do código, código limpo, etc;

## Design do projeto

O projeto baseia-se em duas camadas: __Board layer__ e __Chess layer__. O tabuleiro é uma matriz. Cada elemento da matriz contém ou não uma peça. Porém, a forma como acessamos esta matriz é diferente entre as camadas. Na camada __Board layer__ temos todas as lógicas de controle do tabuleiro. Os índices da matriz são os números inteiros correspondentes aos índices das listas. Temos a classe _Position_ que representa uma posição da matriz. A classe abstrata _Piece_ representa a peça na matriz através da _Position_ e os métodos abstratos de movimentos possíveis. A classe _Board_ descreve o tabuleiro fisicamente e seu estado. Por fim, nesta camada temos a classe _BoardException_ para tratar exceções do tabuleiro.

A camada __Chess layer__ agrupa todos as peças do tabuleiro (_King_, _Bishop_, _Knight_, _Pawn_, _Queen_, _Rook_) que são entidades (classes) que estende da classe abstrata _ChessPiece_, e esta estende da classe _Piece_ da outra camada. Logo, cada peça herda os atributos e métodos das super classes. Cada peça implementa suas regras de movimentos e jogadas especiais (se houver). A lógica de controle do jogo (check mate) está na classe _ChessMatch_ desta camada que incluem, também, o tratamento das exceções através da classe _ChessException_ o enum _Color_ e a classe _ChessPosition_. Nesta camada, os índices da matriz são acessados com a regra amigável da _UI_, isto é, através de letras e números. As letras de _a_ a _h_ representam as colunas e os números de _1_ a _8_ as linhas do tabuleiro. Então se faz a necessidade conversão entre as coordenadas do tabuleiro.

A seguir, o diagrama UML do projeto (_créditos do material do curso_):
![](https://github.com/tiagosathler/chess-system-java/blob/master/misc/chess-system-design.png)

## Ambiente de desenvolvimento e execução

O projeto foi desenvolvido na IDE [_Eclipse_](https://www.eclipse.org/) versão 2022-14 (4.26.0), Linux Ubuntu 22.04 LTS e Java OpenJDK 11. Mas pode ser executado também em versões superiores.

O programa pode ser executado diretamente do console da IDE ou na linha de comando do terminal.

Para executar diretamente no terminal, utilize o arquivo exportado do projeto `chess-system-java.jar`. Da pasta raiz do repositório clonado, execute:

```
java -cp exported/chess-system-java.jar application.Program
```

> Lembrando que é necessário ter o Java instalado na máquina na versão 11 ou superior.

A tela do programa deve ser executado semelhante ao mostrado a seguir:

![](https://github.com/tiagosathler/chess-system-java/blob/master/misc/tela.png)

O turno começa com as peças Brancas (_WHITE_). A _UI_ do programa solicita a entrada de origem da peça a mover (_Source_). Exemplo: "_a2_" seleciona o Peão Branco da posição A2. Confirme com ENTER e então o programa solicitará a o destino (_Target_) da nova posição da peça, exemplo "_a4_". Observe que o programa já mostra quais movimentos possíveis da peça e trata possíveis erros de movimentação. Depois de uma movimentação válida do atual jogador segue-se para o movimento do opositor, ou seja, da peça preta (_BLACK_). Concluída o turno, segue-se para o próximo repetindo-se a sequência. As peças capturadas são mostradas em todas a rodadas.

## Carga horária

O projeto foi guiado por 33 videos-aulas do curso, cerca de 5h45m de gravações e atividades de desenvolvimento de aproximadamente 10h, entre os dias 19 a 24 de setembro de 2022.

![](https://github.com/tiagosathler/chess-system-java/blob/master/misc/wakatime-report.png)

## Conteúdo: Sistema jogo de xadrez - 33 aulas - 5h45m

  1. _Visão geral do capítulo Sistema Jogo de Xadrez_  
  2. _Material de apoio do capítulo_
  3. _Criando projeto e repositório Git_
  4. _Primeira classe - Position_
  5. _Começando a implementar Board e Piece_
  6. _Camada Chess e imprimindo o tabuleiro_
  7. _Colocando peças no tabuleiro_
  8. _BoardException e programação defensiva_
  9. _ChessException e ChessPosition_
  10. _Pequena melhoria na impressão do tabuleiro_
  11. _Movendo peças_
  12. _Tratando exceções e limpando a tela_
  13. _Movimentos possíveis de uma peça_
  14. _Implementando movimentos possíveis da Torre_
  15. _Imprimindo os movimentos possíveis_
  16. _Implementando os movimentos possíveis do Rei_
  17. _Trocando de jogador a cada turno_
  18. _Manipulando peças capturadas_
  19. _Lógica de xeque - PARTE 1_
  20. _Lógica de xeque - PARTE 2_
  21. _Lógica de xequemate_
  22. _Contagem de movimentos das peças_
  23. _Peão_
  24. _Bispo_
  25. _Cavalo_
  26. _Rainha_
  27. _Jogada especial Roque - PARTE 1_
  28. _Jogada especial Roque - PARTE 2_
  29. _Jogada especial en passant - PARTE 1_
  30. _Jogada especial en passant - PARTE 2_
  31. _Jogada especial promoção_
  32. _Atualização de compliance_
  33. _Dando um tratamento melhor para promoção_
