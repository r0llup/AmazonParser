INSERT INTO XDBBOOKS
VALUES
(
sys.xmltype.createxml(xdbURIType('/home/BLANPAOL/books/books.xml').getClob())
);