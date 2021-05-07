/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mehdi
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//possiblité de ne pas spécifier le descriminator, il sera générée automatiquement, (valeur par defaut)
public class OperationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="numero_operation")
    private Long numero;
    @Column(name="date")
    private String operation_date;
    private double montant;
    
    
    @ManyToOne
    @JoinColumn(name="id_conseiller")
    private ConseillerEntity conseiller;
    
    @ManyToOne
    @JoinColumn(name="numero_compte")
    private CompteEntity compte;
    public OperationEntity() {
    }

    public OperationEntity(String operation_date, double montant) {
        this.operation_date = operation_date;
        this.montant = montant;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(String operation_date) {
        this.operation_date = operation_date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public CompteEntity getCompteEntity() {
        return compte;
    }

    public void setCompte(CompteEntity compte) {
        this.compte = compte;
    }   
}

