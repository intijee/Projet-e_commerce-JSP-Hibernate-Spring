package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Role;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCatController {

	@Autowired
	IAdminService adminService;

	/**
	 * @param adminService
	 *            the adminService to set
	 */
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	@Autowired
	IClientService clientService;

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/acc", method = RequestMethod.GET)
	public String accueil(ModelMap model) {

		return "adminCatAccueil";
	}

	@RequestMapping(value = "/afficherFormAjouterCategorie", method = RequestMethod.GET)
	public String afficherFormulaireAjouterCategorie(Model model) {

		// On ajoute la cat�gorie dans le model
		model.addAttribute("ajouterFormCategorie", new Categorie());

		return "ajouterCategorie";
	}

	@RequestMapping(value = "/soumettreFormAjouterCategorie", method = RequestMethod.POST)
	public String soumettreFormulaireAjouter(Model model, @ModelAttribute("ajouterFormCategorie") Categorie pCat) {

		// On ajoute l'employ� qui contient les informations du formulaire
		adminService.ajouterCategorieService(pCat);

		return "adminCatAccueil";

	}

	@RequestMapping(value = "/listeCategories", method = RequestMethod.GET)
	public String afficherCategories(ModelMap model) {

		// On recup�re la liste des employ�s gr�ce � la m�thode d'employeService
		List<Categorie> listeCategorie = clientService.getAllCategorieService();

		// On ajoute la liste dans le model
		model.addAttribute("catListe", listeCategorie);

		// On navigue vers la page o� la liste sera affich�e
		return "gererCategorie";
	}

	@RequestMapping(value = "/soumettreFormSupprimerCategorie", method = RequestMethod.GET)
	public String soumettreFormulaireSupprimer(Model model, @RequestParam("nom_param") String nom_categorie) {

		// On recup�re l'employ� gr�ce � son id
		Categorie cat = clientService.getCategorieByNameService(nom_categorie);

		// On supprime l'employ� envoy�
		adminService.supprimerCategorieService(cat);

		// On recup�re la liste des employ�s gr�ce � la m�thode d'employeService
		List<Categorie> listeCategorie = clientService.getAllCategorieService();

		// On ajoute la liste dans le model
		model.addAttribute("catListe", listeCategorie);

		// On retourne sur l'accueil
		return "gererCategorie";

	}

	@RequestMapping(value = "/afficherFormModifierCategorie", method = RequestMethod.GET)
	public String afficherFormulaireModifier(Model model, @RequestParam("cat_id_param") long id_cat) {

		Categorie cat = adminService.getCategorieByIdService(id_cat);

		model.addAttribute("modifierFormCategorie", cat);

		// On affiche sur la page modifier
		return "modifierCategorie";
	}

	@RequestMapping(value = "/soumettreFormModifierCategorie", method = RequestMethod.POST)
	public String soumettreFormulaireModifier(Model model, @ModelAttribute("modifierFormCategorie") Categorie cat) {

		// On envoie la cat�gorie � modifier
		adminService.modifierCategorieService(cat.getId(), cat);

		return "adminCatAccueil";

	}

	@RequestMapping(value = "/afficherFormAjouterAdmin", method = RequestMethod.GET)
	public String afficherFormulaireAjouterAdmin(Model model) {

		// On ajoute la cat�gorie dans le model
		model.addAttribute("ajouterFormAdmin", new Admin());

		return "ajouterAdmin";
	}

	@RequestMapping(value = "/soumettreFormAjouterAdmin", method = RequestMethod.POST)
	public String soumettreFormulaireAjouterAdmin(Model model, @ModelAttribute("ajouterFormAdmin") Admin ad) {

		ad.setpRole(adminService.getRoleByNameService(ad.getNomRole()));
		adminService.ajouterAdminService(ad);

		return "adminCatAccueil";

	}

	@RequestMapping(value = "/listeAdmin", method = RequestMethod.GET)
	public String afficherAdmin(ModelMap model) {

		// On recup�re la liste des admins gr�ce � la m�thode d'adminService
		List<Admin> listeAdmin = adminService.getAllAdminService();

		// On ajoute la liste dans le model
		model.addAttribute("adminListe", listeAdmin);

		// On navigue vers la page o� la liste sera affich�e
		return "gererAdmin";
	}

	@RequestMapping(value = "/soumettreFormSupprimerAdmin", method = RequestMethod.GET)
	public String soumettreFormulaireSupprimerAdmin(Model model, @RequestParam("mail_param") String mail_admin) {

		// On recup�re l'employ� gr�ce � son id
		Admin ad = adminService.getAdminByMailService(mail_admin);

		// On supprime l'employ� envoy�
		adminService.supprimerAdminService(ad.getId());

		// On recup�re la liste des admins gr�ce � la m�thode d'adminService
		List<Admin> listeAdmin = adminService.getAllAdminService();

		// On ajoute la liste dans le model
		model.addAttribute("adListe", listeAdmin);

		// On navigue vers la page o� la liste sera affich�e
		return "gererAdmin";

	}
	
	
	@RequestMapping(value = "/afficherFormModifierAdmin", method = RequestMethod.GET)
	public String afficherFormulaireModifierAdmin(Model model, @RequestParam("ad_mail_param") String mail_admin) {

		Admin ad = adminService.getAdminByMailService(mail_admin);

		model.addAttribute("modifierFormAdmin", ad);

		// On affiche sur la page modifier
		return "modifierAdmin";
	}

	@RequestMapping(value = "/soumettreFormModifierAdmin", method = RequestMethod.POST)
	public String soumettreFormulaireModifierAdmin(Model model, @ModelAttribute("modifierFormAdmin") Admin ad) {
		
		ad.setpRole(adminService.getRoleByNameService(ad.getNomRole()));
		
		// On envoie l'admin � modifier
		adminService.modifierRoleService(ad,ad.getpRole());

		return "adminCatAccueil";

	}

}
