/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoIndividual;

import Formulas.CalculoKDA;
import java.util.Scanner;

/**
 *
 * @author Caiqu
 */
public class Valorant {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);
        Double kdaPartida = null;
        String login = null;
        String senha = null;
         Boolean usuarioLogado = false;
       int contador = 1;
        for (int i = 0; i < contador; i++) {
            if(usuarioLogado) {
        System.out.println(String.format("\n --> Seja bem vindo %s :D < --", login));
        System.out.println("\nAnalise de desempenho pós partida\n");
        System.out.println("1 - Veja seu KDA por partida");
        System.out.println("2 - Avaliação de desempenho da partida");
        System.out.println("3 - Crie sua conta");
        System.out.println("4 - Faça login");
        System.out.println("5 - Jogar");
        System.out.println("6 - Sair");
            } else {
        System.out.println("\nAnalise de desempenho pós partida\n");
        System.out.println("1 - Veja seu KDA por partida");
        System.out.println("2 - Avaliação de desempenho da partida");
        System.out.println("3 - Crie sua conta");
        System.out.println("4 - Faça login");
        System.out.println("5 - Jogar");
        System.out.println("6 - Sair");
            }
        
        Integer opcaoUsuario = leitor.nextInt();
        
            switch(opcaoUsuario) {
            case 1 -> {
                
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
                pularLinhas();
                
                System.out.println("Deseja fazer outra atividade?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                
                Integer opcaoUsuarioAtividade = leitor.nextInt();
              
               switch(opcaoUsuarioAtividade){
                   case 1 -> {
                       pularLinhas();
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
            case 2 -> {
                            if(kdaPartida == null){
                 System.out.println("Por favor insira o KDA da partida na primeira opção antes de solicitar uma "
            + "avaliação!");
            } else if(kdaPartida <= 1.5){
                    String frase = String.format("De acordo com o seu KDA de %.2f. Seu desempenho não está sendo"
                            + " tão bom, treine mais!", kdaPartida);
                    System.out.println(frase);
            } else if(kdaPartida <= 2.5){
                String frase = String.format("De acordo com o seu KDA de %.2f. Seu desempenho está razoável,"
                        + " você está melhorando!", kdaPartida);
                    System.out.println(frase);
            } else if(kdaPartida <= 10){
                String frase = String.format("De acordo com o seu KDA de %.2f. Você está muito bem!"
                        + " continue mantendo consistência em suas partidas :D !",kdaPartida);
                    System.out.println(frase);
            }
                   pularLinhas();
                System.out.println("Deseja fazer outra atividade?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                
                Integer opcaoUsuarioAtividade = leitor.nextInt();
              
               switch(opcaoUsuarioAtividade){
                   case 1 -> {
                       pularLinhas();
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
            case 3 -> {
                System.out.println("\n -- > Crie sua conta < --\n");
                System.out.println("Insira o login:");
                login = leitorString.nextLine();
                
                System.out.println("Insira sua senha:");
                senha = leitorString.nextLine();
                
                System.out.println("\ncadastro realizado com sucesso! efetue login para jogar....");
                pularLinhas();
                contador++;
            }
            case 4 -> {
                if(login == null && senha == null){
                    System.out.println("\nVocê deve efetuar um cadastro antes de efetuar login!\n");
                    pularLinhas();
                    contador++;
                } else {
                    String loginUsuario;
                    String senhaUsuario;
                    
                    System.out.println("\n -- > Efetue login para jogar! < -- \n");
                    System.out.println("Insira seu login:");
                    
                    loginUsuario = leitorString.nextLine();
                    
                    System.out.println("Insira sua senha:");
                    
                    senhaUsuario = leitorString.nextLine();
                    
                    if(loginUsuario.equals(login) && senhaUsuario.equals(senha)){
                        usuarioLogado = true;
                        System.out.println("\n Login efetuado com sucesso!\n");
                System.out.println("Deseja fazer outra atividade?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                
                Integer opcaoUsuarioAtividade = leitor.nextInt();
              
               switch(opcaoUsuarioAtividade){
                   case 1 -> {
                       pularLinhas();
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
                        System.out.println("\n Você deve inserir seu login e senha corretamente. "
                                + "Tente efetuar login novamente!!\n");
                        pularLinhas();
                        contador++;
                    }
                }
                
            }
            case 5 -> {
                System.out.println("     |>>>  \n" +
"     |  \n" +
" _  _|_  _  \n" +
"/| |_| |_| |\\  \n" +
"  \\    _    /  \n" +
"   |_______|  \n" +
"   (  | |  )  \n" +
"   (  | |  )  \n" +
"   (  | |  )  \n" +
"  |_______|");
            }
            case 6 ->{
                System.out.println("\nDeseja realmente sair?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                
                Integer opcaoUsuarioAtividade = leitor.nextInt();
              
               switch(opcaoUsuarioAtividade){
                   case 1 -> {
                       System.out.println("\nAté logo :)");
                       leitor.close();
                   }
                   case 2 -> {
                       pularLinhas();
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
public static void pularLinhas() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}


