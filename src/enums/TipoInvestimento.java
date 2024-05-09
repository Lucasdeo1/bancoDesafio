package enums;


public enum TipoInvestimento {
    CDB("Investimento em CDB"), ACAO ("Investimento em fundo de ações"), IMOBILIARIO("Investimento em fundo imobiliário");
    
    private final String descricao;

    
    private TipoInvestimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
