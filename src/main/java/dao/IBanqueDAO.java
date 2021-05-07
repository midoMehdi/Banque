/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dao.CompteEntity;
import dao.OperationEntity;
import dao.UserEntity;
import java.util.List;



/**
 *
 * @author Mehdi
 */
public interface IBanqueDAO {
    public UserEntity addClient(UserEntity user);
    public CompteEntity addCompte(CompteEntity compte,  Long codeClient);
    public OperationEntity addOperation(OperationEntity operation,Long codeCompte);
    //public double virement(double montant, String codeCompteOne, String codeCompteTwo);
    public CompteEntity consulterCompte(Long codeCompte);
    public List<OperationEntity> ConsultetOperations(Long codeCompte);
    public UserEntity consulterClient(Long codeClient);
    public List<UserEntity> consulterClients(String key_word);
    public List<CompteEntity> getComptesByClient(Long codeClient);
    public void updateCompte(CompteEntity compte);
    public void deleteCompte(CompteEntity compte);
    public List<CompteEntity> getTypeCompte(Long codeCompte);
    
    public void addConseillers(List<ConseillerEntity> conseillers);
    public ConseillerEntity consulterConseiller(String id_conseiller);
    public void addMessage(MessageEntity message,String id_conseiller);
    public List<CompteEntity> consulterComptesParConseiller(String id_conseiller);
    public List<MessageEntity> consulterMessagesParConseiller(String id_conseiller);
    public void operationByConseiller(String id_conseiller);
    
    
}
