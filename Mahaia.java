public class Mahaia {
	private static Mahaia NireMahaia;
	private KartaZerrenda mKarta;

	private Mahaia() {
		mKarta = new KartaZerrenda();
		mKarta.gehituKarta(Mazoa.getMazoa().kartaEman());
	}

	public static Mahaia getMahaia() {
		if (NireMahaia == null) {
			NireMahaia = new Mahaia();
		}
		return NireMahaia;
	}

	public void gehituKarta(Karta Karta) {
		mKarta.gehituKarta(Karta);
	}

	public Karta itzuliKarta() {
		Karta k = mKarta.getKarta(mKarta.kartaKop()-1);
		return k;

	}
	
	public boolean botaBai(Karta pKarta)
	{
		boolean bota = mKarta.berdina(pKarta, itzuliKarta());
		return bota;
	}
	public void imprimatuAzkena() {
		mKarta.imprimatuAzkena();
		
	}
}
