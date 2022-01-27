package src.domain;

public class Ficha {
    private int id;
    private String descricao;
    private String dataRegistro;
    private String tipoAtendimento;

    public Ficha(int id, String descricao, String dataRegistro, String tipoAtendimento) {
        this.id = id;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.tipoAtendimento = tipoAtendimento;
    }

    public int getId() {
        return id;
    }

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
