package alimentation;

/**
 * Classe Application Cette classe contient le point d'entrée (main) de
 * l'application
 * 
 * @author jerome.blais-morin
 * @version 1.0
 *
 */
//Paul Champagne
//Jean-Luc Manseau
public class Application {

	public static void main(String[] args) {

		// Creation d'aliments
		// http://www.passeportsante.net/fr/Nutrition/EncyclopedieAliments/Fiche.aspx?doc=pomme_nu
		// http://www.doctissimo.fr/asp/aliments/base_aliments/visu_index.asp?num_ali=55
		Aliment pomme = new Aliment(19.1, 0.2, 0.4, 0.0, 72, "Pomme",
				TypeAliment.FRUIT);
		Aliment sandwichJambon = new Aliment(32.2, 8.7, 11.2, 0.5, 252,
				"Sandwich au jambon", TypeAliment.REPAS_PRINCIPAL);
		Aliment noix = new Aliment(10.5, 63.8, 14.5, 0.2, 194, "Noix",
				TypeAliment.NOIX);
		Aliment carotte = new Aliment(8.1, 0.4, 0.3, 0.0, 50, "Carotte",
				TypeAliment.LEGUME);

		// Création d'une boîte à lunch 1
		BoiteALunch Boite1 = new BoiteALunch();
		Boite1.ajouter(pomme);
		Boite1.ajouter(sandwichJambon);
		Boite1.ajouter(carotte);
		Boite1.ajouter(noix);

		System.out.println("Boite a lunch 1 :");
		Boite1.afficherPourcentValeurQuotidienne();

		System.out.println();
		if (Boite1.estSante())
			System.out.println("La boite a lunch 1 est sante!");
		else
			System.out.println("La boite a lunch 1 n'est pas sante!");

		System.out.println(Boite1);

		System.out.println("Boite 1 : Nombre de grammes de proteine : "
				+ Boite1.getNiveau(InfoNutritive.PROTEINE));

		System.out.println();
		System.out.println();

		Aliment poire = new Aliment(22.1, 0.2, 0.4, 0.0, 72, "Poire",
				TypeAliment.FRUIT);
		Aliment sandwichDinde = new Aliment(30.2, 8.7, 10.2, 0.5, 252,
				"Sandwich à la dinde", TypeAliment.REPAS_PRINCIPAL);
		Aliment mousseChocolat = new Aliment(37.8, 11.6, 6.6, 0.2, 282,
				"Mousse au chocolat", TypeAliment.DESSERT_SUCRE);
		Aliment jusPomme = new Aliment(19.1, 0.4, 0.3, 0.0, 121,
				"Jus de pomme", TypeAliment.JUS);
		Aliment jusAnanas = new Aliment(23.1, 0.4, 0.3, 0.0, 121,
				"Jus d'ananas", TypeAliment.JUS);

		// Création d'une boîte à lunch 2
		BoiteALunch boite2 = new BoiteALunch();
		boite2.ajouter(poire);
		boite2.ajouter(sandwichDinde);
		boite2.ajouter(mousseChocolat);
		boite2.ajouter(mousseChocolat);
		
		
		
		if (boite2.contient(TypeAliment.JUS))

			System.out.println("La boite à lunch 2 contient un jus.");

		else

			System.out.println("La boite à lunch 2 ne contient pas de jus.");

		System.out.println("Boite a lunch 2 :");
		boite2.afficherPourcentValeurQuotidienne();

		System.out.println();
		if (boite2.estSante())
			System.out.println("La boite a lunch 2 est sante!");
		else
			System.out.println("La boite a lunch 2 n'est pas sante!");

		System.out.println(boite2);

		System.out.println("Boite 2 : Nombre de grammes de proteine : "
				+ boite2.getNiveau(InfoNutritive.PROTEINE));

	}

}
