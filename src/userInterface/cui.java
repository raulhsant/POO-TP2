package userInterface;

import operadora.Operadora;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cui {
    private static Operadora operadora;

    public static void main(String[] args) {

        cui ui =  new cui();
        operadora = Operadora.readFile();

        int selectedOption;
        Boolean close =  false;

        Scanner in = new Scanner(System.in);
        while (!close) {

            ui.writeMenu();

            System.out.printf("\nDigite o número da atividade desejada: ");

            selectedOption = in.nextInt();

            switch(selectedOption) {
                default:
                    System.out.println("Não foi possível identificar a opção digitada. Pressione ENTER e tente novamente.");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;

                case 0:
//                    System.out.println("\nSalvando alterações...");
//                    close = true;
//                    banco.writeFile();
//                    System.out.println("\tAté logo!");
                    break;

                case 1:
//                    cui.writeClientAccountMenu("Adicionar", 1);
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 2:
//                    cui.writeClientAccountMenu("Remover", 2);
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 3:
//                    cui.writeClientAccountMenu("Listar", 3);
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 4:
//                    cui.writeExecuteMenu("Dep");
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 5:
//                    cui.writeExecuteMenu("Saq");
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 6:
//                    cui.writeExecuteMenu("Transf");
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    break;

                case 7:
//                    cui.writeSaldoMenu();
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
//                        cui.writeExtractMenu();
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

    private void writeMenu() {
        System.out.println(new String(new char[ 55 ]).replace('\0', '_'));
        System.out.println("O que você deseja?\n");

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
        linhas.add("| " + whitespace +  "4 - Adicionar Créditos" + whitespace +   "|");
        linhas.add(trace);

        linhas.add(traceAux);
        linhas.add("| " + whitespace +  "5 - Registrar Ligação" + whitespace +   " |");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 6 ]).replace('\0', ' ');

        linhas.add(traceAux);
        linhas.add("| " + whitespace +  "Visualizar" + whitespace + "|");
        linhas.add(traceAux);
        linhas.add("|      6 - Saldo (Pré)       7 - Conta (Pós)      |");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 12 ]).replace('\0', ' ');

        linhas.add(traceAux);
        linhas.add("|" + whitespace +  "8 - Extrato de Ligações" + whitespace +   "|");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 15 ]).replace('\0', ' ');
        linhas.add(traceAux);
        linhas.add("|" + whitespace +  "9 - Informativo de vencimento" + whitespace +   "|");
        linhas.add(trace);


        whitespace = new String(new char[ (linhas.get(0).length())/2 - 15 ]).replace('\0', ' ');

        linhas.add(traceAux);
        linhas.add("|" + whitespace +  " 0 - Sair e Salvar Alterações" + whitespace + "|");
        linhas.add(trace);


        for(String line : linhas)
            System.out.println(line);
    }
}
