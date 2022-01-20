package src.interfaces;

public interface IMedico {
    int getId();
    String getCrm();
    String[] getEspecialidade();
    String[] getDiasPlantao();
    float getInicioExpediente();
    float getFimExpediente();
    void setCrm(String crm);
    void setEspecialidade(String[] especialidade);
    void setDiasPlantao(String[] diasPlantao);
    void setInicioExpediente(float inicioExpediente);
    void setFimExpediente(float fimExpediente);
    float calculaExpediente();
}
