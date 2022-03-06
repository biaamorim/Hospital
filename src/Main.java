import dao.EnfermeiroDAO;
import dao.MedicoDAO;
import domain.Enfermeiro;
import domain.Medico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            opcao = mostraMenuInicial(scan);
            switch (opcao) {
                default -> {
                    mostraErroUsuario();
                }
                case 0 -> {
                    System.out.println("------------------------------------------------");
                    System.out.println("Volte mais vezes!");
                }
                case 1 -> {
                    opcao = mostraMedicoOperacao(scan);
                    opcao = trataMedicoOperacao(opcao);
                }
                case 2 -> {
                    opcao = mostraEnfermeiroOperacao(scan);
                    opcao = trataEnfermeiroOperacao(opcao);
                }
                case 3 -> {
                    opcao = mostrarCadastroNovoUsuario(scan);
                    opcao = trataCadastroNovoUsuario(opcao);
                }
                case 4 -> {
                    System.out.println("\n");
                }
            }
        } while (opcao != 0);
    }

    public static int mostraMenuInicial(Scanner scan) {
        System.out.println("------------------- HOSPITAL -------------------");
        System.out.println("Seja bem-vindo(a) ao sistema deste hospital!");
        System.out.println("Quem você é? ");
        System.out.println("1 - Médico(a);");
        System.out.println("2 - Enfermeiro(a);");
        System.out.println("3 - Novo usuário.");
        System.out.println("------------------------------------------------");
        System.out.println("Digite 0 se desejar sair do sistema.");
        return scan.nextInt();
    }

    public static int mostraMedicoOperacao(Scanner scan) {
        System.out.println("------------------- Operações de Médico -------------------");
        System.out.println("O que você deseja fazer hoje?");
        System.out.println("1- Ver Pacientes;");
        System.out.println("2- Ver fichas;");
        System.out.println("3- Ver Registros;");
        System.out.println("4- Ver Perfis;");
        System.out.println("5- Preencher registro médico;");
        System.out.println("6- Atualizar dados pessoais;");
        System.out.println("7- Remover Conta;");
        System.out.println("------------------------------------------------");
        System.out.println("Digite 0 se desejar sair do menu.");
        return scan.nextInt();
    }

    public static int trataMedicoOperacao(int opcao) {
        switch (opcao) {
            default -> {
                mostraErroUsuario();
            }
            case 0 -> {
                return 4;
            }
            /* case 1 -> {
            }
            case 2 -> {
            }
            case 3-> {
            } */
            case 4-> {
                MedicoDAO medicoDAO = new MedicoDAO();
                medicoDAO.listaMedicos();
            } /*
            case 5 -> {
            } */
            case 6 -> {
                MedicoDAO medicoDAO = new MedicoDAO();
                Scanner scan = new Scanner(System.in);
                System.out.println("Insira o id do médico a atualizar: ");
                int id = scan.nextInt();
                Medico medico = medicoDAO.preencheMedico();
                medicoDAO.atualizaMedico(medico, id);
                System.out.println("O médico foi atualizado com sucesso!");
            }
            case 7 -> {
                MedicoDAO medicoDAO = new MedicoDAO();
                Scanner scan = new Scanner(System.in);
                System.out.println("Insira o id do médico a remover: ");
                int id = scan.nextInt();
                medicoDAO.removeMedico(id);
                System.out.println("Médico removido com sucesso!");
            }
        }
        return opcao;
    }

    public static int mostraEnfermeiroOperacao(Scanner scan) {
        System.out.println("------------------- Operações de Enfermeiro -------------------");
        System.out.println("O que voce deseja?");
        System.out.println("1- Ver Pacientes;");
        System.out.println("2- Ver fichas;");
        System.out.println("3- Ver Registros;");
        System.out.println("4- Ver Perfis;");
        System.out.println("5- Cadastrar ficha;");
        System.out.println("6- Cadastrar Paciente;");
        System.out.println("7- Preencher registro médico");
        System.out.println("8- Atualizar dados pessoais;");
        System.out.println("9- Remover conta;");
        System.out.println("------------------------------------------------");
        System.out.println("Digite 0 se desejar sair do menu.");
        return scan.nextInt();
    }

    public static int trataEnfermeiroOperacao(int opcao) {
        switch (opcao) {
            default -> {
                mostraErroUsuario();
            }
            case 0 -> {}
            /*case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {
            } */
            case 4 -> {
                EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                enfermeiroDAO.listaEnfermeiros();
            }
            /* case 5 -> {
            }
            case 6 -> {
            }
            case 7 -> {
            } */
            case 8 -> {
                EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                Scanner scan = new Scanner(System.in);
                System.out.println("Insira o id do enfermeiro a atualizar: ");
                int id = scan.nextInt();
                Enfermeiro enfermeiro = enfermeiroDAO.preencheEnfermeiro();
                enfermeiroDAO.atualizaEnfermeiro(enfermeiro, id);
                System.out.println("O enfermeiro foi atualizado com sucesso!");
            }
            case 9 -> {
                EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                Scanner scan = new Scanner(System.in);
                System.out.println("Insira o id do enfermeiro a remover: ");
                int id = scan.nextInt();
                enfermeiroDAO.removeEnfermeiro(id);
                System.out.println("Enfermeiro removido com sucesso!");
            }
        }
        return 4;
    }

    public static int mostrarCadastroNovoUsuario(Scanner scan) {
        System.out.println("------------------- Operações de Novo usuário -------------------");
        System.out.println("O que voce deseja?");
        System.out.println("1- Cadastrar novo perfil de Médico;");
        System.out.println("2- Cadastrar novo perfil de Enfermeiro;");
        System.out.println("------------------------------------------------");
        System.out.println("Digite 0 se desejar sair do menu.");
        return scan.nextInt();
    }

    public static int trataCadastroNovoUsuario(int opcao) {
        switch (opcao) {
            default -> {
                mostraErroUsuario();
            }
            case 0 -> {
                return 4;
            }
            case 1 -> {
                MedicoDAO medicoDao = new MedicoDAO();
                Medico medico = medicoDao.preencheMedico();
                medicoDao.cadastraMedico(medico);
                System.out.println("Médico cadastrado com sucesso.");
            }
            case 2 -> {
                EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                Enfermeiro enfermeiro = enfermeiroDAO.preencheEnfermeiro();
                enfermeiroDAO.cadastraEnfermeiro(enfermeiro);
                System.out.println("Enfermeiro cadastrado com sucesso.");
            }
        }
        return 4;
    }

    public static void mostraErroUsuario() {
        System.out.println("Você inseriu um número inválido para esse menu.");
        System.out.println("Tente novamente!");
        System.out.println("------------------------------------------------");
    }
}