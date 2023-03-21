/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoIndividual;

import Formulas.CalculoKDA;
import Formulas.Utilitarios;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Caiqu
 */
public class Valorant {

    public static void main(String[] args) throws InterruptedException {

        Scanner leitor = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);
        Double kdaPartida = null;
        String login = null;
        String senha = null;
        Boolean usuarioLogado = false;
        Utilitarios utility = new Utilitarios();
        int contador = 1;
        for (int i = 0; i < contador; i++) {
            if (usuarioLogado) {
                System.out.println("\n----------------- > VALORANT - ACT IV <----------------\n");
                System.out.println("               Seja bem vindo " + login + " !!!\n");
                System.out.println("3 - Veja seu KDA por partida");
                System.out.println("4 - Avaliação de desempenho da partida");
                System.out.println("5 - Jogar");
                System.out.println("6 - Sair");
            } else {
                System.out.println("\n------------------ > VALORANT - NEW ACT VI <---------------\n");
                System.out.println("1 - Crie sua conta");
                System.out.println("2 - Faça login");
                System.out.println("3 - Veja seu KDA por partida");
                System.out.println("4 - Avaliação de desempenho da partida");
                System.out.println("5 - Jogar");
                System.out.println("6 - Sair");
            }

            Integer opcaoUsuario = leitor.nextInt();

            switch (opcaoUsuario) {
                case 1 -> {
                    System.out.println("\n -- > Crie sua conta < --\n");
                    System.out.println("Insira o login:");
                    login = leitorString.nextLine();

                    System.out.println("Insira sua senha:");
                    senha = leitorString.nextLine();

                    System.out.println("\nCadastro realizado com sucesso! efetue login para jogar....");
                    utility.pularLinhas();
                    contador++;
                }
                case 2 -> {
                    if (login == null && senha == null) {
                        System.out.println("\nVocê deve efetuar um cadastro antes de efetuar login!\n");
                        utility.pularLinhas();
                        contador++;
                    } else {
                        String loginUsuario;
                        String senhaUsuario;

                        System.out.println("\n -- > Efetue login para jogar! < -- \n");
                        System.out.println("Insira seu login:");

                        loginUsuario = leitorString.nextLine();

                        System.out.println("Insira sua senha:");

                        senhaUsuario = leitorString.nextLine();

                        if (loginUsuario.equals(login) && senhaUsuario.equals(senha)) {
                            usuarioLogado = true;
                            System.out.println("\n Login efetuado com sucesso!\n");
                            contador++;
                        } else {
                            System.out.println("\n Você deve inserir seu login e senha corretamente. "
                                    + "Tente efetuar login novamente!!\n");
                            utility.pularLinhas();
                            contador++;
                        }
                    }

                }
                case 3 -> {
                    if (usuarioLogado) {
                        CalculoKDA kdaUsuario;
                        kdaUsuario = new CalculoKDA();

                        System.out.println("Insira o número de kills da partida:");
                        kdaUsuario.quantidadeKills = leitor.nextInt();
                        System.out.println("Insira o número de mortes da partida:");
                        kdaUsuario.quantidadeDeath = leitor.nextInt();
                        System.out.println("Insira o número de assistências da partida:");
                        kdaUsuario.quantidadeAssistence = leitor.nextInt();

                        Double calculoKDA = (double) kdaUsuario.resultadoKDA();
                        kdaPartida = calculoKDA;
                        String frase = String.format("seu KDA desta partida é %.2f", calculoKDA);
                        System.out.println(frase);
                        utility.pularLinhas();

                        System.out.println("Deseja fazer outra atividade?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");

                        Integer opcaoUsuarioAtividade = leitor.nextInt();

                        switch (opcaoUsuarioAtividade) {
                            case 1 -> {
                                utility.pularLinhas();
                                contador++;
                            }
                            case 2 -> {
                                System.out.println("Até logo :)");
                                leitor.close();
                            }
                            default -> {
                                System.out.println("Por favor digite uma das opções!!");
                                opcaoUsuarioAtividade = leitor.nextInt();
                            }
                        }

                    } else {
                        System.out.println("Efetue login ou crie uma conta para calcular seu KDA!");
                        contador++;
                    }
                }
                case 4 -> {
                    if (kdaPartida == null) {
                        System.out.println("Por favor insira o KDA da partida  antes de solicitar uma "
                                + "avaliação!");
                    } else if (kdaPartida <= 1.5) {
                        String frase = String.format("De acordo com o seu KDA de %.2f. Seu desempenho não está sendo"
                                + " tão bom, treine mais!", kdaPartida);
                        System.out.println(frase);
                    } else if (kdaPartida <= 2.5) {
                        String frase = String.format("De acordo com o seu KDA de %.2f. Seu desempenho está razoável,"
                                + " você está melhorando!", kdaPartida);
                        System.out.println(frase);
                    } else if (kdaPartida <= 10) {
                        String frase = String.format("De acordo com o seu KDA de %.2f. Você está muito bem!"
                                + " continue mantendo consistência em suas partidas :D !", kdaPartida);
                        System.out.println(frase);
                    }
                    utility.pularLinhas();
                    System.out.println("Deseja fazer outra atividade?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");

                    Integer opcaoUsuarioAtividade = leitor.nextInt();

                    switch (opcaoUsuarioAtividade) {
                        case 1 -> {
                            utility.pularLinhas();
                            contador++;
                        }
                        case 2 -> {
                            System.out.println("Até logo :)");
                            leitor.close();
                        }
                        default -> {
                            System.out.println("Por favor digite uma das opções!!");
                            opcaoUsuarioAtividade = leitor.nextInt();
                        }
                    }
                }
                case 5 -> {
                    if (usuarioLogado) {
                        
                        System.out.println("""
                                           Antes de jogar saiba:
                                           O jogador inicia com 100 pontos e no decorrer da partida
                                           pode ganhar mais pontos ou perder pontos, caso o usuario 
                                           chegue a 500 ou mais pontos, ele vencer\u00e1 a partida e 
                                           se ele chegar a 0 pontos ou menos, ele perde o game.""");
                        
                        System.out.println("\nAguarde achar partida!!");
                        for (int b = 0; b < 5; b++) {
                            System.out.println((b + 1) + "...");
                            Thread.sleep(1000);
                        }
                        System.out.println("\n |---------------> PARTIDA ENCONTRADA <---------------| \n");
                        System.out.println("Selecione seu Agente: \n");
                        System.out.println("1 - Jett ( Duelista )");
                        System.out.println("2 - Sova ( Iniciador )");
                        System.out.println("3 - Omen ( Controlador )");
                        System.out.println("4 - Cypher ( Sentinela )");
                        System.out.println("5 - KillJoy ( Sentinela )");

                        Integer opcaoUsuarioAgente = leitor.nextInt();

                        Integer pontosJogador = 100;

                        switch (opcaoUsuarioAgente) {
                            case 1 -> {
                                System.out.println("\nVocê selecionou um Duelista!\n");
                                System.out.println("""
                                                                                   Duelistas são agentes ofensivos com habilidades
                                                                                   que ajudam a engajar em confrontos e eliminar inimigos.""");
                            }
                            case 2 -> {
                                System.out.println("\nVocê selecionou um Iniciador!\n");
                                System.out.println("""
                                                                                   Iniciadores são agentes com habilidades que permitem
                                                                                   iniciar ações e informar a equipe sobre a posições dos inimigos.""");
                            }
                            case 3 -> {
                                System.out.println("\nVocê selecionou um Controlador\n");
                                System.out.println("""
                                                                                   Controladores são agentes que podem criar zonas de
                                                                                   controle e bloquear areas do mapa com suas habilidades.""");
                            }
                            case 4, 5 -> {
                                System.out.println("\nVocê selecionou um Sentinela\n");
                                System.out.println("""
                                                                                   Sentinelas são agentes defensivos que podem fornecer 
                                                                                   suporte à equipe com habilidades curativas e proteção de áreas""");
                            }
                        }

                        System.out.println("\n |---------------> INICIANDO GAME <---------------| \n");

                        for (int b = 0; b < 3; b++) {
                            System.out.println((b + 1) + "....");
                            Thread.sleep(1000);
                        }

                        Integer contadorJogo = 1;
                        Integer somarPontosAtirar = 100;
                        Integer somarPontosCorrer = 60;
                        Integer somarPontosSpike = 200;
                        Integer somarPontosPoder = 110;
                        Random random = new Random();
                        Integer valorEMaior;
                        for (int j = 0; j < contadorJogo; j++) {
                            System.out.println("\nO que deseja fazer?");
                            System.out.println("1 - Atirar");
                            System.out.println("2 - Correr");
                            System.out.println("3 - Plantar c4");
                            System.out.println("4 - Usar Poder");

                            Integer opcaoUsuarioAtividade = leitor.nextInt();

                            switch (opcaoUsuarioAtividade) {
                                case 1 -> {
                                    valorEMaior = random.nextInt(200);
                                    if (valorEMaior > somarPontosAtirar) {
                                        if (pontosJogador <= 0) {
                                            System.out.println("Você levou um tiro e morreu! inicie outra partida.");
                                            j = contadorJogo;
                                            contador++;
                                            pontosJogador = 100;
                                        } else {
                                            pontosJogador -= valorEMaior;

                                            if (pontosJogador <= 0) {
                                                System.out.println("Você trocou tiro e morreu, inicie outra partida!");
                                                System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                j = contadorJogo;
                                                contador++;
                                                pontosJogador = 100;
                                            } else {
                                                System.out.println("Você trocou tiro e está com pouca vida...\n");
                                                System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                contadorJogo++;
                                            }
                                        }
                                    } else {
                                        pontosJogador += somarPontosAtirar;
                                        System.out.println("Você matou um inimigo!");
                                        System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                        if (pontosJogador >= 500) {
                                            System.out.println("\n |---------------> VOCÊ VENCEU O GAME <---------------| \n");
                                            System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                            j = contadorJogo;
                                            contador++;
                                        } else {
                                            contadorJogo++;
                                        }
                                    }
                                }
                                case 2 -> {
                                    valorEMaior = random.nextInt(200);
                                    if (valorEMaior > somarPontosCorrer) {
                                        if (pontosJogador <= 0) {
                                            System.out.println("Você levou um tiro e morreu! inicie outra partida");
                                            j = contadorJogo;
                                            contador++;
                                            pontosJogador = 100;
                                        } else {
                                            pontosJogador -= valorEMaior;
                                            if (pontosJogador <= 0) {
                                                System.out.println("Você correu porém foi encontrado e executado,"
                                                        + " inicie outra partida!");
                                                System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                j = contadorJogo;
                                                contador++;
                                                pontosJogador = 100;
                                            } else {
                                                System.out.println("Você correu e se escondeu, mas está com pouca vida...\n");
                                                System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                contadorJogo++;
                                            }
                                        }
                                    } else {
                                        pontosJogador += somarPontosCorrer;
                                        System.out.println("Você correu e conseguiu se reposicionar!");
                                        System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                        if (pontosJogador >= 500) {
                                            System.out.println("\n |---------------> VOCÊ VENCEU O GAME <---------------| \n");
                                            System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                            j = contadorJogo;
                                            contador++;
                                        } else {
                                            contadorJogo++;
                                        }
                                    }
                                }
                            
                        case 3 -> {
                                        valorEMaior = random.nextInt(200);
                                        if (valorEMaior > somarPontosSpike) {
                                            if (pontosJogador <= 0) {
                                                System.out.println("Você levou um tiro e morreu! inicie outra partida");
                                                j = contadorJogo;
                                                contador++;
                                                pontosJogador = 100;
                                            } else {
                                                pontosJogador -= valorEMaior;
                                                if (pontosJogador <= 0) {
                                                    System.out.println("Você plantou a c4, mas não conseguiu defender o bomb!"
                                                            + "inicie outra partida.");
                                                    System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                    j = contadorJogo;
                                                    contador++;
                                                    pontosJogador = 100;
                                                } else {
                                                    System.out.println("Você plantou a c4, mas está com pouca vida!\n");
                                                    System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                    contadorJogo++;
                                                }
                                            }
                                        } else {
                                            pontosJogador += somarPontosSpike;
                                            System.out.println("Você plantou a c4 e está defendendo o bomb!");
                                            System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                            if (pontosJogador >= 500) {
                                            System.out.println("\n |---------------> VOCÊ VENCEU O GAME <---------------| \n");
                                            System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                            j = contadorJogo;
                                            contador++;
                                        } else {
                                            contadorJogo++;
                                        }
                                        }
                                    }
                                    case 4 -> {
                                        valorEMaior = random.nextInt(200);
                                        if (valorEMaior > somarPontosPoder) {
                                            if (pontosJogador <= 0) {
                                                System.out.println("Você levou um tiro e morreu! inicie outra partida");
                                                j = contadorJogo;
                                                contador++;
                                                pontosJogador = 100;
                                            } else {
                                                pontosJogador -= valorEMaior;
                                                if (pontosJogador <= 0) {
                                                    System.out.println("""
                                                                       Voc\u00ea utilizou uma Habilidade por\u00e9m 
                                                                       foi surpreendido por um inimigo levou um tiro e morreu!""");
                                                    System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                    j = contadorJogo;
                                                    contador++;
                                                    pontosJogador = 100;
                                                } else {
                                                    System.out.println("Você utilizou uma habilidade, porém está com pouca vida!\n");
                                                    System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                                    contadorJogo++;
                                                }
                                            }
                                        } else {
                                            pontosJogador += somarPontosPoder;
                                            System.out.println("Você utilizou uma Habilidade e matou um inimigo!");
                                            System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                             if (pontosJogador >= 500) {
                                            System.out.println("\n |---------------> VOCÊ VENCEU O GAME <---------------| \n");
                                            System.out.println(String.format("Seus Pontos são: %d", pontosJogador));
                                            j = contadorJogo;
                                            contador++;
                                        } else {
                                            contadorJogo++;
                                        }
                                        }
                                    }
                                    default -> {
                                            System.out.println("Digite uma das opções disponíveis");
                                            }
                                }
                        }
                    } else {
                        System.out.println("Você deve fazer login ou criar uma conta para Jogar!");
                        contador++;
                    }
                    }

                
            
        
    

case 6 -> {
                    System.out.println("\nDeseja realmente sair?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");

                    Integer opcaoUsuarioAtividade = leitor.nextInt();

                    switch (opcaoUsuarioAtividade) {
                        case 1 -> {
                            System.out.println("\nAté logo :)");
                            leitor.close();
                        }
                        case 2 -> {
                            utility.pularLinhas();
                            contador++;
                        }
                        default -> {
                            System.out.println("Por favor digite uma das opções!!");
                            opcaoUsuarioAtividade = leitor.nextInt();
                        }
                    }
                }
                default -> {
                    System.out.println("Você deve digitar uma opção válida!");
                    opcaoUsuario = leitor.nextInt();
                }
            }
        }
    }
}
