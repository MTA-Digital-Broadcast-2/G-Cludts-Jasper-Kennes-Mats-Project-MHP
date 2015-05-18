public class Main {

public static void main(String args[])

{
	Werknemer herman = new Werknemer("herman", "hermans", 1, 1000);
	Werknemer Jasper = new Werknemer("Jasper", "Cludts", 2, 200);
	Werknemer Jonah = new Werknemer("Jonah", "Boons", 3, 2575);
	Werknemer Dieter = new Werknemer("Dieter", "Clauwaert", 4, 201);
	Werknemer Mats = new Werknemer("Mats", "Kennes", 5, 500000);
	
	System.out.println(Mats.voornaam + " verdient " + Mats.getsalaris() + " Euro per dag");
	
	//oef 2
	
	//herman.salarisverhogen(10);
	Mats.salarisverhogen(100);
	System.out.println(Mats.voornaam + " verdient " + Mats.getsalaris() + " Euro per dag na opslag");
	
	//oef3
	
	PartTimeWerknemer Ilse = new PartTimeWerknemer("Ilse", "Luiaert", 6, 59, 20);
	PartTimeWerknemer Peggy = new PartTimeWerknemer("Peggy", "Lompegeit", 7, 60, 15);
	
	System.out.println(Ilse.voornaam + " verdient " + Ilse.getsalaris() + " Euro per dag");
	
	//oef4
	
	Ilse.salarisverhogen(6);
	System.out.println(Ilse.voornaam + " verdient " + Ilse.getsalaris() + " Euro per dag na opslag");
	
	//oef5
	
	System.out.println(Mats.voornaam + " betaalt " + Mats.getRSZ() + "% RSZ");
	
	//oef6
	System.out.println(Ilse.voornaam + " betaalt " + Ilse.getRSZ() + "% RSZ");
	
	//oef7
	StudentWerknemer Marc = new StudentWerknemer("Marc", "Kennes", 8, 60,15);
	
	System.out.println(Marc.voornaam + " betaalt "  + Marc.getRSZ() + "% RSZ");
	
	//oef8 & 9
	Marc.betaal();
	}
	}