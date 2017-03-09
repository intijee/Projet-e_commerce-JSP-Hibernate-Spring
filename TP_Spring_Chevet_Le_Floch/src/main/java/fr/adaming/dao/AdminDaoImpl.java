package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	SessionFactory sf;

	/**
	 * @param sf
	 *            the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public int isExist(Admin admin) {

		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select a from Admin a where a.mail=:pMail and a.password=:pPassword";

		Query query = s.createQuery(req);

		// Assignation des paramètres de la requete
		query.setParameter("pMail", admin.getMail());
		query.setParameter("pPassword", admin.getPassword());

		// Recuperation de l'admin
		Admin ad = (Admin) query.list().get(0);

		if (ad != null) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public void ajouterProduit(Produit produit) {

		Session s = sf.getCurrentSession();

		s.save(produit);

	}

	@Override
	public void supprimerProduitByName(int id_produit) {

		Session s = sf.getCurrentSession();

		Produit produit = (Produit) s.get(Produit.class, id_produit);

		s.delete(produit);
	}

	@Override
	public void modifierProduit(int id_produit, Produit produit) {

		Session s = sf.getCurrentSession();

		Produit prod = (Produit) s.get(Produit.class, id_produit);

		prod.setDescription(produit.getDescription());
		prod.setDesignation(produit.getDesignation());
		prod.setPrix(produit.getPrix());
		prod.setQuantite(produit.getQuantite());

		s.saveOrUpdate(prod);
	}

	@Override
	public Produit chercherProduitByName(String designation_produit) {

		Session s = sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select p from Produit p where p.designation=:pDesignation";
		
		Query query=s.createQuery(req);
		
		// Assignation des paramètres
		query.setParameter("pDesignation", designation_produit);
		
		return (Produit) query.list().get(0);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduit() {

		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select p from Produit p";
		
		Query query=s.createQuery(req);
		
		if (query.list().size()!=0){
		return query.list();
		} else {
			return null;
		}
		
	}

}
