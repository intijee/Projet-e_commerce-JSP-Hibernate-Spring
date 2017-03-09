package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;


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



}
