package fr.adaming.controller;

import java.util.ArrayList;
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
import fr.adaming.entities.Client;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@Autowired
	IAdminService adminService;

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}


	LigneCommande ligneCommande = new LigneCommande();
	
	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	
	List<LigneCommande> listeCommande = new ArrayList<LigneCommande>();
	

	public void setListeCommande(List<LigneCommande> listeCommande) {
		this.listeCommande = listeCommande;
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

	// lien la recherche par mot cl� et son formulaire
	@RequestMapping(value = "/motCle", method = RequestMethod.GET)
	public String chercherMotCle(ModelMap model) {
		model.addAttribute("produitMotCle", new Produit());
		return "clientMotCle";
	}

	// resultat de la requete mot cl�
	@RequestMapping(value = "/soumettreMotCle", method = RequestMethod.POST)
	public String soumettreFormulaireAjouterAdmin(Model model, @ModelAttribute("produitMotCle") Produit produit) {

		List<Produit> listeProduitRecherche = clientService.chercherProduitMotCleService(produit.getDesignation());
		model.addAttribute("listeRecherche", listeProduitRecherche);

		return "resultatRecherche";

	}

	// affichage des cat�gories
	@RequestMapping(value = "/afficherCat", method = RequestMethod.GET)
	public String afficherLesCategories(ModelMap model) {
// C'est un formulaire avec la liste d�roulante des cat�gorie en entr�e
		model.addAttribute("cat", new Categorie());
// Affichage de la liste des cat�gories
		List<Categorie> listeCategorie = clientService.getAllCategorieService();
		model.addAttribute("catListe", listeCategorie);
// Affichage dans le menu d�roulant de la liste
		List<String> listeNomCat = clientService.getAllCategorieNameService();
		model.addAttribute("catNomListe", listeNomCat);

		return "clientCategorie";
	}

	@RequestMapping(value = "/soumettreCat", method = RequestMethod.POST)
	public String soumettreLesCategories(ModelMap model, @ModelAttribute("cat") Categorie cat) {
		// Categorie categorie = clientService.getCategorieByNameService(cat);

		Categorie categorie = clientService.getCategorieByNameService(cat.getNom());
		
		//On r�cup�re les produit de la cat�gorie correspondante
		List<Produit> listeProduit = clientService.getAllProduitCategorieService(categorie);
		model.addAttribute("listeProduitCat", listeProduit);

		return "resultatCategorie";
	}

	@RequestMapping(value = "/ajouterPanier", method = RequestMethod.GET)
	public String soumettreFormulaireAjouterProduitPanier(Model model, @RequestParam("param") String nom_produit) {
		
		// On r�cup�re le produit � partir du nom r�cup�r� sur la page
		Produit produit = adminService.chercherProduitByNameService(nom_produit);
		clientService.selectionnerProduitByNameService(produit.getId());
		
//		this.ligneCommande.setpProduit(produit);
//		this.ligneCommande.setQuantite(produit.getQuantite());
//		List<Produit> listeProduitSelectionne = clientService.getAllProduitSelectionneService();
//		model.addAttribute("prodListeSelection", listeProduitSelectionne);
//
//		long prixarticle = produit.getPrix() * ligneCommande.getQuantite();
//		this.ligneCommande.setPrix(prixarticle);
//		//List<LigneCommande> listeCommande = new ArrayList<LigneCommande>();
//		this.listeCommande.add(ligneCommande);
//		Panier panier = new Panier();
//		panier.setListeLigneCommandes(listeCommande);
		
		// On renvoie la liste des produits s�lectionn�s
		List<Produit> listeProduitSelectionne = clientService.getAllProduitSelectionneService();
		model.addAttribute("prodListeSelection", listeProduitSelectionne);
		
//		long pprix = 0;
//		for (LigneCommande lc : this.listeCommande) {
//			long prix = lc.getPrix();
//			pprix = pprix + prix;
//		}
		
		long pprix = 0;
		for (Produit p : listeProduitSelectionne) {
			long prix = p.getPrix();
			pprix = pprix + prix;
		}
		model.addAttribute("prix", pprix);
		return "clientPanier";
	}

	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String afficherPanier(Model model) {
// Affichage des produits dans le panier
		List<Produit> listeProduitSelectionne = clientService.getAllProduitSelectionneService();
		model.addAttribute("prodListeSelection", listeProduitSelectionne);
//Affichage du prix
		long pprix = 0;
		for (Produit p : listeProduitSelectionne) {
			long prix = p.getPrix();
			pprix = pprix + prix;
		}
		model.addAttribute("prix", pprix);

		return "clientPanier";
	}

	@RequestMapping(value = "/supprimerPanier", method = RequestMethod.GET)
	public String soumettreFormulaireSupprimerProduitPanier(Model model) {
		// Vider le panier
		clientService.remiseZeroSelectionneService();
		List<Produit> listeProduitSelectionne = clientService.getAllProduitSelectionneService();
		model.addAttribute("prodListeSelection", listeProduitSelectionne);
		return "clientPanier";
	}

	@RequestMapping(value = "/enregistrerClient", method = RequestMethod.GET)
	public String enregistrerCommandeAfficher(Model model) {
		//Formulaire pour enregistrer le client
		model.addAttribute("client", new Client());
		return "clientFormulaire";
	}

	@RequestMapping(value = "/soumettreClient", method = RequestMethod.POST)
	public String enregistrerCommandeSoumettre(ModelMap model, @ModelAttribute("client") Client client) {
		
// On enregistre le client
		clientService.EnregistrerClientCommandeService(client);

		return "clientAccueil";
	}

}
