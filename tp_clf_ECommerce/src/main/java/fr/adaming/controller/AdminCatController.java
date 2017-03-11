package fr.adaming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Categorie;
import fr.adaming.service.IAdminService;

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

	
	
	@RequestMapping(value = "/acc", method = RequestMethod.GET)
	public String accueil(ModelMap model) {

		return "adminCatAccueil";
	}
	
	
	@RequestMapping(value = "/afficherFormAjouterCategorie", method = RequestMethod.GET)
	public String afficherFormulaireAjouterCategorie(Model model) {

		// On ajoute la catégorie dans le model
		model.addAttribute("ajouterFormCategorie", new Categorie());

		return "ajouterCategorie";
	}

	
	@RequestMapping(value = "/soumettreFormAjouterCategorie", method = RequestMethod.POST)
	public String soumettreFormulaireAjouter(Model model,@ModelAttribute("ajouterFormCategorie") Categorie pCat) {


			// On ajoute l'employé qui contient les informations du formulaire
			adminService.ajouterCategorieService(pCat);
			
			return "adminCatAccueil";
	
		}
}
