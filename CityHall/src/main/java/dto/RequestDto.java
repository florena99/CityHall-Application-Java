package dto;

import entity.Address;
import entity.Document;
import entity.User;


public class RequestDto {

    private User user;
    private Address address;
    private Document document;

    public RequestDto(User user, Address address, Document document) {
        this.user = user;
        this.address = address;
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
