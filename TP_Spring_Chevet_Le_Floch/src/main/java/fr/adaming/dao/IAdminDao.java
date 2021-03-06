package fr.adaming.dao;

import java.util.List;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;



/**
 * Interface qui d�finit les signatures des m�thodes Admin
 *
 */
public interface IAdminDao {
	
	

	/**
	 * Methode g�rant la connexion pour un admin
	 * @param admin
	 * @return un entier pour savoir si il existe un admin qui repond a ces crit�res
	 */
	public int isExist(Admin admin);
	
	/**
	 * M�thode pour ajouter un produit dans la base de donn�es
	 * @param produit
	 */
	public void ajouterProduit(Produit produit);
	
	
	/**
	 * M�thode pour supprimer un produit dans la base de donn�es
	 * @param id_produit 
	 */
	public void supprimerProduitByName(int id_produit);
	

	/**
	 * M�thode pour modifier un produit dans la base de donn�es
	 * @param id_produit pour trouver le produit a modifier
	 * @param produit qui contient les nouvelles informations du produit
	 */
	public void modifierProduit (int id_produit, Produit produit);
	
	
	/**
	 * M�thode pour consulter l'�tat d'un produit
	 * @param  designation_produit
	 * @return le produit trouv� (si il existe)
	 */
	public Produit chercherProduitByName(String designation_produit);
	
	
	
	/**
	 * Methode pour consulter tous les produits
	 * @return la liste des produits de la base de donn�es
	 */
	public List<Produit> getAllProduit();
	

}
