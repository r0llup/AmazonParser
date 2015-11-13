INSERT INTO XDBMOVIES
VALUES
(
sys.xmltype.createxml(xdbURIType('/home/BLANPAOL/movies/movies.xml').getClob())
);