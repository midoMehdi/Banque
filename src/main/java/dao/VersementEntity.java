/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.OperationEntity;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Mehdi
 */
@Entity
@DiscriminatorValue("versement")
public class VersementEntity extends OperationEntity {

    public VersementEntity() {
    }

    public VersementEntity(String operation_date, double montant) {
        super(operation_date, montant);
    }

    @Override
    public String toString() {
        return "versement";
    }
    

   
    
    
}
