package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String iduser;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String CNP;

    @Column
    private int admin;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    @OneToMany(mappedBy = "user")
    private Set<Address> addresses=new HashSet<>();

    public User(String name, String phone, String email, String CNP, String password) {
        this.iduser = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.CNP = CNP;
        this.admin = 0;
        this.password = password;
    }

    public User(){

    }

    public String getIduser() {
        return iduser;
    }


    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }


}
