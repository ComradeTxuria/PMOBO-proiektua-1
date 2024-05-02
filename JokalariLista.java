
import java.util.ArrayList;
import java.util.*;

public class JokalariLista {
	//atributuak
	private ArrayList<Jokalari> jLista;
	private static JokalariLista nireJokalariLista = null;
	private int maxJok;
	
	//eraikitzailea eta singleton patroia
	private JokalariLista()
	{
		this.jLista = new ArrayList<Jokalari>();
		this.maxJok =  setJokalariKop();
		gehituJok();
	}
	
	public static JokalariLista getJokalariLista() 
	{
		if(nireJokalariLista==null)
		{
			nireJokalariLista = new JokalariLista();
		}
		return nireJokalariLista;
	}
	
	
	private void gehituJok()
	{
		int i = 0;
		while(i<maxJok)
		{
			String izena;
			try
			{
			izena = Teklatua.getTeklatua().getString("Idatzi jokalariaren izena.");
			}
			catch (Exception e)
			{
				izena = Teklatua.getTeklatua().getString("Idatzi ZUZENA den izen bat.");
			}
			Jokalari jokalaria = new Jokalari(izena);
			jLista.add(jokalaria);
			i++;
		}
	}
	
	
	private Iterator<Jokalari> getIterator()
	{
		return this.jLista.iterator();
	}
	
	public void imprimatu() 
	{
		System.out.println("Jokalari lista");
		Iterator<Jokalari> itr = getIterator();
		Jokalari j = null;
		while(itr.hasNext()) {
			j = itr.next();
			j.imprimatu();
		}
	}
	
	public void imprimatuKartak(Jokalari pJokalari) 
	{
		Jokalari j = pJokalari;
		j.imprimatuKartak();
	}
	
	public void imprimatuKartaKop() 
	{
		Iterator<Jokalari> itr = getIterator();
		Jokalari j = null;
		while(itr.hasNext()) {
			j = itr.next();
			j.imprimatuKartaKop();
		}
	}
	
	//partida
	public void jolastuPartida()
	{
		boolean jokoaAmaitu = false;
		int i=0;
		while (jokoaAmaitu==false)
		{
			Jokalari jokalaria = jLista.get(i);
			Printeatzea.getNirePrinteatzea().printKarta(jokalaria);
			jokalaria.jolastuTurnoa();
			i++;
			if (i==maxJok)
			{
				i=0;
			}
			if(jokalaria.jokoaAmaitua())
			{
				Printeatzea.getNirePrinteatzea().printAmaitu(jokalaria);
				jokoaAmaitu = true;
			}
		}	
	}
	
	//TODO karta gehiago gehitzean, jokalari limitea handitu
	private int setJokalariKop()
	{
		boolean ondo = false;
		int jokKop = Teklatua.getTeklatua().getInt("Ipini zenbat jokalari nahi dituzun, 2tik 4ra.");
		
		while(ondo==false) try
			{
				if(jokKop>4 || jokKop<2 )
				{
					throw (new ZenbakiLimite());
				}
				else
				{
					ondo = true;
				}
			}
			catch(ZenbakiLimite e)
			{
				jokKop = Teklatua.getTeklatua().getInt("Ipini zenbat jokalari nahi dituzun, 2tik 4ra MESEDEZ.");
			}
			catch(Exception e) 
			{
				jokKop = Teklatua.getTeklatua().getInt("Ipini ZENBAKIZ zenbat jokalari nahi dituzun, 2tik 4ra.");
			}
		return jokKop;
	}
}

