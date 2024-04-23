package UnoProiektua;
import java.util.ArrayList;
import java.util.Iterator;

public class JokalariLista {
	//atributuak
	private ArrayList<Jokalari> jLista;
	private static JokalariLista nireJokalariLista = null;
	private static int maxJok = getJokalariKop();
	
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
			Jokalari jokalaria = new Jokalari("izena");
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
		boolean JokoaAmaitu = false;
		int i=0;
		Jokalari jokalaria = null;
		while (i<maxJok && JokoaAmaitu==false)
		{
			jokalaria.jolastuTurnoa();
			if (i==maxJok)
			{
				i=0;
			}
		}	
	}
	
	private static int getJokalariKop()
	{
		return 4; //Teklatua.getInt();
	}
}

// jokoa nola amaitu??? atributo batekin egin??? funtzio batekin whilean???
// iterator ez da erabili behar izan oraingoz
// izena eta jokalari kopurua jokalaria editatu ahal izango ditu baina oraingoz ez  
//try / catch erabili behar da 0 jokalari jarri ahal ez izateko eta 4 maximoa izateko

