package models;

// Classe que representa um cliente do sistema de aluguer.
public class Cliente {
    private String nome; // Nome do cliente.
    private String morada; // Morada do cliente.
    private String cc; // Número do Cartão de Cidadão do cliente.
    private String cartaConducao; // Número da Carta de Condução do cliente.

    // Construtor que inicializa os atributos do cliente.
    public Cliente(String nome, String morada, String cc, String cartaConducao) {
        this.nome = nome; // Define o nome do cliente.
        this.morada = morada; // Define a morada do cliente.
        this.cc = cc; // Define o número do Cartão de Cidadão do cliente.
        this.cartaConducao = cartaConducao; // Define o número da Carta de Condução do cliente.
    }

    // Método para obter o nome do cliente.
    public String getNome() {
        return nome;
    }

    // Método para atualizar o nome do cliente.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter a morada do cliente.
    public String getMorada() {
        return morada;
    }

    // Método para atualizar a morada do cliente.
    public void setMorada(String morada) {
        this.morada = morada;
    }

    // Método para obter o número do Cartão de Cidadão do cliente.
    public String getCc() {
        return cc;
    }

    // Método para atualizar o número do Cartão de Cidadão do cliente.
    public void setCc(String cc) {
        this.cc = cc;
    }

    // Método para obter o número da Carta de Condução do cliente.
    public String getCartaConducao() {
        return cartaConducao;
    }

    // Método para atualizar o número da Carta de Condução do cliente.
    public void setCartaConducao(String cartaConducao) {
        this.cartaConducao = cartaConducao;
    }

    // Método que retorna uma representação textual do cliente, incluindo todos os seus atributos.
    @Override
    public String toString() {
        return "Cliente{" +
                "Nome='" + nome + '\'' +
                ", Morada='" + morada + '\'' +
                ", CC='" + cc + '\'' +
                ", Carta de Condução='" + cartaConducao + '\'' +
                '}';
    }
}
