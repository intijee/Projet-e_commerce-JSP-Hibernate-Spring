package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	IClientService clientService;
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	// lien vers accueil
	@RequestMapping(value = "/acc", method = RequestMethod.GET)
	public String accueil(ModelMap model) {

		return "accueil";
	}

	// lien vers accueil du client
	@RequestMapping(value = "/accueilClient", method = RequestMethod.GET)
	public String accueilClient(ModelMap model) {

		return "clientAccueil";
	}

	// lien la recherche par mot clé
	@RequestMapping(value = "/motCle", method = RequestMethod.GET)
	public String chercherMotCle(ModelMap model) {
		model.addAttribute("produitMotCle", new Produit());
		return "clientMotCle";
	}

	// resultat de la requete mot clé
	@RequestMapping(value = "/soumettreMotCle", method = RequestMethod.POST)
	public String soumettreFormulaireAjouterAdmin(Model model, @ModelAttribute("produitMotCle") Produit produit) {

		List<Produit> listeProduitRecherche = clientService.chercherProduitMotCleService(produit.getDesignation());
		model.addAttribute("listeRecherche", listeProduitRecherche);

		return "resultatRecherche";

	}
	// affichage des catégories
	@RequestMapping(value = "/afficherCat", method = RequestMethod.GET)
	public String afficherLesCategories(ModelMap model) {
		
		model.addAttribute("cat", new Categorie());
		
		List<Categorie> listeCategorie = clientService.getAllCategorieService();
		model.addAttribute("catListe", listeCategorie);
		
		List<String> listeNomCat = clientService.getAllCategorieNameService();
		model.addAttribute("catNomListe",listeNomCat);
		

		return "clientCategorie";
	}
	@RequestMapping(value = "/soumettreCat", method = RequestMethod.POST)
	public String soumettreLesCategories(ModelMap model, @ModelAttribute("cat") Categorie cat) {
		//Categorie categorie = clientService.getCategorieByNameService(cat);
		
		Categorie categorie = clientService.getCategorieByNameService(cat.getNom());
		List<Produit> listeProduit = clientService.getAllProduitCategorieService(categorie);
		model.addAttribute("listeProduitCat", listeProduit);
		

		return "resultatCategorie";
	}
	
	
}
