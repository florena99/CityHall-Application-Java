package service;

import dto.AddressDto;
import dto.UserDto;
import entity.Address;
import entity.Document;
import entity.User;
import repository.AddressRepo;
import repository.UserRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressService {
    private final AddressRepo addressRepo=new AddressRepo();


    public void addAddress(Address address, User user){
        address.setUser(user);
        System.out.println(user.getName());
        user.addAddress(address);

        addressRepo.insertNewAddress(address);

    }

    public List<AddressDto> getAllAddresses(User user){
        List<Address> address1= addressRepo.findall(user);
        List<AddressDto> address=new ArrayList<>();
        Iterator it=address1.iterator();
        while(it.hasNext())
        {
            Address address2= (Address) it.next();
            AddressDto addressDto = new AddressDto(address2.getIdaddress(), address2.getAddressname(), address2.getCity(), address2.getPostalcode());
            address.add(addressDto);
        }
        return address;
    }

    public List<String> getAllAddressesName(User user){

        List<Address> addresses= addressRepo.findall(user);
        List<String> names = new ArrayList<>();
        Iterator it= addresses.iterator();
        while (it.hasNext()){
            Address address=(Address) it.next();
            names.add(address.getAddressname());
        }
        return names;

    }




    public void delete(Address address){
        addressRepo.deleteById(address);
    }

    public Address getAddressName(String address){
        return addressRepo.findByAddressName(address);
    }



}
