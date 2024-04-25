package UNOJava;

public class ZenbakiLimite extends Exception
{
	private int min;
	private int max;
	
	public ZenbakiLimite(int pMin, int pMax)
	{
		super();
		this.min = pMin;
		this.max = pMax;
	}
}
