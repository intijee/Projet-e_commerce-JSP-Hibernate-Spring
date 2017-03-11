package fr.adaming.service;

import java.util.List;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.entities.Role;


/**
 * Interface qui d�finit les signatures des m�thodes pour la couche Metier
 *
 */

public interface IAdminService {
	

	
	/**
	 * Methode g�rant la connexion pour un admin
	 * @param admin
	 * @return un entier qui v�rifie l'existence d'un admin ou non 
	 */
	public int isExistService(Admin admin);


	/**
	 * M�thode pour ajouter un produit dans la base de donn�es
	 * @param produit
	 * @return un entier pour savoir si l'ajout a reussi
	 */
	public int ajouterProduitService(Produit produit);
	

	/**
	 * M�thode pour supprimer un produit dans la base de donn�es
	 * @param id_produit
	 * @return un entier pour savoir si la suppression a reussi
	 */
	public int supprimerProduitByNameService(int id_produit);
	

	/**
	 * M�thode pour modifier un produit dans la base de donn�es
	 * @param id_produit pour trouver le produit a modifier
	 * @param produit qui contient les nouvelles informations du produit
	 * @return un entier pour savoir si la modification a reussi
	 */
	public int modifierProduitService(int id_produit, Produit produit);
	

	/**
	 * M�thode pour consulter l'�tat d'un produit
	 * @param designation_produit
	 * @return le produit trouv� (si il existe)
	 */
	public Produit chercherProduitByNameService(String designation_produit);
	

	/**
	 * Methode pour consulter tous les produits
	 * @return la liste des produits de la base de donn�es
	 */
	public List<Produit> getAllProduitService();
	
	
	/**
	 * Methode pour cr�er une nouvelle cat�gorie dans la base de donn�es
	 * @param categorie a ajouter dans la base de donn�es
	 * @return un entier qui donne la r�ussite ou non de la m�thode
	 */
	public int ajouterCategorieService(Categorie categorie);
	
	
	/**
	 * Methode qui permet de modifier une cat�gorie dans la base de donn�es
	 * @param id_categorie de la cat�gorie � modifier
	 * @param categorie qui encapsule les nouvelles informations
	 * @return un entier qui donne la r�ussite ou non de la m�thode
	 */
	public int modifierCategorieService(long id_categorie, Categorie categorie);
	
	
	/**
	 * Methode pour modifier le role d'un admin dans la base de donn�es
	 * @param admin a modifier dans la base de donn�es
	 * @param role qui est le nouveau role de l'admin
	 * @return un entier qui donne la r�ussite ou non de la m�thode
	 */
	public int modifierRoleService(Admin admin, Role role);
	
	
	/**
	 * Methode pour ajouter un admin dans la base de donn�es
	 * @param admin a ajouter dans la base de donn�es
	 * @return un entier qui donne la r�ussite ou non de la m�thode
	 */
	public int ajouterAdminService(Admin admin);
	
	
	/**
	 * Methode pour supprimer un admin de la base de donn�es
	 * @param id_admin de l'admin � supprimer dans la base de donn�es
	 * @return un entier qui donne la r�ussite ou non de la m�thode
	 */
	public int supprimerAdminService(int id_admin);
	
	
	/**
	 * Methode qui permet de r�cup�rer un role dans la base de donn�es � partir de son nom
	 * @param nom_role du role qu'on veut r�cup�rer
	 * @return le role recup�r�
	 */
	public Role getRoleByNameService(String nom_role);
	
	/**
	 * Methode pour recup�rer un admin par son mail
	 * @param mail_admin le mail de l'admin qu'on veut recup�rer
	 * @return l'admin trouv� si il existe
	 */
	public Admin getAdminByMailService(String mail_admin);
	
	
	
	/**
	 * Methode pour supprimer une cat�gorie
	 * @param categorie que l'on veut supprimer
	 * @return un entier pour savoir si la suppression a reussi
	 */
	public int supprimerCategorieService(Categorie categorie);
	
	
	/**
	 * Methode pour trouver une cat�gorie avec son id
	 * @param id de la cat�gorie qu'on veut trouver
	 * @return la cat�gorie retrouv�e
	 */
	public Categorie getCategorieByIdService(long id);
	
	
	
	/**
	 * Methode pour recup�rer la liste des admins
	 * @return la liste des admins
	 */
	public List<Admin> getAllAdminService();

}
