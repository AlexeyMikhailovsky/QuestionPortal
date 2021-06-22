package by.htp.ll.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
    private static final long serialVersionUID = -1959040783153783376L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private int idUser;

    @Column(name="first_name")
    private String name;

    @Column(name="last_name")
    private String surname;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phonenumber")
    private String phonenumber;

    @Column(name="date")
    private LocalDateTime date;

    public User() {}

    public User(String name, String surname, String email, String password, String phonenumber, LocalDateTime date) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.date = date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
              String formattedDateTime = date.format(formatter);
              return formattedDateTime;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
