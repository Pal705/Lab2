package alimentation;

/**
 * Classe BoiteALunch Cette classe permet de contenir des aliments. Une boîte à
 * lunch peut contenir jusqu'à 4 aliments.
 * 
 * @author jerome.blais-morin
 * @version 1.0
 *
 */
// Paul Champagne
// Jean-Luc Manseau
public class BoiteALunch {
	private Aliment aliment1;
	private Aliment aliment2;
	private Aliment aliment3;
	private Aliment aliment4;

	// On considère qu'un boîte a lunch devrait contenir 30% de l'apport
	// quoditien en aliments.
	public final static double PROPORTION_APPORT_QUOTIDIEN = 0.30;

	public BoiteALunch() {
		aliment1 = null;
		aliment2 = null;
		aliment3 = null;
		aliment4 = null;
	}

	/**
	 * Ajoute un aliment dans la boîte a lunch s'il reste de la place.
	 * 
	 * @param unAliment
	 *            L'aliment à ajouter
	 * @return true si l'ajout a réussi. false s'il a échoué.
	 */
	public boolean ajouter(Aliment unAliment) {
		boolean ajoutReussi = false;

		if (aliment1 == null) {
			aliment1 = unAliment;
			ajoutReussi = true;
		} else if (aliment2 == null) {
			aliment2 = unAliment;
			ajoutReussi = true;
		} else if (aliment3 == null) {
			aliment3 = unAliment;
			ajoutReussi = true;
		} else if (aliment4 == null) {
			aliment4 = unAliment;
			ajoutReussi = true;
		}

		return ajoutReussi;
	}

	public boolean enlever(TypeAliment unTypeAliment) {

		boolean retraitReussi = false;

		if (aliment1 != null && aliment1.getTypeAliment() == unTypeAliment) {
			aliment1 = null;
			retraitReussi = true;
		} else if (aliment2 != null
				&& aliment2.getTypeAliment() == unTypeAliment) {
			aliment2 = null;
			retraitReussi = true;
		} else if (aliment3 != null
				&& aliment3.getTypeAliment() == unTypeAliment) {
			aliment3 = null;
			retraitReussi = true;
		} else if (aliment4 != null
				&& aliment4.getTypeAliment() == unTypeAliment) {
			aliment4 = null;
			retraitReussi = true;
		}

		return retraitReussi;
	}

	public boolean contient(TypeAliment unTypeAliment) {

		boolean Contient = false;

		if (aliment1.getTypeAliment() == unTypeAliment) {
			Contient = true;
		} else if (aliment2.getTypeAliment() == unTypeAliment) {
			Contient = true;
		} else if (aliment3.getTypeAliment() == unTypeAliment) {
			Contient = true;
		} else if (aliment4.getTypeAliment() == unTypeAliment) {
			Contient = true;
		}
		return Contient;
	}

	public double getNiveau(InfoNutritive info) {

		double niveau = 0.0;

		switch (info) {
		case GLUCIDE:
			niveau = getTotalGlucide();
		case LIPIDE:
			niveau = getTotalLipide();
		case PROTEINE:
			niveau = getTotalProteine();
		case SODIUM:
			niveau = getTotalSodium();
		case CALORIES:
			niveau = getTotalCalories();
		}

		return niveau;
	}

	public double getTotalGlucide() {

		double total = 0.0;

		if (aliment1 != null)
			total += aliment1.getNbGrammesGlucide();

		if (aliment2 != null)
			total += aliment2.getNbGrammesGlucide();

		if (aliment3 != null)
			total += aliment3.getNbGrammesGlucide();

		if (aliment4 != null)
			total += aliment4.getNbGrammesGlucide();

		return total;
	}

	public double getTotalLipide() {

		double total = 0.0;

		if (aliment1 != null)
			total += aliment1.getNbGrammesLipide();

		if (aliment2 != null)
			total += aliment2.getNbGrammesLipide();

		if (aliment3 != null)
			total += aliment3.getNbGrammesLipide();

		if (aliment4 != null)
			total += aliment4.getNbGrammesLipide();

		return total;
	}

	public double getTotalProteine() {

		double total = 0.0;

		if (aliment1 != null)
			total += aliment1.getNbGrammesProteine();

		if (aliment2 != null)
			total += aliment2.getNbGrammesProteine();

		if (aliment3 != null)
			total += aliment3.getNbGrammesProteine();

		if (aliment4 != null)
			total += aliment4.getNbGrammesProteine();

		return total;
	}

	public double getTotalSodium() {

		double total = 0.0;

		if (aliment1 != null)
			total += aliment1.getNbGrammesSodium();

		if (aliment2 != null)
			total += aliment2.getNbGrammesSodium();

		if (aliment3 != null)
			total += aliment3.getNbGrammesSodium();

		if (aliment4 != null)
			total += aliment4.getNbGrammesSodium();

		return total;
	}

	public double getTotalCalories() {

		double total = 0.0;

		if (aliment1 != null)
			total += aliment1.getNbCalories();

		if (aliment2 != null)
			total += aliment2.getNbCalories();

		if (aliment3 != null)
			total += aliment3.getNbCalories();

		if (aliment4 != null)
			total += aliment4.getNbCalories();

		return total;
	}

	public boolean estSante() {

		boolean estSante = false;

		if (getTotalProteine() >= PROPORTION_APPORT_QUOTIDIEN
				* Aliment.VALEUR_QUOTIDIENNE_PROTEINE
				&&

				getTotalCalories() <= PROPORTION_APPORT_QUOTIDIEN
						* Aliment.VALEUR_QUOTIDIENNE_CALORIE
				&&

				getTotalSodium() <= PROPORTION_APPORT_QUOTIDIEN
						* Aliment.VALEUR_QUOTIDIENNE_SODIUM
				&&

				(contient(TypeAliment.FRUIT) || contient(TypeAliment.LEGUME))
				|| contient(TypeAliment.REPAS_PRINCIPAL))
			estSante = true;

		return estSante;
	}

	public void afficherPourcentValeurQuotidienne() {

		System.out.println("Pourcentage de la valeur quotidienne");

		afficherPourcentage("Glucide ", getTotalGlucide(),
				Aliment.VALEUR_QUOTIDIENNE_GLUCIDE);
		afficherPourcentage("Lipide  ", getTotalLipide(),
				Aliment.VALEUR_QUOTIDIENNE_LIPIDE);
		afficherPourcentage("Proteine", getTotalProteine(),
				Aliment.VALEUR_QUOTIDIENNE_PROTEINE);
		afficherPourcentage("Sodium  ", getTotalSodium(),
				Aliment.VALEUR_QUOTIDIENNE_SODIUM);
		afficherPourcentage("Calorie ", getTotalCalories(),
				Aliment.VALEUR_QUOTIDIENNE_CALORIE);
	}

	public void afficherPourcentage(String categorie, double numerateur,
			double denumerateur) {

		System.out.print(categorie + " : ");

		int i = 0;
		while (i < 10) {
			if (numerateur / denumerateur >= i / 10.0) {
				i = i + 1;
				System.out.print("*");
			}

			else
				System.out.print(".");
			i = i + 1;
		}

		// Affichage en nombre et changement de ligne
		System.out.println("  " + (numerateur / denumerateur) * 100.0 + "%");
	}

	public String toString() {
		String reponse = "Boite a lunch :\n";

		if (aliment1 != null) {
			reponse += "\t";
			reponse += aliment1.toString();
			reponse += "\n";
		}

		if (aliment2 != null) {
			reponse += "\t";
			reponse += aliment2.toString();
			reponse += "\n";
		}

		if (aliment3 != null) {
			reponse += "\t";
			reponse += aliment3.toString();
			reponse += "\n";
		}

		if (aliment4 != null) {
			reponse += "\t";
			reponse += aliment4.toString();
			reponse += "\n";
		}

		return reponse;
	}

}
