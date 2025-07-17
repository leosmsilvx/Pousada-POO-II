package model;

import enums.CategoriaQuarto;

public class Quarto {
    
    private Integer idQuarto;
    private CategoriaQuarto categoria;
    private Float valor;

    public Quarto() {
    }

    public Quarto(String categoria, Float valor) {
        this.categoria = CategoriaQuarto.fromDescricao(categoria);
        this.valor = valor;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }
    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }
    public Float getValor() {
        return valor;
    }
    public void setValor(Float valor) {
        this.valor = valor;
    }
    public CategoriaQuarto getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaQuarto categoria) {
        this.categoria = categoria;
    }
    
    public Integer getValorInteger() {
        Float valorConvertido = valor * 100;
        return valorConvertido.intValue();
    }
    
    @Override
    public String toString(){
        return  idQuarto + " - " + categoria;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Quarto other = (Quarto) obj;
        return this.idQuarto.equals(other.getIdQuarto());
    }
}
