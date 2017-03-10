package fr.adaming.test;

import static org.junit.Assert.assertEquals;
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
//choisir le runner de spring
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClientClassTestService {
	@Autowired
	IClientService clientService;
	@Autowired
	IAdminService adminService;

	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllCategorieService() {
		int tailleInitiale = clientService.getAllCategorieService().size();
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		int tailleFinale = clientService.getAllCategorieService().size();
		assertTrue(tailleInitiale==tailleFinale-1);
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitCategorieService(){
		Produit p = new Produit("toto", "titi", 50, 20, false);
		Categorie cat = new Categorie("lolo", "lili");
		p.setpCategorie(cat);
		// avec les cascades on construit tout normalement
		adminService.ajouterProduitService(p);
		System.out.println("getAllProduitCategorie : "+clientService.getAllProduitCategorieService(cat).get(0));
		List<Produit> listeProdCat = clientService.getAllProduitCategorieService(cat);
		Produit pp = listeProdCat.get(listeProdCat.size()-1);
		assertEquals(p.getPrix(), pp.getPrix());
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testSelectionnerProduitByNameService(){
		Produit p = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(p);
		int id = adminService.getAllProduitService().size()-1;
		clientService.selectionnerProduitByNameService(id);
		Produit pp = adminService.getAllProduitService().get(id);
		// a voir
		System.out.println(pp.isSelectionne());
		assertTrue(pp.isSelectionne());
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitSelectionneService(){
		Produit p = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(p);
		int id = adminService.getAllProduitService().size()-1;
		clientService.selectionnerProduitByNameService(id);
		List<Produit> listeSelection = clientService.getAllProduitSelectionneService();
		for (Produit prod : listeSelection){
			System.out.println("testGetAllProduitSelectionneService  " +prod);
		}
		assertTrue(listeSelection.size()>1);
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testEnregistrerClientCommandeService(){
		Client cl = new Client("wesh", "gros", "sisi", "la@famille", "0606060606");
		int verif = clientService.EnregistrerClientCommandeService(cl);
		int resAttendu = 1;
		assertTrue(verif==resAttendu);
		// pas d'idée
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testChercherProduitMotCleService(){
		Produit p = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(p);
		String motcle="toto";
		List<Produit> listeProdMC=clientService.chercherProduitMotCleService(motcle);
		Produit pMC = listeProdMC.get(listeProdMC.size()-1);
		assertEquals(p.getDesignation(), pMC.getDesignation());
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetCategorieByNameService(){
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		String nomCat="toto";
		Categorie catcat=clientService.getCategorieByNameService(nomCat);
		assertEquals(cat.getNom(),catcat.getNom());
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllCategorieNameService(){
		List<String> listeNomCat1=clientService.getAllCategorieNameService();
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		List<String> listeNomCat2 = clientService.getAllCategorieNameService();
		assertTrue(listeNomCat1.size()<listeNomCat2.size());
		for(String s : listeNomCat2){
			System.out.println("testGetAllCategorieNameService  "+s);
		}
		
		
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitNameService(){
		List<String> listeNomProd1=clientService.getAllProduitNameService();
		Produit prod = new Produit("toto", "titi", 50, 20, false);
		adminService.ajouterProduitService(prod);
		List<String> listeNomProd2 = clientService.getAllProduitNameService();
		assertTrue(listeNomProd1.size()<listeNomProd2.size());
		for(String s : listeNomProd2){
			System.out.println("testGetAllProduitNameService  "+s);
		}
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testRemiseZeroSelectionneService(){
		Produit prod = new Produit("toto", "titi", 50, 20, true);
		List<Produit> listeCom = clientService.getAllProduitSelectionneService();
		int tailleInitiale = listeCom.size();
		clientService.remiseZeroSelectionneService();
		List<Produit> listeCom2 = clientService.getAllProduitSelectionneService();
		int tailleFinale = listeCom2.size();
		assertTrue(tailleFinale<tailleInitiale);
	}

}
