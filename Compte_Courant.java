package banque;

public class Compte_Courant extends Compte{

    private double decouvert_autorise;

    public Compte_Courant(int numero, String nom_titulaire, double solde, double decouvert) {
        super(numero, nom_titulaire, solde);
        decouvert_autorise = decouvert;
    }
    
    

    public double getDecouvert_autorise() {
		return decouvert_autorise;
	}

	public void setDecouvert_autorise(double decouvert_autorise) {
		this.decouvert_autorise = decouvert_autorise;
	}


	public void consulte() {
        super.consulte();
        System.out.println("Le compte courant a un decouvert maximale autorisé de " + decouvert_autorise + "$");
    }

    public void retirer(int val){
        if (solde - val > decouvert_autorise) {
            solde = solde - val;
        }
        else {
        	System.out.println("Retrait impossible!");
        }
    }
    
    public int type(){
    	return 1;
    }

}
