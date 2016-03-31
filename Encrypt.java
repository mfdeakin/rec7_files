
package rec8_files;

import java.io.InputStream;
import java.io.IOException;

public class Encrypt extends InputStream {
    private InputStream text, key;
    public Encrypt(InputStream text, InputStream key) {
	this.text = text;
	this.key = key;
    }

    public int available() throws IOException {
	int textAvail = text.available();
	int keyAvail = key.available();
	if(textAvail < keyAvail) {
	    return textAvail;
	}
	else {
	    return keyAvail;
	}
    }

    public void close() throws IOException {
	text.close();
	key.close();
    }

    public boolean markSupported() {
	return text.markSupported() && key.markSupported();
    }

    public void mark(int readLimit) {
	text.mark(readLimit);
	key.mark(readLimit);
    }

    public void reset() throws IOException {
	text.reset();
	key.reset();
    }

    public int read() throws IOException {
	int textVal = text.read();
	int keyVal = key.read();
	return textVal ^ keyVal;
    }

    public long skip(long n) throws IOException{
	long tskip = text.skip(n);
	long kskip = key.skip(n);
	if(tskip != kskip) {
	    throw new IOException("Could not skip the text and key by the same amount");
	}
	return tskip;
    }
}
