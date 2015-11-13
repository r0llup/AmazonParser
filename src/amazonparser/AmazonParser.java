/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazonparser;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import types.Book;
import types.Media;
import types.Movie;
import types.Music;
import utils.FileLoader;
import utils.PageLoader;
import utils.PropertiesLauncher;

/**
 *
 * @author Sh1fT
 */

public final class AmazonParser {
    protected PropertiesLauncher propertiesLauncher;
    protected PageLoader pageLoader;
    protected String data;
    protected ParsingMaker parsingMaker;
    protected FileLoader fileLoader;

    /**
     * Creates new instance AmazonParser
     */
    public AmazonParser() {
        this.setPropertiesLauncher(new PropertiesLauncher(
            System.getProperty("file.separator") + "properties" +
            System.getProperty("file.separator") + "AmazonParser.properties"));
        this.setPageLoader(null);
        this.setData(null);
        this.setParsingMaker(null);
        this.setFileLoader(null);
    }

    public PropertiesLauncher getPropertiesLauncher() {
        return this.propertiesLauncher;
    }

    protected void setPropertiesLauncher(PropertiesLauncher propertiesLauncher) {
        this.propertiesLauncher = propertiesLauncher;
    }

    public PageLoader getPageLoader() {
        return this.pageLoader;
    }

    protected void setPageLoader(PageLoader pageLoader) {
        this.pageLoader = pageLoader;
    }

    public String getData() {
        return this.data;
    }

    protected void setData(String data) {
        this.data = data;
    }

    public ParsingMaker getParsingMaker() {
        return this.parsingMaker;
    }

    protected void setParsingMaker(ParsingMaker parsingMaker) {
        this.parsingMaker = parsingMaker;
    }

    public FileLoader getFileLoader() {
        return this.fileLoader;
    }

    protected void setFileLoader(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    public String getBaseHtmlPage() {
        return this.getPropertiesLauncher().getProperties().getProperty("baseHtmlPage");
    }

    public String getBookTopHtmlPage() {
        return this.getPropertiesLauncher().getProperties().getProperty("bookTopHtmlPage");
    }

    public String getMovieTopHtmlPage() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieTopHtmlPage");
    }

    public String getMusicTopHtmlPage() {
        return this.getPropertiesLauncher().getProperties().getProperty("musicTopHtmlPage");
    }

    public String getMediaTopRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("mediaTopRegex");
    }

    public String getMediaTitleRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("mediaTitleRegex");
    }

    public String getMediaAsinRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("mediaAsinRegex");
    }

    public String getMediaPriceRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("mediaPriceRegex");
    }

    public String getMediaImageRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("mediaImageRegex");
    }

    public String getBookAuthorsRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("bookAuthorsRegex");
    }

    public String getBookPublisherRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("bookPublisherRegex");
    }

    public String getBookFormatRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("bookFormatRegex");
    }

    public String getBookPagesRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("bookPagesRegex");
    }

    public String getMovieActorsRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieActorsRegex");
    }

    public String getMovieDirectorsRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieDirectorsRegex");
    }

    public String getMovieStudioRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieStudioRegex");
    }

    public String getMovieFormatRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieFormatRegex");
    }

    public String getMovieDiscsRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieDiscsRegex");
    }

    public String getMovieLanguagesRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieLanguagesRegex");
    }

    public String getMovieSubtitlesRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieSubtitlesRegex");
    }

    public String getMovieRuntimeRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieRuntimeRegex");
    }

    public String getMovieReleaseDateRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieReleaseDateRegex");
    }

    public String getMusicArtistsRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("musicArtistsRegex");
    }

    public String getMusicLabelRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("musicLabelRegex");
    }

    public String getMusicDiscsRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("musicDiscsRegex");
    }

    public String getMusicReleaseDateRegex() {
        return this.getPropertiesLauncher().getProperties().getProperty("musicReleaseDateRegex");
    }

    public String getBookXmlFilename() {
        return this.getPropertiesLauncher().getProperties().getProperty("bookXmlFilename");
    }

    public String getMovieXmlFilename() {
        return this.getPropertiesLauncher().getProperties().getProperty("movieXmlFilename");
    }

    public String getMusicXmlFilename() {
        return this.getPropertiesLauncher().getProperties().getProperty("musicXmlFilename");
    }

    public String getFtpHost() {
        return this.getPropertiesLauncher().getProperties().getProperty("ftpHost");
    }

    public Integer getFtpPort() {
        return Integer.parseInt(this.getPropertiesLauncher().getProperties().getProperty("ftpPort"));
    }

    public String getFtpUser() {
        return this.getPropertiesLauncher().getProperties().getProperty("ftpUser");
    }

    public String getFtpPassword() {
        return this.getPropertiesLauncher().getProperties().getProperty("ftpPassword");
    }

    public String getFtpBookDirectory() {
        return this.getPropertiesLauncher().getProperties().getProperty("ftpBookDirectory");
    }

    public String getFtpMovieDirectory() {
        return this.getPropertiesLauncher().getProperties().getProperty("ftpMovieDirectory");
    }

    public String getFtpMusicDirectory() {
        return this.getPropertiesLauncher().getProperties().getProperty("ftpMusicDirectory");
    }

    public String getCharset() {
        return this.getPropertiesLauncher().getProperties().getProperty("charset");
    }

    /**
     * Feed Media
     * @param m
     * @throws MalformedURLException 
     */
    protected void feedMedia(Media m) throws MalformedURLException {
        this.setParsingMaker(new ParsingMaker(this.getMediaTitleRegex(), this.getData()));
        m.setTitle(this.getParsingMaker().findOut(">", "<"));
        if (m.getTitle() != null)
            m.setTitle(m.getTitle().trim());
        this.setParsingMaker(new ParsingMaker(this.getMediaAsinRegex(), this.getData()));
        m.setAsin(this.getParsingMaker().findOut("=\"", "\""));
        if (m.getAsin() != null)
            m.setAsin(m.getAsin().trim());
        this.setParsingMaker(new ParsingMaker(this.getMediaPriceRegex(), this.getData()));
        m.setPrice(this.getParsingMaker().findOut(" ", "<"));
        if (m.getPrice() != null)
            m.setPrice(m.getPrice().trim());
        this.setParsingMaker(new ParsingMaker(this.getMediaPriceRegex(), this.getData()));
        m.setDevise(this.getParsingMaker().findOut(">", " "));
        if (m.getDevise() != null)
            m.setDevise(m.getDevise().trim());
        this.setParsingMaker(new ParsingMaker(this.getMediaImageRegex(), this.getData()));
        String imageUrl = this.getParsingMaker().findOut("=\"", "\"");
        if (imageUrl != null) {
            imageUrl = imageUrl.trim();
            this.setFileLoader(new FileLoader(new URL(imageUrl)));
            m.setImage(Base64.encode(this.getFileLoader().getFile()).toString());
        }
    }

    /**
     * Show Book
     * @param books 
     */
    public void showBook(List<Book> books) {
        for (Book b : books)
            System.out.println(b);
    }

    /**
     * Feed Book
     * @param books 
     */
    public void feedBook(List<Book> books) {
    try {
            this.setPageLoader(new PageLoader(new URL(this.getBookTopHtmlPage()), this.getCharset()));
            this.setData(this.getPageLoader().retrieveData());
            this.setParsingMaker(new ParsingMaker(this.getMediaTopRegex(), this.getData()));
            for (String url : this.getParsingMaker().findOut2("=\"", "\"")) {
                this.setPageLoader(new PageLoader(new URL(this.getBaseHtmlPage()+url), this.getCharset()));
                this.setData(this.getPageLoader().retrieveData());
                Book b = new Book();
                this.feedMedia(b);
                this.setParsingMaker(new ParsingMaker(this.getBookAuthorsRegex(), this.getData()));
                b.setAuthors(this.getParsingMaker().findOut("Amazon.fr:", ":"));
                if (b.getAuthors() != null)
                    b.setAuthors(b.getAuthors().trim().replace(", ", ",").concat(","));
                this.setParsingMaker(new ParsingMaker(this.getBookPublisherRegex(), this.getData()));
                b.setPublisher(this.getParsingMaker().findOut("> ", "("));
                if (b.getPublisher() != null)
                    b.setPublisher(b.getPublisher().trim());
                this.setParsingMaker(new ParsingMaker(this.getBookFormatRegex(), this.getData()));
                b.setFormat(this.getParsingMaker().findOut("<b>", ":"));
                if (b.getFormat() != null)
                    b.setFormat(b.getFormat().trim());
                this.setParsingMaker(new ParsingMaker(this.getBookPagesRegex(), this.getData()));
                b.setPages(this.getParsingMaker().findOut("> ", "<"));
                if (b.getPages() != null)
                    b.setPages(b.getPages().trim());
                this.setParsingMaker(new ParsingMaker(this.getBookPublisherRegex(), this.getData()));
                b.setReleaseDate(this.getParsingMaker().findOut(" (", ")"));
                if (b.getReleaseDate() != null)
                    b.setReleaseDate(b.getReleaseDate().trim());
                books.add(b);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Show Movie
     * @param movies 
     */
    public void showMovie(List<Movie> movies) {
        for (Movie m : movies)
            System.out.println(m);
    }

    /**
     * Feed Movie
     * @param movies 
     */
    public void feedMovie(List<Movie> movies) {
        try {
            this.setPageLoader(new PageLoader(new URL(this.getMovieTopHtmlPage()), this.getCharset()));
            this.setData(this.getPageLoader().retrieveData());
            this.setParsingMaker(new ParsingMaker(this.getMediaTopRegex(), this.getData()));
            for (String url : this.getParsingMaker().findOut2("=\"", "\"")) {
                this.setPageLoader(new PageLoader(new URL(this.getBaseHtmlPage()+url), this.getCharset()));
                this.setData(this.getPageLoader().retrieveData());
                Movie m = new Movie();
                this.feedMedia(m);
                this.setParsingMaker(new ParsingMaker(this.getMovieActorsRegex(), this.getData()));
                m.setActors(Utils.arrayToString(this.getParsingMaker().findOut2("=", "\"")));
                if (m.getActors() != null)
                    m.setActors(m.getActors().trim());
                this.setParsingMaker(new ParsingMaker(this.getMovieDirectorsRegex(), this.getData()));
                m.setDirectors(Utils.arrayToString(this.getParsingMaker().findOut2("=", "\"")));
                if (m.getDirectors() != null)
                    m.setDirectors(m.getDirectors().trim());
                this.setParsingMaker(new ParsingMaker(this.getMovieStudioRegex(), this.getData()));
                m.setStudio(this.getParsingMaker().findOut("</b>", "</li>"));
                if (m.getStudio() != null)
                    m.setStudio(m.getStudio().trim());
                this.setParsingMaker(new ParsingMaker(this.getMovieFormatRegex(), this.getData()));
                m.setFormat(this.getParsingMaker().findOut("</span>", "<br />"));
               if (m.getFormat() != null)
                   m.setFormat(m.getFormat().trim());
                this.setParsingMaker(new ParsingMaker(this.getMovieDiscsRegex(), this.getData()));
                m.setDiscs(this.getParsingMaker().findOut("</b>", "</li>"));
                if (m.getDiscs() != null)
                    m.setDiscs(m.getDiscs().trim());
                this.setParsingMaker(new ParsingMaker(this.getMovieLanguagesRegex(), this.getData()));
                m.setLanguages(this.getParsingMaker().findOut("</b>", "</li>"));
                if (m.getLanguages() != null)
                    m.setLanguages(m.getLanguages().trim().replace(", ", ",").concat(","));
                this.setParsingMaker(new ParsingMaker(this.getMovieSubtitlesRegex(), this.getData()));
                m.setSubtitles(this.getParsingMaker().findOut("</b>", "</li>"));
                if (m.getSubtitles() != null)
                    m.setSubtitles(m.getSubtitles().trim().replace(", ", ",").concat(","));
                this.setParsingMaker(new ParsingMaker(this.getMovieRuntimeRegex(), this.getData()));
                m.setRuntime(this.getParsingMaker().findOut("</b>", "</li>"));
                if (m.getRuntime() != null)
                    m.setRuntime(m.getRuntime().trim());
                this.setParsingMaker(new ParsingMaker(this.getMovieReleaseDateRegex(), this.getData()));
                m.setReleaseDate(this.getParsingMaker().findOut("</b>", "</li>"));
                if (m.getReleaseDate() != null)
                    m.setReleaseDate(m.getReleaseDate().trim());
                movies.add(m);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Show Music
     * @param musics 
     */
    public void showMusic(List<Music> musics) {
        for (Music m : musics)
            System.out.println(m);
    }

    /**
     * Feed Music
     * @param musics 
     */
    public void feedMusic(List<Music> musics) {
        try {
            this.setPageLoader(new PageLoader(new URL(this.getMusicTopHtmlPage()), this.getCharset()));
            this.setData(this.getPageLoader().retrieveData());
            this.setParsingMaker(new ParsingMaker(this.getMediaTopRegex(), this.getData()));
            for (String url : this.getParsingMaker().findOut2("=\"", "\"")) {
                this.setPageLoader(new PageLoader(new URL(this.getBaseHtmlPage()+url), this.getCharset()));
                this.setData(this.getPageLoader().retrieveData());
                Music m = new Music();
                this.feedMedia(m);
                this.setParsingMaker(new ParsingMaker(this.getMusicArtistsRegex(), this.getData()));
                m.setArtists(this.getParsingMaker().findOut("\"", ","));
                if (m.getArtists() != null) {
                    if (m.getArtists().contains(","))
                        m.setArtists(m.getArtists().substring(0, m.getArtists().indexOf(",")));
                    m.setArtists(m.getArtists().trim().concat(","));
                }
                this.setParsingMaker(new ParsingMaker(this.getMusicLabelRegex(), this.getData()));
                m.setLabel(this.getParsingMaker().findOut("> ", "<"));
                if (m.getLabel() != null)
                    m.setLabel(m.getLabel().trim());
                this.setParsingMaker(new ParsingMaker(this.getMusicDiscsRegex(), this.getData()));
                m.setDiscs(this.getParsingMaker().findOut("> ", "<"));
                if (m.getDiscs() != null)
                    m.setDiscs(m.getDiscs().trim());
                this.setParsingMaker(new ParsingMaker(this.getMusicReleaseDateRegex(), this.getData()));
                m.setReleaseDate(this.getParsingMaker().findOut("CD</b>  (", ")"));
                if (m.getReleaseDate() != null)
                    m.setReleaseDate(m.getReleaseDate().trim());
                musics.add(m);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        Boolean doBook = true;
        Boolean doMovie = true;
        Boolean doMusic = true;

        if (args.length > 0) {
            String _args = "";

            for (String arg : args) {
                _args += arg;
            }

            if (_args.contains("-book"))
                doBook = true;
            else
                doBook = false;
            if (_args.contains("-movie"))
                doMovie = true;
            else
                doMovie = false;
            if (_args.contains("-music"))
                doMusic = true;
            else
                doMusic = false;
        }

        AmazonParser ap = new AmazonParser();
        FTPHandler ftpHandler = new FTPHandler(ap.getFtpHost(), ap.getFtpPort(),
            ap.getFtpUser(), ap.getFtpPassword(), true);
        ftpHandler.connect();

        if (doBook) {
            System.out.println(". ..:: Loading Books ::.. .");
            List<Book> books = new LinkedList<>();
            ap.feedBook(books);
            System.out.println(". ..:: Books Loaded Successfully ::.. .");
            ap.showBook(books);
            System.out.println(". ..:: Saving Books ::.. .");
            XMLHandler hdBook = new XMLHandler(ap.getBookXmlFilename());
            hdBook.buildBookXML(books);
            hdBook.saveXML();
            System.out.println(". ..:: Books Saved Successfully ::.. .");
            System.out.println(". ..:: Uploading Books ::.. .");
            ftpHandler.setDirectory(ap.getFtpBookDirectory());
            ftpHandler.upload(new File(ap.getBookXmlFilename()));
            System.out.println(". ..:: Books Uploaded Successfully ::.. .");
        } if (doMovie) {
            System.out.println(". ..:: Loading Movies ::.. .");
            List<Movie> movies = new LinkedList<>();
            ap.feedMovie(movies);
            System.out.println(". ..:: Movies Loaded Successfully ::.. .");
            ap.showMovie(movies);
            System.out.println(". ..:: Saving Movies ::.. .");
            XMLHandler hdMovie = new XMLHandler(ap.getMovieXmlFilename());
            hdMovie.buildMovieXML(movies);
            hdMovie.saveXML();
            System.out.println(". ..:: Movies Saved Successfully ::.. .");
            System.out.println(". ..:: Uploading Movies ::.. .");
            ftpHandler.setDirectory(ap.getFtpMovieDirectory());
            ftpHandler.upload(new File(ap.getMovieXmlFilename()));
            System.out.println(". ..:: Movies Uploaded Successfully ::.. .");
        } if (doMusic) {
            System.out.println(". ..:: Loading Musics ::.. .");
            List<Music> musics = new LinkedList<>();  
            ap.feedMusic(musics);
            System.out.println(". ..:: Musics Loaded Successfully ::.. .");
            ap.showMusic(musics);
            System.out.println(". ..:: Saving Musics ::.. .");
            XMLHandler hdMusic = new XMLHandler(ap.getMusicXmlFilename());
            hdMusic.buildMusicXML(musics);
            hdMusic.saveXML();
            System.out.println(". ..:: Musics Saved Successfully ::.. .");
            System.out.println(". ..:: Uploading Musics ::.. .");
            ftpHandler.setDirectory(ap.getFtpMusicDirectory());
            ftpHandler.upload(new File(ap.getMusicXmlFilename()));
            System.out.println(". ..:: Musics Uploaded Successfully ::.. .");
        }
        ftpHandler.disconnect();
    }
}