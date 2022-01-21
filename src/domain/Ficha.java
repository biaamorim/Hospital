package src.domain;

public class Ficha {
    private String descricao;
    private String dataRegistro;
    private String tipoAtendimento;

    public String getDescricao() {
        return descricao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }
}
