package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.Cliente;

public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>(); // Lista para armazenar os clientes registados.

    public void adicionarCliente(Cliente cliente) {
        // Verifica se já existe um cliente com o mesmo Cartão de Cidadão (CC) na lista.
        Optional<Cliente> existente = clientes.stream()
                .filter(c -> c.getCc().equals(cliente.getCc()))
                .findFirst();
        if (existente.isPresent()) {
            // Lança uma exceção se o CC já estiver associado a outro cliente.
            throw new IllegalArgumentException("Já existe um cliente com o CC " + cliente.getCc());
        }
        clientes.add(cliente); // Adiciona o novo cliente à lista.
    }

    public void removerCliente(String cc) {
        // Remove o cliente da lista com base no CC fornecido.
        clientes.removeIf(cliente -> cliente.getCc().equals(cc));
    }

    public void atualizarCliente(String cc, Cliente atualizado) {
        // Percorre a lista para encontrar o cliente com o CC especificado.
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCc().equals(cc)) {
                clientes.set(i, atualizado); // Atualiza os dados do cliente encontrado.
                return;
            }
        }
        // Lança uma exceção caso o CC não corresponda a nenhum cliente na lista.
        throw new IllegalArgumentException("Cliente com CC " + cc + " não encontrado.");
    }

    public List<Cliente> listarClientes() {
        // Retorna uma cópia da lista de clientes para evitar alterações externas.
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> buscarPorCC(String cc) {
        // Busca e retorna um cliente com o CC especificado, se existir.
        return clientes.stream().filter(c -> c.getCc().equals(cc)).findFirst();
    }
}
