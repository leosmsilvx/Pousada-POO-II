
package model;

public class Hospede {
    
    private Integer idHospede;
    private String cpf;
    private String nome;
    
    public Hospede() {
    }

    public Hospede(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Integer getIdHospede() {
        return idHospede;
    }
    public void setIdHospede(Integer idHospede) {
        this.idHospede = idHospede;
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
}
