package UnoProiektua;

import java.util.ArrayList;

public class Jokalari {
	private String id;
	private KartaZerrenda eskua;
	
	public Jokalari(String pId)
	{
		this.id = pId;
		this.eskua = new KartaZerrenda();
		for (int i=0; i<7; i++)
		{
			Karta k = kartaHartu();
			eskua.gehituKarta(k);
		}	
	}
	
	
	public void jolastuTurnoa()
	{
		int x = 0;
		boolean jolastu = true;
		while(jolastu == true & x<2)
		{	
			if(kartaBotaBai() == true)
			{
				int botatzeko = Teklatua.getTeklatua().getInt("Ipini bota nahi duzun karta");
				Karta bota = eskua.getKarta(botatzeko);
				kartaEman(bota);
				jolastu = false;
			}
			else
			{
				kartaHartu();
			}
			x++;
		}		
	}
	
	private Karta kartaHartu()
	{
		Karta k = Mazoa.getMazoa().kartaEman();
		return k;
	}
	
	private boolean kartaBotaBai()
	{
		Karta gohiko = Mahaia.getMahaia().itzuliKarta();
		boolean bota = eskua.berdina(gohiko);
		return bota;
	}
	
	private void kartaEman(Karta pKarta)
	{
		Mahaia.getMahaia().gehituKarta(pKarta);
	}
	
	public boolean jokoaAmaitua() 
	{
		return eskua.utsa();
	}
	
}

//zenbat adliz hartu daiteke kartak? 2
//errore bat egotekotan ez dago amaitua
//zergatik get txarto??
//kartaBotaBai KartaZerrendan egin behar da
