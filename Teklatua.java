import java.util.Scanner;

import java.util.Scanner;

public class Teklatua {
	
	private Scanner sc;
	private static Teklatua nireTeklatua = null;
	
	private Teklatua() 
	{
		sc = new Scanner(System.in);
	}
	
	public static Teklatua getTeklatua() {
		
		if (nireTeklatua == null) {
			nireTeklatua = new Teklatua();
		}
		return nireTeklatua;
	}
	
	public String getString(String pMezua) 
	{
		Printeatzea.getNirePrinteatzea().printTestua(pMezua);
		String mezua = sc.nextLine();
		return mezua;
	}
	
	public int getInt(String pMezua) 
	{
		Printeatzea.getNirePrinteatzea().printTestua(pMezua);
		int zenb = sc.nextInt();
		sc.nextLine();
		return zenb;
	}
}

