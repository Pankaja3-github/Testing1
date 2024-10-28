package Generic_Utilities;

import java.util.Random;

// This method is used to avoid duplicates

public class Program003_Java_Utility {
	public int getRandomNum()
	{
		Random ran = new Random(); 
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

}
