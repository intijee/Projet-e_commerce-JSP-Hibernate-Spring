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
	
	
	// Injection de dépendances
	@Autowired
	IClientService clientService;
	@Autowired
	IAdminService adminService;

	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllCategorieService() {
		
		// On recupère la taille de la liste des catégorie dans la base de donnée
		int tailleInitiale = clientService.getAllCategorieService().size();
		
		// On crée une nouvelle catégorie
		Categorie cat = new Categorie("toto", "titi");
		
		// On ajoute cette catégorie à la base de donnée
		adminService.ajouterCategorieService(cat);
		
		// On vérifie que la taille a bien augmenté de 1
		int tailleFinale = clientService.getAllCategorieService().size();
		assertTrue(tailleInitiale==tailleFinale-1);
	}
	
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitCategorieService(){
		
		// On crée un nouveau produit et une nouvelle catégorie
		Produit p = new Produit("toto", "titi", 50, 20, false);
		Categorie cat = new Categorie("lolo", "lili");
		
		// On affecte au produit sa catégorie
		p.setpCategorie(cat);
	
		// On ajoute le produit et la catégorie dans la base de donnée
		adminService.ajouterCategorieService(cat);
		adminService.ajouterProduitService(p);

		// On recupère la liste des produits de la catégorie
		List<Produit> listeProdCat = clientService.getAllProduitCategorieService(cat);
		
		// On vérifie que le dernier produit ajouté à la catégorie est bien celui qu'on a ajouté
		Produit pp = listeProdCat.get(listeProdCat.size()-1);
		assertEquals(p.getPrix(), pp.getPrix());
	}
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testSelectionnerProduitByNameService(){
		
		// On crée un nouveau produit
		Produit p = new Produit("toto", "titi", 50, 20, false);
		
		// On ajoute ce produit à la base de donnée
		adminService.ajouterProduitService(p);
		
		// On recupère le produit ajouté par son nom et on le selectionne
		clientService.selectionnerProduitByNameService(adminService.chercherProduitByNameService(p.getDesignation()).getId());
		
		
		// On vérifie que le produit est bien sélectionné
		assertTrue(adminService.chercherProduitByNameService(p.getDesignation()).isSelectionne()==true);
		
	}
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitSelectionneService(){
		
		// On crée un nouveau produit et on l'ajoute a la base de donnée
		Produit p = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(p);
		
		// On sélectionne le produit en le recupérant par son nom
		clientService.selectionnerProduitByNameService(adminService.chercherProduitByNameService(p.getDesignation()).getId());
		
		// On recupère la liste des produits sélectionnés
		List<Produit> listeSelection = clientService.getAllProduitSelectionneService();
		
		// On vérifie que la liste des produits sélectionnés n'est pas vide
		assertTrue(listeSelection.size()!=0);
		
	}
	
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testEnregistrerClientCommandeService(){
		
		// On crée un nouveau client
		Client cl = new Client("wesh", "gros", "sisi", "la@famille", "0606060606");
		
		// On enregistre ce client à la base de donnée
		int verif = clientService.EnregistrerClientCommandeService(cl);
		
		// On vérifie que la méthode renvoie un résultat de 1 (ajout réussi)
		int resAttendu = 1;
		assertTrue(verif==resAttendu);
	
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testChercherProduitMotCleService(){
		
		// On crée un nouveau produit et on l'ajoute a la base de donnée
		Produit p = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(p);
		
		// On recupère ce produit grâce à un mot clé
		String motcle="tot";
		List<Produit> listeProdMC=clientService.chercherProduitMotCleService(motcle);
		Produit pMC = listeProdMC.get(listeProdMC.size()-1);
		
		// On vérifie qu'on a bien recupéré un produit
		assertNotNull(pMC);
		
	}
	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testGetCategorieByNameService(){
		
		// On crée une nouvelle catégorie et on l'ajoute a la base de donnée
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		
		// On recupère la catégorie par son nom
		String nomCat="toto";
		Categorie catcat=clientService.getCategorieByNameService(nomCat);
		
		// On vérifie qu'on recupère bien une catégorie
		assertNotNull(catcat);
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllCategorieNameService(){
		
		
		// On recupère la liste des noms des catégories
		List<String> listeNomCat1=clientService.getAllCategorieNameService();
		
		// On crée une nouvelle catégorie et on l'ajoute a la base de donnée
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		
		// On reupère la nouvelle liste des noms
		List<String> listeNomCat2 = clientService.getAllCategorieNameService();
		
		// On vérifie que la nouvelle liste des noms à augmenté de 1
		assertTrue(listeNomCat1.size()<listeNomCat2.size());
		
		
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitNameService(){
		
		// On recupère la liste des noms des produits
		List<String> listeNomProd1=clientService.getAllProduitNameService();
		
		// On crée un nouveau produit et on l'ajoute a la base de donnée
		Produit prod = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(prod);
		
		// On recupère la nouvelle taille de la liste des noms et on la compare a la taille précédente
		List<String> listeNomProd2 = clientService.getAllProduitNameService();
		assertTrue(listeNomProd1.size()<listeNomProd2.size());
	
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testRemiseZeroSelectionneService(){
		
		// On crée iun nouveau produit et on l'ajoute a la base de donnée
		Produit prod = new Produit("toto", "titi", 50, 20, true);
		adminService.ajouterProduitService(prod);
		
		// On remet à false les valeurs des booleens de la base de donnée
		clientService.remiseZeroSelectionneService();
		
		// On recupère le produit dans la base de donnée et on vérifie que son booleen vaut bien false
		assertTrue(adminService.chercherProduitByNameService(prod.getDesignation()).isSelectionne()==false);
	}
}
