/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mehdi
 */
@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_client")
    private Long id;
    private String firstName;
    private String lastName;
    private String adresse;
    private String gender;
    private String email;
    private Long phoneNumber;
    
    @OneToMany(mappedBy="user")
    private List<CompteEntity> comptes = new ArrayList<>();
    public UserEntity() {
        this.firstName = "";
        this.lastName = "";
        this.gender = "";
        this.email = "";
        this.phoneNumber = null;
        this.comptes = new ArrayList<>();
    }

    public UserEntity(String firstName, String lastName, String adresse,  String email, Long phoneNumber,String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public List<CompteEntity> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteEntity> comptes) {
        this.comptes = comptes;
    }
    
    public void addCompte(CompteEntity compte){
        this.comptes.add(compte);
    }
    

   

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


