public class PartTimeWerknemer extends Werknemer {

	int urenGewerkt;
	
	public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urengw){
		
		super(voornaam, achternaam, wNummer, salaris);
		urenGewerkt=urengw;
		
		
		}
		
		public void salarisverhogen(int percentage)
		{
		if (percentage>5) {
		System.out.println("FOUT: PartTimeWerknemers kunnen maar 5% opslag krijgen HAHA HA HA");
		}
		else
		{
		super.salarisverhogen(percentage);
		}
		}
		}