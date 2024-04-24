package UnoProiektua;
import java.util.ArrayList;
import java.util.Iterator;

public class Jokalari {
	private String id;
	private KartaZerrenda eskua;
	
	public Jokalari(String pId)
	{
		this.id = pId;
		this.eskua = new KartaZerrenda();
	}
	
	
	public void jolastuTurnoa()
	{
		boolean jolastu = true;
		while(jolastu == true)
		{	
			if(eskua==null)
			{
				for (int i=0; i<5; i++)
				{
					Karta k = kartaHartu();
					eskua.gehituKarta(k);
				}	
			}
			if(kartaBotaBai() == true)
			{
				int botatzeko = Teklatua.getInt();
				Karta bota = eskua.get(botatzeko);
				kartaEman(bota);
				jolastu = false;
			}
			else
			{
				kartaHartu();
			}
		}
	}
	
	private Karta kartaHartu()
	{
		Karta k = Mazoa.kartaEman();
		return k;
	}
	
	private boolean kartaBotaBai()
	{
		Karta erdiko = Mahaia.kartaEman();
		boolean bota = eskua.berdina(erdiko);
		return bota;
	}
	
	private void kartaEman(Karta pKarta)
	{
		Mahaia.gehituKarta(pKarta);
	}

}

//zenbat adliz hartu daiteke kartak?
//errore bat egotekotan ez dago amaitua
//zergatik get txarto??
//kartaBotaBai KartaZerrendan egin behar da
