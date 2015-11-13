/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Sh1fT
 */

public final class FileLoader {
    protected URL url;
    protected byte[] file;

    /**
     * Creates new instance FileLoader
     * @param url 
     */
    public FileLoader(URL url) {
        this.setUrl(url);
        this.setFile(new byte[1024]);
        this.loadFile();
    }

    public URL getUrl() {
        return this.url;
    }

    protected void setUrl(URL url) {
        this.url = url;
    }

    public byte[] getFile() {
        return this.file;
    }

    protected void setFile(byte[] file) {
        this.file = file;
    }

    /**
     * Load The File
     */
    private void loadFile() {
        try {
            HttpURLConnection con = (HttpURLConnection) this.getUrl().openConnection();
            con.connect();
            con.getInputStream().read(this.getFile());
        } catch (IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }
}