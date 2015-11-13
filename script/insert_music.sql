INSERT INTO XDBMUSICS
VALUES
(
sys.xmltype.createxml(xdbURIType('/home/BLANPAOL/musics/musics.xml').getClob())
);