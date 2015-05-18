public class Factuur implements Betaalbaar {

int bedrag = 0;
int factnr = 0;

public Factuur(int bedrag, int factnr)
{
this.bedrag = bedrag;
this.factnr = factnr;
}

public void betaal()
{
System.out.println("Betaal het factuur " + factnr + " voor een bedrag van " + bedrag);
}
}