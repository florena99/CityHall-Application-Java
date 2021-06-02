package query;

public class UserQuery {
    public static final String USER_BY_CNP="SELECT u From User u WHERE u.CNP= :CNP" ;
    public static final String USER_BY_PHONE= "SELECT u From User u WHERE u.phone = :phone";
    public static final String USER_BY_EMAIL= "SELECT u From User u WHERE u.email = :email";
    public static final String USER_BY_PASSWORD= "SELECT u From User u WHERE u.password = :password";
    public static final String USERS="SELECT u From User u WHERE u.admin =:admin";
    public static final String USER_BY_ID="SELECT u From User u WHERE u.iduser =:iduser";
    }

