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
		berdina = k.komparatuKolore(gohiko);
		return berdina;
	}
	public int kartaKop() {

		return kLista.size();
	}

	public boolean hutsa() {
		return kLista.isEmpty();
	}

	public void imprimatuKartak() {
		Iterator<Karta> itr = getIterator();
		Karta k = null;
		while(itr.hasNext()) {
			k = itr.next();
			k.imprimatu();
		}
	}
	
	public void imprimatuAzkena() {
		System.out.println("Erdiko karta: "
				+ "");
		kLista.get(kLista.size()-1).imprimatu();
	}
	
	public void barageatu() {
		Collections.shuffle(kLista);
	}
}
