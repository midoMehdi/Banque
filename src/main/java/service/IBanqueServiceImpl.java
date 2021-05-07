/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserEntity;
import dao.CompteEntity;
import dao.ConseillerEntity;
import dao.OperationEntity;
import dao.RetraitEntity;
import dao.VersementEntity;
import java.util.Date;
import java.util.List;
import dao.IBanqueDAO;
import dao.MessageEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mehdi
 */
@Service
public class IBanqueServiceImpl implements IBanqueService {
    
    @Autowired
    private IBanqueDAO banqueDao;

    public void setBanqueDao(IBanqueDAO banqueDao) {
        this.banqueDao = banqueDao;
    }

    @Override
    public UserEntity addClient(UserEntity client) {
        return banqueDao.addClient(client);
    }

    @Override
    public CompteEntity addCompte(CompteEntity compte, Long codeClient) {
        return banqueDao.addCompte(compte, codeClient);
    }

    @Override
    public void verser(Long codeCompte, double montant,String date) {
        banqueDao.addOperation(new VersementEntity(date,montant), codeCompte);
        CompteEntity compte = banqueDao.consulterCompte(codeCompte);
        if(compte != null){
            compte.setSolde(compte.getSolde() + montant);
            banqueDao.updateCompte(compte);
        }
        
        
    }

    @Override
    public void retirer(Long codeCompte, double montant, String date) {
        banqueDao.addOperation(new RetraitEntity(date,montant), codeCompte);
        CompteEntity compte = banqueDao.consulterCompte(codeCompte);
        
        if(compte != null){
            compte.setSolde(compte.getSolde() - montant);
            banqueDao.updateCompte(compte);
        }
    }

    @Override
    public void virement(double montant, Long codeCompteOne, Long codeCompteTwo, String date) {
        retirer(codeCompteOne,montant,date);
        verser(codeCompteTwo,montant,date);
    }

    @Override
    public CompteEntity consulterCompte(Long codeCompte) {
        return banqueDao.consulterCompte(codeCompte);
    }

    @Override
    public List<OperationEntity> ConsultetOperations(Long codeCompte) {
        return banqueDao.ConsultetOperations(codeCompte);
    }

    @Override
    public UserEntity consulterClient(Long codeClient) {
        return banqueDao.consulterClient(codeClient);
    }

    @Override
    public List<UserEntity> consulterClients(String key_word) {
        return banqueDao.consulterClients(key_word);
    }

    @Override
    public List<CompteEntity> getComptesByClient(Long codeClient) {
        return banqueDao.getComptesByClient(codeClient);
    }
    
    
    @Override
    public void addConseillers(List<ConseillerEntity> conseillers) {
        banqueDao.addConseillers(conseillers);
    }

    @Override
    public void addMessage(MessageEntity message, String id_conseiller) {
        banqueDao.addMessage(message, id_conseiller);
    }

    @Override
    public List<CompteEntity> consulterComptesParConseiller(String id_conseiller) {
        return banqueDao.consulterComptesParConseiller(id_conseiller);
    }
    
     @Override
    public ConseillerEntity consulterConseiller(String id_conseiller) {
        
        return banqueDao.consulterConseiller(id_conseiller);
    }

    @Override
    public void operationByConseiller(String id_conseiller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessageEntity> consulterMessagesParConseiller(String id_conseiller) {
        return banqueDao.consulterMessagesParConseiller(id_conseiller);
    }

    

   
    
}
