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
 * Classe qui gere toutes les taches administratives
 *
 */
@Entity
@Table(name="admins")
public class Admin implements Serializable{
	

	private static final long serialVersionUID = 1L;

	// Clé primaire de la classe Admin
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id_admin")
	private int id;
	
	// Identifiant pour le login
	private String mail;
	
	// Mot de passe pour le login
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id_role")
	private Role pRole;
	
	@Transient
	private String nomRole;
	
	// Constructeur vide
	public Admin() {
		super();
	}

	
	
	public Admin(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}



	// Constructeur avec paramètre sans id
	public Admin(String mail, String password,String nomRole) {
		super();
		this.mail = mail;
		this.password = password;
		this.nomRole=nomRole;
	}

	
	// Constructeur avec id 
	public Admin(int id, String mail, String password) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
	}

	
	// Getter et setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Role getpRole() {
		return pRole;
	}


	public void setpRole(Role pRole) {
		this.pRole = pRole;
	}


	/**
	 * @return the nomRole
	 */
	public String getNomRole() {
		return nomRole;
	}

	/**
	 * @param nomRole the nomRole to set
	 */
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	// Redéfinition de toString
	@Override
	public String toString() {
		return "Admin [id=" + id + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
	
	
	
	
	

}
