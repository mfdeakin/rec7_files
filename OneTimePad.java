
package rec8_files;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OneTimePad {
    
  public static void main(String[] args) throws IOException {
    System.out.println("Text File to encrypt/decrypt:");
    Scanner input = new Scanner(System.in);
    String textFName = input.next().trim();
    FileInputStream text = new FileInputStream(textFName);
    System.out.println("Key File to use to encrypt/decrypt:");
    String keyFName = input.next().trim();
    FileInputStream key = new FileInputStream(keyFName);
    Encrypt encrypted = new Encrypt(text, key);
    System.out.println("Output file:");
    String outFName = input.next().trim();
    FileOutputStream out = new FileOutputStream(outFName);
    while(encrypted.available() > 0) {
    	out.write(encrypted.read());
    }
    input.close();
    encrypted.close();
  }
}
