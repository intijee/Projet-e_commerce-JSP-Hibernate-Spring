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
	
	
	// Test des m�thodes de CRUD pour les objets de type Admin
	
	/**
	 * Methode pour tester qu'on ne trouve aucun resultat avec un mauvais mail
	 */
	public void getAdminByMailTest1(){
		
		// On cr�e un mail qui n'existe pas dans la base de donn�es
		String mail="mail imaginaire";
		
		// On v�rifie que la m�thode retourne bien un objet null
		assertNull(adminDao.getAdminByMail(mail));
	}
	
	
	
	/**
	 * Methode pour tester qu'on retrouve bien un admin si on a le bon mail
	 */
	public void getAdminByMailTest2(){
		
		// On cr�e un nouvel admin qui existe dans la base de donn�es (v�rifi�)
		Admin admin=new Admin(1,"a","a");
		
		// On v�rifie qu'on retrouve bien cette admin en cherchant gr�ce � son mail
		assertEquals(admin, adminDao.getAdminByMail(admin.getMail()));
	}
	
	
	/**
	 * Methode pour v�rifier qu'on a bien cr�e un admin dans la base de donn�es
	 */
	public void ajouterAdminTest(){
		
		// On cr�e un nouvel admin
		Admin admin=new Admin("b","b");
		
		// On essaye de l'ajouter � la base de donn�es
		adminDao.ajouterAdmin(admin);
		
		// On v�rifie qu'il existe bien dans la base de donn�e
		assertNotNull(adminDao.getAdminByMail(admin.getMail()));
	}
	

	/**
	 * Methode pour v�rifier qu'on retrouve bien un admin en entrant les bonnes informations
	 */
	public void testIsExist1() {

		// On s'attend � trouver un r�sultat
		int resultatAttendu = 1;
		
		// On cr�e un nouvel admin
		Admin admin = new Admin("a", "a");

		// On cr�e cet admin dans la base de donn�es
		adminDao.ajouterAdmin(admin);
		
		// On va v�rifier que le retour de la m�thode est bien 1
		assertEquals(resultatAttendu, adminDao.isExist(admin));

	}

	/**
	 * Methode pour v�rifier qu'on ne retrouve pas d'admin en entrant de fausses informations
	 */
	public void testIsExist2() {
		
		// On ne trouvera rien si la m�thode fonctionne
		int resultatAttendu = 0;
		
		// On cr�e un nouvel admin 
		Admin admin = new Admin("b", "b");

		// On ajoute cet admin � la base de donn�es
		adminDao.ajouterAdmin(admin);
		
		// On affecte un nouveau mail a l'admin
		admin.setMail("d");
		
		// On v�rifie qu'on ne trouve rien
		assertEquals(resultatAttendu, adminDao.isExist(admin));

	}
	
	/**
	 * Methode pour v�rifier qu'on ne retrouve pas de role en entrant de fausses infos
	 */
	public void testGetRoleByName1(){
		
		// On cr�e un role qui n'existe pas dans la base de donn�es
		String nomRole="role imaginaire";
		
		// On v�rifie que le resultat de la m�thode est bien null
		assertNull(adminDao.getRoleByName(nomRole));
		
	}
	
	/**
	 * Methode pour v�rifier qu'on retrouve bien un role en entrant un nom existant
	 */
	public void testGetRoleByName2(){
		
		
		// On cr�e un role qui existe
		Role roleAttendu=new Role(1,"ROLE_ADMIN");
		
		// On recherche que ce role existe bien dans la base de donn�es et qu'on le retrouve bien 
		assertEquals(roleAttendu, adminDao.getRoleByName(roleAttendu.getDesignation()));
	}
	
	/**
	 * Methode pour v�rifier qu'on modifie bien le role d'un admin dans la base de donn�es
	 */
	public void testModifierRole(){
		
		// On cr�e un role 
		Role role=new Role(1,"ROLE_USER");
		
		// On cr�e un admin
		Admin admin=new Admin("n","n");
		
		// On l'ajoute dans la base de donn�es
		adminDao.ajouterAdmin(admin);
	
		// On modifie le role de l'admin
		adminDao.modifierRole(admin, role);
		
		// On cr�e ce role comme String
		String designation=role.getDesignation();
		
		// On v�rifie que la designation du role est la meme que le role de l'admin
		assertEquals(designation, adminDao.getAdminByMail(admin.getMail()).getpRole().getDesignation());
		
	}
	
	/**
	 * Methode pour v�rifier qu'on supprime bien un admin dans la base de donn�es
	 */
	public void testSupprimerAdmin(){
		
		// On cr�e un admin
		Admin admin=new Admin("y","y");
		
		// On l'ajoute dans la base de donn�es
		adminDao.ajouterAdmin(admin);
		
		// On recup�re cette admin dans la base (pour avoir son id)
		admin=adminDao.getAdminByMail(admin.getMail());
		
		// On supprime l'admin dans la base
		adminDao.supprimerAdmin(admin.getId());
		
		// On v�rifie que cet admin n'existe pas 
		assertNull(adminDao.getAdminByMail(admin.getMail()));
			
	}
	
	
	
	
	
	
	
	// Test des m�thodes CRUD pour les objets de type Categorie
	
	
	
	
	
	// Test des m�thodes CRUD pour les objets de type Produit
	
	/**
	 * Methode pour v�rifier qu'on retrouve bien la liste des produits
	 */
	public void getAllProduitTest(){
		
		assertNotNull(adminDao.getAllProduit());
	}

}
