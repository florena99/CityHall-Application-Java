package builder;

import entity.Address;

import java.util.UUID;

public class AddressBuilder {
    private Address address;

    public AddressBuilder(){
        address=new Address();
    }

    public AddressBuilder setId(){
        address.setIdaddress(UUID.randomUUID().toString());
        return this;

    }

    public AddressBuilder setAddress(String addressname)
    {
        address.setAddressname(addressname);
        return this;
    }

    public AddressBuilder setPostCode(String postCode)
    {
        address.setPostalcode(postCode);
        return this;
    }

    public AddressBuilder setCity(String city){
        address.setCity(city);
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public AddressBuilder setIdAddress(String idaddress){
        this.address.setIdaddress(idaddress);
        return this;
    }
}
