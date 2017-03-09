package fr.adaming.dao;

import java.util.List;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.entities.Role;



/**
 * Interface qui d�finit les signatures des m�thodes Admin
 *
 */
/**
 * @author inti0226
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
	
	
	/**
	 * Methode pour cr�er une nouvelle cat�gorie dans la base de donn�es
	 * @param categorie a ajouter dans la base de donn�es
	 */
	public void ajouterCategorie (Categorie categorie);
	
	
	/**
	 * Methode qui permet de modifier une cat�gorie dans la base de donn�es
	 * @param id_categorie de la cat�gorie � modifier
	 * @param categorie qui encapsule les nouvelles informations
	 */
	public void modifierCategorie(int id_categorie, Categorie categorie);
	
	
	/**
	 * Methode pour modifier le role d'un admin dans la base de donn�es
	 * @param admin a modifier dans la base de donn�es
	 * @param role qui est le nouveau role de l'admin
	 */
	public void modifierRole(Admin admin, Role role);
	
	
	/**
	 * Methode pour ajouter un admin dans la base de donn�es
	 * @param admin a ajouter dans la base de donn�es
	 */
	public void ajouterAdmin(Admin admin);
	
	
	/**
	 * Methode pour supprimer un admin de la base de donn�es
	 * @param id_admin de l'admin � supprimer dans la base de donn�es
	 */
	public void supprimerAdmin(int id_admin);
	
	
	/**
	 * Methode qui permet de r�cup�rer un role dans la base de donn�es � partir de son nom
	 * @param nom_role du role qu'on veut r�cup�rer
	 * @return le role recup�r�
	 */
	public Role getRoleByName(String nom_role);
	
	
	/**
	 * Methode pour recup�rer un admin par son mail
	 * @param mail_admin le mail de l'admin qu'on veut recup�rer
	 * @return l'admin trouv� si il existe
	 */
	public Admin getAdminByMail(String mail_admin);

}
