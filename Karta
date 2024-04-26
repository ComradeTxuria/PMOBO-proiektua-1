
public class Karta {
	
	protected String kolore;
	
	public Karta(String pKolore) {
		this.kolore = pKolore;
	}
	public void imprimatu() {
		System.out.println("KOLOREA: "+kolore);
	}
	protected void eginAkzio() { //TODO Tenemos que hacerlo cuando sepamos las que acciones son!!
		 
	}
	public String getKolore()
	{
		return this.kolore;
	}
	
	public boolean komparatuZenb(Karta k){return false;}
	public int getZenb(){return -1;}
	
	public boolean komparatuKolore(Karta pKarta)
	{
		boolean berdina = false;
		String koloreK = pKarta.getKolore();
		if (this.kolore == koloreK || koloreK == null)
		{
			berdina = true;
		}
		return berdina;
	}
}
