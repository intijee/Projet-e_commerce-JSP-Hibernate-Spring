package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * classe client qui permet d'ajouter un client afin qu'il effectue une commande
 *
 */

@Entity
@Table(name="clients")
public class Client implements Serializable {
	

	private static final long serialVersionUID = 1L;

	// Clé primaire de la classe client
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private long id;
	
	private String nomClient;
	
	private String prenomClient;
	
	private String adresse;
	
	private String mail;
	
	private String tel;
	
	
	// Attribut qui lie le client à ses commandes 
	@OneToMany (mappedBy="pClient", cascade=CascadeType.ALL)
	private List<Commande> listeCommandes;

	
	// Constructeur vide
	public Client() {
		super();
	}
	
	
	// Constructeur avec paramètre sans id
	public Client(String nomClient, String prenomClient, String adresse, String mail, String tel) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
	}
	
	
	// Constructeur avec id
	public Client(long id, String nomClient, String prenomClient, String adresse, String mail, String tel) {
		super();
		this.id = id;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
	}


	
	// Les getters et setters
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}


	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	
	
	// Getter et setter qui lie le client a ses commandes
	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}


	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}


	// Redéfinition de toString
	@Override
	public String toString() {
		return "Client [id=" + id + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", adresse="
				+ adresse + ", mail=" + mail + ", tel=" + tel + "]";
	}
	
	
	
	
	
	

}
