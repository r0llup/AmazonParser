/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package types;

/**
 *
 * @author Sh1fT
 */

public class Movie extends Media {
    public String actors;
    public String directors;
    public String studio;
    public String format;
    public String discs;
    public String languages;
    public String subtitles;
    public String runtime;
    public String releaseDate;

    public Movie(String title, String asin, String price, String devise,
        String image, String actors, String directors, String studio,
        String format, String discs, String languages, String subtitles,
        String runtime, String releaseDate) {
        super(title, asin, price, devise, image);
        this.actors = actors;
        this.directors = directors;
        this.studio = studio;
        this.format = format;
        this.discs = discs;
        this.languages = languages;
        this.subtitles = subtitles;
        this.runtime = runtime;
        this.releaseDate = releaseDate;
    }

    public Movie() {
        super();
        this.actors = null;
        this.directors = null;
        this.studio = null;
        this.format = null;
        this.discs = null;
        this.languages = null;
        this.subtitles = null;
        this.runtime = null;
        this.releaseDate = null;
    }

    public String getActors() {
        return this.actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirectors() {
        return this.directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getStudio() {
        return this.studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDiscs() {
        return this.discs;
    }

    public void setDiscs(String discs) {
        this.discs = discs;
    }

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSubtitles() {
        return this.subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getRuntime() {
        return this.runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return new StringBuilder("\n. ..:: Movie ::.. .")
            .append("\nTitle...............: ").append(this.getTitle())
            .append("\nAsin................: ").append(this.getAsin())
            .append("\nPrice...............: ").append(this.getPrice())
            .append("\nDevise..............: ").append(this.getDevise())
            .append("\nImage...............:\n").append(this.getImage())
            .append("\nActors..............: ").append(this.getActors())
            .append("\nDirectors...........: ").append(this.getDirectors())
            .append("\nStudio..............: ").append(this.getStudio())
            .append("\nFormat..............: ").append(this.getFormat())
            .append("\nDiscs...............: ").append(this.getDiscs())
            .append("\nLanguages...........: ").append(this.getLanguages())
            .append("\nSubtitles...........: ").append(this.getSubtitles())
            .append("\nRuntime.............: ").append(this.getRuntime())
            .append("\nRelease date........: ").append(this.getReleaseDate()).toString();
    }
}