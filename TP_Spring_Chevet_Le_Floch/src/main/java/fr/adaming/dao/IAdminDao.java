package fr.adaming.dao;

import java.util.List;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;



/**
 * Interface qui définit les signatures des méthodes Admin
 *
 */
public interface IAdminDao {
	
	

	/**
	 * Methode gérant la connexion pour un admin
	 * @param admin
	 * @return un entier pour savoir si il existe un admin qui repond a ces critères
	 */
	public int isExist(Admin admin);
	
	/**
	 * Méthode pour ajouter un produit dans la base de données
	 * @param produit
	 */
	public void ajouterProduit(Produit produit);
	
	
	/**
	 * Méthode pour supprimer un produit dans la base de données
	 * @param id_produit 
	 */
	public void supprimerProduitByName(int id_produit);
	

	/**
	 * Méthode pour modifier un produit dans la base de données
	 * @param id_produit pour trouver le produit a modifier
	 * @param produit qui contient les nouvelles informations du produit
	 */
	public void modifierProduit (int id_produit, Produit produit);
	
	
	/**
	 * Méthode pour consulter l'état d'un produit
	 * @param  designation_produit
	 * @return le produit trouvé (si il existe)
	 */
	public Produit chercherProduitByName(String designation_produit);
	
	
	
	/**
	 * Methode pour consulter tous les produits
	 * @return la liste des produits de la base de données
	 */
	public List<Produit> getAllProduit();
	

}
