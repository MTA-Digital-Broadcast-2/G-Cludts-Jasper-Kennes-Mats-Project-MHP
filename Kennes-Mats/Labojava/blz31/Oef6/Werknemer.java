public class Werknemer {
public String voornaam;
public String achternaam;
public int werknemerNummer;
protected float salaris;
private float RSZPercentage = 33.0f;


public Werknemer (String voornaam, String achternaam, int wNummer, float salaris)
{
this.voornaam = voornaam;
this.achternaam = achternaam;
werknemerNummer=wNummer;
this.salaris = salaris;
}

public void salarisverhogen(int percentage)
{
float verhogingsfactor=(float)percentage/100;
salaris+=salaris*verhogingsfactor;
}

public float getsalaris()
{
return salaris;
}

public float getRSZ()
{
return RSZPercentage;
}

public void setRSZ(float RSZ)
{
if(RSZ<0.0f){
return;
}
if(RSZ >100.0f)
{
return;
}
RSZPercentage = RSZ;
}
}