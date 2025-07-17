package model;

import java.util.Date;

public class Estadia {
 
    private Integer idEstadia;
    private Date dtCheckin;
    private Date dtCheckoutEsperado;
    private Date dtCheckoutFinal;
    private Hospede hospede;
    private Quarto quarto;

    public Estadia() {
    }

    public Estadia(Date dtCheckin, Date dtCheckoutEsperado, Hospede hospede, Quarto quarto) {
        this.dtCheckin = dtCheckin;
        this.dtCheckoutEsperado = dtCheckoutEsperado;
        this.hospede = hospede;
        this.quarto = quarto;
    }

    public Integer getIdEstadia() {
        return idEstadia;
    }
    public void setIdEstadia(Integer idEstadia) {
        this.idEstadia = idEstadia;
    }
    public Date getDtCheckin() {
        return dtCheckin;
    }
    public void setDtCheckin(Date dtCheckin) {
        this.dtCheckin = dtCheckin;
    }
    public Date getDtCheckoutEsperado() {
        return dtCheckoutEsperado;
    }
    public void setDtCheckoutEsperado(Date dtCheckoutEsperado) {
        this.dtCheckoutEsperado = dtCheckoutEsperado;
    }
    public Date getDtCheckoutFinal() {
        return dtCheckoutFinal;
    }
    public void setDtCheckoutFinal(Date dtCheckoutFinal) {
        this.dtCheckoutFinal = dtCheckoutFinal;
    }
    public Hospede getHospede() {
        return hospede;
    }
    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    public Quarto getQuarto() {
        return quarto;
    }
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    public java.sql.Timestamp getDtCheckinTimestamp(){
        return new java.sql.Timestamp(dtCheckin.getTime());
    }
    public java.sql.Timestamp getDtCheckoutEsperadoTimestamp(){
        return new java.sql.Timestamp(dtCheckoutEsperado.getTime());
    }
    public java.sql.Timestamp getDtCheckoutFinalTimestamp(){
        return new java.sql.Timestamp(dtCheckoutFinal.getTime());
    }
}
