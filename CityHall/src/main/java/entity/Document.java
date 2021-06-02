package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "document")
public class Document {
    @Id
    private String iddocument;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany
    @JoinColumn(name = "document")
    private List<Request> request;

    public String getIddocument() {
        return iddocument;
    }

    public void setIddocument(String iddocument) {
        this.iddocument = iddocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
