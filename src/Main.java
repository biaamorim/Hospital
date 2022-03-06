import dao.EnfermeiroDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.RegistroDAO;
import domain.Enfermeiro;
import domain.Medico;
import domain.Paciente;

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
                    opcao = trataMedicoOperacao();
                }
                case 2 -> {
                    opcao = trataEnfermeiroOperacao();
                }
                case 3 -> {
                    opcao = trataCadastroNovoUsuario();
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

    public static int trataMedicoOperacao() {
        Scanner scan = new Scanner(System.in);
        int opcaoLocal = mostraMedicoOperacao(scan);
        do {
            switch (opcaoLocal) {
                default -> {
                    mostraErroUsuario();
                    opcaoLocal = mostraMedicoOperacao(scan);
                }
                case 0 -> {
                    return 4;
                }
                case 1 -> {
                    PacienteDAO paciente = new PacienteDAO();
                    paciente.listaPaciente();
                    opcaoLocal = mostraMedicoOperacao(scan);
                }
            /* case 2 -> {
            } */
                case 3 -> {
                    RegistroDAO registroDAO = new RegistroDAO();
                    registroDAO.listaRegistros();
                    opcaoLocal = mostraMedicoOperacao(scan);
                }
                case 4 -> {
                    MedicoDAO medicoDAO = new MedicoDAO();
                    medicoDAO.listaMedicos();
                    opcaoLocal = mostraMedicoOperacao(scan);
                }
                case 5 -> {
                    RegistroDAO registroDAO = new RegistroDAO();
                    registroDAO.cadastraRegistro();
                    System.out.println("Registro concluído com sucesso!");
                    opcaoLocal = mostraMedicoOperacao(scan);
                }
                case 6 -> {
                    MedicoDAO medicoDAO = new MedicoDAO();
                    System.out.println("Insira o id do médico a atualizar: ");
                    int id = scan.nextInt();
                    Medico medico = medicoDAO.preencheMedico();
                    medicoDAO.atualizaMedico(medico, id);
                    System.out.println("O médico foi atualizado com sucesso!");
                    opcaoLocal = mostraMedicoOperacao(scan);
                }
                case 7 -> {
                    MedicoDAO medicoDAO = new MedicoDAO();
                    System.out.println("Insira o id do médico a remover: ");
                    int id = scan.nextInt();
                    medicoDAO.removeMedico(id);
                    System.out.println("Médico removido com sucesso!");
                    opcaoLocal = mostraMedicoOperacao(scan);
                }
            }
        } while (opcaoLocal != 0);
        return 4;
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

    public static int trataEnfermeiroOperacao() {
        Scanner scan = new Scanner(System.in);
        int opcaoLocal = mostraEnfermeiroOperacao(scan);
        do {
            switch (opcaoLocal) {
                default -> {
                    mostraErroUsuario();
                    opcaoLocal = mostraEnfermeiroOperacao(scan);
                }
                case 0 -> {
                    System.out.println("------------------------------------------------");
                }
                case 1 -> {
                     PacienteDAO paciente = new PacienteDAO();
                     paciente.listaPaciente();
                     opcaoLocal = mostraMedicoOperacao(scan);
                }
            /* case 2 -> {
            } */
                case 3 -> {
                    RegistroDAO registroDAO = new RegistroDAO();
                    registroDAO.listaRegistros();
                    opcaoLocal = mostraEnfermeiroOperacao(scan);
                }
                case 4 -> {
                    EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                    enfermeiroDAO.listaEnfermeiros();
                    opcaoLocal = mostraEnfermeiroOperacao(scan);
                }
                case 5 -> {
                }
                case 6 -> {
                    PacienteDAO pacienteDAO = new PacienteDAO();
                    Paciente paciente = pacienteDAO.preenchePaciente();
                    pacienteDAO.cadastrarPaciente(paciente);
                    System.out.println("Paciente cadastrado com sucesso.");
                    opcaoLocal = mostraEnfermeiroOperacao(scan);
                } 
                case 7 -> {
                    RegistroDAO registroDAO = new RegistroDAO();
                    registroDAO.cadastraRegistro();
                    System.out.println("Registro concluído com sucesso!");
                    opcaoLocal = mostraEnfermeiroOperacao(scan);
                }
                case 8 -> {
                    EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                    System.out.println("Insira o id do enfermeiro a atualizar: ");
                    int id = scan.nextInt();
                    Enfermeiro enfermeiro = enfermeiroDAO.preencheEnfermeiro();
                    enfermeiroDAO.atualizaEnfermeiro(enfermeiro, id);
                    System.out.println("O enfermeiro foi atualizado com sucesso!");
                    opcaoLocal = mostraEnfermeiroOperacao(scan);
                }
                case 9 -> {
                    EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                    System.out.println("Insira o id do enfermeiro a remover: ");
                    int id = scan.nextInt();
                    enfermeiroDAO.removeEnfermeiro(id);
                    System.out.println("Enfermeiro removido com sucesso!");
                    opcaoLocal = mostraEnfermeiroOperacao(scan);
                }
            }
        } while (opcaoLocal != 0);
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

    public static int trataCadastroNovoUsuario() {
        Scanner scan = new Scanner(System.in);
        int opcaoLocal = mostrarCadastroNovoUsuario(scan);
        do {
            switch (opcaoLocal) {
                default -> {
                    mostraErroUsuario();
                    opcaoLocal = mostrarCadastroNovoUsuario(scan);
                }
                case 0 -> {
                    System.out.println("------------------------------------------------");
                }
                case 1 -> {
                    MedicoDAO medicoDao = new MedicoDAO();
                    Medico medico = medicoDao.preencheMedico();
                    medicoDao.cadastraMedico(medico);
                    System.out.println("Médico cadastrado com sucesso.");
                    opcaoLocal = mostrarCadastroNovoUsuario(scan);
                }
                case 2 -> {
                    EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
                    Enfermeiro enfermeiro = enfermeiroDAO.preencheEnfermeiro();
                    enfermeiroDAO.cadastraEnfermeiro(enfermeiro);
                    System.out.println("Enfermeiro cadastrado com sucesso.");
                    opcaoLocal = mostrarCadastroNovoUsuario(scan);
                }
            }
        } while (opcaoLocal != 0);
        return 4;
    }

    public static void mostraErroUsuario() {
        System.out.println("Você inseriu um número inválido para esse menu.");
        System.out.println("Tente novamente!");
        System.out.println("------------------------------------------------");
    }
}