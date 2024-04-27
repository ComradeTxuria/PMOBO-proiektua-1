
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
	}
	
	public void printKarta(Jokalari pJokalari) {
		JokalariLista.getJokalariLista().imprimatuKartak(pJokalari);
		printMahaia();
	}		
	
	public void printMahaia() {
		Mahaia.getMahaia().imprimatuAzkena();
	}
	
	public void printTestua(String pMezua) {
		System.out.println(pMezua);
	}
	
}
