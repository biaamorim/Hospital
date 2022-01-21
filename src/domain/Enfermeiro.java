package src.domain;

public class Enfermeiro extends Pessoa {
    private  int id ;
    private  String tipoEquipe;
    private  boolean eSupervisor;
    private  int expediente ;

    public int getId() {
        return id;
    }

    public String getTipoEquipe() {
        return tipoEquipe;
    }

    public int getExpediente() {
        return expediente;
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

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    @Override
    public Registro preencheRegistro(Registro registro) {
        registro.setEnfermeiroId(id);
        return registro;
    }
}
