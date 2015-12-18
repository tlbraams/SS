package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	public DictionaryAttack() {
		passwordMap = new HashMap<String, String>();
		hashDictionary = new HashMap<String, String>();
	}
	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		boolean doorgaan = true;
		while (doorgaan) {
			String line = null;
			try {
				line = in.readLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			if (line == null) {
				doorgaan = false;
			} else {
				String[] splitLine = line.split(": ");
				passwordMap.put(splitLine[0], splitLine[1]);
			}
		}
		
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
    	byte[] hash = null;
    	try {
			MessageDigest encode = MessageDigest.getInstance("MD5");
			hash = encode.digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
    	return Hex.encodeHexString(hash);
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        boolean result = false;
        if (passwordMap.containsKey(user)) {
        	result = passwordMap.get(user).equals(getPasswordHash(password));
        }
		return result;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    public void addToHashDictionary(String filename) {
    	Boolean doorgaan = true;
    	BufferedReader in = null;
        try {
			in = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
        String line = null;
        while (doorgaan) {
        	try {
        		line = in.readLine();
    		} catch (IOException e) {
    			System.out.println(e.getMessage());
    		}
        	if (line == null) {
        		doorgaan = false;
        	} else {
        		String hash = getPasswordHash(line);
        		hashDictionary.put(hash, line);
        	}
        }
    }
    
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		int foundCount = 0;
		for	(String user: passwordMap.keySet()) {
			if (hashDictionary.containsKey(passwordMap.get(user)))	{
				System.out.println(user + ": " + hashDictionary.get(passwordMap.get(user)));
				foundCount++;
			}
		}
		System.out.println("Found passwords: " + foundCount);
	}
	
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		da.addToHashDictionary("commonPasswords.txt");
		da.addToHashDictionary("words.txt");
		da.readPasswords("src\\ss\\week6\\test\\LeakedPasswords.txt");
		da.doDictionaryAttack();
	}

}
