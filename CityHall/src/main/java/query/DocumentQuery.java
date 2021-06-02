package query;

public class DocumentQuery {
    public static final String DOCUMENT_BY_NAME="SELECT d From Document d WHERE d.name= :name";
    public static final String DOCUMENT_BY_TYPE="SELECT d From Document d WHERE d.type= :type";
    public static final String DOCUMENT_ALL="SELECT d From Document d";
    public static final String DOCUMENT_DELETE_BY_ID="DELETE from Document AS d WHERE d.iddocument= :iddocument";

}
