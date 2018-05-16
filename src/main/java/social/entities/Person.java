package social.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    private Calendar bornDate;

    private String name;
    private String email;
    private String bornCity;
    private String actualCity;


    protected Person() {}

    public Person(Long id) {
        this.id = id;
    }

    public Person(String name, Calendar bornDate, String email, String bornCity, String actualCity) {
        this.name = name;
        this.bornDate = bornDate;
        this.email = email;
        this.bornCity = bornCity;
        this.actualCity = actualCity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Calendar getBornDate() {
        return bornDate;
    }

    public void setBornDate(Calendar bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBornCity() {
        return bornCity;
    }

    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }

    public String getActualCity() {
        return actualCity;
    }

    public void setActualCity(String actualCity) {
        this.actualCity = actualCity;
    }
}
