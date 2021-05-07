/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CompteCourantEntity;
import dao.CompteEntity;
import dao.CompteEpargneEntity;
import dao.ConseillerEntity;

import dao.MessageEntity;
import dao.OperationEntity;
import dao.RetraitEntity;
import dao.UserEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.IBanqueService;


/**
 *
 * @author Mehdi
 */
@Controller
public class BanqueController {

    @Autowired
    IBanqueService iBanqueService;
  
    @RequestMapping(value="accueil", method=RequestMethod.GET)
    String initAccueil()
    {
        return "accueil";
    }
    
  
    
   
    @RequestMapping(value="sign", method=RequestMethod.GET)
    String initSign()
    {
        /**
         * creer trois conseiller par défaut
         */
        ConseillerEntity conseillerOne = new ConseillerEntity("1","conseillerOne",
                "conseillerOne","conseillerOne@conseillerOne.com","conseillerOne");
        
        ConseillerEntity conseillerTwo = new ConseillerEntity("2","conseillerTwo",
                "conseillerTwo","conseillerTwo@conseillerTwo.com","conseillerTwo");
        
        ConseillerEntity conseillerThree = new ConseillerEntity("3","conseillerThree",
                "conseillerThree","conseillerThree@conseillerThree.com","conseillerThree");
        List<ConseillerEntity> conseillers = new ArrayList<>();
        conseillers.add(conseillerOne);  conseillers.add(conseillerTwo);  conseillers.add(conseillerThree);
        
        iBanqueService.addConseillers(conseillers);
        return "connexion";
    }
    
    @RequestMapping(value="signIn", method=RequestMethod.GET)
    String initSignIn()
    {
        
        
        return "enregistrement";
    }
    @RequestMapping(value="enregistrement", method=RequestMethod.GET)
    String initEnregistrement()
    {
        return "enregistrement";
    }
    
    @RequestMapping(value="enregistrement", method=RequestMethod.POST)
    ModelAndView signIn(HttpServletRequest request)
    {
        
        String codeCompte = request.getParameter("codeCompte");
        ModelAndView mv = new ModelAndView("enregistrement");
        
        if( !codeCompte.equals("") || codeCompte.length() > 0 ){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String adresse = request.getParameter("adresse");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassWord");
            String email = request.getParameter("email");
            Long phoneNumber = Long.parseLong(request.getParameter("txtEmpPhone"));
            String typeCompte = request.getParameter("compteSelected");
            String gender = request.getParameter("gender");
            if(firstName != null && lastName != null && adresse != null && password != null && confirmPassword != null &&
                    request.getParameter("txtEmpPhone") != null && typeCompte != null && gender != null){
                if(!password.equals(confirmPassword)){
                mv.addObject("signInMessage","Mot de passe : erreur, échec création du compte !");
                return mv;
            }
            else {
                CompteEntity compteSearch = iBanqueService.consulterCompte(Long.parseLong(codeCompte));
                if(compteSearch == null){
                    UserEntity user = new UserEntity(firstName, lastName,adresse, email, phoneNumber,gender);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                    Date date = new Date();
                    CompteEntity compte ;
                    
                    
                    if(typeCompte.equals("Compte Courant")){
                        compte = new CompteCourantEntity(Long.parseLong(codeCompte),user,password,0,formatter.format(date), null);
                    }
                    else if(typeCompte.equals("Compte Epargne")){
                        compte = new CompteEpargneEntity(Long.parseLong(codeCompte),user,password,0,formatter.format(date),null);
                    }
                    else {
                        mv.addObject("signInMessage","selectionnez un type de compte !");
                        return mv;
                    }
                    /**
                     * affecter un conseiller aléatoirement
                     */
                    Random random = new Random();
                    switch(random.nextInt(3)){
                        case 0://(id)le conseiller du compte est conseillerOne
                            ConseillerEntity conseillerOne = iBanqueService.consulterConseiller("0");
                            compte.setConseiller(conseillerOne);
                            break;
                        case 1:
                            ConseillerEntity conseillerTwo = iBanqueService.consulterConseiller("1");
                            compte.setConseiller(conseillerTwo);
                            break;
                        case 2:
                            ConseillerEntity conseillerThree = iBanqueService.consulterConseiller("2");
                            compte.setConseiller(conseillerThree);
                            break;
                    }
                    iBanqueService.addClient(user);
                    iBanqueService.addCompte(compte, user.getId());
                    mv.addObject("signInMessage","Création du compte avec succès.");
                    return mv;
                }
                else {
                    mv.addObject("signInMessage","Login déjà existé !");
                    return mv;
                }
            }           
        }
        else {
            mv.addObject("signInMessage","Numéro du compte: erreur, échec création du compte !");
            return mv;
        }
                
            }
            else {
                mv.addObject("signInMessage","formulaire incomplète !");
                return mv;
            }
            
    }
    
    @RequestMapping(value="connect", method=RequestMethod.GET)
    String initConnect()
    {
        return "sign";
    }
    
    @RequestMapping(value="connect", method=RequestMethod.POST)
    ModelAndView connect(HttpServletRequest request)
    {
        String numeroCompte = request.getParameter("numCompte");
        String password = request.getParameter("password");
        
        
            CompteEntity compteSearch = iBanqueService.consulterCompte(Long.parseLong(numeroCompte));
            if(compteSearch != null){
                if(compteSearch.getPassword().equals(password)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("getsession",compteSearch);
                    ModelAndView mv = new ModelAndView("accueil");
                    mv.addObject("firstName",compteSearch.getUserEntity().getFirstName());
                    mv.addObject("numeroDuCompte", compteSearch.getCode());
                    mv.addObject("conseiller", compteSearch.getConseiller().getFirst_name());
                    mv.addObject("TypeDueCompte", compteSearch);
                    mv.addObject("dateCreation", compteSearch.getCreation_date());
                    mv.addObject("soldeCompte",compteSearch.getSolde());
                    mv.addObject("nomUser",compteSearch.getUserEntity().getFirstName());
                    mv.addObject("nom", compteSearch.getUserEntity().getLastName());
                    mv.addObject("adresse", compteSearch.getUserEntity().getAdresse());
                    mv.addObject("email", compteSearch.getUserEntity().getEmail());
                    mv.addObject("numeroDuTelephone", compteSearch.getUserEntity().getPhoneNumber());
                //iBanqueService.getComptesByClient(compteSearch.getCode());
                    mv.addObject("TypeDuCompte", compteSearch);
                //List<CompteEntity> comptes = compteSearch.getUserEntity().getComptes();
                    return mv;
                }
                else {
                    ModelAndView mv = new ModelAndView("connexion");
                    mv.addObject("connectMessage", "Erreur login / Password");
                    return mv;
                }
            }
            else {
                ModelAndView mv = new ModelAndView("connexion");
                mv.addObject("connectMessage", "Erreur login / Password");
                return mv;
            }
        
    }
    
    @RequestMapping(value="deconnecter", method=RequestMethod.POST)
    String deconnecterSession(HttpServletRequest request)
    {
        HttpSession session =  request.getSession(true);
        session.invalidate();
        return "connexion";
    }
    
    @RequestMapping(value="retirer", method=RequestMethod.POST)
    ModelAndView retirerMontant(HttpServletRequest request)
    {
        String montantARetirer = request.getParameter("retirer");
        ModelAndView mv = new ModelAndView("accueil");
        HttpSession session =  request.getSession();
        CompteEntity compte = (CompteEntity) session.getAttribute("getsession");
        mv.addObject("firstName",compte.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compte.getCode());
        mv.addObject("conseiller", compte.getConseiller().getFirst_name());
        mv.addObject("dateCreation", compte.getCreation_date());
        mv.addObject("soldeCompte",compte.getSolde());        
        mv.addObject("nomUser",compte.getUserEntity().getFirstName());        
        mv.addObject("nom", compte.getUserEntity().getLastName());        
        mv.addObject("adresse", compte.getUserEntity().getAdresse());
        mv.addObject("email", compte.getUserEntity().getEmail());
        mv.addObject("numeroDuTelephone", compte.getUserEntity().getPhoneNumber());
        mv.addObject("TypeDuCompte", compte);
        if(compte.toString().toLowerCase().equals("comptecourant")){
            if(montantARetirer.length() == 0){
                mv.addObject("retirerMontant", "information incomplète");
                return mv;
            }
            if(compte == null){
                mv.addObject("retirerMontant", "error");
                return mv;
            }
            if(Double.parseDouble(montantARetirer) > 0){
                if(Double.parseDouble(montantARetirer) > compte.getSolde()){
                    mv.addObject("retirerMontant", "Solde insuffisant");
                    return mv;
                }
                else {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                    Date date = new Date();
                    iBanqueService.retirer(compte.getCode(), Double.parseDouble(montantARetirer), formatter.format(date));
                    compte.setSolde(compte.getSolde() - Double.parseDouble(montantARetirer));
                    mv.addObject("soldeCompte",compte.getSolde());
                    mv.addObject("retirerMontant","opération réussie");
                    return mv;
                }
            }
            else {
                mv.addObject("retirerMontant","opération échouée");
                return mv;
            }
        }
        else {
            mv.addObject("retirerMontant","impossible de retirer avec ce compte.");
            return mv;
        }
    }
    @RequestMapping(value="verser", method=RequestMethod.POST)
    ModelAndView verserMontant(HttpServletRequest request)
    {
        String montantAVerser = request.getParameter("verser");
        ModelAndView mv = new ModelAndView("accueil");
        HttpSession session =  request.getSession();
        CompteEntity compte = (CompteEntity) session.getAttribute("getsession");
        mv.addObject("firstName",compte.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compte.getCode());
        mv.addObject("conseiller", compte.getConseiller().getFirst_name());
        mv.addObject("dateCreation", compte.getCreation_date());
        mv.addObject("soldeCompte",compte.getSolde());        
        mv.addObject("nomUser",compte.getUserEntity().getFirstName());        
        mv.addObject("nom", compte.getUserEntity().getLastName());        
        mv.addObject("adresse", compte.getUserEntity().getAdresse());
        mv.addObject("email", compte.getUserEntity().getEmail());
        mv.addObject("numeroDuTelephone", compte.getUserEntity().getPhoneNumber());
        mv.addObject("TypeDuCompte", compte);
        if(montantAVerser.length() == 0){
            mv.addObject("verserMontant", "information incomplète");
                    mv.addObject("soldeCompte",compte.getSolde());
            return mv;
        }
        
        if(compte == null){
            mv.addObject("verserMontant", "error");
                    mv.addObject("soldeCompte",compte.getSolde());
            return mv;
        }
        if(Double.parseDouble(montantAVerser) > 0){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();
            iBanqueService.verser(compte.getCode(), Double.parseDouble(montantAVerser), formatter.format(date));
            compte.setSolde(compte.getSolde() + Double.parseDouble(montantAVerser));
            mv.addObject("soldeCompte",compte.getSolde());
            mv.addObject("verserMontant","opération réussie");
            return mv;
        }
        else {
            mv.addObject("verserMontant","opération échouée");
                    mv.addObject("soldeCompte",compte.getSolde());
            return mv;
        }
    }
    
    @RequestMapping(value="virement", method=RequestMethod.POST)
    ModelAndView virementMontant(HttpServletRequest request)
    {
        
        String montantVirement = request.getParameter("virementCombien");
        String compteTwoString = request.getParameter("virementVers");
        ModelAndView mv = new ModelAndView("accueil");
        HttpSession session =  request.getSession();
        CompteEntity compteOne = (CompteEntity) session.getAttribute("getsession");
        mv.addObject("firstName",compteOne.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compteOne.getCode());
        mv.addObject("conseiller", compteOne.getConseiller().getFirst_name());
        mv.addObject("dateCreation", compteOne.getCreation_date());
        mv.addObject("soldeCompte",compteOne.getSolde());        
        mv.addObject("nomUser",compteOne.getUserEntity().getFirstName());        
        mv.addObject("nom", compteOne.getUserEntity().getLastName());        
        mv.addObject("adresse", compteOne.getUserEntity().getAdresse());
        mv.addObject("email", compteOne.getUserEntity().getEmail());
        mv.addObject("numeroDuTelephone", compteOne.getUserEntity().getPhoneNumber());
        mv.addObject("TypeDuCompte", compteOne);
        if(compteOne.toString().toLowerCase().equals("comptecourant")){
            if(compteTwoString.length() == 0 ||montantVirement.length() == 0){
                mv.addObject("virementMontant", "information incomplète");
                return mv;
            }
            Long compteTwoCode = Long.parseLong(compteTwoString);
            CompteEntity compteTwo = iBanqueService.consulterCompte(compteTwoCode);
        
            if(compteOne == null){
                mv.addObject("virementMontant", "error");
                mv.addObject("soldeCompte",compteOne.getSolde());
                return mv;
            }
            if(compteTwo == null){
                mv.addObject("soldeCompte",compteOne.getSolde());
                mv.addObject("virementMontant", "Compte inéxistant !");
                return mv;
            }
            if(Double.parseDouble(montantVirement) > 0){
                if(Double.parseDouble(montantVirement) > compteOne.getSolde()){
                    mv.addObject("virementMontant", "Solde insuffisuant");
                    return mv;
                }
                else {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                    Date date = new Date();
                    iBanqueService.virement(Double.parseDouble(montantVirement),compteOne.getCode(),compteTwoCode, formatter.format(date));
                    mv.addObject("virementMontant","opération réussie");
                    compteOne.setSolde(compteOne.getSolde() - Double.parseDouble(montantVirement));
                    compteTwo.setSolde(compteTwo.getSolde() + Double.parseDouble(montantVirement));
                    mv.addObject("soldeCompte",compteOne.getSolde());
                    return mv;
                }
            }
            else {
                mv.addObject("virementMontant","opération échouée");
                mv.addObject("soldeCompte",compteOne.getSolde());
                return mv;
            }
        }
        else {
            mv.addObject("virementMontant","impossible de retirer avec ce compte.");
            return mv;
        }
        
    }
    
    @RequestMapping (value="operations", method=RequestMethod.POST)
    protected ModelAndView displayDataOperation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = new ModelAndView("operations");
        HttpSession session =  request.getSession();
        CompteEntity compte = (CompteEntity) session.getAttribute("getsession");
        mv.addObject("firstName",compte.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compte.getCode());
        if(compte == null){
            mv.addObject("infoError","error compte inéxistant");
            return mv;
        }
        List<OperationEntity> operationsList = iBanqueService.ConsultetOperations(compte.getCode());
        mv.addObject("operationsData", operationsList);
        
            
            return mv;
    }
    
    
    @RequestMapping (value="anotherCompte", method=RequestMethod.POST)
    protected ModelAndView addAnotherCompte(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session =  request.getSession();
        CompteEntity compteOne = (CompteEntity) session.getAttribute("getsession");
        ModelAndView mv = new ModelAndView("accueil");
        mv.addObject("firstName",compteOne.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compteOne.getCode());
        mv.addObject("conseiller", compteOne.getConseiller().getFirst_name());
        mv.addObject("dateCreation", compteOne.getCreation_date());
        mv.addObject("soldeCompte",compteOne.getSolde());        
        mv.addObject("nomUser",compteOne.getUserEntity().getFirstName());        
        mv.addObject("nom", compteOne.getUserEntity().getLastName());        
        mv.addObject("adresse", compteOne.getUserEntity().getAdresse());
        mv.addObject("email", compteOne.getUserEntity().getEmail());
        mv.addObject("numeroDuTelephone", compteOne.getUserEntity().getPhoneNumber());
        mv.addObject("TypeDuCompte", compteOne);
        String numeroCompte = request.getParameter("codeCompte");
        if( !numeroCompte.equals("") || numeroCompte.length() > 0 ){
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassWord");
            String typeCompte = request.getParameter("compteSelected");
            if(!password.equals(confirmPassword)){
                mv.addObject("signInMessage","Mot de passe : erreur, échec création du compte !");
                return mv;
            }
            else {
                CompteEntity compteSearch = iBanqueService.consulterCompte(Long.parseLong(numeroCompte));
                if(compteSearch == null){
                    UserEntity user = compteOne.getUserEntity();
                    //UserEntity user = new UserEntity(firstName, lastName,adresse, email, phoneNumber);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                    Date date = new Date();
                    CompteEntity compte;
                    if(typeCompte.equals("Compte Courant")){
                        compte = new CompteCourantEntity(Long.parseLong(numeroCompte),user,password,0,formatter.format(date),compteOne.getConseiller());
                    }
                    else if(typeCompte.equals("Compte Epargne")){
                        compte = new CompteEpargneEntity(Long.parseLong(numeroCompte),user,password,0,formatter.format(date),compteOne.getConseiller());
                    }
                    else {
                        mv.addObject("signInMessage","selectionnez un type de compte !");
                        return mv;
                    }
                    //iBanqueService.addClient(user);
                    iBanqueService.addCompte(compte, user.getId());
                    mv.addObject("signInMessage","Création du compte avec succès.");
                    return mv;
                }
                else {
                    mv.addObject("signInMessage","Login déjà existé !");
                    return mv;
                }
            }           
        }
        else {
            mv.addObject("signInMessage","Numéro du compte: erreur, échec création du compte !");
            return mv;
        }
    } 
    
    
    @RequestMapping (value="comptes", method=RequestMethod.POST)
    protected ModelAndView displayDataCompte(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = new ModelAndView("comptes");
        HttpSession session =  request.getSession();
        CompteEntity compte = (CompteEntity) session.getAttribute("getsession");
        mv.addObject("firstName",compte.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compte.getCode());
        if(compte == null){
            mv.addObject("infoError","error compte inéxistant");
            return mv;
        }
        List<CompteEntity> comptesList = iBanqueService.getComptesByClient(compte.getUserEntity().getId());
        if(comptesList != null){
            mv.addObject("comptesData", comptesList);
            return mv;
        }
        else {
            mv.addObject("infoError", "il n'existe aucun compte");
             return mv;
        }
   
    }
    
    @RequestMapping (value="conseiller", method=RequestMethod.POST)
    protected ModelAndView toConseillerPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = new ModelAndView("envoiMessage");
        HttpSession session =  request.getSession();
        CompteEntity compte = (CompteEntity) session.getAttribute("getsession");
        mv.addObject("firstName",compte.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compte.getCode());
        mv.addObject("conseiller", compte.getConseiller().getFirst_name());
        return mv;
   
    }
    
     @RequestMapping (value="conseiller", method=RequestMethod.GET)
    protected ModelAndView sendMessageToConseiller(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = new ModelAndView("envoiMessage");
        HttpSession session =  request.getSession();
        CompteEntity compte = (CompteEntity) session.getAttribute("getsession");
        mv.addObject("firstName",compte.getUserEntity().getFirstName());
        mv.addObject("numeroDuCompte", compte.getCode());
        mv.addObject("conseiller", compte.getConseiller().getFirst_name());
        String messageText = request.getParameter("messageText");
        if(messageText == null){
            mv.addObject("Message", "Aucun message!");
            return mv;
        }
        else { 
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();
            MessageEntity msgEntity = new MessageEntity(compte,messageText,compte.getConseiller(),formatter.format(date));
            iBanqueService.addMessage(msgEntity, compte.getConseiller().getId_conseiller());
            mv.addObject("Message", "Message envoyé avec succès.");
            return mv;
        }

        
    }
    @RequestMapping (value="connectConseiller", method=RequestMethod.POST)
    protected ModelAndView conseillerConnecter(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String id_conseiller = request.getParameter("id_conseiller");
        String password = request.getParameter("password");
        ConseillerEntity conseiller = iBanqueService.consulterConseiller(id_conseiller);
            if(conseiller != null){
                if(conseiller.getPassword().equals(password)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("getsession",conseiller);
                    ModelAndView mv = new ModelAndView("conseiller");
                    mv.addObject("firstName",conseiller.getFirst_name());
                    List<CompteEntity> comptesList = iBanqueService.consulterComptesParConseiller(id_conseiller);
                    List<MessageEntity> messagesList = iBanqueService.consulterMessagesParConseiller(id_conseiller);
                    mv.addObject("comptesData", comptesList);
                    mv.addObject("messagesData", messagesList);
                    return mv;
                }
                else {
                    ModelAndView mv = new ModelAndView("connexion");
                    mv.addObject("connectMessage", "Erreur login / Password");
                    return mv;
                }
            }
            else {
                ModelAndView mv = new ModelAndView("connexion");
                mv.addObject("connectMessage", "conseiller n'existe pas.");
                return mv;
            }
    }
}
