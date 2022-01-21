package src.domain;

public class Ficha {
    private int id;
    private String descricao;
    private String dataRegistro;
    private int pacienteId;
    private int atendimentoId;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public int getAtendimentoId() {
        return atendimentoId;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public void setAtendimentoId(int atendimentoId) {
        this.atendimentoId = atendimentoId;
    }
}
