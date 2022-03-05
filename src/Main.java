package src;

import src.config.Conexao;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Provedor provedor = new Provedor();
        conn = provedor.pegaConexao();

        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            opcao = mostraMenuInicial(scan, opcao);
            switch (opcao) {
                default: {
                    mostraErroUsuario();
                    break;
                }
                case 1: {
                    opcao = mostraMedicoOperacao(scan, opcao);
                    break;
                }
                case 2: {
                    opcao = mostraEnfermeiroOperacao(scan, opcao);
                    break;
                }
                case 3: {
                    opcao = mostrarCadastroNovoUsuario(scan, opcao);
                    break;
                }
                case 4: {
                    break;
                }
            }
        } while (opcao != 0);
    }

    public static int mostraMenuInicial(Scanner scan, int opcao) {
        System.out.println("------------------- HOSPITAL -------------------");
        System.out.println("Seja bem-vindo(a) ao sistema deste hospital!");
        System.out.println("Quem você é? ");
        System.out.println("1 - Médico(a);");
        System.out.println("2 - Enfermeiro(a);");
        System.out.println("3 - Novo usuário.");
        System.out.println("------------------------------------------------");
        System.out.println("Digite 0 se desejar sair do sistema.");
        opcao = scan.nextInt();
    }

    public static int mostraMedicoOperacao(Scanner scan, int opcao) {
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
        System.out.println("0- Sair do menu.");
        opcao = scan.nextInt();
    }

    public static int trataMedicoOperacao(int opcao) {
        switch (opcao) {
            default: {
                mostraErroUsuario();
                break;
            }
            case 0: {
                return 0;
                break;
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
    }

    public static int mostraEnfermeiroOperacao(Scanner scan, int opcao) {
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
        System.out.println("0- Sair do menu;");
        opcao = scan.nextInt();
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
    }

    public static int mostrarCadastroNovoUsuario(Scanner scan, int opcao) {
        System.out.println("------------------- Operações de Novo usuário -------------------");
        System.out.println("O que voce deseja?");
        System.out.println("1- Cadastrar novo perfil de Médico;");
        System.out.println("2- Cadastrar novo perfil de Enfermeiro;");
        System.out.println("------------------------------------------------");
        System.out.println("0- Sair do menu;");
        opcao = scan.nextInt();
    }

    public static void trataCadastroNovoUsuario(int opcao) {
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
        }
    }

    public static void mostraErroUsuario() {
        System.out.println("Você inseriu um número inválido para esse menu.");
        System.out.println("Tente novamente!");
    }
}