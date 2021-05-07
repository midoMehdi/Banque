/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Mehdi
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//tous les types de omptes on va l'enregitré dans la meme table.
//pour spécifier les comptes il ya une colonne qui s'appelle type de compte. cette colonne il faut la déclarer, c'est pour cela on utilise : 
@DiscriminatorColumn(name="type_compte", discriminatorType= DiscriminatorType.STRING)
public class CompteEntity implements Serializable {
    @Id 
    private Long code;
    @ManyToOne
    @JoinColumn(name="code_cli")
    private UserEntity user;
    private String password;
    private String Creation_date;
    private double solde;
    @ManyToOne
    @JoinColumn(name="id_conseiller")
    private ConseillerEntity conseiller;
    @OneToMany(mappedBy="compte")
    private List<OperationEntity> operations = new ArrayList<>();
    
    @OneToMany(mappedBy="compte")
    private List<MessageEntity> messages;
    

    private static final long serialVersionUID = 1L;
    

    
    public CompteEntity() {
    }

    public CompteEntity(Long code, UserEntity user, String password, double solde, String Creation_date,ConseillerEntity conseiller) {
        this.code = code;
        this.user = user;
        this.password = password;
        this.solde = solde;
        this.Creation_date = Creation_date;
        this.conseiller = conseiller;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
    
    

    public UserEntity getUserEntity() {
        return user;
    }

    public void setUserEntity(UserEntity user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Long getNumeroDuCompte() {
        return code;
    }

    public void setNumeroDuCompte(Long numeroDuCompte) {
        this.code = numeroDuCompte;
    }

    public List<OperationEntity> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationEntity> operations) {
        this.operations = operations;
    }
    public void addOperation(OperationEntity operation){
        this.operations.add(operation);
    }

    public String getCreation_date() {
        return Creation_date;
    }

    public void setCreation_date(String Creation_date) {
        this.Creation_date = Creation_date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ConseillerEntity getConseiller() {
        return conseiller;
    }

    public void setConseiller(ConseillerEntity conseiller) {
        this.conseiller = conseiller;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }
    
    

    @Override
    public String toString() {
        return "CompteEntity{" + '}';
    }
    
}





