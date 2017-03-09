package fr.adaming.entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe association qui permet de relier un produit a une commande et donc à un client (par lien)
 *
 */

@Entity
@Table(name="ligneCommandes")
public class LigneCommande implements Serializable{
	
	

	private static final long serialVersionUID = 1L;


	// Clé primaire de la classe LigneCommande
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ligne_commande")
	private long id;
	
	
	private int quantite;
	
	private long prix;
	
	// Attribut qui représente l'association entre la ligne de commande et le produit 
	@ManyToOne
	@JoinColumn(name="produit_id_fk", referencedColumnName="id_produit")
	private Produit pProduit;
	
	// Attribut qui représente l'association entre la ligne et la commande a laquelle elle appartient
	@ManyToOne
	@JoinColumn(name="commande_id_fk", referencedColumnName="id_commande")
	private Commande pCommande;
	
	// Attribut qui représente l'association entre la ligne de commande et son panier
	@Transient
	private Panier panier;
	
	
	// Constructeur vide
	public LigneCommande() {
		super();
	}

	
	// Constructeur avec paramètre sans id
	public LigneCommande(int quantite, long prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	
	// Constructeur avec id
	public LigneCommande(long id, int quantite, long prix) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
	}


	
	// Getter et setter
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public long getPrix() {
		return prix;
	}


	public void setPrix(long prix) {
		this.prix = prix;
	}


	
	
	// Getter et setter pour l'association entre la ligne de commande et le produit
	public Produit getpProduit() {
		return pProduit;
	}


	public void setpProduit(Produit pProduit) {
		this.pProduit = pProduit;
	}


	// Getter et setter pour l'association entre la ligne de commande et la commande
	public Commande getpCommande() {
		return pCommande;
	}


	public void setpCommande(Commande pCommande) {
		this.pCommande = pCommande;
	}


	
	// Getter et setter pour l'association entre le panier et les lignes de commande qu'il contient
	public Panier getPanier() {
		return panier;
	}


	public void setPanier(Panier panier) {
		this.panier = panier;
	}


	// Redéfinition de toString
	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
	
	
	
	
	
	

}
