package src.interfaces;

public interface IFicha {
    int getId();
    String getDescricao();
    String getDataRegistro();
    int getPacienteId();
    int getAtendimentoId();
    void setDescricao(String descricao);
    void setDataRegistro(String dataRegistro);
    void setPacienteId(int pacienteId);
    void setAtendimentoId(int atendimentoId);
}
