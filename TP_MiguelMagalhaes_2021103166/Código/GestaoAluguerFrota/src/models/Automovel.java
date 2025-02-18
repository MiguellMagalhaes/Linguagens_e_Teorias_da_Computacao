package models;

// Classe que representa um automóvel disponível para aluguer.
public class Automovel {
    private String marca; // Marca do automóvel.
    private String modelo; // Modelo do automóvel.
    private String cor; // Cor do automóvel.
    private int cilindrada; // Cilindrada do automóvel em centímetros cúbicos.
    private int anoAquisicao; // Ano de aquisição do automóvel.
    private String matricula; // Matrícula do automóvel.
    private double valorDia; // Valor diário para o aluguer do automóvel.

    // Construtor que inicializa todos os atributos do automóvel.
    public Automovel(String marca, String modelo, String cor, int cilindrada, int anoAquisicao, String matricula, double valorDia) {
        this.marca = marca; // Define a marca do automóvel.
        this.modelo = modelo; // Define o modelo do automóvel.
        this.cor = cor; // Define a cor do automóvel.
        this.cilindrada = cilindrada; // Define a cilindrada do automóvel.
        this.anoAquisicao = anoAquisicao; // Define o ano de aquisição do automóvel.
        this.matricula = matricula; // Define a matrícula do automóvel.
        this.valorDia = valorDia; // Define o valor diário de aluguer do automóvel.
    }

    // Método para obter a marca do automóvel.
    public String getMarca() {
        return marca;
    }

    // Método para atualizar a marca do automóvel.
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Método para obter o modelo do automóvel.
    public String getModelo() {
        return modelo;
    }

    // Método para atualizar o modelo do automóvel.
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Método para obter a cor do automóvel.
    public String getCor() {
        return cor;
    }

    // Método para atualizar a cor do automóvel.
    public void setCor(String cor) {
        this.cor = cor;
    }

    // Método para obter a cilindrada do automóvel.
    public int getCilindrada() {
        return cilindrada;
    }

    // Método para atualizar a cilindrada do automóvel.
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    // Método para obter o ano de aquisição do automóvel.
    public int getAnoAquisicao() {
        return anoAquisicao;
    }

    // Método para atualizar o ano de aquisição do automóvel.
    public void setAnoAquisicao(int anoAquisicao) {
        this.anoAquisicao = anoAquisicao;
    }

    // Método para obter a matrícula do automóvel.
    public String getMatricula() {
        return matricula;
    }

    // Método para atualizar a matrícula do automóvel.
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Método para obter o valor diário de aluguer do automóvel.
    public double getValorDia() {
        return valorDia;
    }

    // Método para atualizar o valor diário de aluguer do automóvel.
    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    // Método que retorna uma representação textual do automóvel, incluindo todos os seus atributos.
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
