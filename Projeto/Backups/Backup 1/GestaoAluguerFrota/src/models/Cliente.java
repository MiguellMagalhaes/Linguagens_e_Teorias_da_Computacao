package models;

public class Cliente {
    private String nome;
    private String morada;
    private String cc; // Cartão de cidadão
    private String cartaConducao;

    // Construtor
    public Cliente(String nome, String morada, String cc, String cartaConducao) {
        this.nome = nome;
        this.morada = morada;
        this.cc = cc;
        this.cartaConducao = cartaConducao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCartaConducao() {
        return cartaConducao;
    }

    public void setCartaConducao(String cartaConducao) {
        this.cartaConducao = cartaConducao;
    }

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
