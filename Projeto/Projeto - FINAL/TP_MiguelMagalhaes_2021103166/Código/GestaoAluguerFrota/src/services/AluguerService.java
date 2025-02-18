package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import models.Aluguer;
import models.Automovel;

public class AluguerService {
    private final List<Aluguer> alugueres = new ArrayList<>(); // Lista para armazenar os alugueres realizados.

    public void adicionarAluguer(Aluguer aluguer) {
        // Verifica se o automóvel está disponível no período especificado para o novo aluguer.
        boolean jaAlugado = alugueres.stream()
                .anyMatch(a -> a.getAutomovel().getMatricula().equals(aluguer.getAutomovel().getMatricula()) &&
                        !(aluguer.getDataFim().isBefore(a.getDataInicio()) || aluguer.getDataInicio().isAfter(a.getDataFim())));

        if (jaAlugado) {
            // Lança uma exceção caso o automóvel esteja ocupado no período solicitado.
            throw new IllegalArgumentException("O automóvel já está alugado no período especificado.");
        }

        alugueres.add(aluguer); // Adiciona o novo aluguer à lista de alugueres.
    }

    public void removerAluguer(Aluguer aluguer) {
        alugueres.remove(aluguer); // Remove o aluguer especificado da lista de alugueres.
    }

    public List<Aluguer> listarAlugueres() {
        // Retorna uma cópia da lista de alugueres para evitar modificações externas.
        return new ArrayList<>(alugueres);
    }

    public List<Aluguer> listarAutomoveisAlugadosOrdenadoPorEntrega() {
        // Retorna uma lista de alugueres ordenada pela data de fim (entrega do automóvel).
        return alugueres.stream()
                .sorted((a1, a2) -> a1.getDataFim().compareTo(a2.getDataFim()))
                .collect(Collectors.toList());
    }

    public List<Automovel> listarAutomoveisDisponiveis(List<Automovel> todosAutomoveis) {
        // Obtém uma lista de matrículas dos automóveis que estão atualmente alugados.
        List<String> alugados = alugueres.stream()
                .map(aluguer -> aluguer.getAutomovel().getMatricula())
                .collect(Collectors.toList());

        // Retorna uma lista de automóveis que não estão na lista de automóveis alugados.
        return todosAutomoveis.stream()
                .filter(automovel -> !alugados.contains(automovel.getMatricula()))
                .collect(Collectors.toList());
    }
}
