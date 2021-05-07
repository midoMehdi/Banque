/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dao.CompteEntity;
import dao.IBanqueDAO;
import dao.OperationEntity;
import dao.UserEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mehdi
 */
@Repository
public class IBanqueDAOImpl implements IBanqueDAO {
    //pour gerer la persistance on va appeler Entitymanager
    @PersistenceContext(name="GestionBanquePU")
    private EntityManager entity_manager;
    
    public EntityManager getEm() {
        return entity_manager;
    }
    public void setEm(EntityManager em) {
        this.entity_manager = em;
    }
    
    @Transactional    
    @Override
    public UserEntity addClient(UserEntity user) {
        entity_manager.persist(user);
        return user;
    }

    @Transactional
    @Override
    public CompteEntity addCompte(CompteEntity compte, Long codeClient) {
        UserEntity user = entity_manager.find(UserEntity.class, codeClient);
        compte.setUserEntity(user);
        entity_manager.persist(compte);
        return compte;
    }

    @Transactional
    @Override
    public OperationEntity addOperation(OperationEntity operation, Long codeCompte) {
        CompteEntity compte  = consulterCompte(codeCompte);
        operation.setCompte(compte);
        entity_manager.persist(operation);
        return operation;
    }
    @Transactional
    @Override
    public void updateCompte(CompteEntity compte) {
        
        entity_manager.merge(compte);
    }
    
    @Transactional
    @Override
    public void deleteCompte(CompteEntity compte) {
        
        entity_manager.remove(compte);
    }

    @Transactional(readOnly = true)
    @Override
    public CompteEntity consulterCompte(Long codeCompte) {
        CompteEntity compte = entity_manager.find(CompteEntity.class, codeCompte);
        
        return compte;
    }

    @Transactional
    @Override
    public List<OperationEntity> ConsultetOperations(Long codeCompte) {
        Query query = entity_manager.createQuery("SELECT op FROM OperationEntity op WHERE op.compte.code = :value");
        return query.setParameter("value", codeCompte).getResultList();
    }
    

    @Transactional(readOnly = true)
    @Override
    public UserEntity consulterClient(Long codeClient) {
        UserEntity client = entity_manager.find(UserEntity.class, codeClient);
        return client;
    }

    @Transactional
    @Override
    public List<UserEntity> consulterClients(String key_word) {
        Query query = entity_manager.createQuery("select clt from UserEntity clt where clt.name like : value");
        return query.setParameter("value", "%"+key_word+"ù").getResultList();
    }

    @Transactional
    @Override
    public List<CompteEntity> getComptesByClient(Long codeClient) {
        Query query = entity_manager.createQuery("select cpt from CompteEntity cpt where cpt.user.id = :value");
        return query.setParameter("value", codeClient).getResultList();
    } 
    @Transactional
    @Override
    public List<CompteEntity> getTypeCompte(Long codeCompte){
        Query query = entity_manager.createQuery("SELECT cpt FROM CompteEntity cpt WHERE cpt.code = :value");

        return query.setParameter("value", codeCompte).getResultList();
    }
    
    @Transactional
    @Override
    public void addConseillers(List<ConseillerEntity> conseillers){
        for(ConseillerEntity ce : conseillers){
            if(entity_manager.find(ConseillerEntity.class, ce.getId_conseiller()) == null ){
                entity_manager.persist(ce);
            }
        }
    }
    @Transactional
    @Override
    public ConseillerEntity consulterConseiller(String id_conseiller) {
        return entity_manager.find(ConseillerEntity.class, id_conseiller);
    }
    @Transactional
    @Override
    public void addMessage(MessageEntity me, String id_conseiller) {
        ConseillerEntity conseiller = consulterConseiller(id_conseiller);
        me.setConseiller(conseiller);
        entity_manager.persist(me);
    }
    @Transactional
    @Override
    public List<CompteEntity> consulterComptesParConseiller(String id_conseiller) {
        Query query = entity_manager.createQuery("SELECT cpt FROM CompteEntity cpt WHERE cpt.conseiller.id_conseiller = :value");
        return query.setParameter("value", id_conseiller).getResultList();
    }
    @Transactional
    @Override
    public void operationByConseiller(String id_conseiller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessageEntity> consulterMessagesParConseiller(String id_conseiller) {
        Query query = entity_manager.createQuery("SELECT msg FROM MessageEntity msg WHERE msg.conseiller.id_conseiller = :value ORDER BY msg.date_message DESC");
        return query.setParameter("value", id_conseiller).getResultList();
    }

    
}
