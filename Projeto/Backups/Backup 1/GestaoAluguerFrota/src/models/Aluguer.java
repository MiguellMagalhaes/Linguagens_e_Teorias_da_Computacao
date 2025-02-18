package models;

import java.time.LocalDate;

public class Aluguer {
    private Automovel automovel;
    private Cliente cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    // Construtor
    public Aluguer(Automovel automovel, Cliente cliente, LocalDate dataInicio, LocalDate dataFim) {
        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início.");
        }
        this.automovel = automovel;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início.");
        }
        this.dataFim = dataFim;
    }

    public double calcularValor() {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
        return dias * automovel.getValorDia();
    }

    @Override
    public String toString() {
        return "Aluguer{" +
                "Automóvel=" + automovel +
                ", Cliente=" + cliente +
                ", Data Início=" + dataInicio +
                ", Data Fim=" + dataFim +
                ", Valor Total=" + calcularValor() +
                '}';
    }
}
