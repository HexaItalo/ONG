package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Voluntario;
import database.ConexaoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VoluntarioController {

    public void adicionarVoluntario(Voluntario v) {
        String sql = "INSERT INTO voluntarios (nome, contato, area_atuacao, disponibilidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getContato());
            stmt.setString(3, v.getAreaAtuacao());
            stmt.setString(4, v.getDisponibilidade());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar voluntário: " + e.getMessage(), e);
        }
    }
    
    public List<Voluntario> listarVoluntarios() {
    List<Voluntario> lista = new ArrayList<>();
    String sql = "SELECT nome, contato, area_atuacao, disponibilidade FROM voluntarios";

    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Voluntario v = new Voluntario(
                rs.getString("nome"),
                rs.getString("contato"),
                rs.getString("area_atuacao"),
                rs.getString("disponibilidade")
            );
            lista.add(v);
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao listar voluntários: " + e.getMessage(), e);
    }

    return lista;
    }
}
