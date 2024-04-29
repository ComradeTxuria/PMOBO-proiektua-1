public class Normala extends Karta {
	
	private int zenbaki;
	
	public Normala(int pZenbaki, String pKolore) {
		super(pKolore);
		this.zenbaki = pZenbaki;
	}
	public void imprimatu(int pPos) {
		super.imprimatu(pPos);
		if (pPos == -1){
			System.out.println(" ZENBAKI/KOLORE: "+zenbaki+" "+super.kolore);
		}
		else 
		{
			System.out.println(pPos + " ZENBAKI/KOLORE: "+zenbaki+" "+super.kolore);
		}
	}
	
	public int getZenb()
	{
		return this.zenbaki;
	}
	
	
	public boolean komparatuZenb(Karta pKarta)
	{
		boolean berdina = false;
		int zenb = pKarta.getZenb();
		if (this.zenbaki == zenb)
		{
			berdina = true;
		}
		return berdina;
	}

}
