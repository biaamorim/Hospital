import config.ProvedorPostgres;
import dao.medicoDao;
import domain.Medico;

import java.sql.Connection;
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
                }
                case 2 -> {
                    opcao = mostraEnfermeiroOperacao(scan);
                }
                case 3 -> {
                    opcao = mostrarCadastroNovoUsuario(scan);
                }
                case 4 -> {
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
        System.out.println("1- Ver Paciente;");
        System.out.println("2- Ver ficha;");
        System.out.println("3- Ver Registro;");
        System.out.println("4- Ver Perfil;");
        System.out.println("5- Preencher registro médico;");
        System.out.println("6- Atualizar dados pessoais;");
        System.out.println("7- Remover Conta;");
        System.out.println("------------------------------------------------");
        System.out.println("Digite 0 se desejar sair do menu.");
        return scan.nextInt();
    }

    public static int trataMedicoOperacao(int opcao) {
        switch (opcao) {
            default: {
                mostraErroUsuario();
                break;
            }
            case 0: {
                return 0;
            }
            case 1: {
            }
            case 2: {
            }
            case 3: {
            }
            case 4: {
            }
            case 5: {
            }
            case 6: {
            }
            case 7: {
            }
        }
        return opcao;
    }

    public static int mostraEnfermeiroOperacao(Scanner scan) {
        System.out.println("------------------- Operações de Enfermeiro -------------------");
        System.out.println("O que voce deseja?");
        System.out.println("1- Ver Paciente;");
        System.out.println("2- Ver ficha;");
        System.out.println("3- Ver Registro;");
        System.out.println("4- Ver Perfil;");
        System.out.println("5- Cadastrar ficha;");
        System.out.println("6- Cadastrar Paciente!;");
        System.out.println("7- Preencher registro médico");
        System.out.println("8- Atualizar dados pessoais;");
        System.out.println("9- Remover conta;");
        System.out.println("------------------------------------------------");
        System.out.println("Digite 0 se desejar sair do menu.");
        return scan.nextInt();
    }

    public static int trataEnfermeiroOperacao(int opcao) {
        switch (opcao) {
            default: {
                mostraErroUsuario();
                break;
            }
            case 0: {
            }
            case 1: {
            }
            case 2: {
            }
            case 3: {
            }
            case 4: {
            }
            case 5: {
            }
            case 6: {
            }
            case 7: {
            }
            case 8: {
            }
            case 9: {
            }
        }
        return opcao;
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
                return 0;
            }
            case 1 -> {
                medicoDao medicoDao = new medicoDao();
                Medico medico = medicoDao.cadastraMedico(null);
                System.out.printf("Médico cadastrado com sucesso. Este é o seu id: %d", medico.getId());
            }
            case 2 -> {
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