
package rec8_files;

import java.util.Scanner;
import java.io.FileInputStream;

public class OneTimePad {
    
    public static void main(String[] args) {
	System.out.println("Text File to encrypt/decrypt:");
	Scanner input = new Scanner(System.in);
	String textFName = input.next().trim();
	FileInputStream text = new FileInputStream(textFName);
	System.out.println("Key File to use to encrypt/decrypt:");
	String keyFName = input.next().trim();
	FileInputStream key = new FileInputStream(keyFName);
	Encrypt encrypted = new Encrypt(text, key);
    }
}
