import java.util.Scanner;

public class App {
    public static Empresa setFuncionarios(Empresa empresa) {
        empresa.addFuncionario(new Funcionario("AGATHA VICTORIA CORREA NUNES", "66958985836", "Gerente ", 5000.34f));
        empresa.addFuncionario(new Funcionario("ALANA COSTA DO NASCIMENTO", "52495745947", "Auxiliar de limpeza", 1212.45f));
        empresa.addFuncionario(new Funcionario("FRANCISCO IARLEY SILVA MOURAO", "35094540978", "Auxiliar de limpeza", 1212.45f));
        empresa.addFuncionario(new Funcionario("FRANCISCO ROBSON DA SILVA MONTEIRO", "77419726672", "Auxiliar de cozinha", 1212.45f));
        empresa.addFuncionario(new Funcionario("JOHN ALLYSSON DE OLIVEIRA SOUZA ", "78050071682", "Cozinheiro", 2345.32f));
        empresa.addFuncionario(new Funcionario("JOSE KEVIN QUEIROZ DE OLIVEIRA", "58872866764", "Cozinheiro", 2345.32f));
        empresa.addFuncionario(new Funcionario("LUAN HENRIQUE DE SOUZA LIMA", "73234134155", "Fiscal", 1212.45f));
        empresa.addFuncionario(new Funcionario("LIDIA LIMA RIBEIRO", "80547868848", "Fiscal", 1212.45f));
        empresa.addFuncionario(new Funcionario("LUCAS LEVY DO NASCIMENTO DE SOUSA", "22377298735", "Garçom", 1212.45f));
        empresa.addFuncionario(new Funcionario("PIERRE TOBIAS DA SILVA SANTOS", "41852079139", "Garçom", 1212.45f));
        return empresa;
    }
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        Empresa empresa;
        RestauranteUniversitario restauranteUniversitario;
        ArmazenaEstudante armazenaEstudante = new ArmazenaEstudante();
        byte entrada = 0;
        while (true) {
            System.out.println("Digite as credenciais da empresa.");
            System.out.println("Digite o nome da empresa.");
            final String  NOMEDAEMPRESA = cin.nextLine();
            System.out.println("Digite o CNPJ.");
            final String CNPJ = cin.nextLine();
            empresa = new Empresa(NOMEDAEMPRESA, CNPJ);
            setFuncionarios(empresa);
            cin.reset();
            restauranteUniversitario = new RestauranteUniversitario(empresa);
            final String menu = 
            "|---------------------------------------------------|\n" +
            "|    [1] - Adicionar estudante                      |\n" +
            "|    [2] - Adicionar funcionário                    |\n" +
            "|    [3] - Demitir funcionário                      |\n" + 
            "|    [4] - Obter relatório de funcionários          |\n" +
            "|    [5] - Obter cardápio                           |\n" +
            "|    [6] - Adicionar Créditos                       |\n" +
            "|    [7] - Listar estudantes                        |\n" +
            "|    [8] - Atualizar salário do empregado           |\n" +
            "|    [9] - Sair                                     |\n" +
            "|---------------------------------------------------|\n" +
            "Digite a opção desejada: \n";
            do {
                System.out.println(menu);
                entrada = cin.nextByte();
                cin.reset();
                switch (entrada) {
                    case 1:
                        System.out.println("Digite o nome e matrícula do estudante");
                        String nome = cin.next();
                        String matricula = cin.next();
                        armazenaEstudante.adicionarEstudante(new Estudante(nome, matricula));
                        break;
                    case 2:
                        System.out.println("Digite o nome, CPF, função e o salário do funcionário");
                        // problema com string com espaço, específicamente na parte de função
                        empresa.addFuncionario(new Funcionario(cin.nextLine(), cin.nextLine(), cin.next(), cin.nextInt()));
                        break;
                    case 3:
                        System.out.println("Digite o CPF do funcíonario a ser demitido");
                        empresa.demitirFuncionario(cin.next());
                        break;
                    case 4:
                        empresa.getRelatorioFuncionarios();
                        break;
                    case 5:
                        System.out.println(restauranteUniversitario.getCardapio());
                        break;
                    case 6:
                        System.out.println("Digite o identificador do cartão.");
                        matricula = cin.next();
                        System.out.println("Digite a quantidade de créditos a ser colocada.");
                        byte quantidadeDeCreditos = cin.nextByte();
                        int index = armazenaEstudante.getIndexEstudantePorMatricula(matricula);
                        if (index > -1)
                            armazenaEstudante.getEstudantes().get(index).getCartao().addCreditos(quantidadeDeCreditos);
                        break;
                    case 7:
                        System.out.println(armazenaEstudante);
                        break;
                    case 8:
                        System.out.println("Digite o CPF e o valor que é desejado.");
                        empresa.atualizarSalarioFuncionario(cin.next(), cin.nextInt());
                        break;
                    case 9:
                        System.out.println("Fechando aplicação...");
                        System.exit(1);
                    cin.close();
                }
            }
            while (true);
        }
    }
}

