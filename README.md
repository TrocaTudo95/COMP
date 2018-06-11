# PPIN

**PROJECT TITLE:** Compiler of the yal0.4 language to Java Bytecodes
  
**GROUP:** G46

**NAME1:** Daniel Machado, **NR1:** 201506365, **GRADE1:** 16, **CONTRIBUTION1:** 23%

**NAME2:** José Pedro Machado, **NR2:** 201504779, **GRADE2:** 17, **CONTRIBUTION2:** 30%

**NAME3:** Nuno Pereira, **NR3:** 201506265, **GRADE3:** 15, **CONTRIBUTION3:** 17%

**NAME4:** Pedro Miranda, **NR4:** 201506574, **GRADE4:** 17, **CONTRIBUTION4:** 30%
  
**GLOBAL Grade of the project:** 16

**SUMMARY:** O nosso projeto consiste num compilador da linguagem yal para Java Bytecodes. Esta ferramenta compila código, mostrando a tabela de símbolos assim como os diferentes tipos de erros encontrados ao longo da compilação.

**EXECUTE:** Para correr o nosso programa devem-se executar as seguintes intruções:

* jjtree yal2jvm.jjt
* javacc yal2jvm.jj
* javac *.java
* java yal2jvm < filename >

**DEALING WITH SYNTACTIC ERRORS:** A nossa aplicação é capaz de lidar com diversos erros semânticos, apresentando-os no ecrã. 

**SEMANTIC ANALYSIS:** A análise semântica foi implementada na totalidade: assigns, condições e functions calls.

**INTERMEDIATE REPRESENTATIONS (IRs):** Não se adequa à nossa implemetação

**CODE GENERATION:** O nosso programa gera código corretamente quase para todas as situações. É possível apenas verificar alguns problemas quando se misturam condições IF dentro de ciclos WHILE

**OVERVIEW:** Foi usado JUnit para implementar os testes unitários. Também usamos um artigo de standford como guia para implementar a nossa tabela de símbolos: https://theory.stanford.edu/~aiken/software/cooldist/src/PA5J/SymbolTable.java


**TESTSUITE AND TEST INFRASTRUCTURE:** Foi implementada uma bateria de testes no ficheiro YalParserTest.java. 
Tratam-se de testes JUnit e como tal cada teste :

 * Corre o parser de um dado ficheiro
 * Gera ficheiro .j
 * Gera ficheiro .class
 * Corre o ficheiro com java e utiliza assert para comparar o resultado com o esperado

Estes cobrem todos os ficheiros aval (aval1 a aval9), maxmin, array1 e ainda foi implementado um teste suplementar - constantRanges().


**TASK DISTRIBUTION:** 

SYNTACTIC ERRORS -  Daniel, José, Pedro, Nuno

SEMANTIC ANALYSIS - José, Daniel

INTERMEDIATE REPRESENTATIONS - José

SYMBOL TABLE  -José

CODE GENERATION - Pedro

**PROS:** A nossa aplicação lida com todos os erros semânticos e sintáticos, apresentando sempre a tabela de símbolos

**CONS:** Na geração de código, quando se misturam IFs e WHILEs o resultado é diferente do esperado

