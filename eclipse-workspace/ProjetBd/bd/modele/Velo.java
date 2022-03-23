package modele;

public class Velo {
  private String fonction_cage;

   public Velo() {
    }

   public Velo(String n) {
        this.fonction_cage = n;
    }

  public String getFonctionCage() {
    return fonction_cage;
  }  

  public void setFonctionCage(String n) {
    fonction_cage = n;
  }

}