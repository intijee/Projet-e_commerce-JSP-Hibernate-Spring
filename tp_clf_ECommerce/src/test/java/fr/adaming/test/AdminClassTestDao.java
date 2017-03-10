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
		
		// On crée un mail qui n'existe pas dans la base de données
		String mail="mail imaginaire";
		
		// On vérifie que la méthode retourne bien un objet null
		assertNull(adminDao.getAdminByMail(mail));
	}
	
	
	
	/**
	 * Methode pour tester qu'on retrouve bien un admin si on a le bon mail
	 */
	public void getAdminByMailTest2(){
		
		// On crée un nouvel admin qui existe dans la base de données (vérifié)
		Admin admin=new Admin(1,"a","a");
		
		// On vérifie qu'on retrouve bien cette admin en cherchant grâce à son mail
		assertEquals(admin, adminDao.getAdminByMail(admin.getMail()));
	}
	
	
	/**
	 * Methode pour vérifier qu'on a bien crée un admin dans la base de données
	 */
	public void ajouterAdminTest(){
		
		// On crée un nouvel admin
		Admin admin=new Admin("b","b");
		
		// On essaye de l'ajouter à la base de données
		adminDao.ajouterAdmin(admin);
		
		// On vérifie qu'il existe bien dans la base de donnée
		assertNotNull(adminDao.getAdminByMail(admin.getMail()));
	}
	

	/**
	 * Methode pour vérifier qu'on retrouve bien un admin en entrant les bonnes informations
	 */
	public void testIsExist1() {

		// On s'attend à trouver un résultat
		int resultatAttendu = 1;
		
		// On crée un nouvel admin
		Admin admin = new Admin("a", "a");

		// On crée cet admin dans la base de données
		adminDao.ajouterAdmin(admin);
		
		// On va vérifier que le retour de la méthode est bien 1
		assertEquals(resultatAttendu, adminDao.isExist(admin));

	}

	/**
	 * Methode pour vérifier qu'on ne retrouve pas d'admin en entrant de fausses informations
	 */
	public void testIsExist2() {
		
		// On ne trouvera rien si la méthode fonctionne
		int resultatAttendu = 0;
		
		// On crée un nouvel admin 
		Admin admin = new Admin("b", "b");

		// On ajoute cet admin à la base de données
		adminDao.ajouterAdmin(admin);
		
		// On affecte un nouveau mail a l'admin
		admin.setMail("d");
		
		// On vérifie qu'on ne trouve rien
		assertEquals(resultatAttendu, adminDao.isExist(admin));

	}
	
	/**
	 * Methode pour vérifier qu'on ne retrouve pas de role en entrant de fausses infos
	 */
	public void testGetRoleByName1(){
		
		// On crée un role qui n'existe pas dans la base de données
		String nomRole="role imaginaire";
		
		// On vérifie que le resultat de la méthode est bien null
		assertNull(adminDao.getRoleByName(nomRole));
		
	}
	
	/**
	 * Methode pour vérifier qu'on retrouve bien un role en entrant un nom existant
	 */
	public void testGetRoleByName2(){
		
		
		// On crée un role qui existe
		Role roleAttendu=new Role(1,"ROLE_ADMIN");
		
		// On recherche que ce role existe bien dans la base de données et qu'on le retrouve bien 
		assertEquals(roleAttendu, adminDao.getRoleByName(roleAttendu.getDesignation()));
	}
	
	/**
	 * Methode pour vérifier qu'on modifie bien le role d'un admin dans la base de données
	 */
	public void testModifierRole(){
		
		// On crée un role 
		Role role=new Role(1,"ROLE_USER");
		
		// On crée un admin
		Admin admin=new Admin("n","n");
		
		// On l'ajoute dans la base de données
		adminDao.ajouterAdmin(admin);
	
		// On modifie le role de l'admin
		adminDao.modifierRole(admin, role);
		
		// On crée ce role comme String
		String designation=role.getDesignation();
		
		// On vérifie que la designation du role est la meme que le role de l'admin
		assertEquals(designation, adminDao.getAdminByMail(admin.getMail()).getpRole().getDesignation());
		
	}
	
	/**
	 * Methode pour vérifier qu'on supprime bien un admin dans la base de données
	 */
	public void testSupprimerAdmin(){
		
		// On crée un admin
		Admin admin=new Admin("y","y");
		
		// On l'ajoute dans la base de données
		adminDao.ajouterAdmin(admin);
		
		// On recupère cette admin dans la base (pour avoir son id)
		admin=adminDao.getAdminByMail(admin.getMail());
		
		// On supprime l'admin dans la base
		adminDao.supprimerAdmin(admin.getId());
		
		// On vérifie que cet admin n'existe pas 
		assertNull(adminDao.getAdminByMail(admin.getMail()));
			
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
