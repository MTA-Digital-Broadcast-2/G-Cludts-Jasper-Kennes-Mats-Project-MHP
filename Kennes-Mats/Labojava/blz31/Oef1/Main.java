public class Main {

public static void main(String args[])

{
	Werknemer herman = new Werknemer("herman", "hermans", 1, 1000);
	Werknemer Jasper = new Werknemer("Jasper", "Cludts", 2, 200);
	Werknemer Jonah = new Werknemer("Jonah", "Boons", 3, 2575);
	Werknemer Dieter = new Werknemer("Dieter", "Clauwaert", 4, 201);
	Werknemer Mats = new Werknemer("Mats", "Kennes", 5, 500000);
	
	System.out.println(Mats.voornaam + " verdient " + Mats.getsalaris() + " Euro");
	}
	}