/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package types;

/**
 *
 * @author Sh1fT
 */

public class Music extends Media {
    public String artists;
    public String label;
    public String discs;
    public String releaseDate;

    public Music(String title, String asin, String price, String devise,
        String image, String artists, String label, String discs, String releaseDate) {
        super(title, asin, price, devise, image);
        this.artists = artists;
        this.label = label;
        this.discs = discs;
        this.releaseDate = releaseDate;
    }

    public Music() {
        super();
        this.artists = null;
        this.label = null;
        this.discs = null;
        this.releaseDate = null;
    }

    public String getArtists() {
        return this.artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDiscs() {
        return this.discs;
    }

    public void setDiscs(String discs) {
        this.discs = discs;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return new StringBuilder("\n. ..:: Music ::.. .")
            .append("\nTitle...............: ").append(this.getTitle())
            .append("\nAsin................: ").append(this.getAsin())
            .append("\nPrice...............: ").append(this.getPrice())
            .append("\nDevise..............: ").append(this.getDevise())
            .append("\nImage...............:\n").append(this.getImage())
            .append("\nArtists.............: ").append(this.getArtists())
            .append("\nLabel...............: ").append(this.getLabel())
            .append("\nDiscs...............: ").append(this.getDiscs())
            .append("\nRelease date........: ").append(this.getReleaseDate()).toString();
    }
}