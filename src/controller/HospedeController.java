package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Hospede;

public class HospedeController {
    
    public void insert(Hospede hospede){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO tb_hospede (vc_cpf, vc_nome) " +
            "VALUES (?, ?)";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, hospede.getCpf());
            ps.setString(2, hospede.getNome());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
    }

    public void edit(Hospede hospede){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE tb_hospede SET  vc_cpf = ?, vc_nome = ? " +
            "WHERE id_hospede = ?";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, hospede.getCpf());
            ps.setString(2, hospede.getNome());
            ps.setInt(3, hospede.getIdHospede());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar:" + e.getMessage());
        }
        c.desconectar();
    }

    public void delete(Integer idHospede) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM tb_hospede " +
            "WHERE (id_hospede = ?)";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idHospede);

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir:" + e.getMessage());
        }
        c.desconectar();
    }

    public Hospede findByIdHospede(Integer idHospede) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM tb_hospede " +
            "WHERE (id_hospede = ?)";

        Hospede hospede = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idHospede);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hospede = new Hospede(rs.getString("vc_cpf"), rs.getString("vc_nome"));
                hospede.setIdHospede(rs.getInt("id_hospede"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return hospede;
    }

    public List<Hospede> findAll(){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM tb_hospede";

        List<Hospede> lista = new ArrayList<>();
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hospede h = new Hospede(rs.getString("vc_cpf"), rs.getString("vc_nome"));
                h.setIdHospede(rs.getInt("id_hospede"));
                lista.add(h);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return lista;
    }
}
