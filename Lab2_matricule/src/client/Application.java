package client;

import java.util.Scanner;

import client.Client.classeConfortSouhaitee;

import client.Taxi;
//Paul Champagne
//Jean-Luc Manseau

/**
 * Description de la classe
 * 
 * @author Martin Simoneau
 * @version 1.0.0
 * 
 *
 */

public class Application {
	public static void main(String[] args) {
		Scanner entree = new Scanner(System.in);
		Taxi taxi1 = new Taxi("Capitaine flamme");
		Taxi taxi2 = new Taxi("Youpi");
		Taxi taxi3 = new Taxi("Biz");

		Client precieuxMonsieur = new Client(100, 7, "Zoro",
				classeConfortSouhaitee.LUXE);
		Client clientGratteux = new Client(30, 34, "Woody",
				classeConfortSouhaitee.PROMO);
		Client jeuneHomme = new Client(200, 39, "Gasper",
				classeConfortSouhaitee.LOCAL);
		Client tresJeuneHomme = new Client(200, 12, "Yagourt",
				classeConfortSouhaitee.TOURISTIQUE);
		Client richeHommeAffaire = new Client(1500, 80, "Goldorak",
				classeConfortSouhaitee.AFFAIRE);
		Client retardataire = new Client(200, 45, "Babar",
				classeConfortSouhaitee.AFFAIRE);

		jeuneHomme.changeAnniversaire(1996, 25, 12);
		tresJeuneHomme.changeAnniversaire(1997, 3, 1);
		// SCENARIO 1__________________________________________________________
		// Les clients entrent dans les taxis
		taxi1.embarque(precieuxMonsieur);
		// pas assez riche
		taxi2.embarque(clientGratteux);

		// oups! trop jeune
		taxi2.embarque(jeuneHomme);
		// oups! encore trop jeune
		taxi2.embarque(tresJeuneHomme);

		// Les taxis roulent. le precieuxMonsieur débarque
		taxi1.roule(10);
		taxi2.roule(10);
		taxi3.roule(10);

		System.out.println("\nROULE 1_____");
		System.out.println(precieuxMonsieur);
		System.out.println(clientGratteux);
		System.out.println(jeuneHomme);
		System.out.println(tresJeuneHomme);

		System.out.println(taxi1);
		System.out.println(taxi2);
		System.out.println(taxi3);

		// On change de jour. C'est Noël!
		taxi1.changeDateCourante(25, 12, 2014);
		taxi2.changeDateCourante(25, 12, 2014);
		taxi3.changeDateCourante(25, 12, 2014);

		// Un riche homme d'affaire accapare le taxi 3
		taxi3.embarque(richeHommeAffaire);
		// Oups plus assez riche
		taxi3.embarque(precieuxMonsieur);

		// on ira moins loin
		clientGratteux.setDistanceSouhaitee(7);
		taxi2.embarque(clientGratteux);

		// Enfin assez vieux!
		taxi3.embarque(jeuneHomme);
		// oups! encore trop jeune
		taxi2.embarque(tresJeuneHomme);

		// Les taxis roulent. le precieuxMonsieur débarque
		taxi1.roule(10);
		taxi2.roule(10);
		taxi3.roule(10);

		System.out.println("\nROULE 2_____");
		System.out.println(precieuxMonsieur);
		System.out.println(clientGratteux);
		System.out.println(jeuneHomme);
		System.out.println(tresJeuneHomme);

		System.out.println(taxi1);
		System.out.println(taxi2);
		System.out.println(taxi3);

		// On change de jour. C'est Noël!
		taxi1.changeDateCourante(4, 1, 2015);
		taxi2.changeDateCourante(4, 1, 2015);
		taxi3.changeDateCourante(4, 1, 2015);

		// On embarque
		// Enfin autonome
		taxi2.embarque(tresJeuneHomme);
		// Oups le taxi est plein
		taxi3.embarque(retardataire);

		// Les taxis roulent. // le jeune homme débarque
		taxi1.roule(30);
		taxi2.roule(30);
		taxi3.roule(30);

		System.out.println("\nROULE 3_____");
		System.out.println(precieuxMonsieur);
		System.out.println(clientGratteux);
		System.out.println(jeuneHomme);
		System.out.println(tresJeuneHomme);

		System.out.println(taxi1);
		System.out.println(taxi2);
		System.out.println(taxi3);

		// On calcul les frais de transports
		taxi1.appliqueDepense();
		taxi2.appliqueDepense();
		taxi3.appliqueDepense();

		System.out.println("\nFINAL_____");
		System.out.println(precieuxMonsieur);
		System.out.println(clientGratteux);
		System.out.println(jeuneHomme);
		System.out.println(tresJeuneHomme);

		System.out.println(taxi1);
		System.out.println(taxi2);
		System.out.println(taxi3);

		// SCENARIO 2__________________________________________________________

		// À faire

		System.out.println("Entrer le nom du taxi");
		String nomTaxi = entree.next();

		Taxi taxi4 = new Taxi(nomTaxi);

		boolean reponseUtilisateur = false;

		do {

			System.out.println("Entrer le nom du client");
			String nomClient = entree.next();

			System.out.println("Entrer l'avoir du client (nombre entier)");
			int avoir = entree.nextInt();

			System.out
					.println("Entrer la distance souhaitée initiale du client (nombre entier)");
			int distanceInitialSouhaitee = entree.nextInt();

			Client clientCapricieux = new Client(avoir,
					distanceInitialSouhaitee, nomClient,
					classeConfortSouhaitee.LOCAL);
			taxi4.embarque(clientCapricieux);

			System.out.println("Entrer la distance à parcourir par le taxi");
			int distanceParcourir = entree.nextInt();

			taxi4.roule(distanceParcourir);

			System.out.println("Voulez-vous continuer ?");
			String reponse = entree.next();

			if (reponse == "true")

				reponseUtilisateur = true;

		} while (reponseUtilisateur == true);

	}
}
