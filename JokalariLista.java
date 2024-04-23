package UnoProiektua;
import java.util.ArrayList;
import java.util.Iterator;

public class JokalariLista {
	//atributuak
	private ArrayList<Jokalari> jLista;
	private static JokalariLista nireJokalariLista = null;
	
	//eraikitzailea eta singleton patroia
	private JokalariLista()
	{
		this.jLista = new ArrayList<Jokalari>();
	}
	public static JokalariLista getJokalariLista() 
	{
		if(nireJokalariLista==null)
		{
			nireJokalariLista = new JokalariLista();
		}
		return nireJokalariLista;
	}
	
	//iterator
	/*private Iterator<Jokalari> getIterator()
	{
		return this.jLista.iterator();
	}*/
	
	//partida
	public void jolastuPartida()
	{
		boolean JokoaAmaitu = false;
		int i=0;
		Jokalari jokalaria = null;
		int maxJok = getJokalariKop();
		while (i<maxJok && JokoaAmaitu==false)
		{
			jokalaria.jolastuTurnoa();
			if (i==maxJok)
			{
				i=0;
			}
		}	
	}
	
	private int getJokalariKop()
	{
		return Teklatua.getInt();   //try / catch erabili behar da 0 jokalari jarri ahal ez izateko eta 4 maximoa izateko
	}
}
