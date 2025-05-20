package model;

public class Voluntario {
    private String nome;
    private String email;
    private String areaAtuacao;
    private String disponibilidade;

    public Voluntario(String nome, String email, String areaAtuacao, String disponibilidade) {
        this.nome = nome;
        this.email = email;
        this.areaAtuacao = areaAtuacao;
        this.disponibilidade = disponibilidade;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getAreaAtuacao() { return areaAtuacao; }
    public String getDisponibilidade() { return disponibilidade; }
    
}
