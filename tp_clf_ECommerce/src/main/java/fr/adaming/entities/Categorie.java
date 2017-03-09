package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe qui donne la catégorie des produits
 *
 */
@Entity
@Table(name="categories")
public class Categorie implements Serializable {

	

	private static final long serialVersionUID = 1L;

	// Clé primaire de la table catégories
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categorie")
	private long id;
	
	private String nom;
	
	private String description;
	
	@OneToMany(mappedBy="pCategorie")
	private List<Produit> listeProduits;
	
	

	// Constructeur vide
	public Categorie() {
		super();
	}
	
	// Constructeur avec paramètres sans id 
	public Categorie(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	
	// Constructeur avec id
	public Categorie(long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	
	// Getter et setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	// Getter et setter pour lier les produits avec leur catégorie
	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	// Redéfinition de toString
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom  + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
}
