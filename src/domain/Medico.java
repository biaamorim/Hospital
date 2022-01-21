package src.domain;

public class Medico extends Pessoa {
    private int id;
    private String crm;
    private String[] especialidade;
    private String[] diasPlantao;
    private float inicioExpediente;
    private float fimExpediente;

    public int getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public String[] getEspecialidade() {
        return especialidade;
    }

    public String[] getDiasPlantao() {
        return diasPlantao;
    }

    public float getInicioExpediente() {
        return inicioExpediente;
    }

    public float getFimExpediente() {
        return fimExpediente;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEspecialidade(String[] especialidade) {
        this.especialidade = especialidade;
    }

    public void setDiasPlantao(String[] diasPlantao) {
        this.diasPlantao = diasPlantao;
    }

    public void setInicioExpediente(float inicioExpediente) {
        this.inicioExpediente = inicioExpediente;
    }

    public void setFimExpediente(float fimExpediente) {
        this.fimExpediente = fimExpediente;
    }

    public float calculaExpediente() {
        return this.fimExpediente - this.inicioExpediente;
    }

    @Override
    public Registro preencheRegistro(Registro registro) {
        registro.setMedicoId(id);
        return registro;
    }
}
