package fr.adaming.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Role;

public class AdminClassTestDao {

	@Autowired
	private IAdminDao adminDao;

	/**
	 * @param adminDao
	 *            the adminDao to set
	 */
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
	// Test des méthodes de CRUD pour les objets de type Admin
	
	/**
	 * Methode pour tester qu'on ne trouve aucun resultat avec un mauvais mail
	 */
	public void getAdminByMailTest1(){
		
		int resultatAttendu=0;
	
		String mail="mail imaginaire";
		
		assertEquals(resultatAttendu, adminDao.getAdminByMail(mail));
	}
	
	
	
	/**
	 * Methode pour tester qu'on retrouve bien un admin si on a le bon mail
	 */
	public void getAdminByMailTest2(){
		
		Admin admin=new Admin(1,"a","a");
		
		assertEquals(admin, adminDao.getAdminByMail("a"));
	}
	
	
	/**
	 * Methode pour vérifier qu'on a bien crée un admin dans la base de données
	 */
	public void ajouterAdminTest(){
		
		Admin admin=new Admin("b","b");
		
		adminDao.ajouterAdmin(admin);
		
		assertEquals(admin, adminDao.getAdminByMail(admin.getMail()));
	}
	

	/**
	 * Methode pour vérifier qu'on retrouve bien un admin en entrant les bonnes informations
	 */
	public void testIsExist1() {

		int resultatAttendu = 1;

		Admin admin = new Admin("a", "a");

		adminDao.ajouterAdmin(admin);

		assertEquals(resultatAttendu, adminDao.isExist(admin));

	}

	/**
	 * Methode pour vérifier qu'on ne retrouve pas d'admin en entrant de fausses informations
	 */
	public void testIsExist2() {

		int resultatAttendu = 0;

		Admin admin = new Admin("b", "b");

		adminDao.ajouterAdmin(admin);

		admin.setMail("b");

		assertEquals(resultatAttendu, adminDao.isExist(admin));

	}
	
	/**
	 * Methode pour vérifier qu'on ne retrouve pas de role en entrant de fausses infos
	 */
	public void testGetRoleByName1(){
		
		int resultatAttendu=0;
		
		String nomRole="role imaginaire";
		
		assertEquals(resultatAttendu, adminDao.getRoleByName(nomRole));
		
	}
	
	/**
	 * Methode pour vérifier qu'on retrouve bien un role en entrant un nom existant
	 */
	public void testGetRoleByName2(){
		
		Role roleAttendu=new Role(1,"ROLE_ADMIN");
		
		assertEquals(roleAttendu, adminDao.getRoleByName(roleAttendu.getDesignation()));
	}
	
	/**
	 * Methode pour vérifier qu'on modifie bien le role d'un admin dans la base de données
	 */
	public void testModifierRole(){
		
		Role role=new Role(1,"ROLE_USER");
		
		Admin admin=new Admin("n","n");
		
		adminDao.ajouterAdmin(admin);
	
		adminDao.modifierRole(admin, role);
		
		String designation=role.getDesignation();
		
		assertEquals(designation, adminDao.getAdminByMail(admin.getMail()).getpRole().getDesignation());
		
	}
	
	
	public void testSupprimerAdmin(){
		
		
	}
	
	
	
	
	
	
	
	// Test des méthodes CRUD pour les objets de type Categorie
	
	
	
	
	
	// Test des méthodes CRUD pour les objets de type Produit
	
	/**
	 * Methode pour vérifier qu'on retrouve bien la liste des produits
	 */
	public void getAllProduitTest(){
		
		assertNotNull(adminDao.getAllProduit());
	}

}
