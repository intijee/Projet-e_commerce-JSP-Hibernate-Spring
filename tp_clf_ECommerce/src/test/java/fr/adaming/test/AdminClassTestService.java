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

		// On crée un nouvel admi
		Admin a = new Admin("t@t", "t");

		// On ajoute cet admin à la base de donnée
		adminService.ajouterAdminService(a);

		// On vérifie que cet admin a bien été crée
		int res = adminService.isExistService(a);

		// On vérifie ensuite que la méthode renvoie le bon résultat
		int resAttendu = 1;
		assertTrue(res == resAttendu);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterProduitService() {

		// On ajoute un produit à la base de donnée
		Produit p = new Produit("toto", "titi", 20, 50, false);
		adminService.ajouterProduitService(p);

		// On recupère la liste des produit
		List<Produit> listeproduit = adminService.getAllProduitService();

		// On vérifie sur le dernier produit ajouté
		Produit pp = listeproduit.get(listeproduit.size() - 1);

		// On vérifie que le produit est bien ajouté avec les bonnes
		// caractéristiques
		assertEquals(p.getDesignation(), pp.getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testSupprimerProduitService() {

		// On crée un nouveau produit
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On l'ajoute à la base de donnée
		adminService.ajouterProduitService(p);

		// On vérifie que la liste des produits n'est pas nulle
		int taille = adminService.getAllProduitService().size();

		if (taille != 0) { // on vérifie que la liste n'est pas vide

			// On supprime ce produit grâce à son id (qu'on recupère dans la
			// base de données)
			adminService.supprimerProduitByNameService(
					adminService.chercherProduitByNameService(p.getDesignation()).getId());

			// On vérifie ensuite que la taille de la liste a bien diminué de 1
			int resAttendu = taille - 1;
			int newTaille = adminService.getAllProduitService().size();
			assertTrue(resAttendu == newTaille);
		}
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierProduitService() {

		// On crée un nouveau produit
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On ajoute ce produit à la base de données
		adminService.ajouterProduitService(p);

		// On recupére l'id du produit à partir de son nom
		int id = (adminService.chercherProduitByNameService(p.getDesignation())).getId();

		// Affection de nouvelles valeurs aux attributs du produit
		p.setDesignation("nomUnique");

		// On modifie le produit
		adminService.modifierProduitService(id, p);

		// On vérifie qu'on retrouve bien un produit avec ce nom
		assertNotNull(adminService.chercherProduitByNameService(p.getDesignation()));
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testChercherProduitByNameService() {

		// On crée un nouveau produit
		String designation = "toto";
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On ajoute ce produit à la base de donnée
		adminService.ajouterProduitService(p);

		// On vérifie que le produit est bien ajouté a la base et on le recupère
		String resDesignation = adminService.chercherProduitByNameService(designation).getDesignation();

		// On vérifie qu'on retrouve bien le bon produit
		assertEquals(designation, resDesignation);

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitService() {

		// On recupère la liste des produits présents dans la base de donnée
		List<Produit> listeBefore = adminService.getAllProduitService();

		// On crée un nouveau produit
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On ajoute ce produit à la base de donnée
		adminService.ajouterProduitService(p);

		// On recupère la nouvelle liste de produit
		List<Produit> listeproduit = adminService.getAllProduitService();

		// On vérifie que la taille de la liste à bien augmenté de 1 (donc qu'on
		// recupère la bonne liste)
		assertTrue(listeBefore.size() == listeproduit.size() - 1);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterCategorieService() {

		// On crée une nouvelle catégorie
		Categorie cat = new Categorie("toto", "titi");

		// On vérifie le retour de la méthode
		int verif = adminService.ajouterCategorieService(cat);

		// On vérifie que le retour est bien 1 (la catégorie a bien été ajouté)
		int resAttendu = 1;
		assertTrue(verif == resAttendu);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierCategorieService() {

		// On crée une nouvelle catégorie
		Categorie cat = new Categorie("toto", "titi");

		// On l'ajout dans la base de données
		adminService.ajouterCategorieService(cat);

		// On retrouve cet catégorie dans la base de donnée pour récupérer son
		// id
		int id = (int) clientService.getCategorieByNameService(cat.getNom()).getId();

		// On affecte de nouvelles valeurs aux attributs de la catégorie
		cat.setDescription("lala");
		cat.setNom("lili");

		// On modifie cette catégorie dans la base de donnée
		adminService.modifierCategorieService(id, cat);

		// On vérifie qu'on recupère bien une catégorie qui a ce nom
		assertNotNull(clientService.getCategorieByNameService(cat.getNom()));
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierRoleService() {

		// On crée un nouvel admin et un nouveau role
		Admin ad = new Admin("t@t", "t");
		Role roleInitial = new Role("ROLE_ADMIN_PROD");

		// On donne ce role a l'admin
		ad.setpRole(roleInitial);

		// On ajoute l'admin dans la base
		adminService.ajouterAdminService(ad);

		// On crée un nouveau role
		Role roleFinal = new Role("ROLE_ADMIN_CAT");

		// On modifie le role de l'admin
		adminService.modifierRoleService(ad, roleFinal);

		// On vérifie que le nouveau role de l'admin est le bon
		assertEquals(roleFinal.getDesignation(), ad.getpRole().getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterAdminService() {

		// On crée un nouvel admin
		Admin ad = new Admin("t@t", "t");

		// On ajoute cet admin à la base de donnée
		adminService.ajouterAdminService(ad);

		// On vérifie qu'on entrant ce mail on retrouve bien un nouvel admin
		assertNotNull(adminService.getAdminByMailService(ad.getMail()));

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testSupprimerAdminService() {

		// On crée un nouvel admin
		Admin ad = new Admin("t@t", "t");

		// On ajoute cet admin dans la base de donnée
		adminService.ajouterAdminService(ad);

		// On recupère l'admin crée dans la base
		Admin adSup = adminService.getAdminByMailService(ad.getMail());

		// On le supprime grâce à son id
		adminService.supprimerAdminService(adSup.getId());

		// On essaie de récupérer cet admin
		Admin adVerif = adminService.getAdminByMailService(ad.getMail());

		// On vérifie qu'on ne récupère rien
		assertNull(adVerif);

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetRoleByNameService() {

		// On crée un nouveau role (existant dans la base de donnée)
		Role roleInitial = new Role("ROLE_ADMIN_PROD");

		// On recupère un role qui a ce nom dans la base de donnée
		String nom_role = roleInitial.getDesignation();
		Role roleFinal = adminService.getRoleByNameService(nom_role);

		// On vérifie qu'on recupère bien le bon role
		assertEquals(nom_role, roleFinal.getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetAdminByMailService() {

		// On crée un nouvel admin
		Admin ad = new Admin("t@t", "t");

		// On ajoute cet admin à la base de données
		adminService.ajouterAdminService(ad);

		// On recupère cet admin dans la base de données
		Admin adVerif = adminService.getAdminByMailService("t@t");

		// On vérifie qu'on a bien recupéré le bon grâce à son password
		assertEquals(ad.getPassword(), adVerif.getPassword());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetCategorieById() {

		// On crée une nouvelle catégorie et on l'ajoute à la base de données
		Categorie cat = new Categorie("nomCat", "descriptionCat");

		adminService.ajouterCategorieService(cat);

		// On recupère la catégorie par son id, en recuperant son id grâce au
		// nom de la catégorie (méthode testée)
		Categorie catRecup = adminService
				.getCategorieByIdService(clientService.getCategorieByNameService(cat.getNom()).getId());

		// On vérifie qu'on recupère bien la bonne catégorie avec son id
		assertEquals(catRecup.getDescription(), cat.getDescription());

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllAdmin() {

		// On ajoute un nouvel admin dans la base de donnée
		adminService.ajouterAdminService(new Admin("a", "a"));

		// On vérifie que la liste récupérée n'est pas vide
		assertNotNull(adminService.getAllAdminService());

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetProduitById() {

		// On crée un nouveau produit et on l'ajoute à la base de données
		Produit produit = new Produit("a", "a", 1, 1, false);
		adminService.ajouterProduitService(produit);

		// On recupère le produit par son id, en recuperant son id grâce au nom
		// du produit(méthode testée)
		Produit prod = adminService
				.getProduitByIdService(adminService.chercherProduitByNameService(produit.getDesignation()).getId());

		// On vérifie qu'on recupère bien la bonne catégorie avec son id
		assertEquals(produit.getDescription(), prod.getDescription());
	}

	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testSupprimerCategorie(){
		
		// On crée une nouvelle catégorie et on l'ajoute a la base de donnée
		Categorie cat=new Categorie("nomCat","descriptionCat");
		
		adminService.ajouterCategorieService(cat);
		
		// On supprime cette catégorie dans la base de donnée
		adminService.supprimerCategorieService(cat);
		
		// On vérifie que la catégorie n'existe plus
		assertNull(clientService.getCategorieByNameService(cat.getNom()));
	}

}
