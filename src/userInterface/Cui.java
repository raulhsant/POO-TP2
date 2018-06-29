package userInterface;

import dto.FaturaCreditoDTO;
import excecoes.CelularException;
import excecoes.ClienteException;
import excecoes.PlanoException;

import java.text.DateFormat;
import operadora.Celular;
import operadora.Cliente;
import operadora.Operadora;
import operadora.Plano;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    System.out.println("\nSalvando alterações...");
                    close = true;
                    operadora.writeFile();
                    System.out.println("\tAté logo!");
                    break;

                case 1:
                    try {
                        ui.escreveClienteCelularPlanoMenu("Adicionar", 1);
//                        System.in.read();
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
                    try{
                        ui.escreveAdicionarCreditos();
                    } catch (CelularException e) {
                        System.out.println("**********************************************************");
                        System.out.println("\t" + e);
                        System.out.println("**********************************************************");
                        in.nextLine();
                    }
                    break;

                case 5:
                    try {
                        ui.escreveRegistrarLigacao();
                    } catch (Exception e) {
                        System.out.println("**********************************************************");
                        System.out.println("\t" + e);
                        System.out.println("**********************************************************");
                        in.nextLine();
                    }

                    break;

                case 6:
                    try {
                        ui.escreveSaldoConta(1);
                    } catch (CelularException e) {
                        System.out.println("**********************************************************");
                        System.out.println("\t" + e);
                        System.out.println("**********************************************************");
                        in.nextLine();in.nextLine();
                    }
                    break;

                case 7:
                    try {
                        ui.escreveSaldoConta(2);
                    } catch (CelularException e) {
                        System.out.println("**********************************************************");
                        System.out.println("\t" + e);
                        System.out.println("**********************************************************");
                        in.nextLine();in.nextLine();

                    }
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

    private void escreveClienteCelularPlanoMenu(String action, int whatToDo) throws Exception {

        Scanner in = new Scanner(System.in);
        int selectedOption = 0;

        System.out.println(String.format("\nVocê deseja %s: ", action));
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

                System.out.printf("Endereço: ");
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
                    System.out.printf("Endereço: %s\n", cliente.getEndereco());

                }
                System.out.println(trace);
                System.out.println("\nPressione ENTER para continuar");
                in.nextLine();
            }

        } else if (selectedOption == 2) {
            if(whatToDo == 1) {
                //asks for data to add
                System.out.println("\nFavor digitar as informações do plano a ser cadastrado");
                in.nextLine();
                System.out.printf("Nome do plano: ");
                String nome = in.nextLine();
                System.out.printf("Preço por minuto (0.00): ");
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
                    System.out.printf("Preço do minuto: R$ %.2f\n", plano.getValorMinuto());

                }
                System.out.println(trace);
                System.out.println("\nPressione ENTER para continuar");
                in.nextLine();
            }
        } else if (selectedOption == 3){
            if(whatToDo == 1) {
                System.out.println("\nFavor definir as informações do celular a ser adicionado.");
                in.nextLine();

                System.out.printf("Defina o tipo de celular: \n1 - Cartão (Pré-Pago)\n2 - Conta (Pós-Pago)\n");
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

                    System.out.printf("Dia do mês para vencimento da conta: ");
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

                    System.out.printf("Número: %s\t", celular.getNumero());
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
            System.out.println("Não foi possível identificar a opção digitada, tente novamente.");
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

        System.out.println("\nVocê deseja excluir um celular.\nO celular só pode ser excluído se não possuir créditos ou ligações a serem pagas!");

        System.out.println("Favor digitar o número do celular a ser removido");
//        in.nextLine();
        System.out.printf("Número: ");
        Integer numero = in.nextInt();
        in.nextLine();
//        System.out.printf("Preço por minuto (0.00): ");
//        String valorMinuto = in.nextLine();

        operadora.excluirCelular(numero);

        System.out.println(String.format("\nCelular %d removido com sucesso. \nPressione ENTER para continuar", numero));
//        in.nextLine();
    }


    private void escreveAdicionarCreditos() throws CelularException {

        Scanner in = new Scanner(System.in);

        System.out.println("\nVocê deseja adicionar créditos");
//        in.nextLine();
        System.out.printf("Número: ");
        Integer numero = in.nextInt();
        in.nextLine();
        System.out.printf("Valor dos créditos (0.00): ");
        String credito = in.nextLine();

        operadora.adicionarCréditos(numero,  Double.parseDouble( credito.replace(",",".") ));

        System.out.println(String.format("\nCrédito adicionado com sucesso. \nPressione ENTER para continuar"));
        in.nextLine();


    }

    private void escreveRegistrarLigacao() throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.println("\nVocê deseja registrar uma ligação");
//        in.nextLine();
        System.out.printf("Número que efetuou a ligação: ");
        Integer numero = in.nextInt();
        in.nextLine();
        System.out.printf("Data da ligação (dd/MM/yyyy): ");
        String dataLigacao = in.nextLine();
        System.out.printf("Duracao em minutos: ");
        String duracaoString = in.nextLine();


        GregorianCalendar data = new GregorianCalendar();

        DateFormat newFormatter = new SimpleDateFormat("dd/MM/yyyy");

        Date dateAux = null;
        try {
            dateAux = (Date)newFormatter.parse(dataLigacao);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("**********************************************************");
            System.out.println("\t" + e);
            System.out.println("**********************************************************");
            in.nextLine();
        }
        data.setTime(dateAux);


        Integer duracao = Integer.valueOf(duracaoString);

        if (duracao != null){
            operadora.registrarLigacao(numero,data,duracao);
        }

        System.out.println(String.format("\nLigação registrada com sucesso. \nPressione ENTER para continuar"));
        in.nextLine();

    }


    private void escreveSaldoConta(int saldoConta) throws CelularException {
        Scanner in = new Scanner(System.in);

        if(saldoConta == 1)
            System.out.println("\nVocê deseja visualizar o saldo.");
        else if (saldoConta == 2)
            System.out.println("\nVocê deseja visualizar a conta.");


        System.out.printf("Número: ");
        Integer numero = in.nextInt();
        in.nextLine();

        FaturaCreditoDTO faturaCreditoDTO = null;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        if(saldoConta == 1){

            faturaCreditoDTO= operadora.listaCreditos(numero);

            String trace = new String(new char[ 42 ]).replace('\0', '-');

            System.out.print("");
            System.out.println(trace);
            System.out.println(String.format("Saldo do telefone %d", faturaCreditoDTO.getCelular().getNumero()));

            System.out.println(trace);


            System.out.printf("Saldo: %.2f\n", faturaCreditoDTO.getValue());
            System.out.printf("Validade: " + formatter.format(faturaCreditoDTO.getValidadeVencimento().getTime()) + "\n");

            System.out.println(trace);
            System.out.println("\nPressione ENTER para continuar");
            in.nextLine();

        } else if (saldoConta == 2){
            faturaCreditoDTO= operadora.listaConta(numero);

            String trace = new String(new char[ 42 ]).replace('\0', '-');

            System.out.print("");
            System.out.println(trace);
            System.out.println(String.format("Conta do telefone %d", faturaCreditoDTO.getCelular().getNumero()));

            System.out.println(trace);


            System.out.printf("Valor da conta: %.2f\n", faturaCreditoDTO.getValue());
            System.out.printf("Vencimento: " + formatter.format(faturaCreditoDTO.getValidadeVencimento().getTime()) + "\n");

            System.out.println(trace);
            System.out.println("\nPressione ENTER para continuar");
            in.nextLine();
        }
    }

}
