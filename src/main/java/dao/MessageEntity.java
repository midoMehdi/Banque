/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mehdi
 */
@Entity
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="code")
    private CompteEntity compte;
    
    private String msg;
    private String date_message;
    
    @ManyToOne
    @JoinColumn(name="id_conseiller")
    private ConseillerEntity conseiller;

    public MessageEntity() {
    }

    public MessageEntity(CompteEntity compte, String msg, ConseillerEntity conseiller, String date_message) {
        this.compte = compte;
        this.msg = msg;
        this.conseiller = conseiller;
        this.date_message = date_message;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteEntity getCompte() {
        return compte;
    }

    public void setCompte(CompteEntity compte) {
        this.compte = compte;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ConseillerEntity getConseiller() {
        return conseiller;
    }

    public void setConseiller(ConseillerEntity conseiller) {
        this.conseiller = conseiller;
    }

    public String getDate_message() {
        return date_message;
    }

    public void setDate_message(String date_message) {
        this.date_message = date_message;
    }
    
    
    

    
    
}
