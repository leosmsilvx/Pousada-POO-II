package controller;

import model.Funcionario;
import enums.CargoFuncionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connection.Conexao;

public class FuncionarioController {

    public FuncionarioController() {
    }

    public void insert(Funcionario funcionario) {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "INSERT INTO tb_funcionario (vc_cpf, vc_nome, vc_cargo) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setString(1, funcionario.getCpf());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCargo().getDescricao());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void edit(Funcionario funcionario) {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "UPDATE tb_funcionario SET vc_cpf = ?, vc_nome = ?, vc_cargo = ? WHERE id_funcionario = ?";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setString(1, funcionario.getCpf());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCargo().getDescricao());
            ps.setInt(4, funcionario.getIdFuncionario());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar : " + e.getMessage());
        }
    }

    public void delete(int id) {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "DELETE FROM tb_funcionario WHERE id_funcionario = ?";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }

    public List<Funcionario> findAll() {
        Conexao c = new Conexao();
        c.conectar();
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_funcionario ORDER BY vc_nome";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setCpf(rs.getString("vc_cpf"));
                funcionario.setNome(rs.getString("vc_nome"));
                funcionario.setCargo(CargoFuncionario.fromDescricao(rs.getString("vc_cargo")));
                lista.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar : " + e.getMessage());
        }
        return lista;
    }

    public Funcionario findByIdFuncionario(int id) {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT * FROM tb_funcionario WHERE id_funcionario = ?";
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("id_funcionario"));
                f.setCpf(rs.getString("vc_cpf"));
                f.setNome(rs.getString("vc_nome"));
                f.setCargo(CargoFuncionario.fromDescricao(rs.getString("vc_cargo")));
                return f;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
}
