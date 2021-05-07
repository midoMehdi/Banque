/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author Mehdi
 */
@Entity
@DiscriminatorValue("compteEpargne")
public class CompteEpargneEntity extends CompteEntity {
    

    public CompteEpargneEntity() {
    }

    

    public CompteEpargneEntity(Long code, UserEntity user, String password, double solde, String Creation_date,ConseillerEntity conseiller) {
        super(code, user,password, solde, Creation_date,conseiller);
        
    }
    @Override
    public String toString() {
        return "CompteEpargne";
    }

    
    
    
}
