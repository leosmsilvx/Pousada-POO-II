package model;

import java.util.Date;

import enums.TipoServico;

public class Servico{

    private Integer idServico;
    private Hospede hospede;
    private TipoServico tipo;
    private Float valor;
    private Date dtServico;

    public Servico() {
    }

    public Servico(Hospede hospede, String tipo, Float valor, Date dtServico) {
        this.hospede = hospede;
        this.tipo = TipoServico.fromDescricao(tipo);
        this.valor = valor;
        this.dtServico = dtServico;
    }

    public Integer getIdServico() {
        return idServico;
    }
    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }
    public Hospede getHospede() {
        return hospede;
    }
    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    public Float getValor() {
        return valor;
    }
    public void setValor(Float valor) {
        this.valor = valor;
    }
    public Date getDtServico() {
        return dtServico;
    }
    public void setDtServico(Date dtServico) {
        this.dtServico = dtServico;
    }
    public TipoServico getTipo() {
        return tipo;
    }
    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }

    public java.sql.Date getDtServicoSql(){
        return new java.sql.Date(dtServico.getTime());
    }

    public Integer getValorInteger(){
        Float valorConvertido = valor * 100;
        return valorConvertido.intValue();
    }
}
