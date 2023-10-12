package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mediator")
public class Mediator implements Serializable {
    public int getId_prim() {
        return id_prim;
    }

    public void setId_prim(int id_prim) {
        this.id_prim = id_prim;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prim;


    private int id;

    private String firstName;

    private String lastName;

    private String Password;

    // Note that in this case, choosing CascadeType.ALL would mean that deleting a lecturer would also delete all his or her courses.
    // This is a design choice, and may not be ideal.


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Mediator(int id, String firstName, String lastName, String password) {
        this.id=id;
        this.Password=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id_prim=id;
    }
    public Mediator(Mediator lec) {
        this.id=lec.id;
        this.Password=lec.Password;
        this.firstName = lec.firstName;
        this.lastName = lec.lastName;
        this.id_prim=lec.id_prim;
    }

    public Mediator() {

    }



}