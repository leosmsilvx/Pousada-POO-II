package enums;

public enum CargoFuncionario {
    RECEPCIONISTA("Recepcionista"),
    CAMAREIRA("Camareira"),
    COZINHEIRO("Cozinheiro"),
    CHEFE("Chefe"),
    GARCOM("Garçom"),
    GUIA("Guia"),
    GERENTE("Gerente");

    private final String descricao;

    CargoFuncionario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public static CargoFuncionario fromDescricao(String descricao) {
        for (CargoFuncionario c : values()) {
            if (c.descricao.equalsIgnoreCase(descricao)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cargo inválido: " + descricao);
    }
}
