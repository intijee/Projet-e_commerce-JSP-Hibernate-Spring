package fr.adaming.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClientClassTestService {
	
	
	// Injection de d�pendances
	@Autowired
	IClientService clientService;
	@Autowired
	IAdminService adminService;

	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllCategorieService() {
		
		// On recup�re la taille de la liste des cat�gorie dans la base de donn�e
		int tailleInitiale = clientService.getAllCategorieService().size();
		
		// On cr�e une nouvelle cat�gorie
		Categorie cat = new Categorie("toto", "titi");
		
		// On ajoute cette cat�gorie � la base de donn�e
		adminService.ajouterCategorieService(cat);
		
		// On v�rifie que la taille a bien augment� de 1
		int tailleFinale = clientService.getAllCategorieService().size();
		assertTrue(tailleInitiale==tailleFinale-1);
	}
	
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitCategorieService(){
		
		// On cr�e un nouveau produit et une nouvelle cat�gorie
		Produit p = new Produit("toto", "titi", 50, 20, false);
		Categorie cat = new Categorie("lolo", "lili");
		
		// On affecte au produit sa cat�gorie
		p.setpCategorie(cat);
	
		// On ajoute le produit et la cat�gorie dans la base de donn�e
		adminService.ajouterCategorieService(cat);
		adminService.ajouterProduitService(p);

		// On recup�re la liste des produits de la cat�gorie
		List<Produit> listeProdCat = clientService.getAllProduitCategorieService(cat);
		
		// On v�rifie que le dernier produit ajout� � la cat�gorie est bien celui qu'on a ajout�
		Produit pp = listeProdCat.get(listeProdCat.size()-1);
		assertEquals(p.getPrix(), pp.getPrix());
	}
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testSelectionnerProduitByNameService(){
		
		// On cr�e un nouveau produit
		Produit p = new Produit("toto", "titi", 50, 20, false);
		
		// On ajoute ce produit � la base de donn�e
		adminService.ajouterProduitService(p);
		
		// On recup�re le produit ajout� par son nom et on le selectionne
		clientService.selectionnerProduitByNameService(adminService.chercherProduitByNameService(p.getDesignation()).getId());
		
		
		// On v�rifie que le produit est bien s�lectionn�
		assertTrue(adminService.chercherProduitByNameService(p.getDesignation()).isSelectionne()==true);
		
	}
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitSelectionneService(){
		
		// On cr�e un nouveau produit et on l'ajoute a la base de donn�e
		Produit p = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(p);
		
		// On s�lectionne le produit en le recup�rant par son nom
		clientService.selectionnerProduitByNameService(adminService.chercherProduitByNameService(p.getDesignation()).getId());
		
		// On recup�re la liste des produits s�lectionn�s
		List<Produit> listeSelection = clientService.getAllProduitSelectionneService();
		
		// On v�rifie que la liste des produits s�lectionn�s n'est pas vide
		assertTrue(listeSelection.size()!=0);
		
	}
	
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testEnregistrerClientCommandeService(){
		
		// On cr�e un nouveau client
		Client cl = new Client("wesh", "gros", "sisi", "la@famille", "0606060606");
		
		// On enregistre ce client � la base de donn�e
		int verif = clientService.EnregistrerClientCommandeService(cl);
		
		// On v�rifie que la m�thode renvoie un r�sultat de 1 (ajout r�ussi)
		int resAttendu = 1;
		assertTrue(verif==resAttendu);
	
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testChercherProduitMotCleService(){
		
		// On cr�e un nouveau produit et on l'ajoute a la base de donn�e
		Produit p = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(p);
		
		// On recup�re ce produit gr�ce � un mot cl�
		String motcle="tot";
		List<Produit> listeProdMC=clientService.chercherProduitMotCleService(motcle);
		Produit pMC = listeProdMC.get(listeProdMC.size()-1);
		
		// On v�rifie qu'on a bien recup�r� un produit
		assertNotNull(pMC);
		
	}
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetCategorieByNameService(){
		
		// On cr�e une nouvelle cat�gorie et on l'ajoute a la base de donn�e
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		
		// On recup�re la cat�gorie par son nom
		String nomCat="toto";
		Categorie catcat=clientService.getCategorieByNameService(nomCat);
		
		// On v�rifie qu'on recup�re bien une cat�gorie
		assertNotNull(catcat);
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllCategorieNameService(){
		
		
		// On recup�re la liste des noms des cat�gories
		List<String> listeNomCat1=clientService.getAllCategorieNameService();
		
		// On cr�e une nouvelle cat�gorie et on l'ajoute a la base de donn�e
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		
		// On reup�re la nouvelle liste des noms
		List<String> listeNomCat2 = clientService.getAllCategorieNameService();
		
		// On v�rifie que la nouvelle liste des noms � augment� de 1
		assertTrue(listeNomCat1.size()<listeNomCat2.size());
		
		
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitNameService(){
		
		// On recup�re la liste des noms des produits
		List<String> listeNomProd1=clientService.getAllProduitNameService();
		
		// On cr�e un nouveau produit et on l'ajoute a la base de donn�e
		Produit prod = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(prod);
		
		// On recup�re la nouvelle taille de la liste des noms et on la compare a la taille pr�c�dente
		List<String> listeNomProd2 = clientService.getAllProduitNameService();
		assertTrue(listeNomProd1.size()<listeNomProd2.size());
	
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testRemiseZeroSelectionneService(){
		
		// On cr�e iun nouveau produit et on l'ajoute a la base de donn�e
		Produit prod = new Produit("toto", "titi", 50, 20, true);
		adminService.ajouterProduitService(prod);
		
		// On remet � false les valeurs des booleens de la base de donn�e
		clientService.remiseZeroSelectionneService();
		
		// On recup�re le produit dans la base de donn�e et on v�rifie que son booleen vaut bien false
		assertTrue(adminService.chercherProduitByNameService(prod.getDesignation()).isSelectionne()==false);
	}
}
