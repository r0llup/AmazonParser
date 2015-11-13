/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package types;

/**
 *
 * @author Sh1fT
 */

public class Book extends Media {
    public String authors;
    public String publisher;
    public String format;
    public String pages;
    public String releaseDate;

    public Book(String title, String asin, String price, String devise,
        String image, String authors, String publisher, String format,
        String pages, String releaseDate) {
        super(title, asin, price, devise, image);
        this.authors = authors;
        this.publisher = publisher;
        this.format = format;
        this.pages = pages;
        this.releaseDate = releaseDate;
    }

    public Book() {
        super();
        this.authors = null;
        this.publisher = null;
        this.format = null;
        this.pages = null;
        this.releaseDate = null;
    }

    public String getAuthors() {
        return this.authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPages() {
        return this.pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return new StringBuilder("\n. ..:: Book ::.. .")
            .append("\nTitle...............: ").append(this.getTitle())
            .append("\nAsin................: ").append(this.getAsin())
            .append("\nPrice...............: ").append(this.getPrice())
            .append("\nDevise..............: ").append(this.getDevise())
            .append("\nImage...............:\n").append(this.getImage())
            .append("\nAuthors.............: ").append(this.getAuthors())
            .append("\nPublisher...........: ").append(this.getPublisher())
            .append("\nFormat..............: ").append(this.getFormat())
            .append("\nPages...............: ").append(this.getPages())
            .append("\nRelease date........: ").append(this.getReleaseDate()).toString();
    }
}