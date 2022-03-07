package domain;

public class Enfermeiro extends Pessoa {
    private final int id;
    private String tipoEquipe;
    private boolean eSupervisor;

    public Enfermeiro(String nome, String cpf, String numeroTelefone, String endereco,
                      String sexo, int id, String tipoEquipe, boolean eSupervisor) {
        super(nome, cpf, numeroTelefone, endereco, sexo);
        this.id = id;
        this.tipoEquipe = tipoEquipe;
        this.eSupervisor = eSupervisor;
    }

    public int getId() {
        return id;
    }

    public String getTipoEquipe() {
        return tipoEquipe;
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
}
