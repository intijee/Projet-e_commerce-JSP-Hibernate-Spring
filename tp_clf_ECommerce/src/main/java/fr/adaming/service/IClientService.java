package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;


public interface IClientService {

	
	
	
	
	/**
	 * Methode pour consulter toutes les catégories 
	 * @return la liste des catégories qui existent dans la base de données
	 */
	public List<Categorie> getAllCategorieService();
	
	
	/**
	 * Methode pour consulter tous les produits d'une catégorie
	 * @param categorie
	 * @return une liste des produits appartenant à la catégorie
	 */
	public List<Produit> getAllProduitCategorieService(Categorie categorie);
	
	
	/**
	 * Methode pour selectionner un produit (donne true au boolean selectionner de Produit)
	 * @param id_produit
	 * @return un entier pour savoir si la méthode a fonctionné
	 */
	public int selectionnerProduitByNameService(int id_produit);
	
	
	/**
	 * Methode pour retourner la liste des produits selectionnés
	 * @return liste des produits selectionnés
	 */
	public List<Produit> getAllProduitSelectionneService();
	
	
	
	/**
	 * Methode pour ajouter dans la base de données la commande et le client
	 * @param client
	 * @return un entier pour savoir si l'enregistrement a reussi
	 */
	public int EnregistrerClientCommandeService(Client client);
	
	
	/**
	 * Methode pour chercher un produit avec un mot clé
	 * @param motCle
	 * @return la liste des produits correspondants à ce mot clé
	 */
	public List<Produit> chercherProduitMotCleService(String motCle);
	
	
	/**
	 * Methode qui permet de récupérer une catégorie dans la base de données avec son nom
	 * @param nom_categorie
	 * @return la categorie qui possède ce nom
	 */
	public Categorie getCategorieByNameService(String nom_categorie);
	
	
	/**
	 * Methode qui permet de récuperer la liste des noms des catégories de la base
	 * @return la liste des noms des catégories (utilise lors de l'ajout d'un produit à la base de données)
	 */
	public List<String> getAllCategorieNameService();
	
	/**
	 * Methode qui permet de récuperer la liste des noms des produits de la base
	 * @return la liste des noms des produits (utilisee dans beaucoup de méthodes)
	 */
	public List<String> getAllProduitNameService();
	

	/**
	 * Methode qui remet les valeurs des booléens à false dans la base de données
	 */
	public void remiseZeroSelectionneService();
	
}
