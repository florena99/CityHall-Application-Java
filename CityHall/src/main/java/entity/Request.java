package entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "request")
public class Request {
    @Id
    private String idrequest;
    @Column
    private LocalDate date;
    @Column
    private int approved;
    @ManyToOne
    @JoinColumn(name = "iddocument")
    private Document documents;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idaddress")
    private Address address;

    public String getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(String idrequest) {
        this.idrequest = idrequest;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public Document getDocuments() {
        return documents;
    }

    public void setDocuments(Document documents) {
        this.documents = documents;
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
}
