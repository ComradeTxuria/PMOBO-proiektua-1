
public class Printeatzea {
	private static Printeatzea nirePrinteatzea= null;

	private Printeatzea() {
		
	}
	
	public static Printeatzea getNirePrinteatzea() {
		if(nirePrinteatzea == null) {
			nirePrinteatzea = new Printeatzea();
		}
		return nirePrinteatzea;
	}

	public void printMenua() {
		System.out.println(" _     _      ____       _  ____  _  __ ____  ____ \r\n"
				+ "/ \\ /\\/ \\  /|/  _ \\     / |/  _ \\/ |/ //  _ \\/  _ \\\r\n"
				+ "| | ||| |\\ ||| / \\|     | || / \\||   / | / \\|| / \\|\r\n"
				+ "| \\_/|| | \\||| \\_/|  /\\_| || \\_/||   \\ | \\_/|| |-||\r\n"
				+ "\\____/\\_/  \\|\\____/  \\____/\\____/\\_|\\_\\\\____/\\_/ \\|");
		
		//System.out.println("Jokalari kopurua: "+JokalariLista.getJokalariLista().setJokalariKop());
		JokalariLista.getJokalariLista().imprimatu();
		
	}
	
	public void printKarta(Jokalari pJokalari) {
		System.out.println(" ");
		System.out.println("Hasi partida:");
		System.out.println(" ");
		Printeatzea.getNirePrinteatzea().printBesteJokalari();
		System.out.println(" ");
		JokalariLista.getJokalariLista().imprimatuKartak(pJokalari);
		System.out.println(" ");
		Printeatzea.getNirePrinteatzea().printMahaia();
		System.out.println(" ");
		
	}		
	
	public void printMahaia() {
		Mahaia.getMahaia().imprimatuAzkena();
	}
	
	public void printTestua(String pMezua) {
		System.out.println(pMezua);
	}
	
	private void printBesteJokalari() {
		System.out.println("-- Jokalarien Karta Kopurua --");
		JokalariLista.getJokalariLista().imprimatuKartaKop();
	}

	public void printAmaitu(Jokalari pJokalari) {
		System.out.println(pJokalari.getId()+" Zorionak irabazi egin duzu!!");
	}
	
