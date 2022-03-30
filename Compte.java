package banque;

public class Compte {

    protected int numero;
    protected double solde;
    protected String nom_titulaire;

    public Compte(int numero, String nom_titulaire, double solde) {
        this.numero = numero;
        this.nom_titulaire = nom_titulaire;
        this.solde = solde;
    }
    
    
    public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	

	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public String getNom() {
		return nom_titulaire;
	}
	public void setNom(String nom_titulaire) {
		this.nom_titulaire = nom_titulaire;
	}


	public void consulte() {
        System.out.println("Le compte a un solde de " + solde +"$");

    }

    public void deposer(double val) {
        solde = solde + val;
    }

    public void retirer(double val) {
        solde = solde - val;
    }


}