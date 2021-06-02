package dto;

public class AddressDto {
    private String idaddress;
    private String addressname;
    private String city;
    private String postalcode;

    public AddressDto(String idaddress, String addressname, String city, String postalcode) {
        this.idaddress = idaddress;
        this.addressname = addressname;
        this.city = city;
        this.postalcode = postalcode;
    }

    public String getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(String idaddress) {
        this.idaddress = idaddress;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
}
