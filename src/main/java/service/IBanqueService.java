/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserEntity;
import dao.CompteEntity;
import dao.ConseillerEntity;
import dao.MessageEntity;
import dao.OperationEntity;
import java.util.List;

/**
 *
 * @author Mehdi
 */
public interface IBanqueService {
    public UserEntity addClient(UserEntity client);
    public CompteEntity addCompte(CompteEntity compte,  Long codeClient);
    public void verser(Long codeCompte, double montant, String date);
    public void retirer(Long codeCompte, double montant,String date);
    public void virement(double montant, Long codeCompteOne, Long codeCompteTwo, String date);
    public CompteEntity consulterCompte(Long codeCompte);
    public List<OperationEntity> ConsultetOperations(Long codeCompte);
    public UserEntity consulterClient(Long codeClient);
    public List<UserEntity> consulterClients(String key_word);
    public List<CompteEntity> getComptesByClient(Long codeClient);
    
    public void addConseillers(List<ConseillerEntity> conseillers);
    public ConseillerEntity consulterConseiller(String id_conseiller);
    public void addMessage(MessageEntity message,String id_conseiller);
    public List<CompteEntity> consulterComptesParConseiller(String id_conseiller);
    public List<MessageEntity> consulterMessagesParConseiller(String id_conseiller);
    public void operationByConseiller(String id_conseiller);
    
}
