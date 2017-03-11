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

		// On cr�e un nouvel admi
		Admin a = new Admin("t@t", "t");

		// On ajoute cet admin � la base de donn�e
		adminService.ajouterAdminService(a);

		// On v�rifie que cet admin a bien �t� cr�e
		int res = adminService.isExistService(a);

		// On v�rifie ensuite que la m�thode renvoie le bon r�sultat
		int resAttendu = 1;
		assertTrue(res == resAttendu);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterProduitService() {

		// On ajoute un produit � la base de donn�e
		Produit p = new Produit("toto", "titi", 20, 50, false);
		adminService.ajouterProduitService(p);

		// On recup�re la liste des produit
		List<Produit> listeproduit = adminService.getAllProduitService();

		// On v�rifie sur le dernier produit ajout�
		Produit pp = listeproduit.get(listeproduit.size() - 1);

		// On v�rifie que le produit est bien ajout� avec les bonnes
		// caract�ristiques
		assertEquals(p.getDesignation(), pp.getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testSupprimerProduitService() {

		// On cr�e un nouveau produit
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On l'ajoute � la base de donn�e
		adminService.ajouterProduitService(p);

		// On v�rifie que la liste des produits n'est pas nulle
		int taille = adminService.getAllProduitService().size();

		if (taille != 0) { // on v�rifie que la liste n'est pas vide

			// On supprime ce produit gr�ce � son id (qu'on recup�re dans la
			// base de donn�es)
			adminService.supprimerProduitByNameService(
					adminService.chercherProduitByNameService(p.getDesignation()).getId());

			// On v�rifie ensuite que la taille de la liste a bien diminu� de 1
			int resAttendu = taille - 1;
			int newTaille = adminService.getAllProduitService().size();
			assertTrue(resAttendu == newTaille);
		}
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierProduitService() {

		// On cr�e un nouveau produit
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On ajoute ce produit � la base de donn�es
		adminService.ajouterProduitService(p);

		// On recup�re l'id du produit � partir de son nom
		int id = (adminService.chercherProduitByNameService(p.getDesignation())).getId();

		// Affection de nouvelles valeurs aux attributs du produit
		p.setDesignation("nomUnique");

		// On modifie le produit
		adminService.modifierProduitService(id, p);

		// On v�rifie qu'on retrouve bien un produit avec ce nom
		assertNotNull(adminService.chercherProduitByNameService(p.getDesignation()));
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testChercherProduitByNameService() {

		// On cr�e un nouveau produit
		String designation = "toto";
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On ajoute ce produit � la base de donn�e
		adminService.ajouterProduitService(p);

		// On v�rifie que le produit est bien ajout� a la base et on le recup�re
		String resDesignation = adminService.chercherProduitByNameService(designation).getDesignation();

		// On v�rifie qu'on retrouve bien le bon produit
		assertEquals(designation, resDesignation);

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllProduitService() {

		// On recup�re la liste des produits pr�sents dans la base de donn�e
		List<Produit> listeBefore = adminService.getAllProduitService();

		// On cr�e un nouveau produit
		Produit p = new Produit("toto", "titi", 20, 50, false);

		// On ajoute ce produit � la base de donn�e
		adminService.ajouterProduitService(p);

		// On recup�re la nouvelle liste de produit
		List<Produit> listeproduit = adminService.getAllProduitService();

		// On v�rifie que la taille de la liste � bien augment� de 1 (donc qu'on
		// recup�re la bonne liste)
		assertTrue(listeBefore.size() == listeproduit.size() - 1);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterCategorieService() {

		// On cr�e une nouvelle cat�gorie
		Categorie cat = new Categorie("toto", "titi");

		// On v�rifie le retour de la m�thode
		int verif = adminService.ajouterCategorieService(cat);

		// On v�rifie que le retour est bien 1 (la cat�gorie a bien �t� ajout�)
		int resAttendu = 1;
		assertTrue(verif == resAttendu);
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierCategorieService() {

		// On cr�e une nouvelle cat�gorie
		Categorie cat = new Categorie("toto", "titi");

		// On l'ajout dans la base de donn�es
		adminService.ajouterCategorieService(cat);

		// On retrouve cet cat�gorie dans la base de donn�e pour r�cup�rer son
		// id
		int id = (int) clientService.getCategorieByNameService(cat.getNom()).getId();

		// On affecte de nouvelles valeurs aux attributs de la cat�gorie
		cat.setDescription("lala");
		cat.setNom("lili");

		// On modifie cette cat�gorie dans la base de donn�e
		adminService.modifierCategorieService(id, cat);

		// On v�rifie qu'on recup�re bien une cat�gorie qui a ce nom
		assertNotNull(clientService.getCategorieByNameService(cat.getNom()));
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testModifierRoleService() {

		// On cr�e un nouvel admin et un nouveau role
		Admin ad = new Admin("t@t", "t");
		Role roleInitial = new Role("ROLE_ADMIN_PROD");

		// On donne ce role a l'admin
		ad.setpRole(roleInitial);

		// On ajoute l'admin dans la base
		adminService.ajouterAdminService(ad);

		// On cr�e un nouveau role
		Role roleFinal = new Role("ROLE_ADMIN_CAT");

		// On modifie le role de l'admin
		adminService.modifierRoleService(ad, roleFinal);

		// On v�rifie que le nouveau role de l'admin est le bon
		assertEquals(roleFinal.getDesignation(), ad.getpRole().getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testAjouterAdminService() {

		// On cr�e un nouvel admin
		Admin ad = new Admin("t@t", "t");

		// On ajoute cet admin � la base de donn�e
		adminService.ajouterAdminService(ad);

		// On v�rifie qu'on entrant ce mail on retrouve bien un nouvel admin
		assertNotNull(adminService.getAdminByMailService(ad.getMail()));

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testSupprimerAdminService() {

		// On cr�e un nouvel admin
		Admin ad = new Admin("t@t", "t");

		// On ajoute cet admin dans la base de donn�e
		adminService.ajouterAdminService(ad);

		// On recup�re l'admin cr�e dans la base
		Admin adSup = adminService.getAdminByMailService(ad.getMail());

		// On le supprime gr�ce � son id
		adminService.supprimerAdminService(adSup.getId());

		// On essaie de r�cup�rer cet admin
		Admin adVerif = adminService.getAdminByMailService(ad.getMail());

		// On v�rifie qu'on ne r�cup�re rien
		assertNull(adVerif);

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetRoleByNameService() {

		// On cr�e un nouveau role (existant dans la base de donn�e)
		Role roleInitial = new Role("ROLE_ADMIN_PROD");

		// On recup�re un role qui a ce nom dans la base de donn�e
		String nom_role = roleInitial.getDesignation();
		Role roleFinal = adminService.getRoleByNameService(nom_role);

		// On v�rifie qu'on recup�re bien le bon role
		assertEquals(nom_role, roleFinal.getDesignation());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetAdminByMailService() {

		// On cr�e un nouvel admin
		Admin ad = new Admin("t@t", "t");

		// On ajoute cet admin � la base de donn�es
		adminService.ajouterAdminService(ad);

		// On recup�re cet admin dans la base de donn�es
		Admin adVerif = adminService.getAdminByMailService("t@t");

		// On v�rifie qu'on a bien recup�r� le bon gr�ce � son password
		assertEquals(ad.getPassword(), adVerif.getPassword());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetCategorieById() {

		// On cr�e une nouvelle cat�gorie et on l'ajoute � la base de donn�es
		Categorie cat = new Categorie("nomCat", "descriptionCat");

		adminService.ajouterCategorieService(cat);

		// On recup�re la cat�gorie par son id, en recuperant son id gr�ce au
		// nom de la cat�gorie (m�thode test�e)
		Categorie catRecup = adminService
				.getCategorieByIdService(clientService.getCategorieByNameService(cat.getNom()).getId());

		// On v�rifie qu'on recup�re bien la bonne cat�gorie avec son id
		assertEquals(catRecup.getDescription(), cat.getDescription());

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetAllAdmin() {

		// On ajoute un nouvel admin dans la base de donn�e
		adminService.ajouterAdminService(new Admin("a", "a"));

		// On v�rifie que la liste r�cup�r�e n'est pas vide
		assertNotNull(adminService.getAllAdminService());

	}

	@Test
	@Rollback(true)
	@Transactional
	public void testGetProduitById() {

		// On cr�e un nouveau produit et on l'ajoute � la base de donn�es
		Produit produit = new Produit("a", "a", 1, 1, false);
		adminService.ajouterProduitService(produit);

		// On recup�re le produit par son id, en recuperant son id gr�ce au nom
		// du produit(m�thode test�e)
		Produit prod = adminService
				.getProduitByIdService(adminService.chercherProduitByNameService(produit.getDesignation()).getId());

		// On v�rifie qu'on recup�re bien la bonne cat�gorie avec son id
		assertEquals(produit.getDescription(), prod.getDescription());
	}

	
	
	@Test
	@Rollback(true)
	@Transactional
	public void testSupprimerCategorie(){
		
		// On cr�e une nouvelle cat�gorie et on l'ajoute a la base de donn�e
		Categorie cat=new Categorie("nomCat","descriptionCat");
		
		adminService.ajouterCategorieService(cat);
		
		// On supprime cette cat�gorie dans la base de donn�e
		adminService.supprimerCategorieService(cat);
		
		// On v�rifie que la cat�gorie n'existe plus
		assertNull(clientService.getCategorieByNameService(cat.getNom()));
	}

}
