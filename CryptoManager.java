public class CryptoManager {
	
	private static int LOWER_BOUND = 32;
	private static int UPPER_BOUND = 95;
	private static int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds(String plainText) {
		//flag variable
		boolean flag = true;
		//for loop which goes through each character to determine if it is greater
		//than the highest bound or less than the lowest bound. If so then the character
		//cannot be encrypted
		for(int i = 0; i < plainText.length(); i++) {
			if(!((int)plainText.charAt(i) >= LOWER_BOUND) 
				|| (int)plainText.charAt(i) <= 95){
					flag = false;
				}
		}
		return flag;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//Wrap around the key if it is greater than the upper bound
		key = Wrap_around(key);
		
		//Encrypted text
		String res = " ";
		for(int i = 0; i < plainText.length(); i++) {
			res+= Character.toString((int)plainText.charAt(i)+key);
		}
		return res;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//encrypted string
		String res = "";
		
		//adjust the length of the Bellaso to the plainText
		while(bellasoStr.length() < plainText.length()) {
			bellasoStr += bellasoStr.substring(0, (plainText.length()-bellasoStr.length()));
		}
		//encryption
		for(int i = 0; i < plainText.length(); i++) {
			char c=(char)Wrap_around((int)plainText.charAt(i)+(int)bellasoStr.charAt(i) );
			res+=Character.toString(c);
		}
		return res;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//Wrap around the key if it is greater than the upper bound
		key = Wrap_around(key);
				
		//Encrypted text
		String res = " ";
		for(int i = 0; i < encryptedText.length(); i++) {
			res+= Character.toString((int)encryptedText.charAt(i)-key);
			}
		return res;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//decrypted text
		String res = " ";
		
		//Adjust length of bellasoStr to plainText
		while (bellasoStr.length() < encryptedText.length()) {
			bellasoStr+= bellasoStr.substring(0,(encryptedText.length()-bellasoStr.length()));
		}
		
		//decryption
		for (int i = 0; i < encryptedText.length(); i++) {
			char c = (char) Wrap_around((int)encryptedText.charAt(i)-(int)bellasoStr.charAt(i));
			res+=Character.toString(c);
		}
		  
		return res;
	}
	
	public static int Wrap_around(int key) {
		while(key>UPPER_BOUND) {
			key-=(UPPER_BOUND-LOWER_BOUND);
		}
		return key;
	}
}


 

