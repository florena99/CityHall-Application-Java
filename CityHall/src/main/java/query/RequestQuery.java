package query;

public class RequestQuery {
    public static final String REQUESTS="Select r From Request r Where r.user = :user";
    public static final String ALL_REQUESTS="Select r From Request r";
    public static final String UPDATE_REQUEST = "UPDATE Request r Set r.address = :address WHERE r.idrequest = :idrequest";
    public static final String UPDATE_STATUS = "UPDATE Request r Set r.approved = :approved WHERE r.idrequest = :idrequest";
}
