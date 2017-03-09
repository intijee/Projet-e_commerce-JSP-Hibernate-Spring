package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	SessionFactory sf;
	
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategorie() {
		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select c from Categorie c";
		
		Query query=s.createQuery(req);
		
		if (query.list().size()!=0){
			return query.list();
		} else {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduitByCategorie(Categorie categorie) {
		
		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select p from Produit p where p.pCategorie=:pPCategorie";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pPCategorie", categorie);
		
		if (query.list().size()!=0){
			return query.list();
		} else {
			return null;
		}
	
	}

	@Override
	public void selectionnerProduitByName(int id_produit) {

		Session s=sf.getCurrentSession();
		
		Produit produit=(Produit) s.get(Produit.class, id_produit);
		
		produit.setSelectionne(true);
		
		s.saveOrUpdate(produit);	
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduitSelectionne() {

		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select p from Produit p where p.selectionne=:pSelectionne";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pSelectionne", true);
		
		if(query.list().size()!=0){
			return query.list();
		} else {
			return null;
		}
		
	}

	@Override
	public void EnregistrerClientCommande(Client client) {

			Session s=sf.getCurrentSession();
			
			s.save(client);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> chercherProduitMotCle(String motCle) {


		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select p from Produit p where p.designation like :pMotCle";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pMotCle", motCle+"%");
		
		if (query.list().size()!=0){
			return query.list();
		} else {
		return null;
		}
	}

	@Override
	public Categorie getCategorieByName(String nom_categorie) {
		
		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select c from Categorie c where c.nom=:pNom";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pNom", nom_categorie);
		
		if (query.list().size()!=0){
			return (Categorie) query.list().get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCategorieName() {

		Session s=sf.getCurrentSession();
		
		String req="select c from Categorie c";
		
		Query query=s.createQuery(req);
		
		List<String> listeNomCategorie=new ArrayList<String>();
		
		if (query.list().size()!=0){
			
			List<Categorie> listeCategorie=query.list();
			
			for (Categorie c:listeCategorie){
				
				listeNomCategorie.add(c.getNom());
			} 
			
			return listeNomCategorie;
			
		} else {
			
			return null;
			
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllProduitName() {
		Session s=sf.getCurrentSession();
		
		String req="select p from Produit p";
		
		Query query=s.createQuery(req);
		
		List<String> listeNomProduit=new ArrayList<String>();
		
		if (query.list().size()!=0){
			
			List<Produit> listeProduit=query.list();
			
			for (Produit p:listeProduit){
				
				listeNomProduit.add(p.getDesignation());
			} 
			
			return listeNomProduit;
			
		} else {
			
			return null;
			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remiseZeroSelectionne() {


		Session s=sf.getCurrentSession();
		
		String req="select p from Produit p";
		
		Query query=s.createQuery(req);
		
		if (query.list().size()!=0){
			
			List<Produit> listeProduit=query.list();
			
			for (Produit p:listeProduit){
				p.setSelectionne(false);
				s.saveOrUpdate(p);
			}
		} 
	}

}
