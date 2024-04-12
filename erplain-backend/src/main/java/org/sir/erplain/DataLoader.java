package org.sir.erplain;
import org.sir.erplain.zsecurity.entity.AppUser;
import org.sir.erplain.zsecurity.entity.Role;
import org.sir.erplain.zsecurity.service.facade.AppUserService;
import org.sir.erplain.zsecurity.service.facade.RoleService;
import org.sir.erplain.zsecurity.permissions.RoleEnum;
import org.sir.erplain.service.facade.contacts.FournisseurService;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.service.facade.contacts.ClientTaxeService;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.user.AdminService;
import org.sir.erplain.bean.core.contacts.user.Admin;
import org.sir.erplain.service.facade.contacts.user.EmployeService;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.sir.erplain.service.facade.produit.ProduitTaxeService;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.service.facade.produit.ProduitService;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.service.facade.ventes.CommandeExpeditionService;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.sir.erplain.service.facade.ventes.PaiementService;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.service.facade.ventes.estimation.EstimationProduitService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeService;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.service.facade.ventes.commande.CommandeProduitService;
import org.sir.erplain.bean.core.ventes.commande.CommandeProduit;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeService;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.service.facade.ventes.facture.FactureProduitService;
import org.sir.erplain.bean.core.ventes.facture.FactureProduit;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitProduitService;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduitProduit;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitService;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditTaxeService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditProduitService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditProduit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementTaxeService;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementProduitService;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.service.facade.inventaire.NiveauStockService;
import org.sir.erplain.bean.core.inventaire.NiveauStock;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeExpeditionService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeProduitService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeProduit;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonTaxeExpeditionService;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonProduitService;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonProduit;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonService;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.service.facade.parametres.DestinataireEmployeService;
import org.sir.erplain.bean.core.parametres.DestinataireEmploye;
import org.sir.erplain.service.facade.parametres.AlerteService;
import org.sir.erplain.bean.core.parametres.Alerte;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.DevisService;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.service.facade.parametres.NouvelleDeviseService;
import org.sir.erplain.bean.core.parametres.NouvelleDevise;
import org.sir.erplain.service.facade.parametres.MethodePaiementService;
import org.sir.erplain.bean.core.parametres.MethodePaiement;
import org.sir.erplain.service.facade.parametres.NiveauPrixService;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.service.facade.parametres.TaxeService;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.service.facade.address.AddressService;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.service.facade.address.CountryService;
import org.sir.erplain.bean.core.address.Country;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;
@Component
public class DataLoader implements ApplicationRunner {
@Value("${app.data-loader.load}")
private boolean load;
@Override
public void run(ApplicationArguments args) throws Exception {
if (load) {
System.out.println("Data Loading...");
generatePermission();
generateAdminAccount();
generateEmployeAccount();
generateFournisseur();
generateClientTaxe();
generateClient();
generateAdmin();
generateEmploye();
generateProduitTaxe();
generateProduit();
generateCommandeExpedition();
generatePaiement();
generateEstimationTaxe();
generateEstimationTaxeExpedition();
generateEstimationProduit();
generateEstimation();
generateCommandeTaxe();
generateCommandeTaxeExpedition();
generateCommandeProduit();
generateCommande();
generateFactureTaxe();
generateFactureTaxeExpedition();
generateFactureProduit();
generateFacture();
generateRetourProduitProduit();
generateRetourProduit();
generateNoteCreditTaxe();
generateNoteCreditProduit();
generateNoteCredit();
generateRemboursementTaxe();
generateRemboursementProduit();
generateRemboursement();
generateNiveauStock();
generateBonCommandeTaxe();
generateBonCommandeTaxeExpedition();
generateBonCommandeProduit();
generateBonCommande();
generateLivraisonTaxeExpedition();
generateLivraisonProduit();
generateLivraison();
generateDestinataireEmploye();
generateAlerte();
generateEntreprise();
generateDevis();
generateNouvelleDevise();
generateMethodePaiement();
generateNiveauPrix();
generateTaxe();
generateAddress();
generateCountry();
System.out.println("Data Loaded!");
}
}
private void generatePermission() {
for (RoleEnum role : RoleEnum.values()) {
var roleEntity = role.getRole();
roleService.save(roleEntity);
}
}
private void generateAdminAccount() {
AppUser user = new AppUser("admin");
user.setPassword("123");
Role role = new Role();
role.setName(RoleEnum.ADMIN.name());
user.setRoles(new ArrayList<>());
user.getRoles().add(role);
appUserService.save(user);
System.out.println("One Account For ADMIN role is created: 'admin' :: '123'");
}
private void generateEmployeAccount() {
AppUser user = new AppUser("employe");
user.setPassword("123");
Role role = new Role();
role.setName(RoleEnum.EMPLOYE.name());
user.setRoles(new ArrayList<>());
user.getRoles().add(role);
appUserService.save(user);
System.out.println("One Account For EMPLOYE role is created: 'employe' :: '123'");
}
private void generateFournisseur() {
for (int i = 0; i < 50; i++) {
Fournisseur item = new Fournisseur();
item.setNom("nom " + i);
item.setCode("code " + i);
item.setEmail("email " + i);
item.setSiteweb("siteweb " + i);
item.setTelephone("telephone " + i);
fournisseurService.create(item);
}
System.out.println("Data For Fournisseur Generated!");
}
private void generateClientTaxe() {
for (int i = 0; i < 50; i++) {
ClientTaxe item = new ClientTaxe();
clientTaxeService.create(item);
}
System.out.println("Data For ClientTaxe Generated!");
}
private void generateClient() {
for (int i = 0; i < 50; i++) {
Client item = new Client();
item.setNom("nom " + i);
item.setCode("code " + i);
item.setEmail("email " + i);
item.setSiteweb("siteweb " + i);
item.setTelephone("telephone " + i);
clientService.create(item);
}
System.out.println("Data For Client Generated!");
}
private void generateAdmin() {
for (int i = 0; i < 50; i++) {
Admin item = new Admin();
item.setNom("nom " + i);
item.setPrenom("prenom " + i);
item.setUsername("Admin " + i);
item.setPassword(appUserService.cryptPassword("Admin " + i));
List<Role> savedRoles = roleService.save(item.getRoles());
item.setRoles(savedRoles);
adminService.create(item);
}
System.out.println("Data For Admin Generated!");
}
private void generateEmploye() {
for (int i = 0; i < 50; i++) {
Employe item = new Employe();
item.setNom("nom " + i);
item.setPrenom("prenom " + i);
item.setCode("code " + i);
item.setTelephone("telephone " + i);
item.setUsername("Employe " + i);
item.setPassword(appUserService.cryptPassword("Employe " + i));
List<Role> savedRoles = roleService.save(item.getRoles());
item.setRoles(savedRoles);
employeService.create(item);
}
System.out.println("Data For Employe Generated!");
}
private void generateProduitTaxe() {
for (int i = 0; i < 50; i++) {
ProduitTaxe item = new ProduitTaxe();
produitTaxeService.create(item);
}
System.out.println("Data For ProduitTaxe Generated!");
}
private void generateProduit() {
for (int i = 0; i < 50; i++) {
Produit item = new Produit();
item.setNom("nom " + i);
item.setSku("sku " + i);
item.setBarcode("barcode " + i);
item.setEmplacementDeBac("emplacementDeBac " + i);
produitService.create(item);
}
System.out.println("Data For Produit Generated!");
}
private void generateCommandeExpedition() {
for (int i = 0; i < 50; i++) {
CommandeExpedition item = new CommandeExpedition();
item.setCode("code " + i);
commandeExpeditionService.create(item);
}
System.out.println("Data For CommandeExpedition Generated!");
}
private void generatePaiement() {
for (int i = 0; i < 50; i++) {
Paiement item = new Paiement();
paiementService.create(item);
}
System.out.println("Data For Paiement Generated!");
}
private void generateEstimationTaxe() {
for (int i = 0; i < 50; i++) {
EstimationTaxe item = new EstimationTaxe();
estimationTaxeService.create(item);
}
System.out.println("Data For EstimationTaxe Generated!");
}
private void generateEstimationTaxeExpedition() {
for (int i = 0; i < 50; i++) {
EstimationTaxeExpedition item = new EstimationTaxeExpedition();
estimationTaxeExpeditionService.create(item);
}
System.out.println("Data For EstimationTaxeExpedition Generated!");
}
private void generateEstimationProduit() {
for (int i = 0; i < 50; i++) {
EstimationProduit item = new EstimationProduit();
estimationProduitService.create(item);
}
System.out.println("Data For EstimationProduit Generated!");
}
private void generateEstimation() {
for (int i = 0; i < 50; i++) {
Estimation item = new Estimation();
item.setCode("code " + i);
estimationService.create(item);
}
System.out.println("Data For Estimation Generated!");
}
private void generateCommandeTaxe() {
for (int i = 0; i < 50; i++) {
CommandeTaxe item = new CommandeTaxe();
commandeTaxeService.create(item);
}
System.out.println("Data For CommandeTaxe Generated!");
}
private void generateCommandeTaxeExpedition() {
for (int i = 0; i < 50; i++) {
CommandeTaxeExpedition item = new CommandeTaxeExpedition();
commandeTaxeExpeditionService.create(item);
}
System.out.println("Data For CommandeTaxeExpedition Generated!");
}
private void generateCommandeProduit() {
for (int i = 0; i < 50; i++) {
CommandeProduit item = new CommandeProduit();
commandeProduitService.create(item);
}
System.out.println("Data For CommandeProduit Generated!");
}
private void generateCommande() {
for (int i = 0; i < 50; i++) {
Commande item = new Commande();
item.setCode("code " + i);
commandeService.create(item);
}
System.out.println("Data For Commande Generated!");
}
private void generateFactureTaxe() {
for (int i = 0; i < 50; i++) {
FactureTaxe item = new FactureTaxe();
factureTaxeService.create(item);
}
System.out.println("Data For FactureTaxe Generated!");
}
private void generateFactureTaxeExpedition() {
for (int i = 0; i < 50; i++) {
FactureTaxeExpedition item = new FactureTaxeExpedition();
factureTaxeExpeditionService.create(item);
}
System.out.println("Data For FactureTaxeExpedition Generated!");
}
private void generateFactureProduit() {
for (int i = 0; i < 50; i++) {
FactureProduit item = new FactureProduit();
factureProduitService.create(item);
}
System.out.println("Data For FactureProduit Generated!");
}
private void generateFacture() {
for (int i = 0; i < 50; i++) {
Facture item = new Facture();
item.setCode("code " + i);
factureService.create(item);
}
System.out.println("Data For Facture Generated!");
}
private void generateRetourProduitProduit() {
for (int i = 0; i < 50; i++) {
RetourProduitProduit item = new RetourProduitProduit();
retourProduitProduitService.create(item);
}
System.out.println("Data For RetourProduitProduit Generated!");
}
private void generateRetourProduit() {
for (int i = 0; i < 50; i++) {
RetourProduit item = new RetourProduit();
item.setCode("code " + i);
retourProduitService.create(item);
}
System.out.println("Data For RetourProduit Generated!");
}
private void generateNoteCreditTaxe() {
for (int i = 0; i < 50; i++) {
NoteCreditTaxe item = new NoteCreditTaxe();
noteCreditTaxeService.create(item);
}
System.out.println("Data For NoteCreditTaxe Generated!");
}
private void generateNoteCreditProduit() {
for (int i = 0; i < 50; i++) {
NoteCreditProduit item = new NoteCreditProduit();
noteCreditProduitService.create(item);
}
System.out.println("Data For NoteCreditProduit Generated!");
}
private void generateNoteCredit() {
for (int i = 0; i < 50; i++) {
NoteCredit item = new NoteCredit();
item.setCode("code " + i);
noteCreditService.create(item);
}
System.out.println("Data For NoteCredit Generated!");
}
private void generateRemboursementTaxe() {
for (int i = 0; i < 50; i++) {
RemboursementTaxe item = new RemboursementTaxe();
remboursementTaxeService.create(item);
}
System.out.println("Data For RemboursementTaxe Generated!");
}
private void generateRemboursementProduit() {
for (int i = 0; i < 50; i++) {
RemboursementProduit item = new RemboursementProduit();
remboursementProduitService.create(item);
}
System.out.println("Data For RemboursementProduit Generated!");
}
private void generateRemboursement() {
for (int i = 0; i < 50; i++) {
Remboursement item = new Remboursement();
item.setCode("code " + i);
remboursementService.create(item);
}
System.out.println("Data For Remboursement Generated!");
}
private void generateNiveauStock() {
for (int i = 0; i < 50; i++) {
NiveauStock item = new NiveauStock();
item.setNom("nom " + i);
item.setSku("sku " + i);
item.setDisponible("disponible " + i);
niveauStockService.create(item);
}
System.out.println("Data For NiveauStock Generated!");
}
private void generateBonCommandeTaxe() {
for (int i = 0; i < 50; i++) {
BonCommandeTaxe item = new BonCommandeTaxe();
bonCommandeTaxeService.create(item);
}
System.out.println("Data For BonCommandeTaxe Generated!");
}
private void generateBonCommandeTaxeExpedition() {
for (int i = 0; i < 50; i++) {
BonCommandeTaxeExpedition item = new BonCommandeTaxeExpedition();
bonCommandeTaxeExpeditionService.create(item);
}
System.out.println("Data For BonCommandeTaxeExpedition Generated!");
}
private void generateBonCommandeProduit() {
for (int i = 0; i < 50; i++) {
BonCommandeProduit item = new BonCommandeProduit();
bonCommandeProduitService.create(item);
}
System.out.println("Data For BonCommandeProduit Generated!");
}
private void generateBonCommande() {
for (int i = 0; i < 50; i++) {
BonCommande item = new BonCommande();
item.setCode("code " + i);
bonCommandeService.create(item);
}
System.out.println("Data For BonCommande Generated!");
}
private void generateLivraisonTaxeExpedition() {
for (int i = 0; i < 50; i++) {
LivraisonTaxeExpedition item = new LivraisonTaxeExpedition();
livraisonTaxeExpeditionService.create(item);
}
System.out.println("Data For LivraisonTaxeExpedition Generated!");
}
private void generateLivraisonProduit() {
for (int i = 0; i < 50; i++) {
LivraisonProduit item = new LivraisonProduit();
livraisonProduitService.create(item);
}
System.out.println("Data For LivraisonProduit Generated!");
}
private void generateLivraison() {
for (int i = 0; i < 50; i++) {
Livraison item = new Livraison();
item.setCode("code " + i);
livraisonService.create(item);
}
System.out.println("Data For Livraison Generated!");
}
private void generateDestinataireEmploye() {
for (int i = 0; i < 50; i++) {
DestinataireEmploye item = new DestinataireEmploye();
destinataireEmployeService.create(item);
}
System.out.println("Data For DestinataireEmploye Generated!");
}
private void generateAlerte() {
for (int i = 0; i < 50; i++) {
Alerte item = new Alerte();
item.setNom("nom " + i);
alerteService.create(item);
}
System.out.println("Data For Alerte Generated!");
}
private void generateEntreprise() {
for (int i = 0; i < 50; i++) {
Entreprise item = new Entreprise();
item.setNom("nom " + i);
item.setEmail("email " + i);
item.setTelephone("telephone " + i);
item.setSiteweb("siteweb " + i);
item.setLogo("logo " + i);
entrepriseService.create(item);
}
System.out.println("Data For Entreprise Generated!");
}
private void generateDevis() {
for (int i = 0; i < 50; i++) {
Devis item = new Devis();
devisService.create(item);
}
System.out.println("Data For Devis Generated!");
}
private void generateNouvelleDevise() {
for (int i = 0; i < 50; i++) {
NouvelleDevise item = new NouvelleDevise();
item.setLabelle("labelle " + i);
nouvelleDeviseService.create(item);
}
System.out.println("Data For NouvelleDevise Generated!");
}
private void generateMethodePaiement() {
for (int i = 0; i < 50; i++) {
MethodePaiement item = new MethodePaiement();
item.setNom("nom " + i);
methodePaiementService.create(item);
}
System.out.println("Data For MethodePaiement Generated!");
}
private void generateNiveauPrix() {
for (int i = 0; i < 50; i++) {
NiveauPrix item = new NiveauPrix();
item.setNom("nom " + i);
niveauPrixService.create(item);
}
System.out.println("Data For NiveauPrix Generated!");
}
private void generateTaxe() {
for (int i = 0; i < 50; i++) {
Taxe item = new Taxe();
item.setNom("nom " + i);
taxeService.create(item);
}
System.out.println("Data For Taxe Generated!");
}
private void generateAddress() {
for (int i = 0; i < 50; i++) {
Address item = new Address();
item.setAddress1("address1 " + i);
item.setAddress2("address2 " + i);
item.setPostalCode("postalCode " + i);
item.setCity("city " + i);
addressService.create(item);
}
System.out.println("Data For Address Generated!");
}
private void generateCountry() {
for (int i = 0; i < 50; i++) {
Country item = new Country();
item.setName("name " + i);
countryService.create(item);
}
System.out.println("Data For Country Generated!");
}
@Autowired private FournisseurService fournisseurService;
@Autowired private ClientTaxeService clientTaxeService;
@Autowired private ClientService clientService;
@Autowired private AdminService adminService;
@Autowired private EmployeService employeService;
@Autowired private ProduitTaxeService produitTaxeService;
@Autowired private ProduitService produitService;
@Autowired private CommandeExpeditionService commandeExpeditionService;
@Autowired private PaiementService paiementService;
@Autowired private EstimationTaxeService estimationTaxeService;
@Autowired private EstimationTaxeExpeditionService estimationTaxeExpeditionService;
@Autowired private EstimationProduitService estimationProduitService;
@Autowired private EstimationService estimationService;
@Autowired private CommandeTaxeService commandeTaxeService;
@Autowired private CommandeTaxeExpeditionService commandeTaxeExpeditionService;
@Autowired private CommandeProduitService commandeProduitService;
@Autowired private CommandeService commandeService;
@Autowired private FactureTaxeService factureTaxeService;
@Autowired private FactureTaxeExpeditionService factureTaxeExpeditionService;
@Autowired private FactureProduitService factureProduitService;
@Autowired private FactureService factureService;
@Autowired private RetourProduitProduitService retourProduitProduitService;
@Autowired private RetourProduitService retourProduitService;
@Autowired private NoteCreditTaxeService noteCreditTaxeService;
@Autowired private NoteCreditProduitService noteCreditProduitService;
@Autowired private NoteCreditService noteCreditService;
@Autowired private RemboursementTaxeService remboursementTaxeService;
@Autowired private RemboursementProduitService remboursementProduitService;
@Autowired private RemboursementService remboursementService;
@Autowired private NiveauStockService niveauStockService;
@Autowired private BonCommandeTaxeService bonCommandeTaxeService;
@Autowired private BonCommandeTaxeExpeditionService bonCommandeTaxeExpeditionService;
@Autowired private BonCommandeProduitService bonCommandeProduitService;
@Autowired private BonCommandeService bonCommandeService;
@Autowired private LivraisonTaxeExpeditionService livraisonTaxeExpeditionService;
@Autowired private LivraisonProduitService livraisonProduitService;
@Autowired private LivraisonService livraisonService;
@Autowired private DestinataireEmployeService destinataireEmployeService;
@Autowired private AlerteService alerteService;
@Autowired private EntrepriseService entrepriseService;
@Autowired private DevisService devisService;
@Autowired private NouvelleDeviseService nouvelleDeviseService;
@Autowired private MethodePaiementService methodePaiementService;
@Autowired private NiveauPrixService niveauPrixService;
@Autowired private TaxeService taxeService;
@Autowired private AddressService addressService;
@Autowired private CountryService countryService;
@Autowired private AppUserService appUserService;
@Autowired private RoleService roleService;
}