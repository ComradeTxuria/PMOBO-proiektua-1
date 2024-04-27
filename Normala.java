public class Normala extends Karta {
	
	private int zenbaki;
	
	public Normala(int pZenbaki, String pKolore) {
		super(pKolore);
		this.zenbaki = pZenbaki;
	}
	public void imprimatu() {
		super.imprimatu();
		System.out.println("ZENBAKI: "+zenbaki);
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
