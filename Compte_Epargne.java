package banque;

import java.util.ArrayList;

public class Compte_Epargne extends Compte{

    private double taux;
    ArrayList<String> lesOperations= new ArrayList<String>();

    public Compte_Epargne(int numero, String nom_titulaire, double solde, double taux) {
        super(numero, nom_titulaire, solde);
        this.taux = taux;
    }
    
    

    public double getTaux() {
		return taux;
	}



	public void setTaux(double taux) {
		this.taux = taux;
	}



	public void consulte() {
        super.consulte();
        System.out.println("Le compte epargne a un taux de " + taux + "%");
    }

    public void mise_a_jour(double nouveau_taux) {
        this.taux = nouveau_taux;
    }
    
    public int type(){
    	return 2;
    }

}