/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Mehdi
 */
@Entity
@DiscriminatorValue("retrait")
public class RetraitEntity extends OperationEntity {

    public RetraitEntity() {
    }

    public RetraitEntity(String operation_date, double montant) {
        super(operation_date, montant);
    }

    @Override
    public String toString() {
        return "retrait";
    }
    
}
