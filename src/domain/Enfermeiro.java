package src.domain;

public class Enfermeiro extends Pessoa {
    private final int id;
    private String tipoEquipe;
    private boolean eSupervisor;
    private float inicioExpediente;
    private float fimExpediente;

    public Enfermeiro(String nome, String cpf, String numeroTelefone, String endereco,
                      String sexo, int id, String tipoEquipe, boolean eSupervisor,
                      float inicioExpediente, float fimExpediente) {
        super(nome, cpf, numeroTelefone, endereco, sexo);
        this.id = id;
        this.tipoEquipe = tipoEquipe;
        this.eSupervisor = eSupervisor;
        this.inicioExpediente = inicioExpediente;
        this.fimExpediente = fimExpediente;
    }

    public int getId() {
        return id;
    }

    public String getTipoEquipe() {
        return tipoEquipe;
    }

    public float getInicioExpediente() {
        return inicioExpediente;
    }

    public float getFimExpediente() {
        return fimExpediente;
    }

    public boolean getESupervisor() {
        return eSupervisor;
    }

    public void setTipoEquipe(String tipoEquipe) {
        this.tipoEquipe = tipoEquipe;
    }

    public void setESupervisor(boolean eSupervisor) {
        this.eSupervisor = eSupervisor;
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
        registro.setEnfermeiroId(id);
        return registro;
    }
}
