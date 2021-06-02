package dto;

public class UserDto {
    private String iduser;
    private String name;
    private String phone;
    private String email;
    private String CNP;

    public UserDto(String iduser, String name, String CNP, String phone, String email) {
        this.iduser = iduser;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.CNP = CNP;
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
}
