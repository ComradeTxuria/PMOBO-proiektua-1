
public class Karta {
	
	protected String kolore;
	
	protected Karta(String pKolore) {
		this.kolore = pKolore;
	}
	
	public String getKolore()
	{
		return this.kolore;
	}
	
	public boolean komparatuZenb(Karta k){return false;}
	protected int getZenb(){return -1;}
	public void imprimatu(int pPos) {}
	protected boolean komparatuMota(Karta k){return false;}
	protected void eginAkzio() { }
	
	
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
