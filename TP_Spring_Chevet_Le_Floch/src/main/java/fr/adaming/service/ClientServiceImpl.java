package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;

@Service(value="clientServiceBean")
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	IClientDao clientDao;
	
	
	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	
	
	@Override
	public List<Categorie> getAllCategorieService() {
		return clientDao.getAllCategorie();
	}

	@Override
	public List<Produit> getAllProduitCategorieService(Categorie categorie) {
		
		return clientDao.getAllProduitByCategorie(categorie);
	}

	@Override
	public int selectionnerProduitByNameService(int id_produit) {
		
		try {
			clientDao.selectionnerProduitByName(id_produit);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		

	}

	@Override
	public List<Produit> getAllProduitSelectionneService() {
		
		return clientDao.getAllProduitSelectionne();
	}


	@Override
	public int EnregistrerClientCommandeService(Client client) {
		
		try {
			clientDao.EnregistrerClientCommande(client);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	
		
	}

	@Override
	public List<Produit> chercherProduitMotCleService(String motCle) {
		
		return clientDao.chercherProduitMotCle(motCle);
	}

	@Override
	public Categorie getCategorieByNameService(String nom_categorie) {
		
		return clientDao.getCategorieByName(nom_categorie);
	}

	@Override
	public List<String> getAllCategorieNameService() {
	
		return clientDao.getAllCategorieName();
	}

	@Override
	public List<String> getAllProduitNameService() {
		
		return clientDao.getAllProduitName();
	}

	@Override
	public void remiseZeroSelectionneService() {

		clientDao.remiseZeroSelectionne();
		
	}

}
