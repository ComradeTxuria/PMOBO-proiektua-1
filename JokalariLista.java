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
	private Iterator<Jokalari> getIterator()
	{
		return this.jLista.iterator();
	}
	//while batekin egin
	/*public void jolastuPartida()
	{
		Iterator<Jokalari> itr = this.getIterator();
		Jokalari jokalaria = null;
		while (itr.hasNext())
		{
			jokalaria = itr.next();
			jokalaria.jolastuTurnoa();
		}
		if (itr.hasNext()==false)
		{
			
		}
	}*/
}

