CREATE OR REPLACE TRIGGER VALIDATE_BOOK BEFORE INSERT ON XDBBOOKS
FOR EACH ROW
DECLARE
XMLDATA XMLTYPE;
BEGIN
XMLDATA := :new.sys_nc_rowinfo$;
XMLTYPE.schemavalidate(XMLDATA);
END;
/