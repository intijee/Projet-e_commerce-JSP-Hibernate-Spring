package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe qui regroupe les commandes 
 *
 */
@Entity
@Table(name="commandes")
public class Commande implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	// Clé primaire de la classe commande
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private long id;
	
	// Date de la commande (TemporalType=Date)
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	
	// Attribut qui représente l'association entre la ligne de commande 
	@OneToMany(mappedBy="pCommande",cascade=CascadeType.ALL)
	private List<LigneCommande> listeLignesCommandes;
	
	// Attribut qui représente l'association entre le client et la commande
	@ManyToOne 
	// Renommage de la colonne qui contient l'id du client
	@JoinColumn(name="client_id_fk", referencedColumnName="id_client")
	private Client pClient;
	

	// Constructeur vide
	public Commande() {
		super();
	}

	// Constructeur avec paramètres sans id
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	// Constructeur avec id
	public Commande(long id, Date dateCommande) {
		super();
		this.id = id;
		this.dateCommande = dateCommande;
	}

	
	// Les getters et setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	
	
	// Getter et setter qui réprésente l'association entre la commande et les lignes de commande qui la composent
	public List<LigneCommande> getListeLignesCommandes() {
		return listeLignesCommandes;
	}

	public void setListeLignesCommandes(List<LigneCommande> listeLignesCommandes) {
		this.listeLignesCommandes = listeLignesCommandes;
	}
	
	// Getter et setter qui représente l'association entre le client et ses commandes
	public Client getpClient() {
		return pClient;
	}

	public void setpClient(Client pClient) {
		this.pClient = pClient;
	}

	// Redéfinition de toString
	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCommande=" + dateCommande + "]";
	}

	
	
	
	
	
	

}
