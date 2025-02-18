package services;

import models.Aluguer;
import models.Automovel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AluguerService {
    private final List<Aluguer> alugueres = new ArrayList<>();

    public void adicionarAluguer(Aluguer aluguer) {
        // Verifica se o automóvel está disponível no período
        boolean jaAlugado = alugueres.stream()
                .anyMatch(a -> a.getAutomovel().getMatricula().equals(aluguer.getAutomovel().getMatricula()) &&
                        !(aluguer.getDataFim().isBefore(a.getDataInicio()) || aluguer.getDataInicio().isAfter(a.getDataFim())));

        if (jaAlugado) {
            throw new IllegalArgumentException("O automóvel já está alugado no período especificado.");
        }

        alugueres.add(aluguer);
    }

    public void removerAluguer(Aluguer aluguer) {
        alugueres.remove(aluguer);
    }

    public List<Aluguer> listarAlugueres() {
        return new ArrayList<>(alugueres);
    }

    public List<Aluguer> listarAutomoveisAlugadosOrdenadoPorEntrega() {
        return alugueres.stream()
                .sorted((a1, a2) -> a1.getDataFim().compareTo(a2.getDataFim()))
                .collect(Collectors.toList());
    }

    public List<Automovel> listarAutomoveisDisponiveis(List<Automovel> todosAutomoveis) {
        List<String> alugados = alugueres.stream()
                .map(aluguer -> aluguer.getAutomovel().getMatricula())
                .collect(Collectors.toList());

        return todosAutomoveis.stream()
                .filter(automovel -> !alugados.contains(automovel.getMatricula()))
                .collect(Collectors.toList());
    }
}
