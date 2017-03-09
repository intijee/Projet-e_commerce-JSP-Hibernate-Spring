package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;





/**
 * Interface qui sert à donner les signatures des méthodes des clients
 *
 */


public interface IClientDao {
	


	
	/**
	 * Méthode pour retourner la liste des catégories
	 * @return liste des catégories
	 */
	public List<Categorie> getAllCategorie();
	
	 
	/**
	 * Méthode pour retourner tous les produits d'une catégorie
	 * @param categorie
	 * @return liste des produits
	 */
	public List<Produit> getAllProduitByCategorie(Categorie categorie);
	
	
	
	/**
	 * Methode pour selectionner un produit (donne true au boolean selectionner de Produit)
	 * @param id_produit
	 */
	public void selectionnerProduitByName(int id_produit);
	

	/**
	 * Methode pour retourner la liste des produits selectionnés
	 * @return liste des produits selectionnés
	 */
	public List<Produit> getAllProduitSelectionne();
	
	
	
	/**
	 * Methode pour ajouter dans la base de données la commande et le client
	 * @param client
	 */
	public void EnregistrerClientCommande(Client client);
	
	

	/**
	 * Methode pour chercher un produit avec un mot clé
	 * @param motCle
	 * @return la liste des produits correspondants a ce mot clé
	 */
	public List<Produit> chercherProduitMotCle(String motCle);
	
	
	/**
	 * Methode qui permet de récupérer une catégorie dans la base de données avec son nom
	 * @param nom_categorie
	 * @return la categorie qui possède ce nom
	 */
	public Categorie getCategorieByName(String nom_categorie);
	
	
	
	/**
	 * Methode qui permet de récuperer la liste des noms des catégories de la base
	 * @return la liste des noms des catégories (utilise lors de l'ajout d'un produit à la base de données)
	 */
	public List<String> getAllCategorieName();
	
	
	
	/**
	 * Methode qui permet de récuperer la liste des noms des produits présents dans la base
	 * @return la liste des noms de produits (utilisee dans beaucoup de méthode)
	 */
	public List<String> getAllProduitName();
	
	
	/**
	 * Methode qui remet les valeurs des booléens à false dans la base de données
	 */
	public void remiseZeroSelectionne();
	

}
