package UnoProiektua;

import java.util.ArrayList;
import java.util.InputMismatchException;

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
	
	/*public void imprimatu() {
		System.out.println("ID: " +id);
	}*/
	
	public String getId()
	{
		return this.id;
	}
	
	public void imprimatuKartak() {
		imprimatu();
		eskua.imprimatuKartak();
	}
	
	public void jolastuTurnoa()
	{
		int x = 0;
		boolean jolastu = true;
		while(jolastu == true & x<2)
		{	
			if(kartaBotaBai() == true)
			{
				int botatzeko = botaKarta();
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
	
	private int botaKarta()
	{
		int botatzeko = Teklatua.getTeklatua().getInt("Ipini bota nahi duzun karta");
		try
		{
			if(botatzeko<1 || botatzeko>eskua.kartaKop())
			{
				throw (new ZenbakiLimite());
			}
			else if(botaDaiteke(botatzeko) == false)
			{
				throw (new KartaOkerra());
			}
		}
		catch(ZenbakiLimite e)
		{
			botatzeko = Teklatua.getTeklatua().getInt("Ezin duzu bota ez daukazun karta bat, ipini bota nahi duzun karta bat");
		}
		catch(KartaOkerra e)
		{
			botatzeko = Teklatua.getTeklatua().getInt("Ezin duzu karta hori bota, ipini bota ahal duzun karta bat");
		}
		catch(InputMismatchException e)
		{
			botatzeko = Teklatua.getTeklatua().getInt("Bota nahi duzun karta ZENBAKI baten bidez adierazi behar duzu");
		}
		return botatzeko;
	}
	
	
	private boolean botaDaiteke(int pPos)
	{
		boolean bota = false;
		Karta k = eskua.getKarta(pPos);
		Karta p = Mahaia.getMahaia().itzuliKarta();
		if()
		return bota;
	}
	
	private void kartaEman(Karta pKarta)
	{
		Mahaia.getMahaia().gehituKarta(pKarta);
	}
	
	public boolean jokoaAmaitua() 
	{
		return eskua.hutsa();
	}
	
}
//zenbat adliz hartu daiteke kartak?
//errore bat egotekotan ez dago amaitua
//zergatik get txarto??
//kartaBotaBai KartaZerrendan egin behar da
//zenbat adliz hartu daiteke kartak? 2
//errore bat egotekotan ez dago amaitua
//zergatik get txarto??
//kartaBotaBai KartaZerrendan egin behar da
