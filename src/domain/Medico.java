package domain;

public class Medico extends Pessoa {
    private final int id;
    private String crm;
    private String especialidade;
    private String diaPlantao;

    public Medico(String nome, String cpf, String numeroTelefone, String endereco, String sexo,
                  int id, String crm, String especialidade, String diaPlantao) {
        super(nome, cpf, numeroTelefone, endereco, sexo);
        this.id = id;
        this.crm = crm;
        this.especialidade = especialidade;
        this.diaPlantao = diaPlantao;
    }

    public int getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getDiaPlantao() {
        return diaPlantao;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDiaPlantao(String diaPlantao) {
        this.diaPlantao = diaPlantao;
    }
}
