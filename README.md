# Segunda chamada avaliação POO


Faça um programa em Java para controlar uma Biblioteca. O programa deve manter
um cadastro de livros e suas respectivas locações. O aplicativo deve apresentar
também alguns relatórios para saber os livros cuja devolução está em atraso.
Algumas regras:

- Um livro tem os seguintes atributos: código, titulo, autor e número de páginas.
O código deve ser único, não pode ter mais de um livro com o mesmo código.

- Uma locação deve ter os seguintes atributos: data da locação, cpf do cliente
que está alugando o livro, o código do livro, data da devolução e status
(devolvido ou não).

- Uma locação deve ocorrer sempre para um único livro.

- Para fazer a locação, verifique se o livro existe OU se o mesmo já está alugado
para alguém.

- A estrutura de menus deve ser a seguinte:

| Numero 	| Trabalho                                    	| Atalho 	|
|--------	|---------------------------------------------	|--------	|
| -      	| Classe principal                            	| [Main.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/Main.java) |
| 0      	| Cadastrar livro                             	| [CadastrarLivroOption.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/CadastrarLivroOption.java) |
| 1      	| Consultar Livro                             	| [ConsultarLivroOption.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/ConsultarLivroOption.java) |       	
| 2      	| Listar todos os livros                      	| [Relatorio1Option.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/Relatorio1Option.java) |
| 3      	| Realizar locação                            	| [RealizarLocacaoOption.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/RealizarLocacaoOption.java) |
| 4      	| Realizar devolução                          	| [RealizarDevolucaoOption.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/RealizarDevolucaoOption.java) |
| 5      	| Relatório de livros com devolução em aberto 	| [Relatorio3Option.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/Relatorio3Option.java) |
| 6      	| Relatório de livros alugados por período    	| [Relatorio2Option.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/Relatorio2Option.java) |
| 7      	| Sair                                        	| [SairOption.java](https://github.com/daviddev16/2nd-biblioteca-poo/blob/master/src/main/java/org/biblioteca/options/SairOption.java) |

## Rodar o programa
###### Download do jar em https://github.com/daviddev16/2nd-biblioteca-poo/releases

    java -jar 2nd-biblioteca-<version>.jar
