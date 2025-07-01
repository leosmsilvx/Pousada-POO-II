package model;

import enums.CargoFuncionario;

public class Funcionario {
    
    private Integer idFuncionario;
    private String cpf;
    private String nome;
    private CargoFuncionario cargo;

    public Funcionario() {
    }

    public Funcionario(String cpf, String nome, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = CargoFuncionario.fromDescricao(cargo);
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public CargoFuncionario getCargo() {
        return cargo;
    }
    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }    

    
}
