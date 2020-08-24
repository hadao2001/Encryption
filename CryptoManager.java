/**
 * class CryptoManager has methods to encrypt and decrypt both caesar and bellaso
 * @author hadao
 */ 

public class CryptoManager {

private static final char LOWER_BOUND = ' ';

private static final char UPPER_BOUND = '_';

private static final int RANGE = (int)UPPER_BOUND -  (int) LOWER_BOUND + 1;

/**

* This method determines if a string is within the allowable bounds of ASCII codes

* according to the LOWER_BOUND and UPPER_BOUND characters

* @param plainText a string to be encrypted, if it is within the allowable bounds

* @return true if all characters are within the allowable bounds, false if any character is outside

*/

public static boolean stringInBounds (String plainText) {

	//set value to true so you only evaluate 
boolean boundary = true;

	//for loop to keep testing if the length of word is not passed
for (int i=0; i < plainText.length(); i++) {
	//if loop checks if character from plain text is not in bounds
if (!(charInBounds(plainText.charAt(i)))) {
	//sets test to false
	boundary = false;
	}
	}
	return boundary;
	}



/**
* 
* @param charAt
* @return
*/

public static boolean charInBounds (char worddd) {
	//if statement checks if character being tested is in bounds
		if (worddd >= LOWER_BOUND && worddd <= UPPER_BOUND)
		
			return true;
		
		else
		
			return false;
		}


/**

* Encrypts a string according to the Caesar Cipher. The integer key specifies an offset

* and each character in plainText is replaced by the character \"offset\" away from it

* @param plainText an uppercase string to be encrypted.

* @param key an integer that specifies the offset of each character

* @return the encrypted string

*/

public static String encryptCaesar(String plainText, int key)

{


String encryptedText = "";

if (stringInBounds(plainText))

{

for (int i=0; i<plainText.length(); i++)

{

char alpha = plainText.charAt(i);

int encryptedCharint = ((int)alpha+key);

while (encryptedCharint > UPPER_BOUND)

{

encryptedCharint -= RANGE;

}

encryptedText += (char)encryptedCharint;

}

}

return encryptedText;

}

/**

* Encrypts a string according the Bellaso Cipher. Each character in plainText is offset

* according to the ASCII value of the corresponding character in bellasoStr, which is repeated

* to correspond to the length of plainText

* @param plainText an uppercase string to be encrypted.

* @param bellasoStr an uppercase string that specifies the offsets, character by character.

* @return the encrypted string

*/

public static String encryptBellaso(String plainText, String bellasoStr)

{

//throw new RuntimeException("method not implemented");

String encryptedText = "";

int bellasoStrLength = bellasoStr.length();

for (int i = 0; i < plainText.length(); i++)

{

char beta = plainText.charAt(i);

int encryptedCharint = ((int)beta+(int)bellasoStr.charAt(i%bellasoStrLength));

while (encryptedCharint > (int)UPPER_BOUND)

{

encryptedCharint -= RANGE;

}

encryptedText += (char)encryptedCharint;

}

return encryptedText;

}

/**

* Decrypts a string according to the Caesar Cipher. The integer key specifies an offset

* and each character in encryptedText is replaced by the character \"offset\" characters before it.

* This is the inverse of the encryptCaesar method.

* @param encryptedText an encrypted string to be decrypted.

* @param key an integer that specifies the offset of each character

* @return the plain text string

*/

public static String decryptCaesar(String encryptedText, int key)

{

//throw new RuntimeException("method not implemented");

String decryptedText = "";

for (int i =0; i < encryptedText.length(); i++)

{

char alpha = encryptedText.charAt(i);

int decryptedCharint = ((int)alpha-key);

while (decryptedCharint < LOWER_BOUND)

{

decryptedCharint += RANGE;

}

decryptedText += (char)decryptedCharint;

}

return decryptedText;

}

/**

* Decrypts a string according the Bellaso Cipher. Each character in encryptedText is replaced by

* the character corresponding to the character in bellasoStr, which is repeated

* to correspond to the length of plainText. This is the inverse of the encryptBellaso method.

* @param encryptedText an uppercase string to be encrypted.

* @param bellasoStr an uppercase string that specifies the offsets, character by character.

* @return the decrypted string

*/

public static String decryptBellaso(String encryptedText, String bellasoStr)

{

// throw new RuntimeException("method not implemented");

String decryptedText = "";

int bellasoStrLength = bellasoStr.length();

for (int index = 0; index < encryptedText.length(); index ++)

{

char beta = encryptedText.charAt(index);

int decryptedCharint = ((int)beta-(int)bellasoStr.charAt(index%bellasoStrLength));

while (decryptedCharint < (int)LOWER_BOUND)

{

decryptedCharint += RANGE;

}

decryptedText += (char)decryptedCharint;

}

return decryptedText;

}

}