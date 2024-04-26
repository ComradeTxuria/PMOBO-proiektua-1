package UnoProiektua;
import java.util.ArrayList;
import java.util.*;
//import java.util.Iterator;

public class JokalariLista {
	//atributuak
	private ArrayList<Jokalari> jLista;
	private static JokalariLista nireJokalariLista = null;
	private int maxJok = setJokalariKop();
	
	//eraikitzailea eta singleton patroia
	private JokalariLista()
	{
		this.jLista = new ArrayList<Jokalari>();
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
			catch (InputMismatchException e)
			{
				izena = Teklatua.getTeklatua().getString("Idatzi ZUZENA den izen bat.");
			}
			Jokalari jokalaria = new Jokalari(izena);
			jLista.add(jokalaria);
		}
	}
	
	
	private Iterator<Jokalari> getIterator(){
		return this.jLista.iterator();
	}
	
	public void imprimatu() {
		System.out.println("Jokalari lista");
		Iterator<Jokalari> itr = getIterator();
		Jokalari j = null;
		while(itr.hasNext()) {
			j = itr.next();
			j.imprimatu();
		}
	}
	
	public void imprimatuKartak(Jokalari pJokalari) {
		/*Iterator<Jokalari> itr = getIterator();
		Jokalari j = null;
		while(itr.hasNext()) {
			j = itr.next();
			j.imprimatuKartak();   //Iterando
		}*/
		Jokalari j = pJokalari;
		j.imprimatuKartak();
	
	
	//partida
	public void jolastuPartida()
	{
		boolean jokoaAmaitu;
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
			if(Mazoa.getMazoa().jokoaAmaitua() || jokalaria.jokoaAmaitua())
			{
				jokoaAmaitu = true;
			}
		}	
	}
	
	//TODO karta gehiago gehitzean, jokalari limitea handitu
public int setJokalariKop()
	{
		boolean ondo = false;
		int jokKop = Teklatua.getNireTeklatua().getInt("Ipini zenbat jokalari nahi dituzun, 2tik 4ra.");
		
		 while(ondo==false) try
			{
				if(jokKop<4 || jokKop>2 )
				{
					ondo = true;
				}
				else
				{
					throw (new ZenbakiLimite());
				}
			}
			catch(ZenbakiLimite e)
			{
				jokKop = Teklatua.getTeklatua().getInt("Ipini zenbat jokalari nahi dituzun, 2tik 4ra MESEDEZ.");
			}
			catch(InputMismatchException e)
			{
				jokKop = Teklatua.getTeklatua().getInt("Ipini ZENBAKIZ zenbat jokalari nahi dituzun, 2tik 4ra.");
			}
		return jokKop;
	}
}

