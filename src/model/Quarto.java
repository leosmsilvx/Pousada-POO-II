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

    public String toString() {
        return  idQuarto + " - " + categoria + " - R$" + valor;
    }    
    
    public Integer getValorInteger() {
        Float valorConvertido = valor * 100;
        return valorConvertido.intValue();
    }
}
