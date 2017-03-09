package fr.adaming.dao;

import java.util.List;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.entities.Role;



/**
 * Interface qui définit les signatures des méthodes Admin
 *
 */
/**
 * @author inti0226
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
	
	
	/**
	 * Methode pour créer une nouvelle catégorie dans la base de données
	 * @param categorie a ajouter dans la base de données
	 */
	public void ajouterCategorie (Categorie categorie);
	
	
	/**
	 * Methode qui permet de modifier une catégorie dans la base de données
	 * @param id_categorie de la catégorie à modifier
	 * @param categorie qui encapsule les nouvelles informations
	 */
	public void modifierCategorie(int id_categorie, Categorie categorie);
	
	
	/**
	 * Methode pour modifier le role d'un admin dans la base de données
	 * @param admin a modifier dans la base de données
	 * @param role qui est le nouveau role de l'admin
	 */
	public void modifierRole(Admin admin, Role role);
	
	
	/**
	 * Methode pour ajouter un admin dans la base de données
	 * @param admin a ajouter dans la base de données
	 */
	public void ajouterAdmin(Admin admin);
	
	
	/**
	 * Methode pour supprimer un admin de la base de données
	 * @param id_admin de l'admin à supprimer dans la base de données
	 */
	public void supprimerAdmin(int id_admin);
	
	
	/**
	 * Methode qui permet de récupérer un role dans la base de données à partir de son nom
	 * @param nom_role du role qu'on veut récupérer
	 * @return le role recupéré
	 */
	public Role getRoleByName(String nom_role);
	
	
	/**
	 * Methode pour recupérer un admin par son mail
	 * @param mail_admin le mail de l'admin qu'on veut recupérer
	 * @return l'admin trouvé si il existe
	 */
	public Admin getAdminByMail(String mail_admin);

}
