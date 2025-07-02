package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Estadia;
import model.Hospede;
import model.Quarto;

public class EstadiaController {

    public EstadiaController() {
    }

    public void insert(Estadia estadia) {
        Conexao c = new Conexao();
        c.conectar();

        String sql = "INSERT INTO tb_estadia (dt_checkin, dt_checkout_esperado, dt_checkout_final, id_hospede, id_quarto) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setDate(1, estadia.getDtCheckinSql());
            ps.setDate(2, estadia.getDtCheckoutEsperadoSql());
            ps.setDate(3, estadia.getDtCheckoutFinalSql());
            ps.setInt(4, estadia.getHospede().getIdHospede());
            ps.setInt(5, estadia.getQuarto().getIdQuarto());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void edit(Estadia estadia) {
        Conexao c = new Conexao();
        c.conectar();

        String sql = "UPDATE tb_estadia SET dt_checkin = ?, dt_checkout_esperado = ?, dt_checkout_final = ?, id_hospede = ?, id_quarto = ? WHERE id_estadia = ?";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setDate(1, estadia.getDtCheckinSql());
            ps.setDate(2, estadia.getDtCheckoutEsperadoSql());
            ps.setDate(3, estadia.getDtCheckoutFinalSql());
            ps.setInt(4, estadia.getHospede().getIdHospede());
            ps.setInt(5, estadia.getQuarto().getIdQuarto());
            ps.setInt(6, estadia.getIdEstadia());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void delete(int id) {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "DELETE FROM tb_estadia WHERE id_estadia = ?";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }

    public Estadia findByIdEstadia(int id) {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT * FROM tb_estadia WHERE id_estadia = ?";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Estadia estadia = new Estadia();
                estadia.setIdEstadia(rs.getInt("id_estadia"));
                estadia.setDtCheckin(rs.getDate("dt_checkin"));
                estadia.setDtCheckoutEsperado(rs.getDate("dt_checkout_esperado"));
                estadia.setDtCheckoutFinal(rs.getDate("dt_checkout_final"));

                Hospede hospede = new Hospede();
                hospede.setIdHospede(rs.getInt("id_hospede"));
                estadia.setHospede(hospede);

                Quarto quarto = new Quarto();
                quarto.setIdQuarto(rs.getInt("id_quarto"));
                estadia.setQuarto(quarto);

                return estadia;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar : " + e.getMessage());
        }
        return null;
    }

    public List<Estadia> findAll() {
        Conexao c = new Conexao();
        c.conectar();
        List<Estadia> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_estadia ORDER BY dt_checkin";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estadia estadia = new Estadia();
                estadia.setIdEstadia(rs.getInt("id_estadia"));
                estadia.setDtCheckin(rs.getDate("dt_checkin"));
                estadia.setDtCheckoutEsperado(rs.getDate("dt_checkout_esperado"));
                estadia.setDtCheckoutFinal(rs.getDate("dt_checkout_final"));

                Hospede hospede = new Hospede();
                hospede.setIdHospede(rs.getInt("id_hospede"));
                estadia.setHospede(hospede);

                Quarto quarto = new Quarto();
                quarto.setIdQuarto(rs.getInt("id_quarto"));
                estadia.setQuarto(quarto);

                lista.add(estadia);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar : " + e.getMessage());
        }
        return lista;
    }
}
