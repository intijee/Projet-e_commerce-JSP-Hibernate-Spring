package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping(value = "/adminProd")
public class AdminProdController {

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

		return "adminProdAccueil";
	}

	@RequestMapping(value = "/afficherFormAjouterProduit", method = RequestMethod.GET)
	public String afficherFormulaireAjouterProduit(Model model) {

		List<Categorie> listeCategorie = clientService.getAllCategorieService();

		// On ajoute la cat�gorie dans le model
		model.addAttribute("ajouterFormProduit", new Produit());
		model.addAttribute("listeCat", listeCategorie);

		return "ajouterProduit";
	}

	@RequestMapping(value = "/soumettreFormAjouterProduit", method = RequestMethod.POST)
	public String soumettreFormulaireAjouterAdmin(Model model, @ModelAttribute("ajouterFormProduit") Produit prod) {

		prod.setpCategorie(clientService.getCategorieByNameService(prod.getNomCat()));
		adminService.ajouterProduitService(prod);

		return "adminCatAccueil";

	}

	@RequestMapping(value = "/listeProduit", method = RequestMethod.GET)
	public String afficherProduit(ModelMap model) {

		// On recup�re la liste des produits gr�ce � la m�thode d'adminService
		List<Produit> listeProduit = adminService.getAllProduitService();

		// On ajoute la liste dans le model
		model.addAttribute("prodListe", listeProduit);

		// On navigue vers la page o� la liste sera affich�e
		return "gererProduit";
	}

	@RequestMapping(value = "/soumettreFormSupprimerProduit", method = RequestMethod.GET)
	public String soumettreFormulaireSupprimerProduit(Model model, @RequestParam("nom_param") String nom_produit) {

		// On recup�re le produit gr�ce � son nom
		Produit produit = adminService.chercherProduitByNameService(nom_produit);

		// On supprime le produit envoy�
		adminService.supprimerProduitByNameService(produit.getId());

		// On recup�re la liste des produits gr�ce � la m�thode d'adminService
		List<Produit> listeProduit = adminService.getAllProduitService();

		// On ajoute la liste dans le model
		model.addAttribute("prodListe", listeProduit);

		// On navigue vers la page o� la liste sera affich�e
		return "gererProduit";
	}

	@RequestMapping(value = "/afficherFormModifierProduit", method = RequestMethod.GET)
	public String afficherFormulaireModifierProduit(Model model, @RequestParam("prod_id_param") int id_produit) {

		// On retrouve le produit gr�ce � son id
		Produit prod=adminService.getProduitByIdService(id_produit);
		
		// On recup�re la liste des cat�gories
		List<Categorie> listeCategorie = clientService.getAllCategorieService();

		// On envoie le produit et la liste des cat�gories dans le modele
		model.addAttribute("modifierFormProduit", prod);
		model.addAttribute("listeCat", listeCategorie);

		// On affiche sur la page modifier
		return "modifierProduit";
	}

	@RequestMapping(value = "/soumettreFormModifierProduit", method = RequestMethod.POST)
	public String soumettreFormulaireModifierProduit(Model model, @ModelAttribute("modifierFormProduit") Produit produit) {

		produit.setpCategorie(clientService.getCategorieByNameService(produit.getNomCat()));

		// On envoie le produit � modifier
		adminService.modifierProduitService(produit.getId(), produit);

		return "adminProdAccueil";

	}

}
