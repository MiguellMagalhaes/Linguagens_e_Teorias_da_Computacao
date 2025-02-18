import models.Aluguer;
import models.Automovel;
import models.Cliente;
import services.AluguerService;
import services.AutomovelService;
import services.ClienteService;
import utils.InputUtils;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AutomovelService automovelService = new AutomovelService();
        ClienteService clienteService = new ClienteService();
        AluguerService aluguerService = new AluguerService();

        while (true) {
            System.out.println("\n=== Rent Car Lda ===");
            System.out.println("1. Gerir Automóveis");
            System.out.println("2. Gerir Clientes");
            System.out.println("3. Gerir Alugueres");
            System.out.println("4. Listagens");
            System.out.println("5. Sair");

            int opcao = InputUtils.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> gerirAutomoveis(automovelService);
                case 2 -> gerirClientes(clienteService);
                case 3 -> gerirAlugueres(automovelService, clienteService, aluguerService);
                case 4 -> mostrarListagens(automovelService, aluguerService);
                case 5 -> {
                    System.out.println("Encerrando o sistema...");
                    InputUtils.fecharScanner();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerirAutomoveis(AutomovelService automovelService) {
        System.out.println("\n=== Gestão de Automóveis ===");
        System.out.println("1. Adicionar Automóvel");
        System.out.println("2. Atualizar Automóvel");
        System.out.println("3. Remover Automóvel");
        System.out.println("4. Listar Automóveis");
        int opcao = InputUtils.lerInt("Escolha uma opção: ");

        switch (opcao) {
            case 1 -> {
                String marca = InputUtils.lerString("Marca: ");
                String modelo = InputUtils.lerString("Modelo: ");
                String cor = InputUtils.lerString("Cor: ");
                int cilindrada = InputUtils.lerInt("Cilindrada: ");
                int ano = InputUtils.lerInt("Ano de aquisição: ");
                String matricula = InputUtils.lerString("Matrícula: ");
                double valorDia = InputUtils.lerDouble("Valor por dia: ");

                Automovel automovel = new Automovel(marca, modelo, cor, cilindrada, ano, matricula, valorDia);
                automovelService.adicionarAutomovel(automovel);
                System.out.println("Automóvel adicionado com sucesso!");
            }
            case 2 -> {
                String matricula = InputUtils.lerString("Matrícula do automóvel a atualizar: ");
                automovelService.buscarPorMatricula(matricula).ifPresentOrElse(automovel -> {
                    String novaMarca = InputUtils.lerString("Nova Marca: ");
                    String novoModelo = InputUtils.lerString("Novo Modelo: ");
                    String novaCor = InputUtils.lerString("Nova Cor: ");
                    int novaCilindrada = InputUtils.lerInt("Nova Cilindrada: ");
                    int novoAno = InputUtils.lerInt("Novo Ano de aquisição: ");
                    double novoValorDia = InputUtils.lerDouble("Novo Valor por dia: ");

                    automovel.setMarca(novaMarca);
                    automovel.setModelo(novoModelo);
                    automovel.setCor(novaCor);
                    automovel.setCilindrada(novaCilindrada);
                    automovel.setAnoAquisicao(novoAno);
                    automovel.setValorDia(novoValorDia);

                    System.out.println("Automóvel atualizado com sucesso!");
                }, () -> System.out.println("Automóvel não encontrado."));
            }
            case 3 -> {
                String matricula = InputUtils.lerString("Matrícula do automóvel a remover: ");
                automovelService.removerAutomovel(matricula);
                System.out.println("Automóvel removido com sucesso!");
            }
            case 4 -> {
                List<Automovel> automoveis = automovelService.listarAutomoveis();
                if (automoveis.isEmpty()) {
                    System.out.println("Nenhum automóvel cadastrado.");
                } else {
                    automoveis.forEach(System.out::println);
                }
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void gerirClientes(ClienteService clienteService) {
        System.out.println("\n=== Gestão de Clientes ===");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Atualizar Cliente");
        System.out.println("3. Remover Cliente");
        System.out.println("4. Listar Clientes");
        int opcao = InputUtils.lerInt("Escolha uma opção: ");

        switch (opcao) {
            case 1 -> {
                String nome = InputUtils.lerString("Nome: ");
                String morada = InputUtils.lerString("Morada: ");
                String cc = InputUtils.lerString("Cartão de Cidadão (CC): ");
                String cartaConducao = InputUtils.lerString("Número da Carta de Condução: ");

                Cliente cliente = new Cliente(nome, morada, cc, cartaConducao);
                clienteService.adicionarCliente(cliente);
                System.out.println("Cliente adicionado com sucesso!");
            }
            case 2 -> {
                String cc = InputUtils.lerString("CC do cliente a atualizar: ");
                clienteService.buscarPorCC(cc).ifPresentOrElse(cliente -> {
                    String novoNome = InputUtils.lerString("Novo Nome: ");
                    String novaMorada = InputUtils.lerString("Nova Morada: ");
                    String novaCartaConducao = InputUtils.lerString("Nova Carta de Condução: ");

                    cliente.setNome(novoNome);
                    cliente.setMorada(novaMorada);
                    cliente.setCartaConducao(novaCartaConducao);

                    System.out.println("Cliente atualizado com sucesso!");
                }, () -> System.out.println("Cliente não encontrado."));
            }
            case 3 -> {
                String cc = InputUtils.lerString("CC do cliente a remover: ");
                clienteService.removerCliente(cc);
                System.out.println("Cliente removido com sucesso!");
            }
            case 4 -> {
                List<Cliente> clientes = clienteService.listarClientes();
                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado.");
                } else {
                    clientes.forEach(System.out::println);
                }
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void gerirAlugueres(AutomovelService automovelService, ClienteService clienteService, AluguerService aluguerService) {
        System.out.println("\n=== Gestão de Alugueres ===");
        System.out.println("1. Adicionar Aluguer");
        System.out.println("2. Remover Aluguer");
        System.out.println("3. Listar Alugueres");
        int opcao = InputUtils.lerInt("Escolha uma opção: ");

        switch (opcao) {
            case 1 -> {
                String matricula = InputUtils.lerString("Matrícula do automóvel: ");
                automovelService.buscarPorMatricula(matricula).ifPresentOrElse(automovel -> {
                    String cc = InputUtils.lerString("CC do cliente: ");
                    clienteService.buscarPorCC(cc).ifPresentOrElse(cliente -> {
                        LocalDate dataInicio = InputUtils.lerData("Data de início (dd/MM/yyyy): ");
                        LocalDate dataFim = InputUtils.lerData("Data de fim (dd/MM/yyyy): ");
                        try {
                            Aluguer aluguer = new Aluguer(automovel, cliente, dataInicio, dataFim);
                            aluguerService.adicionarAluguer(aluguer);
                            System.out.println("Aluguer registrado com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }, () -> System.out.println("Cliente não encontrado."));
                }, () -> System.out.println("Automóvel não encontrado."));
            }
            case 2 -> {
                List<Aluguer> alugueres = aluguerService.listarAlugueres();
                if (alugueres.isEmpty()) {
                    System.out.println("Nenhum aluguer registrado.");
                } else {
                    System.out.println("Lista de Alugueres:");
                    for (int i = 0; i < alugueres.size(); i++) {
                        System.out.println((i + 1) + ". " + alugueres.get(i));
                    }
                    int indice = InputUtils.lerInt("Escolha o número do aluguer a remover: ") - 1;
                    if (indice >= 0 && indice < alugueres.size()) {
                        aluguerService.removerAluguer(alugueres.get(indice));
                        System.out.println("Aluguer removido com sucesso!");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
            }
            case 3 -> {
                List<Aluguer> alugueres = aluguerService.listarAlugueres();
                if (alugueres.isEmpty()) {
                    System.out.println("Nenhum aluguer registrado.");
                } else {
                    alugueres.forEach(System.out::println);
                }
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void mostrarListagens(AutomovelService automovelService, AluguerService aluguerService) {
        System.out.println("\n=== Listagens ===");
        System.out.println("1. Automóveis alugados");
        System.out.println("2. Automóveis disponíveis");
        System.out.println("3. Alugueres ordenados por data de entrega");
        int opcao = InputUtils.lerInt("Escolha uma opção: ");

        switch (opcao) {
            case 1 -> {
                List<Aluguer> alugados = aluguerService.listarAlugueres();
                System.out.println("Automóveis alugados:");
                alugados.forEach(aluguer -> System.out.println(aluguer.getAutomovel()));
            }
            case 2 -> {
                List<Automovel> todosAutomoveis = automovelService.listarAutomoveis();
                List<Automovel> disponiveis = aluguerService.listarAutomoveisDisponiveis(todosAutomoveis);
                System.out.println("Automóveis disponíveis:");
                disponiveis.forEach(System.out::println);
            }
            case 3 -> {
                List<Aluguer> ordenados = aluguerService.listarAutomoveisAlugadosOrdenadoPorEntrega();
                System.out.println("Alugueres ordenados por data de entrega:");
                ordenados.forEach(System.out::println);
            }
            default -> System.out.println("Opção inválida.");
        }
    }
}
