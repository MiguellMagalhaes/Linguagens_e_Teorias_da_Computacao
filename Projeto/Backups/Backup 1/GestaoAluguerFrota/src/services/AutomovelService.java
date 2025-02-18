package services;

import models.Automovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutomovelService {
    private final List<Automovel> automoveis = new ArrayList<>();

    public void adicionarAutomovel(Automovel automovel) {
        Optional<Automovel> existente = automoveis.stream()
                .filter(a -> a.getMatricula().equals(automovel.getMatricula()))
                .findFirst();
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Já existe um automóvel com a matrícula " + automovel.getMatricula());
        }
        automoveis.add(automovel);
    }

    public void removerAutomovel(String matricula) {
        automoveis.removeIf(automovel -> automovel.getMatricula().equals(matricula));
    }

    public void atualizarAutomovel(String matricula, Automovel atualizado) {
        for (int i = 0; i < automoveis.size(); i++) {
            if (automoveis.get(i).getMatricula().equals(matricula)) {
                automoveis.set(i, atualizado);
                return;
            }
        }
        throw new IllegalArgumentException("Automóvel com matrícula " + matricula + " não encontrado.");
    }

    public List<Automovel> listarAutomoveis() {
        return new ArrayList<>(automoveis);
    }

    public Optional<Automovel> buscarPorMatricula(String matricula) {
        return automoveis.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst();
    }
}
