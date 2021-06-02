package service;

import builder.RequestBuilder;
import dto.RequestDto;
import dto.RequestTableDto;
import dto.RequestUserDto;
import entity.Request;
import entity.User;
import repository.RequestRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RequestService {

    private RequestRepo requestRepo = new RequestRepo();

    public Request build(RequestDto requestDto) {

        RequestBuilder requestBuilder = new RequestBuilder().setId().setAddress(requestDto.getAddress()).setApproved().setDate().setDocument(requestDto.getDocument()).setUser(requestDto.getUser());
        return requestBuilder.getRequest();
    }

    public void addRequest(Request request){
        requestRepo.insertNewRequest(request);
    }

    public List<RequestTableDto> getAllUserRequests(User user) {
            List<Request> requests= requestRepo.findall(user);
            List<RequestTableDto> requestTableDtos=new ArrayList<>();
            Iterator it=requests.iterator();
            while(it.hasNext())
            {
                Request r= (Request) it.next();
                RequestTableDto requestDto = new RequestTableDto(r.getIdrequest(),r.getDocuments().getType(),r.getAddress().getAddressname(),r.getDate(),r.getApproved());
                requestTableDtos.add(requestDto);
            }
            return requestTableDtos;
        }
    public void delete(RequestTableDto dto, User user){

        DocumentService documentService= new DocumentService();
        AddressService addressService= new AddressService();
        RequestBuilder requestBuilder= new RequestBuilder().setId2(dto.getIdRequest())
                .setUser(user)
                .setDocument(documentService.getDocument2(dto.getDocumentType()))
                .setAddress(addressService.getAddressName(dto.getAddressName()))
                .setDate2(dto.getDate())
                .setStatus(dto.getStatus());

        requestRepo.delete(requestBuilder.getRequest());
    }

    public void updateRequest(RequestTableDto dto, String addressName) {
        if(dto.getStatus()==0) {
            AddressService addressService = new AddressService();
            requestRepo.update(addressService.getAddressName(addressName),dto.getIdRequest());
        }
    }

    public List<RequestUserDto> getAllRequests() {
        List<Request> requests= requestRepo.findAllRequests();
        List<RequestUserDto> requestUserDtos=new ArrayList<>();
        Iterator it=requests.iterator();
        while(it.hasNext())
        {
            Request r= (Request) it.next();
            RequestUserDto requestDto = new RequestUserDto(r.getIdrequest(),r.getDocuments().getType(),r.getAddress().getAddressname(),r.getDate(),r.getApproved(),r.getUser().getCNP());
            requestUserDtos.add(requestDto);
        }
        return requestUserDtos;
    }

    public void updateStatus(RequestUserDto dto,int status){
        if(dto.getStatus()==0) {
            requestRepo.updateStatus(status,dto.getIdRequest());
        }
    }

}
