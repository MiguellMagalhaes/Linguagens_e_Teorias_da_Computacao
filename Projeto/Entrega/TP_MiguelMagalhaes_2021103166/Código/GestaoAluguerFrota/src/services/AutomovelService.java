package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.Automovel;

public class AutomovelService {
    private final List<Automovel> automoveis = new ArrayList<>(); // Lista para armazenar os automóveis registados.

    public void adicionarAutomovel(Automovel automovel) {
        // Verifica se já existe um automóvel com a mesma matrícula na lista.
        Optional<Automovel> existente = automoveis.stream()
                .filter(a -> a.getMatricula().equals(automovel.getMatricula()))
                .findFirst();
        if (existente.isPresent()) {
            // Lança uma exceção se a matrícula já estiver associada a outro automóvel.
            throw new IllegalArgumentException("Já existe um automóvel com a matrícula " + automovel.getMatricula());
        }
        automoveis.add(automovel); // Adiciona o novo automóvel à lista.
    }

    public void removerAutomovel(String matricula) {
        // Remove o automóvel da lista com base na matrícula fornecida.
        automoveis.removeIf(automovel -> automovel.getMatricula().equals(matricula));
    }

    public void atualizarAutomovel(String matricula, Automovel atualizado) {
        // Percorre a lista para encontrar o automóvel com a matrícula especificada.
        for (int i = 0; i < automoveis.size(); i++) {
            if (automoveis.get(i).getMatricula().equals(matricula)) {
                automoveis.set(i, atualizado); // Atualiza os dados do automóvel encontrado.
                return;
            }
        }
        // Lança uma exceção caso a matrícula não corresponda a nenhum automóvel na lista.
        throw new IllegalArgumentException("Automóvel com matrícula " + matricula + " não encontrado.");
    }

    public List<Automovel> listarAutomoveis() {
        // Retorna uma cópia da lista de automóveis para evitar alterações externas.
        return new ArrayList<>(automoveis);
    }

    public Optional<Automovel> buscarPorMatricula(String matricula) {
        // Busca e retorna um automóvel com a matrícula especificada, se existir.
        return automoveis.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst();
    }
}
