package models;

import java.time.LocalDate;

// Classe que representa um aluguer de automóvel.
public class Aluguer {
    private Automovel automovel; // Automóvel alugado.
    private Cliente cliente; // Cliente que efetuou o aluguer.
    private LocalDate dataInicio; // Data de início do aluguer.
    private LocalDate dataFim; // Data de fim do aluguer.

    // Construtor que inicializa os atributos do aluguer e valida a consistência das datas.
    public Aluguer(Automovel automovel, Cliente cliente, LocalDate dataInicio, LocalDate dataFim) {
        if (dataFim.isBefore(dataInicio)) { // Valida se a data de fim é posterior à data de início.
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início.");
        }
        this.automovel = automovel; // Atribui o automóvel ao aluguer.
        this.cliente = cliente; // Atribui o cliente ao aluguer.
        this.dataInicio = dataInicio; // Define a data de início do aluguer.
        this.dataFim = dataFim; // Define a data de fim do aluguer.
    }

    // Método para obter o automóvel associado ao aluguer.
    public Automovel getAutomovel() {
        return automovel;
    }

    // Método para atualizar o automóvel associado ao aluguer.
    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    // Método para obter o cliente associado ao aluguer.
    public Cliente getCliente() {
        return cliente;
    }

    // Método para atualizar o cliente associado ao aluguer.
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método para obter a data de início do aluguer.
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    // Método para atualizar a data de início do aluguer.
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    // Método para obter a data de fim do aluguer.
    public LocalDate getDataFim() {
        return dataFim;
    }

    // Método para atualizar a data de fim do aluguer com validação de consistência.
    public void setDataFim(LocalDate dataFim) {
        if (dataFim.isBefore(dataInicio)) { // Valida se a nova data de fim é posterior à data de início.
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início.");
        }
        this.dataFim = dataFim; // Atualiza a data de fim do aluguer.
    }

    // Método que calcula o valor total do aluguer com base no número de dias.
    public double calcularValor() {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(dataInicio, dataFim) + 1; // Calcula o número de dias do aluguer.
        return dias * automovel.getValorDia(); // Multiplica o número de dias pelo valor diário do automóvel.
    }

    // Método que retorna uma representação textual do aluguer, incluindo o cliente, automóvel e valores.
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
