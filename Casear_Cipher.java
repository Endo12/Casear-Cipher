import java.util.Scanner;
public class Casear_Cipher
{
	public static void main ( String [] args ) //Soham Nagaokar
	{
		Scanner input = new Scanner( System.in ); 
		System.out.print( "Please enter message: ");
		String message = input.nextLine();
		System.out.println( "Please indicate the type of coding you would like to do." );
		System.out.println( "Type 1 to decode message.");
		System.out.println( "Type 2 to encode message.");
		Scanner input2 = new Scanner( System.in ); 
		int typeofConversion = input2.nextInt();
		Scanner input3 = new Scanner( System.in );
		System.out.println("Please enter number of rotations: ");
		int rotations = input3.nextInt();
		String messageA = message.toLowerCase(); //a new string with all lowercase characers is created to avoid future errors
		switch ( typeofConversion ) //the switch uses the type of conversion as it's test statement
		{
			case 1: 
			System.out.println( "The message decoded is: " + decode( messageA,rotations ) ); //decoded message is computed and printed
			break;
			case 2: 
			System.out.println( "The message encoded is: " + encode( messageA,rotations ) ); //encoded message is computed and printed
			break;
		}
	}
	public static String decode ( String messageA, int rot )
	{
		char [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		/* this character array simply gives every letter of the alphabet a numeric equivalent, making it possible to reference them numerically */
		StringBuffer editMessage = new StringBuffer( messageA ); //a string buffer identical to the string is created so that setCharAt can later be used
		int loop; 
		for( loop = 0; loop < messageA.length(); loop++ ) //loops through characters of message
		{
			int letter;
			for ( letter = 0; letter < 26; letter++ ) //this loop finds the letter of the alphabet that the character is and decodes it
			{
				if ( editMessage.charAt( loop ) == alphabet[letter] ) //checks to see when the character matches a letter
				{
					int index = letter + rot;
					if(index>25) //covers case where index goes out of accepted bounds
						index -= 26;
					editMessage.setCharAt( loop, alphabet[ index ] );
					break; //when the letter is translated, the nested loop stops and control is transferred back to the first for loop
				}
			}
		}
		String firstLetter = editMessage.substring(0,1); 
		String finalMessage = firstLetter.toUpperCase() + editMessage.substring(1); //the final message is created by combining the first letter capitalized with the rest of the decoded message
		return finalMessage; 
	}
	public static String encode ( String messageA, int rot )
	{
		char [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		/* this character array simply gives every letter of the alphabet a numeric equivalent, making it possible to reference them numerically */
		StringBuffer editMessage = new StringBuffer( messageA ); //a string buffer identical to the string is created so that setCharAt can later be used
		int loop; 
		for( loop = 0; loop < messageA.length(); loop++ ) //loops throughout characters of message
		{
			int letter;
			for ( letter = 0; letter < 26; letter++ ) //this loop finds the letter of the alphabet that the character is and encodes it
			{
				if ( editMessage.charAt( loop ) == alphabet[letter] ) //checks to see when the character matches a letter
				{
					int index = letter - rot;
					if(index<0) //covers case where index goes out of accepted bounds
						index += 26;
					editMessage.setCharAt( loop, alphabet[ index ] );
					break; //when the letter is untranslated, the nested loop stops and control is transferred back to the first for loop
				}
			}
		}
		String firstLetter = editMessage.substring(0,1); 
		String finalMessage = firstLetter.toUpperCase() + editMessage.substring(1); //the final message is created by combining the first letter capitalized with the rest of the encoded message
		return finalMessage;
	}
}