package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import enums.TipoServico;
import model.Hospede;
import model.Servico;

public class ServicoController {
    
    public void insert(Servico servico){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO tb_servico (id_hospede, vc_tipo, int_valor, dt_servico) " +
            "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, servico.getHospede().getIdHospede());
            ps.setString(2, servico.getTipo().getDescricao());
            ps.setInt(3, servico.getValorInteger());
            ps.setDate(4, servico.getDtServicoSql());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
    }

    public void edit(Servico servico){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE tb_servico SET id_hospede = ?, vc_tipo = ?, int_valor = ?, dt_servico = ? " +
            "WHERE id_servico = ?";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, servico.getHospede().getIdHospede());
            ps.setString(2, servico.getTipo().getDescricao());
            ps.setInt(3, servico.getValorInteger());
            ps.setDate(4, servico.getDtServicoSql());
            ps.setInt(5, servico.getIdServico());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar:" + e.getMessage());
        }
        c.desconectar();
    }

    public void delete(Integer idServico) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM tb_servico " +
            "WHERE (id_servico = ?)";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idServico);

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir:" + e.getMessage());
        }
        c.desconectar();
    }

    public Servico findByIdServico(Integer idServico) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM tb_servico s INNER JOIN tb_hospede h WHERE s.id_hospede = h.id_hospede " +
            "AND id_servico = ?";

        Servico servico = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idServico);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Hospede hospede = new Hospede(rs.getString("vc_cpf"), rs.getString("vc_nome"));
                hospede.setIdHospede(rs.getInt("id_hospede"));
                servico = new Servico();
                servico.setIdServico(rs.getInt("id_servico"));
                servico.setHospede(hospede);
                servico.setTipo(TipoServico.fromDescricao(rs.getString("vc_tipo")));
                servico.setValor(rs.getFloat("int_valor") / 100.0f);
                servico.setDtServico(rs.getDate("dt_servico"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return servico;
    }

    public List<Servico> findAll(){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM tb_servico s INNER JOIN tb_hospede h WHERE s.id_hospede = h.id_hospede";

        List<Servico> lista = new ArrayList<>();
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hospede h = new Hospede(rs.getString("vc_cpf"), rs.getString("vc_nome"));
                h.setIdHospede(rs.getInt("id_hospede"));
                Servico s = new Servico();
                s.setIdServico(rs.getInt("id_servico"));
                s.setHospede(h);
                s.setTipo(TipoServico.fromDescricao(rs.getString("vc_tipo")));
                s.setValor(rs.getFloat("int_valor") / 100.0f);
                s.setDtServico(rs.getDate("dt_servico"));
                lista.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return lista;
    }
}
