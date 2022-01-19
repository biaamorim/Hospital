package src.domain;

public class Enfermeiro {
    private  int id ;
    private  String tipodeEquipe;
    private  boolean issupervisor;
    private  int expediente ;


    public int getId() {
        return id;
    }

    public String getTipodeEquipe() {
        return tipodeEquipe;
    }

    public int getExpediente() {
        return expediente;
    }

    public boolean isIssupervisor() {
        return issupervisor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipodeEquipe(String tipodeEquipe) {
        this.tipodeEquipe = tipodeEquipe;
    }

    public void setIssupervisor(boolean issupervisor) {
        this.issupervisor = issupervisor;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }


}
