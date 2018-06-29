package userInterface;

import excecoes.CelularException;
import excecoes.ClienteException;
import excecoes.PlanoException;
import operadora.Celular;
import operadora.Cliente;
import operadora.Operadora;
import operadora.Plano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cui {
    private static Operadora operadora;

    public static void main(String[] args) {

        Cui ui =  new Cui();
        operadora = Operadora.readFile();

        int selectedOption;
        Boolean close =  false;

        Scanner in = new Scanner(System.in);
        while (!close) {

            ui.escreveMenu();

            System.out.printf("\nDigite o n�mero da atividade desejada: ");

            selectedOption = in.nextInt();

            switch(selectedOption) {
                default:
                    System.out.println("N�o foi poss�vel identificar a op��o digitada. Pressione ENTER e tente novamente.");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;

                case 0:
                    System.out.println("\nSalvando altera��es...");
                    close = true;
                    operadora.writeFile();
                    System.out.println("\tAt� logo!");
                    break;

                case 1:
                    try {
                        ui.escreveClienteCelularPlanoMenu("Adicionar", 1);
                        System.in.read();
                    } catch (Exception e) {
//                        e.printStackTrace();
                        System.out.println("**********************************************************");
                        System.out.println("\t" + e);
                        System.out.println("**********************************************************");
                        in.nextLine();
                    }
                    break;

                case 2:
                    try {
                        ui.escreveClienteCelularPlanoMenu("Remover", 2);
                        System.in.read();
                    } catch (Exception e) {
//                        e.printStackTrace();
                        System.out.println("**********************************************************");
                        System.out.println("\t" + e);
                        System.out.println("**********************************************************");
                        in.nextLine();
                    }

                    break;

                case 3:
                    try {
                        ui.escreveExcluirCelular();
                        System.in.read();
                    } catch (CelularException e) {
                        System.out.println("**********************************************************");
                        System.out.println("\t" + e);
                        System.out.println("**********************************************************");
                        in.nextLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;

                case 4:
//                    Cui.writeExecuteMenu("Dep");
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 5:
//                    Cui.writeExecuteMenu("Saq");
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 6:
//                    Cui.writeExecuteMenu("Transf");
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 7:
//                    Cui.writeSaldoMenu();
//
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }

                    break;

                case 8:
//                    try {
//                        Cui.writeExtractMenu();
//                    } catch (ParseException e1) {
//                        // TODO Auto-generated catch block
//                        e1.printStackTrace();
//                        System.out.println("Error ocnverting date!");
//                    }
//
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 9:
//                    banco.bankRatePayment();
//                    System.out.println("\nTarifas cobradas com sucesso!\nPressione ENTER para continuar.");
//
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 10:

//                    banco.CpmfPayment();
//                    System.out.println("\nCPMF cobrado com sucesso!\nPressione ENTER para continuar.");
//
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

            }

        }

    }

    private void escreveMenu() {
        System.out.println(new String(new char[ 55 ]).replace('\0', '_'));
        System.out.println("O que voc� deseja?\n");

        List<String> linhas = new ArrayList<String>();
        String linha = "|       1 - Adicionar            2 - Listar       |";

        String trace = "";
        String traceAux = "";
        for (int i = 0; i <= linha.length() -1 ; i++) {
            trace += "=";
            traceAux += "-";
        }

        String whitespace = new String(new char[ (linha.length() - 28)/2 ]).replace('\0', ' ');
        linhas.add(traceAux);
        linhas.add(linha);
        linhas.add(traceAux);
        linhas.add("| " +  whitespace + "Cliente - Plano - Celular" + whitespace + " |");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 10 ]).replace('\0', ' ');

        linhas.add(traceAux);
//        linhas.add( "|  " +  whitespace + "Excluir" + whitespace + "  |");
//        linhas.add(traceAux);
        linhas.add("|" + whitespace +  "3 - Excluir Celular" + whitespace +   "|");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 12 ]).replace('\0', ' ');

        linhas.add(traceAux);
        linhas.add("| " + whitespace +  "4 - Adicionar Cr�ditos" + whitespace +   "|");
        linhas.add(trace);

        linhas.add(traceAux);
        linhas.add("| " + whitespace +  "5 - Registrar Liga��o" + whitespace +   " |");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 6 ]).replace('\0', ' ');

        linhas.add(traceAux);
        linhas.add("| " + whitespace +  "Visualizar" + whitespace + "|");
        linhas.add(traceAux);
        linhas.add("|      6 - Saldo (Pr�)       7 - Conta (P�s)      |");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 12 ]).replace('\0', ' ');

        linhas.add(traceAux);
        linhas.add("|" + whitespace +  "8 - Extrato de Liga��es" + whitespace +   "|");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 15 ]).replace('\0', ' ');
        linhas.add(traceAux);
        linhas.add("|" + whitespace +  "9 - Informativo de vencimento" + whitespace +   "|");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 15 ]).replace('\0', ' ');

        linhas.add(traceAux);
        linhas.add("|" + whitespace +  " 0 - Sair e Salvar Altera��es" + whitespace + "|");
        linhas.add(trace);


        for(String line : linhas)
            System.out.println(line);
    }



    private void escreveClienteCelularPlanoMenu(String action, int whatToDo) throws Exception {

        Scanner in = new Scanner(System.in);
        int selectedOption = 0;

        System.out.println(String.format("\nVoc� deseja %s: ", action));
        System.out.println("1 - Cliente\n2 - Plano\n3 - Celular\n0 - Voltar");

        selectedOption = in.nextInt();

        if(selectedOption == 1) {
            if(whatToDo == 1) {
                //asks for data to add
                System.out.println("\nFavor digitar os dados do Cliente a ser adicionado.");

                in.nextLine();

                System.out.printf("Nome: ");
                String nome = in.nextLine();

                System.out.printf("CPF/CNPJ: ");
                String cpf = in.nextLine();

                System.out.printf("Endere�o: ");
                String end = in.nextLine();

//                System.out.printf("Telefone: ");
//                String tel = in.nextLine();

//                Cliente client = new Cliente(nome, cpf, end);

                operadora.cadastrarCliente(nome, cpf, end);

                System.out.println(String.format("\nCliente %s adicionado com sucesso. \nPressione ENTER para continuar", nome));
				in.nextLine();
//
            } else if (whatToDo == 2) {
                //Listar Clientes
                List<Cliente> clientes = operadora.getClientes();

                String trace = new String(new char[ 42 ]).replace('\0', '-');

                System.out.print("");
                System.out.println(trace);
                System.out.println(String.format("Clientes da operadora %s", operadora.getNome()));

                for (Cliente cliente : clientes) {
                    System.out.println(trace);

                    System.out.printf("Nome: %s \t CPF/CNPJ: %s\n", cliente.getNome(), cliente.getCpfCnpj());
                    System.out.printf("Endere�o: %s\n", cliente.getEndereco());

                }
                System.out.println(trace);
                System.out.println("\nPressione ENTER para continuar");
                in.nextLine();
            }

        } else if (selectedOption == 2) {
            if(whatToDo == 1) {
                //asks for data to add
                System.out.println("\nFavor digitar as informa��es do plano a ser cadastrado");
                in.nextLine();
                System.out.printf("Nome do plano: ");
                String nome = in.nextLine();
                System.out.printf("Pre�o por minuto (0.00): ");
                String valorMinuto = in.nextLine();

                operadora.cadastrarPlano(nome, Double.parseDouble( valorMinuto.replace(",",".") ));

                System.out.println(String.format("\nPlano %s cadastrado com sucesso. \nPressione ENTER para continuar", nome));
                in.nextLine();
            } else if (whatToDo == 2) {
                //asks for nothing, shows list

                List<Plano> planos = operadora.getPlanos();

                String trace = new String(new char[ 42 ]).replace('\0', '-');

                System.out.print("");
                System.out.println(trace);
                System.out.println(String.format("Planos da operadora %s", operadora.getNome()));

                for (Plano plano : planos) {
                    System.out.println(trace);

                    System.out.printf("Nome: %s\n", plano.getNome());
                    System.out.printf("Pre�o do minuto: R$ %.2f\n", plano.getValorMinuto());

                }
                System.out.println(trace);
                System.out.println("\nPressione ENTER para continuar");
                in.nextLine();
            }
        } else if (selectedOption == 3){
            if(whatToDo == 1) {
                System.out.println("\nFavor definir as informa��es do celular a ser adicionado.");
                in.nextLine();

                System.out.printf("Defina o tipo de celular: \n1 - Cart�o (Pr�-Pago)\n2 - Conta (P�s-Pago)\n");
                Integer tipo = in.nextInt();
                in.nextLine();
                String tipoString = null;

                System.out.printf("CPF/CNPJ do Cliente: ");
                String cpf = in.nextLine();

                System.out.printf("Nome do plano: ");
                String planoNome = in.nextLine();

                Integer diaVencimento = null;

                if(tipo.equals(2)){
                    tipoString = "Conta";

                    System.out.printf("Dia do m�s para vencimento da conta: ");
                    diaVencimento = in.nextInt();

                } else if(tipo.equals(1))
                    tipoString = "Cartao";

                operadora.adicionarCelular(tipoString,planoNome,cpf,diaVencimento);

                System.out.println("\nCelular adicionado com sucesso. \nPressione ENTER para continuar");
                in.nextLine();

            } else if (whatToDo == 2) {

                List<Celular> celulares = operadora.getCelulares();

                String trace = new String(new char[ 42 ]).replace('\0', '-');

                System.out.print("");
                System.out.println(trace);
                System.out.println(String.format("Celulares da operadora %s", operadora.getNome()));

                for (Celular celular : celulares) {
                    System.out.println(trace);

                    System.out.printf("N�mero: %s\t", celular.getNumero());
                    System.out.printf("Plano: %s\n", celular.getPlano().getNome());
                    System.out.printf("Cliente: %s\n", celular.getCliente().getNome());

                }
                System.out.println(trace);
                System.out.println("\nPressione ENTER para continuar");
                in.nextLine();

            }
        }
        else if(selectedOption == 0) {
            System.out.println("\nPressione ENTER para continuar");
            in.nextLine();
        } else {
            System.out.println("N�o foi poss�vel identificar a op��o digitada, tente novamente.");
            try {
                System.in.read();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


    private void escreveExcluirCelular() throws CelularException {
        Scanner in = new Scanner(System.in);

        System.out.println("\nVoc� deseja excluir um celular.\nO celular s� pode ser exclu�do se n�o possuir cr�ditos ou liga��es a serem pagas!");

        System.out.println("Favor digitar o n�mero do celular a ser removido");
//        in.nextLine();
        System.out.printf("N�mero: ");
        Integer numero = in.nextInt();
        in.nextLine();
//        System.out.printf("Pre�o por minuto (0.00): ");
//        String valorMinuto = in.nextLine();

        operadora.excluirCelular(numero);

        System.out.println(String.format("\nCelular %d removido com sucesso. \nPressione ENTER para continuar", numero));
//        in.nextLine();
    }
}
