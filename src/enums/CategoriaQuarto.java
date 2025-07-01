package enums;

public enum CategoriaQuarto {
    STANDARD("Standard"),
    PREMIUM("Premium"),
    CHALE("Chalé");

    private final String descricao;

    CategoriaQuarto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public static CategoriaQuarto fromDescricao(String descricao) {
        for (CategoriaQuarto categoria : values()) {
            if (categoria.descricao.equalsIgnoreCase(descricao)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + descricao);
    }
}
