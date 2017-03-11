package fr.adaming.service;

import java.util.List;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.entities.Role;


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
	
	
	/**
	 * Methode pour créer une nouvelle catégorie dans la base de données
	 * @param categorie a ajouter dans la base de données
	 * @return un entier qui donne la réussite ou non de la méthode
	 */
	public int ajouterCategorieService(Categorie categorie);
	
	
	/**
	 * Methode qui permet de modifier une catégorie dans la base de données
	 * @param id_categorie de la catégorie à modifier
	 * @param categorie qui encapsule les nouvelles informations
	 * @return un entier qui donne la réussite ou non de la méthode
	 */
	public int modifierCategorieService(long id_categorie, Categorie categorie);
	
	
	/**
	 * Methode pour modifier le role d'un admin dans la base de données
	 * @param admin a modifier dans la base de données
	 * @param role qui est le nouveau role de l'admin
	 * @return un entier qui donne la réussite ou non de la méthode
	 */
	public int modifierRoleService(Admin admin, Role role);
	
	
	/**
	 * Methode pour ajouter un admin dans la base de données
	 * @param admin a ajouter dans la base de données
	 * @return un entier qui donne la réussite ou non de la méthode
	 */
	public int ajouterAdminService(Admin admin);
	
	
	/**
	 * Methode pour supprimer un admin de la base de données
	 * @param id_admin de l'admin à supprimer dans la base de données
	 * @return un entier qui donne la réussite ou non de la méthode
	 */
	public int supprimerAdminService(int id_admin);
	
	
	/**
	 * Methode qui permet de récupérer un role dans la base de données à partir de son nom
	 * @param nom_role du role qu'on veut récupérer
	 * @return le role recupéré
	 */
	public Role getRoleByNameService(String nom_role);
	
	/**
	 * Methode pour recupérer un admin par son mail
	 * @param mail_admin le mail de l'admin qu'on veut recupérer
	 * @return l'admin trouvé si il existe
	 */
	public Admin getAdminByMailService(String mail_admin);
	
	
	
	/**
	 * Methode pour supprimer une catégorie
	 * @param categorie que l'on veut supprimer
	 * @return un entier pour savoir si la suppression a reussi
	 */
	public int supprimerCategorieService(Categorie categorie);
	
	
	/**
	 * Methode pour trouver une catégorie avec son id
	 * @param id de la catégorie qu'on veut trouver
	 * @return la catégorie retrouvée
	 */
	public Categorie getCategorieByIdService(long id);
	
	
	
	/**
	 * Methode pour recupérer la liste des admins
	 * @return la liste des admins
	 */
	public List<Admin> getAllAdminService();

}
