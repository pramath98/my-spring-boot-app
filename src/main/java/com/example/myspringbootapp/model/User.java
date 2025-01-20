package com.example.myspringbootapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")  // Escaping for H2
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Default constructor (required by JPA)
    public User() {
    }

    //Default constructor
    public User(Long id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email = email;
    }

    //toString method

    public String toString(){
        return "User{id="+id+", name='"+name+"', email='"+email+"'}";
    }

    //equals and hashcode method
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return id!=null && id.equals(user.id);
    }

    @Override
    public int hashCode(){
        return 31;
    }

}
