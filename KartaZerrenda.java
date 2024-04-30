import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class KartaZerrenda {
	private ArrayList<Karta> kLista;

	public KartaZerrenda() {
		this.kLista = new ArrayList<>();
	}

	public Iterator<Karta> getIterator() {
		return this.kLista.iterator();
	}

	public Karta getKarta(int pBota) {
		return kLista.get(pBota);
	}

	public void kenduKarta(int pKarta) {
		kLista.remove(pKarta);
	}

	public void gehituKarta(Karta pKarta) {
		kLista.add(pKarta);
	}

	public boolean botaKartak(Karta gohiko) {
		Iterator<Karta> itr = getIterator();
		Karta k = null;
		boolean aurkitu = false;
		while(itr.hasNext() && aurkitu == false)
		{
			k = itr.next();
			aurkitu = berdina(k,gohiko);
		}
		return aurkitu;
	}
	
	public boolean berdina(Karta k, Karta gohiko)
	{
		boolean berdina = false;
		if(k instanceof Normala) //instanceof bere buruarekin???
		{
			berdina = k.komparatuZenb(gohiko);
		}
		else if(k.getKolore() == null)
		{
			berdina = true;
		}
		if(berdina == false)
		{
			berdina = k.komparatuKolore(gohiko);
		}
		return berdina;
	}
	
	public int kartaKop() {

		return kLista.size();
	}

	public boolean hutsa() {
		return kLista.isEmpty();
	}

	public void imprimatuKartak() {
		int i = 0;
		Iterator<Karta> itr = getIterator();
		Karta k = null;
		while(itr.hasNext()) {
			k = itr.next();
			i++;
			k.imprimatu(i);
		}
	}
	
	public void imprimatuAzkena(String pMezu) {
		System.out.println(pMezu + "");
		kLista.get(kLista.size()-1).imprimatu(-1);
	}
	
	public void barageatu() {
		Collections.shuffle(kLista);
	}
}
