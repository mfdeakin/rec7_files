
package rec7_files;

import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class OneTimePad {
    
  public static void main(String[] args) throws IOException {
    System.out.println("Text File to encrypt/decrypt:");
    Scanner input = new Scanner(System.in);
    String textFName = input.next().trim();
    InputStream text = new BufferedInputStream(new FileInputStream(textFName));
    System.out.println("Key File to use to encrypt/decrypt:");
    String keyFName = input.next().trim();
    InputStream key = new BufferedInputStream(new FileInputStream(keyFName));
    InputStream encrypted = new Encrypt(text, key);
    System.out.println("Output file:");
    String outFName = input.next().trim();
    OutputStream out = new BufferedOutputStream(new FileOutputStream(outFName));
    while(encrypted.available() > 0) {
    	out.write(encrypted.read());
    }
    input.close();
    encrypted.close();
    out.close();
  }
}
