package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import enums.CategoriaQuarto;
import model.Quarto;

public class QuartoController {
    
    public void insert(Quarto quarto){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO tb_quarto (vc_categoria, int_valor) " +
            "VALUES (?, ?)";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, quarto.getCategoria().getDescricao());
            ps.setInt(2, quarto.getValorInteger());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
    }

    public void edit(Quarto quarto){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE tb_quarto SET  vc_categoria = ?, int_valor = ? " +
            "WHERE id_quarto = ?";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, quarto.getCategoria().getDescricao());
            ps.setInt(2, quarto.getValorInteger());
            ps.setInt(3, quarto.getIdQuarto());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar:" + e.getMessage());
        }
        c.desconectar();
    }

    public void delete(Integer idQuarto) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM tb_quarto " +
            "WHERE (id_quarto = ?)";

        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idQuarto);

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir:" + e.getMessage());
        }
        c.desconectar();
    }

    public Quarto findByIdQuarto(Integer idQuarto) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM tb_quarto " +
            "WHERE (id_quarto = ?)";

        Quarto quarto = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idQuarto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String categoriaDescricao = rs.getString("vc_categoria");
                CategoriaQuarto categoriaQuarto = CategoriaQuarto.fromDescricao(categoriaDescricao);
                quarto = new Quarto();
                quarto.setCategoria(categoriaQuarto);
                quarto.setValor(rs.getFloat("int_valor")/100);
                quarto.setIdQuarto(rs.getInt("id_quarto"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar:" + e.getMessage());
        }
        c.desconectar();
        return quarto;
    }
    
    public List<Quarto> findByCategoriaQuarto(CategoriaQuarto cat) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM tb_quarto " +
            "WHERE (vc_categoria = ?)";

        List<Quarto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, cat.getDescricao());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Quarto q = new Quarto();
                String categoriaDescricao = rs.getString("vc_categoria");
                CategoriaQuarto categoriaQuarto = CategoriaQuarto.fromDescricao(categoriaDescricao);
                q.setCategoria(categoriaQuarto);
                q.setValor(rs.getFloat("int_valor")/100);
                q.setIdQuarto(rs.getInt("id_quarto"));
                lista.add(q);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar:" + e.getMessage());
        }
        c.desconectar();
        return lista;
    }

    public List<Quarto> findAll(){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM tb_quarto";

        List<Quarto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Quarto q = new Quarto();
                String categoriaDescricao = rs.getString("vc_categoria");
                CategoriaQuarto categoriaQuarto = CategoriaQuarto.fromDescricao(categoriaDescricao);
                q.setCategoria(categoriaQuarto);
                q.setValor(rs.getFloat("int_valor")/100);
                q.setIdQuarto(rs.getInt("id_quarto"));
                lista.add(q);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar:" + e.getMessage());
        }
        c.desconectar();
        return lista;
    }
}
