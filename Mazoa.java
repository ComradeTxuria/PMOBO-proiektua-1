
public class Mazoa {
	private KartaZerrenda mazoKartak;
	private static Mazoa nireMazoa = null;

	private Mazoa() {
		this.mazoKartak = new KartaZerrenda();
		kartaSortu();
	}

	public static Mazoa getMazoa() {
		if (nireMazoa == null) {
			nireMazoa = new Mazoa();
		}
		return nireMazoa;
	}


	public Karta kartaEman() 
	{
		if(MazoHutsa()==true)
		{
			kartakHartu();
		}
		Karta k = mazoKartak.getKarta(0);
		mazoKartak.kenduKarta(0);
		return k;
	}

	private void kartaSortu() {

		// Horia

		Karta h0 = new Normala(0, "Horia");
		mazoKartak.gehituKarta(h0);
	for (int i = 1; i < 10; i++) {
		Karta h = new Normala(i, "Horia");
		Karta h2 = new Normala(i, "Horia");
		mazoKartak.gehituKarta(h);
		mazoKartak.gehituKarta(h2);
	}

	// Urdina
		Karta u0 = new Normala(0, "Urdina");
		mazoKartak.gehituKarta(u0);
	for (int i = 1; i < 10; i++) {
		Karta u = new Normala(i, "Urdina");
		Karta u2 = new Normala(i, "Urdina");
		mazoKartak.gehituKarta(u);
		mazoKartak.gehituKarta(u2);
	}

	// Gorria
		Karta g0 = new Normala(0, "Gorria");
		mazoKartak.gehituKarta(g0);
	for (int i = 1; i < 10; i++) {
		Karta g = new Normala(i, "Gorria");
		Karta g2 = new Normala(i, "Gorria");
		mazoKartak.gehituKarta(g);
		mazoKartak.gehituKarta(g2);
	}

	// Berdea
		Karta b0 = new Normala(0, "Berdea");
		mazoKartak.gehituKarta(b0);
	for (int i = 1; i < 10; i++) {
		Karta b = new Normala(i, "Berdea");
		Karta b2 = new Normala(i, "Berdea");
		mazoKartak.gehituKarta(b);
		mazoKartak.gehituKarta(b2);
		}
		barageatu();
	}
	
	private void barageatu()
	{
		mazoKartak.barageatu();
	}
	
	private boolean MazoHutsa() 
	{
		return mazoKartak.hutsa();
	}
	
	private void kartakHartu() 
	{
		this.mazoKartak = Mahaia.getMahaia().itzuliKartak(); 
		barageatu();
	}
}
