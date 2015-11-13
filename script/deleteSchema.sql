BEGIN
  dbms_xmlschema.deleteSchema (
    'http://10.59.27.3:8080/home/BLANPAOL/books/books.xsd',
    3
  );
  dbms_xmlschema.deleteSchema (
    'http://10.59.27.3:8080/home/BLANPAOL/movies/movies.xsd',
	3
  );
  dbms_xmlschema.deleteSchema (
    'http://10.59.27.3:8080/home/BLANPAOL/musics/musics.xsd',
	3
  );
END;