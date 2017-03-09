package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.MappedSuperclass;

/**
 * Classe qui permet uniquement d'associer plusieurs lignes de commandes 
 * à un seul et même client (classe non persistente)
 *
 */
@MappedSuperclass
public class Panier implements Serializable {
	

	private static final long serialVersionUID = 1L;
	

	// Clé primaire de la classe Panier
	private long id;
	
	private List<LigneCommande> listeLigneCommandes;

	
	// Constructeur vide
	public Panier() {
		super();
	}

	
	// Constructeur avec id
	public Panier(long id) {
		super();
		this.id = id;
	}

	
	
	// Getter et setter
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	
	

	// Getter et setter qui représente l'association entre entre le panier et les lignes de commandes qu'il contient
	public List<LigneCommande> getListeLigneCommandes() {
		return listeLigneCommandes;
	}


	public void setListeLigneCommandes(List<LigneCommande> listeLigneCommandes) {
		this.listeLigneCommandes = listeLigneCommandes;
	}


	// Redéfinition de toString
	@Override
	public String toString() {
		return "Panier [id=" + id + "]";
	}
	
	
	
	
	

}
