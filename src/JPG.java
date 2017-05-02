import java.util.*;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
public class JPG {

	public static void main(String[] args) {
		
		for (int i = 100, t = 0; t< 1000; i++)
		{
			if (ifPrime(i))
			{
				System.out.println(i);
				t++;
			}
		}

	}

	public static boolean ifPrime (int x)
	{
		for (int i = 2; i<=x/2; i++)
		{
			if(x%i == 0) return false;
		}
		return true;
	}
	
}
