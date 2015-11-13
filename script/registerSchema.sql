BEGIN
  dbms_xmlSchema.registerSchema (
    'http://10.59.27.3:8080/home/BLANPAOL/books/books.xsd',
    xdbURIType('/home/BLANPAOL/books/books.xsd').getClob()
  );
  dbms_xmlSchema.registerSchema (
    'http://10.59.27.3:8080/home/BLANPAOL/movies/movies.xsd',
    xdbURIType('/home/BLANPAOL/movies/movies.xsd').getClob()
  );
  dbms_xmlSchema.registerSchema (
    'http://10.59.27.3:8080/home/BLANPAOL/musics/musics.xsd',
    xdbURIType('/home/BLANPAOL/musics/musics.xsd').getClob()
  );
END;