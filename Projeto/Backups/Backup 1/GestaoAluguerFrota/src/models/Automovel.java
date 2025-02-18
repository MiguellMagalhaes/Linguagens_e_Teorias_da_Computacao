package models;

public class Automovel {
    private String marca;
    private String modelo;
    private String cor;
    private int cilindrada;
    private int anoAquisicao;
    private String matricula;
    private double valorDia;

    // Construtor
    public Automovel(String marca, String modelo, String cor, int cilindrada, int anoAquisicao, String matricula, double valorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.cilindrada = cilindrada;
        this.anoAquisicao = anoAquisicao;
        this.matricula = matricula;
        this.valorDia = valorDia;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getAnoAquisicao() {
        return anoAquisicao;
    }

    public void setAnoAquisicao(int anoAquisicao) {
        this.anoAquisicao = anoAquisicao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    @Override
    public String toString() {
        return "Automóvel{" +
                "Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Cor='" + cor + '\'' +
                ", Cilindrada=" + cilindrada +
                ", Ano de Aquisição=" + anoAquisicao +
                ", Matrícula='" + matricula + '\'' +
                ", Valor por dia=" + valorDia +
                '}';
    }
}
