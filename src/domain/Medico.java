package src.domain;

public class Medico extends Pessoa {
    private final int id;
    private String crm;
    private String[] especialidade;
    private String[] diaPlantao;
    private float inicioExpediente;
    private float fimExpediente;

    public Medico(String nome, String cpf, String numeroTelefone, String endereco, String sexo,
            int id, String crm, String[] especialidade, String[] diaPlantao, float inicioExpediente,
            float fimExpediente) {
        super(nome, cpf, numeroTelefone, endereco, sexo);
        this.id = id;
        this.crm = crm;
        this.especialidade = especialidade;
        this.diaPlantao = diaPlantao;
        this.inicioExpediente = inicioExpediente;
        this.fimExpediente = fimExpediente;
    }

    public int getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public String[] getEspecialidade() {
        return especialidade;
    }

    public String[] getDiaPlantao() {
        return diaPlantao;
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

    public void setDiaPlantao(String[] diaPlantao) {
        this.diaPlantao = diaPlantao;
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
}
