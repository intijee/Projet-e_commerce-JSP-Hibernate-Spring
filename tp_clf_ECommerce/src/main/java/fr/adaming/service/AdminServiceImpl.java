package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.entities.Role;


/**
 * Classe qui sert à implementer les règles de gestion pour les méthodes de l'Admin
 *
 */
@Service("adminServiceBean")
@Transactional
public class AdminServiceImpl implements IAdminService {

	// Instanciation d'un objet de type AdminDao pour utliser ses méthodes à partir de son interface
	@Autowired
	IAdminDao adminDao;
	
	
	/**
	 * @param adminDao the adminDao to set
	 */
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public int isExistService(Admin admin) {
		
		return adminDao.isExist(admin);
		
	}
	
	@Override
	public int ajouterProduitService(Produit produit) {
		
		// Afin d'obtenir un retour sur la réussite ou non de la méthode
		try {
			
		adminDao.ajouterProduit(produit);
		return 1;
		
		} catch(Exception e){
			
		return 0;
		
		}
	}

	@Override
	public int supprimerProduitByNameService(int id_produit) {
		
		try {
			
			adminDao.supprimerProduitByName(id_produit);
			return 1;
			
		} catch (Exception e) {
			
			return 0;
			
		}
		
	}

	@Override
	public int modifierProduitService(int id_produit, Produit produit) {
		try {
			
			adminDao.modifierProduit(id_produit, produit);
			return 1;
			
		} catch (Exception e) {
			
			return 0;
			
		}
		
	}

	@Override
	public Produit chercherProduitByNameService(String designation_produit) {
		return adminDao.chercherProduitByName(designation_produit);
	}

	@Override
	public List<Produit> getAllProduitService() {
		return adminDao.getAllProduit();
	}

	@Override
	public int ajouterCategorieService(Categorie categorie) {
		
		try {
			
			adminDao.ajouterCategorie(categorie);
			
			return 1; 
			
		} catch (Exception e) {
			
			return 0;
			
		}
		
	
	
	}

	@Override
	public int modifierCategorieService(int id_categorie, Categorie categorie) {
		
		try {
			
			adminDao.modifierCategorie(id_categorie, categorie);
			
			return 1; 
			
		} catch (Exception e) {
			
			return 0;
			
		}
	}

	@Override
	public int modifierRoleService(Admin admin, Role role) {
		// il pourrait être judicieux de n'accepter en role que ROLE_ADMIN_CAT et ROLE_ADMIN_PROD
		try {
			
			adminDao.modifierRole(admin, role);
			
			return 1; 
			
		} catch (Exception e) {
			
			return 0;
			
		}
	}

	@Override
	public int ajouterAdminService(Admin admin) {
		
		try {
			
			adminDao.ajouterAdmin(admin);
			
			return 1; 
			
		} catch (Exception e) {
			
			return 0;
			
		}
	}

	@Override
	public int supprimerAdminService(int id_admin) {
		
		try {
			
			adminDao.supprimerAdmin(id_admin);
			
			return 1; 
			
		} catch (Exception e) {
			
			return 0;
			
		}
	}

	@Override
	public Role getRoleByNameService(String nom_role) {

		return adminDao.getRoleByName(nom_role);
		
	}

	@Override
	public Admin getAdminByMailService(String mail_admin) {
		
		return adminDao.getAdminByMail(mail_admin);
		
	}




}
