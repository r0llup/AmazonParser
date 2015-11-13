/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazonparser;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import types.Book;
import types.Media;
import types.Movie;
import types.Music;

/**
 *
 * @author Sh1fT
 */

public final class XMLHandler {
    protected String filename;
    protected Document document;

    /**
     * Creates new instance XMLHandler
     * @param filename 
     */
    public XMLHandler(String filename) {
        this.setFilename(filename);
        this.setDocument(null);
        this.initXML();
    }

    public String getFilename() {
        return this.filename;
    }

    protected void setFilename(String filename) {
        this.filename = filename;
    }

    public Document getDocument() {
        return this.document;
    }

    protected void setDocument(Document document) {
        this.document = document;
    }

    /**
     * Initialize The XML Document
     */
    protected void initXML() {
        try {
            DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
            fabrique.setValidating(false);
            DocumentBuilder constructeur = fabrique.newDocumentBuilder();
            this.setDocument(constructeur.newDocument());
            this.getDocument().setXmlVersion("1.0");
        } catch (ParserConfigurationException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Build The Media Tree
     * @param media
     * @param m 
     */
    protected void buildMediaTree(Element media, Media m) {
        Element title = this.getDocument().createElement("title");
        Text titleValue = this.getDocument().createTextNode("Unknown");
        if (m.getTitle() != null)
            titleValue = this.getDocument().createTextNode(m.getTitle());
        title.appendChild(titleValue);
        media.appendChild(title);
        Element asin = this.getDocument().createElement("asin");
        Text asinValue = this.getDocument().createTextNode("Unknown");
        if (m.getAsin() != null)
            asinValue = this.getDocument().createTextNode(m.getAsin());
        asin.appendChild(asinValue);
        media.appendChild(asin);
        Element price = this.getDocument().createElement("price");
        Text priceValue = this.getDocument().createTextNode("Unknown");
        if (m.getPrice() != null)
            priceValue = this.getDocument().createTextNode(m.getPrice());
        price.appendChild(priceValue);
        media.appendChild(price);
        Element devise = this.getDocument().createElement("devise");
        Text deviseValue = this.getDocument().createTextNode("Unknown");
        if (m.getDevise() != null)
            deviseValue = this.getDocument().createTextNode(m.getDevise());
        devise.appendChild(deviseValue);
        media.appendChild(devise);
        Element image = this.getDocument().createElement("image");
        Text imageValue = this.getDocument().createTextNode("Unknown");
        if (m.getImage() != null)
            imageValue = this.getDocument().createTextNode(m.getImage());
        image.appendChild(imageValue);
        media.appendChild(image);
    }

    /**
     * Build The Book Tree
     * @param book
     * @param b 
     */
    protected void buildBookTree(Element book, Book b) {
        this.buildMediaTree(book, b);
        Element author = this.getDocument().createElement("authors");
        Text authorValue = this.getDocument().createTextNode("Unknown,");
        if (b.getAuthors() != null)
            authorValue = this.getDocument().createTextNode(b.getAuthors());
        author.appendChild(authorValue);
        book.appendChild(author);
        Element publisher = this.getDocument().createElement("publisher");
        Text publisherValue = this.getDocument().createTextNode("Unknown");
        if (b.getPublisher() != null)
            publisherValue = this.getDocument().createTextNode(b.getPublisher());
        publisher.appendChild(publisherValue);
        book.appendChild(publisher);
        Element format = this.getDocument().createElement("format");
        Text formatValue = this.getDocument().createTextNode("Unknown");
        if (b.getFormat() != null)
            formatValue = this.getDocument().createTextNode(b.getFormat());
        format.appendChild(formatValue);
        book.appendChild(format);
        Element pages = this.getDocument().createElement("pages");
        Text pagesValue = this.getDocument().createTextNode("Unknown");
        if (b.getPages() != null)
            pagesValue = this.getDocument().createTextNode(b.getPages());
        pages.appendChild(pagesValue);
        book.appendChild(pages);
        Element releaseDate = this.getDocument().createElement("releaseDate");
        Text releaseDateValue = this.getDocument().createTextNode("Unknown");
        if (b.getReleaseDate() != null)
            releaseDateValue = this.getDocument().createTextNode(b.getReleaseDate());
        releaseDate.appendChild(releaseDateValue);
        book.appendChild(releaseDate);
    }

    /**
     * Build The Movie Tree
     * @param movie
     * @param m 
     */
    protected void buildMovieTree(Element movie, Movie m) {
        this.buildMediaTree(movie, m);
        Element actors = this.getDocument().createElement("actors");
        Text actorsValue = this.getDocument().createTextNode("Unknown,");
        if (m.getActors() != null)
            actorsValue = this.getDocument().createTextNode(m.getActors());
        actors.appendChild(actorsValue);
        movie.appendChild(actors);
        Element directors = this.getDocument().createElement("directors");
        Text directorsValue = this.getDocument().createTextNode("Unknown,");
        if (m.getDirectors() != null)
            directorsValue = this.getDocument().createTextNode(m.getDirectors());
        directors.appendChild(directorsValue);
        movie.appendChild(directors);
        Element studio = this.getDocument().createElement("studio");
        Text studioValue = this.getDocument().createTextNode("Unknown");
        if (m.getStudio() != null)
            studioValue = this.getDocument().createTextNode(m.getStudio());
        studio.appendChild(studioValue);
        movie.appendChild(studio);
        Element format = this.getDocument().createElement("format");
        Text formatValue = this.getDocument().createTextNode("Unknown");
        if (m.getFormat() != null)
            formatValue = this.getDocument().createTextNode(m.getFormat());
        format.appendChild(formatValue);
        movie.appendChild(format);
        Element discs = this.getDocument().createElement("discs");
        Text discsValue = this.getDocument().createTextNode("Unknown");
        if (m.getDiscs() != null)
            discsValue = this.getDocument().createTextNode(m.getDiscs());
        discs.appendChild(discsValue);
        movie.appendChild(discs);
        Element languages = this.getDocument().createElement("languages");
        Text languagesValue = this.getDocument().createTextNode("Unknown,");
        if (m.getLanguages() != null)
            languagesValue = this.getDocument().createTextNode(m.getLanguages());
        languages.appendChild(languagesValue);
        movie.appendChild(languages);
        Element subtitles = this.getDocument().createElement("subtitles");
        Text subtitlesValue = this.getDocument().createTextNode("Unknown,");
        if (m.getSubtitles() != null)
            subtitlesValue = this.getDocument().createTextNode(m.getSubtitles());
        subtitles.appendChild(subtitlesValue);
        movie.appendChild(subtitles);
        Element runtime = this.getDocument().createElement("runtime");
        Text runtimeValue = this.getDocument().createTextNode("Unknown");
        if (m.getRuntime() != null)
            runtimeValue = this.getDocument().createTextNode(m.getRuntime());
        runtime.appendChild(runtimeValue);
        movie.appendChild(runtime);
        Element releaseDate = this.getDocument().createElement("releaseDate");
        Text releaseDateValue = this.getDocument().createTextNode("Unknown");
        if (m.getReleaseDate() != null)
            releaseDateValue = this.getDocument().createTextNode(m.getReleaseDate());
        releaseDate.appendChild(releaseDateValue);
        movie.appendChild(releaseDate);
    }

    /**
     * Build The Music Tree
     * @param music
     * @param m 
     */
    protected void buildMusicTree(Element music, Music m) {
        this.buildMediaTree(music, m);
        Element artists = this.getDocument().createElement("artists");
        Text artistsValue = this.getDocument().createTextNode("Unknown,");
        if (m.getArtists() != null)
            artistsValue = this.getDocument().createTextNode(m.getArtists());
        artists.appendChild(artistsValue);
        music.appendChild(artists);
        Element label = this.getDocument().createElement("label");
        Text labelValue = this.getDocument().createTextNode("Unknown");
        if (m.getLabel() != null)
            labelValue = this.getDocument().createTextNode(m.getLabel());
        label.appendChild(labelValue);
        music.appendChild(label);
        Element discs = this.getDocument().createElement("discs");
        Text discsValue = this.getDocument().createTextNode("Unknown");
        if (m.getDiscs() != null)
            discsValue = this.getDocument().createTextNode(m.getDiscs());
        discs.appendChild(discsValue);
        music.appendChild(discs);
        Element releaseDate = this.getDocument().createElement("releaseDate");
        Text releaseDateValue = this.getDocument().createTextNode("Unknown");
        if (m.getReleaseDate() != null)
            releaseDateValue = this.getDocument().createTextNode(m.getReleaseDate());
        releaseDate.appendChild(releaseDateValue);
        music.appendChild(releaseDate);
    }

    /**
     * Build The XML Document
     * @param books 
     */
    public void buildBookXML(List<Book> books) {
        Element _document = this.getDocument().createElement("books");
        _document.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        _document.setAttribute("xsi:noNamespaceSchemaLocation",
            "http://10.59.27.3:8080/home/BLANPAOL/books/books.xsd");
        for (Book b : books) {
            Element book = this.getDocument().createElement("book");
            this.buildBookTree(book, b);
            _document.appendChild(book);
        }
        this.getDocument().appendChild(_document);
    }

    /**
     * Build The XML Document
     * @param movies 
     */
    public void buildMovieXML(List<Movie> movies) {
        Element _document = this.getDocument().createElement("movies");
        _document.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        _document.setAttribute("xsi:noNamespaceSchemaLocation",
            "http://10.59.27.3:8080/home/BLANPAOL/movies/movies.xsd");
        for (Movie m : movies) {
            Element movie = this.getDocument().createElement("movie");
            this.buildMovieTree(movie, m);
            _document.appendChild(movie);
        }
        this.getDocument().appendChild(_document);
    }

    /**
     * Build The XML Document
     * @param musics 
     */
    public void buildMusicXML(List<Music> musics) {
        Element _document = this.getDocument().createElement("musics");
        _document.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        _document.setAttribute("xsi:noNamespaceSchemaLocation",
            "http://10.59.27.3:8080/home/BLANPAOL/musics/musics.xsd");
        for (Music m : musics) {
            Element music = this.getDocument().createElement("music");
            this.buildMusicTree(music, m);
            _document.appendChild(music);
        }
        this.getDocument().appendChild(_document);
    }

    /**
     * Save The XML Document
     */
    public void saveXML() {
        try {
            Source source = new DOMSource(this.getDocument());
            Result resultat = new StreamResult(this.getFilename());
            TransformerFactory fabrique = TransformerFactory.newInstance();
            Transformer transformer = fabrique.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.transform(source, resultat);
        } catch(TransformerException ex){
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }
}