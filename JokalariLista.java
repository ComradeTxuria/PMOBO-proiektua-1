package UnoProiektua;
import java.util.ArrayList;
import java.util.*;
//import java.util.Iterator;

public class JokalariLista {
	//atributuak
	private ArrayList<Jokalari> jLista;
	private static JokalariLista nireJokalariLista = null;
	private int maxJok = getJokalariKop();
	
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
	
	public void imprimatuKartak() {
		Iterator<Jokalari> itr = getIterator();
		Jokalari j = null;
		while(itr.hasNext()) {
			j = itr.next();
			j.imprimatuKartak();
		}
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
	
	
	//iterator
	/*private Iterator<Jokalari> getIterator()
	{
		return this.jLista.iterator();
	}*/
	
	//partida
	public void jolastuPartida()
	{
		boolean jokoaAmaitu = false;
		int i=0;
		while (jokoaAmaitu==false)
		{
			Jokalari jokalaria = jLista.get(i);
			jokalaria.jolastuTurnoa();
			i++;
			if (i==maxJok)
			{
				i=0;
			}
			if(Mazoa.getMazoa().jokoaAmaitua() || jokalaria.jokoaAmaitua()) //PORQUE DA ERROR
			{
				jokoaAmaitu = true;
			}
		}	
	}
	
	//Hacer con itr
	
	//TODO karta gehiago gehitzean, jokalari limitea handitu
	public  int getJokalariKop()
	{
		boolean ondo = false;
		int jokKop = Teklatua.getTeklatua().getInt("Ipini zenbat jokalari nahi dituzun, 2tik 4ra.");
		
		
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

// jokoa nola amaitu??? atributo batekin egin??? funtzio batekin whilean???
// iterator ez da erabili behar izan oraingoz
// izena eta jokalari kopurua jokalaria editatu ahal izango ditu baina oraingoz ez  
//try / catch erabili behar da 0 jokalari jarri ahal ez izateko eta 4 maximoa izateko
