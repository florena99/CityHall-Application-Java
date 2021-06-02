package builder;

import entity.Address;
import entity.Document;
import entity.Request;
import entity.User;

import java.time.LocalDate;
import java.util.UUID;

public class RequestBuilder {
    private Request request;

    public RequestBuilder() {
        this.request = new Request();
    }


    public RequestBuilder setId2(String idrequest){
        request.setIdrequest(idrequest);
        return this;
    }

    public RequestBuilder setId(){
        request.setIdrequest(UUID.randomUUID().toString());
        return this;
    }

    public RequestBuilder setDocument(Document document){
        request.setDocuments(document);
        return this;

    }

    public RequestBuilder setAddress(Address address){
        request.setAddress(address);
        return this;
    }

    public RequestBuilder setDate(){
        request.setDate(LocalDate.now());
        return this;
    }

    public RequestBuilder setDate2(LocalDate localDate){
        request.setDate(localDate);
        return this;
    }

    public RequestBuilder setApproved(){
        request.setApproved(0);
        return this;
    }

    public RequestBuilder setStatus(int status){
        request.setApproved(status);
        return this;
    }
    public RequestBuilder setUser(User user){
        request.setUser(user);
        return this;
    }

    public Request getRequest() {
        return request;
    }
}
