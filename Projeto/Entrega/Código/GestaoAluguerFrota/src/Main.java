// Importação das classes necessárias para a implementação do sistema.
// Incluem modelos, serviços e utilitários que suportam as operações principais do programa.
import java.time.LocalDate;
import java.util.List;
import models.Aluguer;
import models.Automovel;
import models.Cliente;
import services.AluguerService;
import services.AutomovelService;
import services.ClienteService; // Importação da classe LocalDate para manipulação de datas.
import utils.InputUtils; // Importação da interface List para operações com listas.

public class Main {
    // Método principal que serve como ponto de entrada do programa.
    public static void main(String[] args) {
        // Instanciação dos serviços que gerem os automóveis, clientes e alugueres.
        AutomovelService automovelService = new AutomovelService();
        ClienteService clienteService = new ClienteService();
        AluguerService aluguerService = new AluguerService();

        // Loop principal que apresenta o menu e lida com a escolha do utilizador.
        while (true) {
            System.out.println("\n=== Rent Car Lda ==="); // Cabeçalho do menu principal.
            System.out.println("1. Gerir Automóveis");
            System.out.println("2. Gerir Clientes");
            System.out.println("3. Gerir Alugueres");
            System.out.println("4. Listagens");
            System.out.println("5. Sair");

            // Leitura da opção escolhida pelo utilizador.
            int opcao = InputUtils.lerInt("Escolha uma opção: ");

            // Estrutura de decisão que encaminha para a funcionalidade correspondente.
            switch (opcao) {
                case 1 -> gerirAutomoveis(automovelService); // Opção para gerir automóveis.
                case 2 -> gerirClientes(clienteService); // Opção para gerir clientes.
                case 3 -> gerirAlugueres(automovelService, clienteService, aluguerService); // Opção para gerir alugueres.
                case 4 -> mostrarListagens(automovelService, aluguerService); // Opção para exibir listagens.
                case 5 -> { // Opção para sair do programa.
                    System.out.println("Encerrando o sistema...");
                    InputUtils.fecharScanner(); // Fecha o recurso de leitura de entrada.
                    return; // Termina a execução do programa.
                }
                default -> System.out.println("Opção inválida. Tente novamente."); // Mensagem de erro para entrada inválida.
            }
        }
    }

    // Método para gerir as operações relacionadas aos automóveis.
    private static void gerirAutomoveis(AutomovelService automovelService) {
        System.out.println("\n=== Gestão de Automóveis ==="); // Cabeçalho da secção de gestão de automóveis.
        System.out.println("1. Adicionar Automóvel");
        System.out.println("2. Atualizar Automóvel");
        System.out.println("3. Remover Automóvel");
        System.out.println("4. Listar Automóveis");
        int opcao = InputUtils.lerInt("Escolha uma opção: "); // Leitura da opção do utilizador.

        switch (opcao) {
            case 1 -> { // Opção para adicionar um automóvel.
                String marca = InputUtils.lerString("Marca: "); // Leitura da marca do automóvel.
                String modelo = InputUtils.lerString("Modelo: "); // Leitura do modelo.
                String cor = InputUtils.lerString("Cor: "); // Leitura da cor.
                int cilindrada = InputUtils.lerInt("Cilindrada: "); // Leitura da cilindrada.
                int ano = InputUtils.lerInt("Ano de aquisição: "); // Leitura do ano de aquisição.
                String matricula = InputUtils.lerString("Matrícula: "); // Leitura da matrícula.
                double valorDia = InputUtils.lerDouble("Valor por dia: "); // Leitura do valor diário.

                // Criação de um novo objeto Automovel com os dados fornecidos.
                Automovel automovel = new Automovel(marca, modelo, cor, cilindrada, ano, matricula, valorDia);
                automovelService.adicionarAutomovel(automovel); // Adiciona o automóvel ao sistema.
                System.out.println("Automóvel adicionado com sucesso!");
            }
            case 2 -> { // Opção para atualizar os dados de um automóvel.
                String matricula = InputUtils.lerString("Matrícula do automóvel a atualizar: ");
                automovelService.buscarPorMatricula(matricula).ifPresentOrElse(automovel -> {
                    // Atualização dos atributos do automóvel.
                    String novaMarca = InputUtils.lerString("Nova Marca: ");
                    String novoModelo = InputUtils.lerString("Novo Modelo: ");
                    String novaCor = InputUtils.lerString("Nova Cor: ");
                    int novaCilindrada = InputUtils.lerInt("Nova Cilindrada: ");
                    int novoAno = InputUtils.lerInt("Novo Ano de aquisição: ");
                    double novoValorDia = InputUtils.lerDouble("Novo Valor por dia: ");

                    // Atualiza os atributos no objeto Automovel.
                    automovel.setMarca(novaMarca);
                    automovel.setModelo(novoModelo);
                    automovel.setCor(novaCor);
                    automovel.setCilindrada(novaCilindrada);
                    automovel.setAnoAquisicao(novoAno);
                    automovel.setValorDia(novoValorDia);

                    System.out.println("Automóvel atualizado com sucesso!");
                }, () -> System.out.println("Automóvel não encontrado."));
            }
            case 3 -> { // Opção para remover um automóvel.
                String matricula = InputUtils.lerString("Matrícula do automóvel a remover: ");
                automovelService.removerAutomovel(matricula); // Remove o automóvel com a matrícula especificada.
                System.out.println("Automóvel removido com sucesso!");
            }
            case 4 -> { // Opção para listar todos os automóveis.
                List<Automovel> automoveis = automovelService.listarAutomoveis();
                if (automoveis.isEmpty()) {
                    System.out.println("Nenhum automóvel cadastrado."); // Mensagem para lista vazia.
                } else {
                    automoveis.forEach(System.out::println); // Exibe os automóveis existentes.
                }
            }
            default -> System.out.println("Opção inválida."); // Mensagem de erro para entrada inválida.
        }
    }

    // Os outros métodos seguem uma estrutura semelhante, permitindo a gestão de clientes, alugueres e listagens.

    // Método para gerir as operações relacionadas aos clientes.
    private static void gerirClientes(ClienteService clienteService) {
        System.out.println("\n=== Gestão de Clientes ==="); // Cabeçalho da secção de gestão de clientes.
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Atualizar Cliente");
        System.out.println("3. Remover Cliente");
        System.out.println("4. Listar Clientes");
        int opcao = InputUtils.lerInt("Escolha uma opção: "); // Leitura da opção do utilizador.

        switch (opcao) {
            case 1 -> { // Opção para adicionar um cliente.
                String nome = InputUtils.lerString("Nome: "); // Leitura do nome do cliente.
                String morada = InputUtils.lerString("Morada: "); // Leitura da morada.
                String cc = InputUtils.lerString("Cartão de Cidadão (CC): "); // Leitura do número do CC.
                String cartaConducao = InputUtils.lerString("Número da Carta de Condução: "); // Leitura do número da carta de condução.

                // Criação de um novo objeto Cliente com os dados fornecidos.
                Cliente cliente = new Cliente(nome, morada, cc, cartaConducao);
                clienteService.adicionarCliente(cliente); // Adiciona o cliente ao sistema.
                System.out.println("Cliente adicionado com sucesso!");
            }
            case 2 -> { // Opção para atualizar os dados de um cliente.
                String cc = InputUtils.lerString("CC do cliente a atualizar: ");
                clienteService.buscarPorCC(cc).ifPresentOrElse(cliente -> {
                    // Atualização dos atributos do cliente.
                    String novoNome = InputUtils.lerString("Novo Nome: ");
                    String novaMorada = InputUtils.lerString("Nova Morada: ");
                    String novaCartaConducao = InputUtils.lerString("Nova Carta de Condução: ");

                    // Atualiza os atributos no objeto Cliente.
                    cliente.setNome(novoNome);
                    cliente.setMorada(novaMorada);
                    cliente.setCartaConducao(novaCartaConducao);

                    System.out.println("Cliente atualizado com sucesso!");
                }, () -> System.out.println("Cliente não encontrado."));
            }
            case 3 -> { // Opção para remover um cliente.
                String cc = InputUtils.lerString("CC do cliente a remover: ");
                clienteService.removerCliente(cc); // Remove o cliente com o CC especificado.
                System.out.println("Cliente removido com sucesso!");
            }
            case 4 -> { // Opção para listar todos os clientes.
                List<Cliente> clientes = clienteService.listarClientes();
                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado."); // Mensagem para lista vazia.
                } else {
                    clientes.forEach(System.out::println); // Exibe os clientes existentes.
                }
            }
            default -> System.out.println("Opção inválida."); // Mensagem de erro para entrada inválida.
        }
    }

    // Método para gerir as operações relacionadas aos alugueres.
    private static void gerirAlugueres(AutomovelService automovelService, ClienteService clienteService, AluguerService aluguerService) {
        System.out.println("\n=== Gestão de Alugueres ==="); // Cabeçalho da secção de gestão de alugueres.
        System.out.println("1. Adicionar Aluguer");
        System.out.println("2. Remover Aluguer");
        System.out.println("3. Listar Alugueres");
        int opcao = InputUtils.lerInt("Escolha uma opção: "); // Leitura da opção do utilizador.

        switch (opcao) {
            case 1 -> { // Opção para adicionar um aluguer.
                String matricula = InputUtils.lerString("Matrícula do automóvel: "); // Leitura da matrícula do automóvel.
                automovelService.buscarPorMatricula(matricula).ifPresentOrElse(automovel -> {
                    String cc = InputUtils.lerString("CC do cliente: "); // Leitura do CC do cliente.
                    clienteService.buscarPorCC(cc).ifPresentOrElse(cliente -> {
                        LocalDate dataInicio = InputUtils.lerData("Data de início (dd/MM/yyyy): "); // Leitura da data de início.
                        LocalDate dataFim = InputUtils.lerData("Data de fim (dd/MM/yyyy): "); // Leitura da data de fim.
                        try {
                            // Criação de um novo aluguer com os dados fornecidos.
                            Aluguer aluguer = new Aluguer(automovel, cliente, dataInicio, dataFim);
                            aluguerService.adicionarAluguer(aluguer); // Regista o aluguer no sistema.
                            System.out.println("Aluguer registrado com sucesso!");
                        } catch (IllegalArgumentException e) { // Captura de exceções caso os dados sejam inválidos.
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }, () -> System.out.println("Cliente não encontrado.")); // Mensagem de erro para cliente não encontrado.
                }, () -> System.out.println("Automóvel não encontrado.")); // Mensagem de erro para automóvel não encontrado.
            }
            case 2 -> { // Opção para remover um aluguer.
                List<Aluguer> alugueres = aluguerService.listarAlugueres();
                if (alugueres.isEmpty()) {
                    System.out.println("Nenhum aluguer registrado."); // Mensagem para lista vazia.
                } else {
                    System.out.println("Lista de Alugueres:");
                    for (int i = 0; i < alugueres.size(); i++) {
                        System.out.println((i + 1) + ". " + alugueres.get(i)); // Exibe os alugueres registrados.
                    }
                    int indice = InputUtils.lerInt("Escolha o número do aluguer a remover: ") - 1; // Leitura da posição do aluguer a remover.
                    if (indice >= 0 && indice < alugueres.size()) {
                        aluguerService.removerAluguer(alugueres.get(indice)); // Remove o aluguer selecionado.
                        System.out.println("Aluguer removido com sucesso!");
                    } else {
                        System.out.println("Opção inválida."); // Mensagem de erro para entrada inválida.
                    }
                }
            }
            case 3 -> { // Opção para listar todos os alugueres.
                List<Aluguer> alugueres = aluguerService.listarAlugueres();
                if (alugueres.isEmpty()) {
                    System.out.println("Nenhum aluguer registrado."); // Mensagem para lista vazia.
                } else {
                    alugueres.forEach(System.out::println); // Exibe os alugueres existentes.
                }
            }
            default -> System.out.println("Opção inválida."); // Mensagem de erro para entrada inválida.
        }
    }

    // Método para exibir as listagens do sistema.
    private static void mostrarListagens(AutomovelService automovelService, AluguerService aluguerService) {
        System.out.println("\n=== Listagens ==="); // Cabeçalho da secção de listagens.
        System.out.println("1. Automóveis alugados");
        System.out.println("2. Automóveis disponíveis");
        System.out.println("3. Alugueres ordenados por data de entrega");
        int opcao = InputUtils.lerInt("Escolha uma opção: "); // Leitura da opção do utilizador.

        switch (opcao) {
            case 1 -> { // Opção para listar automóveis alugados.
                List<Aluguer> alugados = aluguerService.listarAlugueres();
                System.out.println("Automóveis alugados:");
                alugados.forEach(aluguer -> System.out.println(aluguer.getAutomovel())); // Exibe os automóveis alugados.
            }
            case 2 -> { // Opção para listar automóveis disponíveis.
                List<Automovel> todosAutomoveis = automovelService.listarAutomoveis();
                List<Automovel> disponiveis = aluguerService.listarAutomoveisDisponiveis(todosAutomoveis);
                System.out.println("Automóveis disponíveis:");
                disponiveis.forEach(System.out::println); // Exibe os automóveis disponíveis.
            }
            case 3 -> { // Opção para listar alugueres ordenados por data de entrega.
                List<Aluguer> ordenados = aluguerService.listarAutomoveisAlugadosOrdenadoPorEntrega();
                System.out.println("Alugueres ordenados por data de entrega:");
                ordenados.forEach(System.out::println); // Exibe os alugueres ordenados.
            }
            default -> System.out.println("Opção inválida."); // Mensagem de erro para entrada inválida.
        }
    }
}
