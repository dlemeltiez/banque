package banque;

import java.util.Scanner;
import java.util.ArrayList; 

public class Utilise_Compte {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Compte_Courant> lesComptesCourants= new ArrayList<Compte_Courant>();
		ArrayList<Compte_Epargne> lesComptesEpargnes= new ArrayList<Compte_Epargne>();
		
		Compte_Courant unCompteCourant;
		Compte_Epargne unCompteEpargne;
		
		boolean loop = true, loop2 = false;
		int response1, response2, response3, response4, response5, response6, response7, nbAccount = 0, nbAccount2, discovered;
		String name, nbAccountVerify;
		double balance, rate, withdrawal, deposit, newRate;
		
		while(loop == true) {
			System.out.println("Voulez vous créer un compte ? (1)");
			System.out.println("Voulez vvous afficher tous les comptes ? (2)");
			System.out.println("Voulez vous manipuler un compte ? (3)");
			System.out.println("Voulez vous manipuler tous les comptes ? (4)");
			System.out.println("Voulez vous quittez l'applications ? (5)");
			
			response1 = sc.nextInt();
			
			if(response1 == 1) {
				System.out.println("voulez vous créer un compte courant (1) ou épargne (2)");
				response2 = sc.nextInt();
				
				nbAccount += 1;
				
				System.out.println("Entrez le nom");
				sc.nextLine();
				name = sc.nextLine();
				
				System.out.println("Entrez le solde du compte");
				balance = sc.nextDouble();
				
				if(response2 == 1) {
					System.out.println("Entrez le découvert autorisé");
					discovered = sc.nextInt();
					
					unCompteCourant = new Compte_Courant(nbAccount, name, balance, discovered);
					
					lesComptesCourants.add(unCompteCourant);	
				}
				else if(response2 == 2) {
					System.out.println("Entrez le taux en %");
					rate = (sc.nextDouble()/100 ) + 1;
					
					unCompteEpargne = new Compte_Epargne(nbAccount, name, balance, rate);
					
					lesComptesEpargnes.add(unCompteEpargne);
				}
			}
			else if(response1 == 2) {
				System.out.println("Les comptes courants : ");
				for(Compte_Courant leCompteCourant : lesComptesCourants) {
					System.out.println("le numero est " + leCompteCourant.getNumero());
					System.out.println("le nom est " + leCompteCourant.getNom());
					System.out.println("----------------------------------------------");
				}
				System.out.println("Les comptes épargnes : ");
				for(Compte_Epargne leCompteEpargne : lesComptesEpargnes) {
					System.out.println("le numero est " + leCompteEpargne.getNumero());
					System.out.println("le nom est " + leCompteEpargne.getNom());
					System.out.println("----------------------------------------------");
				}
			}
			else if(response1 == 3) {
				System.out.println("Voulez vous consulter le solde d'un compte? (1)");
				System.out.println("Voulez vous faire un retrait sur un compte? (2)");
				System.out.println("Voulez vous faire un dépot sur un compte? (3)");
				System.out.println("Voulez vous connaitre le montant du découvert d'un compte courant? (4)");
				System.out.println("Voulez vous connaitre le taux de rémunération d'un compte épargne? (5)");
				response3 = sc.nextInt();
				
				if(response3 == 1) {
					System.out.println("S'agit-il d'un compte courant (1) ou d'un compte epargne (2) ?");
					response4 = sc.nextInt();
					
					if(response4 == 1) {
						System.out.println("saisissez le numero du compte");
						nbAccount2 = sc.nextInt();
						for(Compte_Courant leCompteCourant: lesComptesCourants) {
				            if (nbAccount2 == leCompteCourant.getNumero()) {
				                System.out.println("le solde est de :" + leCompteCourant.getSolde());
				            }
						}
					}
					else if(response4 == 2) {
						System.out.println("saisissez le numero du compte");
						nbAccount2 = sc.nextInt();
						for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
				            if (nbAccount2 == leCompteEpargne.getNumero()) {
				                System.out.println("le solde est de :" + leCompteEpargne.getSolde());
				            }
						}
					}
				}
				else if(response3 == 2) {
					System.out.println("S'agit-il d'un compte courant (1) ou d'un compte epargne (2) ?");
					response5 = sc.nextInt();
					
					if(response5 == 1) {
						System.out.println("saisissez le numero du compte");
						nbAccount2 = sc.nextInt();
						
						for(Compte_Courant leCompteCourant: lesComptesCourants) {
							if(nbAccount2 == leCompteCourant.getNumero()) {
								System.out.println("Combien voulez-vous retirez?");
								withdrawal = sc.nextDouble();
								
								leCompteCourant.retirer(withdrawal);
								System.out.println("Le nouveau solde est de :" + leCompteCourant.getSolde());
							}
						}
					}
					else if(response5 == 2) {
						System.out.println("saisissez le numero du compte");
						nbAccount2 = sc.nextInt();
						
						for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
							if(nbAccount2 == leCompteEpargne.getNumero()) {
								System.out.println("Combien voulez-vous retirez?");
								withdrawal = sc.nextDouble();
								
								leCompteEpargne.retirer(withdrawal);
								System.out.println("Le nouveau solde est de :" + leCompteEpargne.getSolde());
							}
						}
					}
				}
				else if(response3 == 3){
					System.out.println("S'agit-il d'un compte courant (1) ou d'un compte epargne (2) ?");
					response6 = sc.nextInt();
					
					if(response6 == 1) {
						System.out.println("saisissez le numero du compte");
						nbAccount2 = sc.nextInt();
						
						for(Compte_Courant leCompteCourant: lesComptesCourants) {
							if(nbAccount2 == leCompteCourant.getNumero()) {
								System.out.println("Combien voulez-vous déposez?");
								deposit = sc.nextDouble();
								
								leCompteCourant.deposer(deposit);
								System.out.println("Le nouveau solde est de :" + leCompteCourant.getSolde());
							}
						}
					}
					else if(response6 == 2) {
						System.out.println("saisissez le numero du compte");
						nbAccount2 = sc.nextInt();
						
						for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
							if(nbAccount2 == leCompteEpargne.getNumero()) {
								System.out.println("Combien voulez-vous déposez?");
								deposit = sc.nextDouble();
								
								leCompteEpargne.deposer(deposit);
								System.out.println("Le nouveau solde est de :" + leCompteEpargne.getSolde());
							}
						}
					}
				}
				else if(response3 == 4){
					System.out.println("saisissez le numero du compte");
					nbAccount2 = sc.nextInt();
					
					for(Compte_Courant leCompteCourant: lesComptesCourants) {
						if(nbAccount2 == leCompteCourant.getNumero()) {
							System.out.println("Le montant du découvert est de :" + leCompteCourant.getDecouvert_autorise());
						}
					}

				}
				else if(response3 == 5){
					System.out.println("saisissez le numero du compte");
					nbAccount2 = sc.nextInt();
					
					for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
						if(nbAccount2 == leCompteEpargne.getNumero()) {
							System.out.println("Le montant du taux est de :" + ((leCompteEpargne.getTaux() - 1)*100));
						}
					}

				}
			}
			else if(response1 == 4){
				System.out.println("Voulez vous afficher la liste des titulaires des comptes courants avec un solde négatif? (1)");
				System.out.println("Voulez vous modifier le taux de rémunération de tous les comptes éparges? (2)");
				System.out.println("Voulez vous afficher la liste des personne possèdant un compte courant et un compte épargne? (3)");
				response7 = sc.nextInt();
				
				if(response7 == 1) {
					for(Compte_Courant leCompteCourant: lesComptesCourants) {
						if(leCompteCourant.getSolde() < 0){
							System.out.println(leCompteCourant.getNom());
						}
					}
				}
				else if(response7 == 2) {
					System.out.println("Quel taux voulez vous mettre en %?");
					newRate = sc.nextDouble();
					
					for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
						leCompteEpargne.setTaux((newRate/100+1));
					}
				}
				else if(response7 == 3) {
					for(Compte_Courant leCompteCourant : lesComptesCourants) {
						for(Compte_Epargne leCompteEpargne : lesComptesEpargnes) {
							if(leCompteCourant.getNom() == leCompteEpargne.getNom()) {
								System.out.println(leCompteCourant.getNom());
							}
						}
					}
				}
			}
			else if(response1 == 5) {
				System.out.println("Au revoir");
				loop = false;
			}
		}
	}
}