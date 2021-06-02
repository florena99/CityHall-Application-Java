package query;

public class AddressQuery {
    public static final String ADDRESSES="Select a From Address a Where a.user = :user";
    public static final String ADDRESS_BY_ADDRESS_NAME="Select a From Address a Where a.addressname = :addressname";

}
