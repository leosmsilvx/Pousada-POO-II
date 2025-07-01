package connection;

import java.sql.*;

public class Conexao {

    public Connection conector;
    public void conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SistemaHospedagem";
            String usuario = "root";
            String senha = "root";
            conector = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e){
            System.out.println("Erro no Driver: "+ e.getMessage());
        } catch (SQLException e){
            System.out.println("Erro na conexão com o banco: "+ e.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            conector.close();
        } catch(SQLException e){
            System.out.println("Erro na conexão com o banco: " + e.getMessage());
        }
    }
    
}
