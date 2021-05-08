package pl.coderslab.spring01hibernatekrkw07.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @Size(min=1)
    private String nip;
    @Size(min=1)
    private String regon;

    public long getId() {
        return id;
    }

    public Publisher setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Publisher setName(String name) {
        this.name = name;
        return this;
    }

    public String getNip() {
        return nip;
    }

    public Publisher setNip(String nip) {
        this.nip = nip;
        return this;
    }

    public String getRegon() {
        return regon;
    }

    public Publisher setRegon(String regon) {
        this.regon = regon;
        return this;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                '}';
    }
}
