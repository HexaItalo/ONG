package model;

public class Voluntario {
    private String nome;
    private String contato;
    private String areaAtuacao;
    private String disponibilidade;

    public Voluntario(String nome, String contato, String areaAtuacao, String disponibilidade) {
        this.nome = nome;
        this.contato = contato;
        this.areaAtuacao = areaAtuacao;
        this.disponibilidade = disponibilidade;
    }

    public String getNome() { return nome; }
    public String getContato() { return contato; }
    public String getAreaAtuacao() { return areaAtuacao; }
    public String getDisponibilidade() { return disponibilidade; }
}
