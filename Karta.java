
public class Karta {
	
	protected String kolore;
	
	public Karta(String pKolore) {
		this.kolore = pKolore;
	}
	
	public void imprimatu(int pPos) {
	}
	
	protected void eginAkzio() 
	{ 
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
