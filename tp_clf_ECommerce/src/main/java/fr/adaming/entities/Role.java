package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_role")
	private int id;
	
	private String designation;
	
	// Un role est partagé par plusieurs admin mais chaque admin n'a qu'un seul role
	@OneToMany(mappedBy="pRole")
	private List<Admin> listeAdmin;

	
	
	// Constructeur vide
	public Role() {
		super();
	}

	// Constructeur sans id
	public Role(String designation) {
		super();
		this.designation = designation;
	}

	// Constructeur avec id
	public Role(int id, String designation) {
		super();
		this.id = id;
		this.designation = designation;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the listeAdmin
	 */
	public List<Admin> getListeAdmin() {
		return listeAdmin;
	}

	/**
	 * @param listeAdmin the listeAdmin to set
	 */
	public void setListeAdmin(List<Admin> listeAdmin) {
		this.listeAdmin = listeAdmin;
	}



	// Redéfinition de toString
	@Override
	public String toString() {
		return "Role [id=" + id + ", designation=" + designation + "]";
	}
	
	
	
	
}
