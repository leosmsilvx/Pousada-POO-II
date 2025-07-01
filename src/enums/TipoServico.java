package enums;

public enum TipoServico {
    CAFE("Café"),
    PASSEIO("Passeio"),
    SPA("Spa"),
    RESTAURANTE("Restaurante"),
    WIFI("Wi-Fi"),
    BICICLETA("Bicicleta"),
    BEBIDA("Bebida");

    private final String descricao;

    TipoServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public static TipoServico fromDescricao(String descricao) {
        for (TipoServico tipo : values()) {
            if (tipo.descricao.equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de serviço inválido: " + descricao);
    }
}
