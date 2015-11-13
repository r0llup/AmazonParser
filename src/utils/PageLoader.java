/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Sh1fT
 */

public final class PageLoader {
    protected URL url;
    protected String charset;
    protected BufferedReader bufferedReader;

    /**
     * Creates new instance PageLoader
     * @param url
     * @param charset 
     */
    public PageLoader(URL url, String charset) {
        this.setUrl(url);
        this.setCharset(charset);
        this.setBufferedReader(null);
        this.loadPage();
    }

    public URL getUrl() {
        return this.url;
    }

    protected void setUrl(URL url) {
        this.url = url;
    }

    public String getCharset() {
        return this.charset;
    }

    protected void setCharset(String charset) {
        this.charset = charset;
    }

    public BufferedReader getBufferedReader() {
        return this.bufferedReader;
    }

    protected void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    /**
     * Load The Page
     */
    private void loadPage() {
        try {
            HttpURLConnection con = (HttpURLConnection) this.getUrl().openConnection();
            con.connect();
            InputStreamReader isr = new InputStreamReader(con.getInputStream(), this.getCharset());
            this.setBufferedReader(new BufferedReader(isr));
        } catch (IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Retrieve Data From The Page
     * @return String
     */
    public String retrieveData() {
        try {
            String data = "";
            String ligne;
            while ((ligne = this.getBufferedReader().readLine()) != null)
                data += ligne;
            this.getBufferedReader().close();
            return data;
        } catch (IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
        return null;
    }
}