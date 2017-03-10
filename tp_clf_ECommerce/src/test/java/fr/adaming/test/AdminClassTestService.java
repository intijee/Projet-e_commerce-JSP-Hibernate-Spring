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

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.entities.Role;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@RunWith(SpringJUnit4ClassRunner.class)
// choisir le runner de spring
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class AdminClassTestService {
	@Autowired
	IAdminService adminService;
	@Autowired
	IClientService clientService;

	@Test
	@Rollback(true)
	@Transactional
	public void testIsExist() {
		Admin a = new Admin("t@t", "t");
		adminService.ajouterAdminService(a);
		int res = adminService.isExistService(a);
		int resAttendu = 1;
		assertTrue(res == resAttendu);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterProduitService() {
		Produit p = new Produit("toto", "titi", 20, 50, false);
		adminService.ajouterProduitService(p);
		List<Produit> listeproduit = adminService.getAllProduitService();
		for (Produit prod : listeproduit) {
			System.out.println(prod);
		}
		// On vérifie sur le dernier produit ajouté
		Produit pp = listeproduit.get(listeproduit.size() - 1);
		assertEquals(p.getDesignation(), pp.getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	// je pourrai faire un while qui me parcourt tous les élément de la liste
	// mais bon on va pas s'enflammer sur les tests du coup je test que le
	// dernier ajouté...
	public void testSupprimerProduitService() {
		Produit p = new Produit("toto", "titi", 20, 50, false);
		adminService.ajouterProduitService(p);
		int taille = adminService.getAllProduitService().size();
		if (taille != 0) { // on vérifie que la liste n'est pas vide
			adminService.supprimerProduitByNameService(taille - 1);
			int resAttendu = taille - 1;
			int newTaille = adminService.getAllProduitService().size();
			assertTrue(resAttendu == newTaille);
		}
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierProduitService() {
		Produit p = new Produit("toto", "titi", 20, 50, false);
		adminService.ajouterProduitService(p);
		int id = adminService.getAllProduitService().size() - 1;
		Produit pMod = new Produit("lala", "lulu", 60, 100, true);
		adminService.modifierProduitService(id, pMod);
		Produit pp = adminService.getAllProduitService().get(id);
		assertEquals("lala", pp.getDesignation());

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testChercherProduitByNameService() {
		String designation = "toto";
		Produit p = new Produit("toto", "titi", 20, 50, false);
		adminService.ajouterProduitService(p);
		String resDesignation = adminService.chercherProduitByNameService(designation).getDesignation();
		assertEquals(designation, resDesignation); // oui c'est de la merde ces
													// tests
	}

	@Test
	@Rollback(true)
	@Transactional
	// pas très inspiré pour celle là, elle teste aussi l'ajout
	public void testGetAllProduitService() {
		List<Produit> listeBefore = adminService.getAllProduitService();
		Produit p = new Produit("toto", "titi", 20, 50, false);
		adminService.ajouterProduitService(p);
		List<Produit> listeproduit = adminService.getAllProduitService();
		for (Produit prod : listeproduit) {
			System.out.println(prod);
		}
		assertTrue(listeBefore.size() == listeproduit.size() - 1);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterCategorieService() {
		Categorie cat = new Categorie("toto", "titi");
		int verif = adminService.ajouterCategorieService(cat);
		int resAttendu = 1;
		assertTrue(verif == resAttendu); // de moins en moins d'inspiration
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierCategorieService() {
		Categorie cat = new Categorie("toto", "titi");
		adminService.ajouterCategorieService(cat);
		int id = clientService.getAllCategorieService().size() - 1;
		Categorie catMod = new Categorie("lala", "lulu");
		adminService.modifierCategorieService(id, catMod);
		Categorie catcat = clientService.getAllCategorieService().get(id);
		assertEquals("lala", catcat.getNom());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierRoleService() {
		Admin ad = new Admin("t@t", "t");
		Role roleInitial = new Role("ROLE_ADMIN_PROD");
		ad.setpRole(roleInitial);
		adminService.ajouterAdminService(ad);
		Role roleFinal = new Role("ROLE_ADMIN_CAT");
		adminService.modifierRoleService(ad, roleFinal);
		// Je suis pas sûr de mon coup
		assertEquals(roleFinal.getDesignation(), ad.getpRole().getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterAdminService() {

		Admin ad = new Admin("t@t", "t");
		Role roleInitial = new Role("ROLE_ADMIN_PROD");
		ad.setpRole(roleInitial);
		int verif = adminService.ajouterAdminService(ad);
		int resAttendu = 1;
		assertTrue(verif == resAttendu);

	}
	@Test
	@Rollback(true)
	@Transactional
	public void testSupprimerAdminService(){
		Admin ad = new Admin("t@t", "t");
		Role roleInitial = new Role("ROLE_ADMIN_PROD");
		ad.setpRole(roleInitial);
		adminService.ajouterAdminService(ad);
		Admin adSup = adminService.getAdminByMailService(ad.getMail());
		adminService.supprimerAdminService(adSup.getId());
		Admin adVerif = adminService.getAdminByMailService(ad.getMail());
		assertEquals(adVerif, null);

	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetRoleByNameService(){
	Admin ad = new Admin("t@t", "t");
	Role roleInitial = new Role("ROLE_ADMIN_PROD");
	ad.setpRole(roleInitial);
	adminService.ajouterAdminService(ad);
	// normalement si la cascade fonctionne...
	String nom_role=roleInitial.getDesignation();
	Role roleFinal = adminService.getRoleByNameService(nom_role);
	assertEquals(nom_role, roleFinal.getDesignation());
	}
	@Test
	@Rollback(true)
	@Transactional
	public void testGetAdminByMailService(){
		Admin ad = new Admin("t@t", "t");
		adminService.ajouterAdminService(ad);
		Admin adVerif = adminService.getAdminByMailService("t@t");
		assertEquals(ad.getPassword(), adVerif.getPassword());
	}

}
