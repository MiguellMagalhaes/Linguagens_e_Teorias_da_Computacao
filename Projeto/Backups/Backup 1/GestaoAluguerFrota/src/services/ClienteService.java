package services;

import models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        Optional<Cliente> existente = clientes.stream()
                .filter(c -> c.getCc().equals(cliente.getCc()))
                .findFirst();
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Já existe um cliente com o CC " + cliente.getCc());
        }
        clientes.add(cliente);
    }

    public void removerCliente(String cc) {
        clientes.removeIf(cliente -> cliente.getCc().equals(cc));
    }

    public void atualizarCliente(String cc, Cliente atualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCc().equals(cc)) {
                clientes.set(i, atualizado);
                return;
            }
        }
        throw new IllegalArgumentException("Cliente com CC " + cc + " não encontrado.");
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> buscarPorCC(String cc) {
        return clientes.stream().filter(c -> c.getCc().equals(cc)).findFirst();
    }
}
