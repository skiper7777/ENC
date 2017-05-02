import java.util.*;

public class ENCRYPTS {

	private static char [] [] Table ;
	private static char [] charKeyWord ;
	private static char [] CharAlfaBeta ;
	private static char [] charStatement ;
	private static char [] charEncrypted ;
	private static char [] charDencrypted ;
	private static char [] charKeywordLoop ;
	private static String AlfaBeta ;
	private static String statement ;
	private static String Dencrypted ;
	private static String Encrypted ;
	private static String keyword ;
	private static ENCRYPTS INSTANCE;
	private ENCRYPTS()
	{
		
		setAlfaBeta("a»bcdsÐtuvഅഈഋ®എഃ©കഗ¨ഘЭЮЯקSרTשUתVץ56ബ¦ഭമയ]രറവളഴêefghijkælm¾³ശ¡ഷwxyzאAבBגCדWףYןZם1ז±GחHטIÆיJכ78¢ങסOעPפQצR2nop§qךr3¤4|DהEוFБГДЖЗИЙ[£ЛПФЦЧ¥¿ШЩЫ90+=_-(*:<>/,}{ഛജദനപKלLמMנN;%.&)^$#@!?'~` ");
		makeTable();
		setKeyWord("");
		setStatement("111 111 111 111 111 111 111 111 111 111 111 111 111 111 111 111");
		
	}

	public static void makeTable ()
	{
		
	    Table = new char [AlfaBeta.length()] [AlfaBeta.length()];
		
		for(int j = 0; j < AlfaBeta.length(); j++)
			Table [0][j] = CharAlfaBeta[j];
		
		for (int i = 1; i<AlfaBeta.length(); i++)
		{
			char temp = CharAlfaBeta[0];
			for (int j = 0;j<AlfaBeta.length() - 1; j++)
				CharAlfaBeta [j] = CharAlfaBeta [j+1];
			CharAlfaBeta[AlfaBeta.length()-1] = temp;
			for(int j = 0; j<AlfaBeta.length(); j++)
				Table [i][j] = CharAlfaBeta[j];
		}
		
		for (int i = 0; i<AlfaBeta.length(); i++)
		{
			CharAlfaBeta[i] = AlfaBeta.charAt(i);
		}
		for (int i = 0; i< AlfaBeta.length(); i++)
		{
			for (int j = 0; j< AlfaBeta.length(); j++)
				System.out.print(Table[i][j]);
			System.out.println();
		}
	}
 	public static String getKeyWord ()
	{
		return keyword;
	}
	public static String getAlfaBeta ()
	{
		return AlfaBeta;
	}
	public static String getStatment ()
	{
		return statement;
	}
	public static ENCRYPTS getINSTANCE()
	{
		if(INSTANCE == null)
			INSTANCE = new ENCRYPTS();
		return INSTANCE;
	}
	public static void setKeyWord (String k)
	{
		if(k == ""||k==null) k = "arie2016@hotmail.com";
		keyword = k;
		charKeyWord = new char [k.length()];
		for(int i = 0; i< keyword.length();i++)
		{
			charKeyWord[i] = keyword.charAt(i);
		}
	}
	private static void setCharKeyWordLoop ()
	{
		charKeywordLoop = new char [statement.length()];
		for (int i = 0; i < statement.length(); i++)
		{
			charKeywordLoop[i] = Table[(i+13*i+17) % AlfaBeta.length()] [IndexOf(CharAlfaBeta, charKeyWord[i % keyword.length()])];
		}
	}
	public static void setStatement (String s)
	{
		if(s == ""|| s== null) s = "דג סקרן שט לו בים זך ולפתע מצא חבורה נחמדה";
		statement = s;
		charStatement = new char [s.length()];
		for(int i = 0; i< statement.length();i++)
			charStatement[i] = statement.charAt(i);
		setCharKeyWordLoop();
	}
	public static void setAlfaBeta (String AB)
	{
		if(AB == "" || AB == null)
			{
				AB = "abcdefghijklmnopqrstuvwxyzאAבBגCדDהEוFזGחHטIיJכKלLמMנNסOעPפQצRקSרTשUתVץWףZךYןZם1234567890+=_-(*%&)^$#@!~` ";
			}
		CharAlfaBeta = new char [AB.length()];
		for (int i = 0; i<AB.length(); i++)
		{
			CharAlfaBeta[i] = AB.charAt(i);
		}
		AlfaBeta = AB;
	}

	public static void main(String[] args)
	{
		getINSTANCE();
		System.out.println(encryp());
		System.out.println(decryp());
		String s = new String(charKeywordLoop);
		System.out.println(s);
	}

	public static String decryp ()
	{
		charDencrypted = new char [Encrypted.length()];
		charEncrypted = new char[Encrypted.length()];
		for (int i = 0; i < Encrypted.length(); i++)
		{
			charEncrypted[i] = Encrypted.charAt(i);
		}
		for(int i = 0; i < Encrypted.length(); i++)
		{
			charDencrypted[i] = CharAlfaBeta[IndexOf(Table[IndexOf(CharAlfaBeta,charKeywordLoop[i])], charEncrypted[i])];
		}
		Dencrypted = new String (charDencrypted);
		return Dencrypted;
	}
	
	public static String encryp ()
	{
		charEncrypted = new char [statement.length()];
		for(int i = 0; i< statement.length();i++)
		{
			charStatement[i] = statement.charAt(i);
		}
		for(int i = 0; i< statement.length(); i++)
		{
			charEncrypted[i] = Table[IndexOf(CharAlfaBeta,charKeywordLoop[i])][IndexOf(CharAlfaBeta, charStatement[i])];
		}
		Encrypted =  new String (charEncrypted);
		return Encrypted;
	}
	
	public static int IndexOf (char [] arr, char c)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == c) return i;
		}
		return -1;		
	}

}
