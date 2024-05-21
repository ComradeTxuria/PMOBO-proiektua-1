
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JokalariTest {

	Jokalari j = new Jokalari("Paco");
	
	@Test
	void testBotaKartaTest() {
		assertEquals(j.botaKartaTest(5), 5);
		assertEquals(j.botaKartaTest(10), -69);
		assertEquals(j.botaKartaTest(-1), -69);
	}

	@Test
	void testKartaHartuTest() 
	{
		assertNull(j.kartaHartuTest("Nope"));
		assertEquals(j.kartaHartuTest(""),"");
	}

}
