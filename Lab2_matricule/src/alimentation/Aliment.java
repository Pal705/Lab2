package alimentation;

/** 
 * Classe Aliments
 * Cette classe permet de décrir des aliments, avec leur valeur 
 * nutritive.
 * @author jerome.blais-morin
 * @version 1.0
 *
 */
public class Aliment {
	private double nbGrammesGlucide;
	private double nbGrammesLipide;
	private double nbGrammesProteine;
	private double nbGrammesSodium;
	private int nbCalories;
	private String nom;
	private TypeAliment monType;
	
	// SOURCE : http://www.canadiensensante.gc.ca/eating-nutrition/label-etiquetage/daily-value-valeur-quotidienne-fra.php
	public static final double VALEUR_QUOTIDIENNE_GLUCIDE = 300.0; 
	public static final double VALEUR_QUOTIDIENNE_LIPIDE = 65.0; 
	public static final double VALEUR_QUOTIDIENNE_PROTEINE = 75.0; 
	public static final double VALEUR_QUOTIDIENNE_SODIUM = 2.4; 
	public static final double VALEUR_QUOTIDIENNE_CALORIE = 2000.0;
	
	public Aliment(double p_nbGrammesGlucide, 
				   double p_nbGrammesLipide, 
				   double p_nbGrammesProteine, 
				   double p_nbGrammeSodium, 
				   int p_nbCalories,
				   String p_nom,
				   TypeAliment p_typeAliment) {
		nbGrammesGlucide = p_nbGrammesGlucide;
		nbGrammesLipide = p_nbGrammesLipide;
		nbGrammesProteine = p_nbGrammesProteine;
		nbGrammesSodium = p_nbGrammeSodium;
		nbCalories = p_nbCalories;
		nom = p_nom;
		monType = p_typeAliment;
	}
	
	public float getNbGrammesGlucide() {
		return nbGrammesGlucide;
	}
	
	public double getNbGrammesLipide() {
		return nbGrammesLipide;
	}

	public double getNbGrammesProteine() {
		return nbGrammesProteine;
	}

	public double getNbGrammesSodium() {
		return nbGrammesSodium;
	}

	public int getNbCalories() {
		return nbCalories;
	}

	public String getNom() {
		return nom;
	}

	public TypeAliment getTypeAliment() {
		return monType;
	}	
	
	public String toString() {
		return nom + " : " + monType + ", " +
				"Glucide [" + nbGrammesGlucide + "g], " +				
				"Lipide [" + nbGrammesLipide + "g], " +
				"Proteine [" + nbGrammesProteine + "g], " +
				"Sodium [" + nbGrammesSodium + "g], " +
				"Calories [" + nbCalories + "g] ";
	}
	
}
