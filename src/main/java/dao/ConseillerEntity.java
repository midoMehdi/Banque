/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Mehdi
 */
@Entity
public class ConseillerEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id_conseiller;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    
    @OneToMany(mappedBy="conseiller")
    private List<CompteEntity> comptes;
    
    @OneToMany(mappedBy="conseiller")
    private List<OperationEntity> operations;
    
    @OneToMany(mappedBy="conseiller")
    private List<MessageEntity> messages;

    public ConseillerEntity() {
    }

    public ConseillerEntity(String id_conseiller, String first_name, String last_name, String email,String password) {
        this.id_conseiller = id_conseiller;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.comptes = new ArrayList<>();
        this.operations = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public String getId_conseiller() {
        return id_conseiller;
    }

    public void setId_conseiller(String id_conseiller) {
        this.id_conseiller = id_conseiller;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<CompteEntity> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteEntity> comptes) {
        this.comptes = comptes;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    public void addMessage(MessageEntity message){
        this.messages.add(message);
    }
    
    public void addOperation(OperationEntity operation){
        this.operations.add(operation);
    }
    
    public void addCompte(CompteEntity compte){
        this.comptes.add(compte);
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

    public List<OperationEntity> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationEntity> operations) {
        this.operations = operations;
    }
    
    
    
}
