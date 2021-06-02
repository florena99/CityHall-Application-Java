package dto;

import java.time.LocalDate;

public class RequestTableDto {

    private String idRequest;
    private String documentType;
    private String addressName;
    private LocalDate date;
    private int status;

    public RequestTableDto(String idRequest, String documentType, String addressName, LocalDate date, int status) {
        this.idRequest = idRequest;
        this.documentType = documentType;
        this.addressName = addressName;
        this.date = date;
        this.status = status;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
