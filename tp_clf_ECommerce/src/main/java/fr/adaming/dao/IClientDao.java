package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;





/**
 * Interface qui sert � donner les signatures des m�thodes des clients
 *
 */


public interface IClientDao {
	


	
	/**
	 * M�thode pour retourner la liste des cat�gories
	 * @return liste des cat�gories
	 */
	public List<Categorie> getAllCategorie();
	
	 
	/**
	 * M�thode pour retourner tous les produits d'une cat�gorie
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
	 * Methode pour retourner la liste des produits selectionn�s
	 * @return liste des produits selectionn�s
	 */
	public List<Produit> getAllProduitSelectionne();
	
	
	
	/**
	 * Methode pour ajouter dans la base de donn�es la commande et le client
	 * @param client
	 */
	public void EnregistrerClientCommande(Client client);
	
	

	/**
	 * Methode pour chercher un produit avec un mot cl�
	 * @param motCle
	 * @return la liste des produits correspondants a ce mot cl�
	 */
	public List<Produit> chercherProduitMotCle(String motCle);
	
	
	/**
	 * Methode qui permet de r�cup�rer une cat�gorie dans la base de donn�es avec son nom
	 * @param nom_categorie
	 * @return la categorie qui poss�de ce nom
	 */
	public Categorie getCategorieByName(String nom_categorie);
	
	
	
	/**
	 * Methode qui permet de r�cuperer la liste des noms des cat�gories de la base
	 * @return la liste des noms des cat�gories (utilise lors de l'ajout d'un produit � la base de donn�es)
	 */
	public List<String> getAllCategorieName();
	
	
	
	/**
	 * Methode qui permet de r�cuperer la liste des noms des produits pr�sents dans la base
	 * @return la liste des noms de produits (utilisee dans beaucoup de m�thode)
	 */
	public List<String> getAllProduitName();
	
	
	/**
	 * Methode qui remet les valeurs des bool�ens � false dans la base de donn�es
	 */
	public void remiseZeroSelectionne();
	

}
