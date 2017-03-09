package fr.adaming.service;

import java.util.List;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;


/**
 * Interface qui définit les signatures des méthodes pour la couche Metier
 *
 */

public interface IAdminService {
	

	
	/**
	 * Methode gérant la connexion pour un admin
	 * @param admin
	 * @return un entier qui vérifie l'existence d'un admin ou non 
	 */
	public int isExistService(Admin admin);


	/**
	 * Méthode pour ajouter un produit dans la base de données
	 * @param produit
	 * @return un entier pour savoir si l'ajout a reussi
	 */
	public int ajouterProduitService(Produit produit);
	

	/**
	 * Méthode pour supprimer un produit dans la base de données
	 * @param id_produit
	 * @return un entier pour savoir si la suppression a reussi
	 */
	public int supprimerProduitByNameService(int id_produit);
	

	/**
	 * Méthode pour modifier un produit dans la base de données
	 * @param id_produit pour trouver le produit a modifier
	 * @param produit qui contient les nouvelles informations du produit
	 * @return un entier pour savoir si la modification a reussi
	 */
	public int modifierProduitService(int id_produit, Produit produit);
	

	/**
	 * Méthode pour consulter l'état d'un produit
	 * @param designation_produit
	 * @return le produit trouvé (si il existe)
	 */
	public Produit chercherProduitByNameService(String designation_produit);
	

	/**
	 * Methode pour consulter tous les produits
	 * @return la liste des produits de la base de données
	 */
	public List<Produit> getAllProduitService();

}
