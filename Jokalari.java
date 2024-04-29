package UnoProiektua;


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
			Karta k = Mazoa.getMazoa().kartaEman();
			eskua.gehituKarta(k);
		}	
	}
	
	public void imprimatu() {
		System.out.println("ID: " +id);
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
				kartaEman(botatzeko);
				jolastu = false;
			}
			else
			{
				kartaHartu();
				if(kartaBotaBai() == true)
				{
					int botatzeko = botaKarta();
					kartaEman(botatzeko);
					jolastu = false;
				}
			}
			x++;
		}		
	}
	
	private void kartaHartu()
	{
		String hartu = Teklatua.getTeklatua().getString("Karta bat hartu enter sakatuz");
		boolean ondo = false;
		while (ondo == false) try
		{
			if (!hartu.equals(""))
			{
				throw (new Okerra());
			}
			else
			{
				ondo = true;
			}
		}
		catch(Okerra e)
		{
			hartu = Teklatua.getTeklatua().getString("Karta bat hartu ENTER sakatuz");
		}
		catch(InputMismatchException e)
		{
			hartu = Teklatua.getTeklatua().getString("Karta bat hartu ENTER sakatuz");
		}
		Karta k = Mazoa.getMazoa().kartaEman();
		eskua.gehituKarta(k);
	}
	
	private boolean kartaBotaBai()
	{
		Karta gohiko = Mahaia.getMahaia().itzuliKarta();
		boolean bota = eskua.botaKartak(gohiko);
		return bota;
	}
	
	private int botaKarta()
	{
		int botatzeko = Teklatua.getTeklatua().getInt("Ipini bota nahi duzun karta")-1;
		boolean ondo = false;
		while(ondo == false) try
		{
			if(botatzeko<0 || botatzeko>eskua.kartaKop()-1)
			{
				throw (new ZenbakiLimite());
			}
			else if(botaDaiteke(botatzeko) == false)
			{
				throw (new KartaOkerra());
			}
			else
			{
				ondo = true;
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
			botatzeko = Teklatua.getTeklatua().getInt("Bota nahi duzun karta, ZENBAKI baten bidez adierazi behar duzu");
		}
		return botatzeko;
	}
	
	
	private boolean botaDaiteke(int pPos)
	{
		boolean bota = false;
		Karta k = eskua.getKarta(pPos);
		bota = Mahaia.getMahaia().botaBai(k);
		return bota;
	}
	
	private void kartaEman(int pKarta)
	{
		Karta bota = eskua.getKarta(pKarta);
		Mahaia.getMahaia().gehituKarta(bota);
		eskua.kenduKarta(pKarta);
	}
	
	public boolean jokoaAmaitua() 
	{
		return eskua.hutsa();
	}
	
}
