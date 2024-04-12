package org.sir.erplain.zsecurity.config;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.sir.erplain.zsecurity.permissions.resources.*;
import org.sir.erplain.zsecurity.permissions.RoleEnum;
import static org.springframework.http.HttpMethod.*;
public class RequestConfig {
private RequestConfig() {}
private static HttpSecurity http;
public static void set(HttpSecurity http) throws Exception {
if (RequestConfig.http == null) RequestConfig.http = http;
fournisseurAuthorizeHttpRequests();
clientTaxeAuthorizeHttpRequests();
clientAuthorizeHttpRequests();
adminAuthorizeHttpRequests();
employeAuthorizeHttpRequests();
produitTaxeAuthorizeHttpRequests();
produitAuthorizeHttpRequests();
commandeExpeditionAuthorizeHttpRequests();
paiementAuthorizeHttpRequests();
estimationTaxeAuthorizeHttpRequests();
estimationTaxeExpeditionAuthorizeHttpRequests();
estimationProduitAuthorizeHttpRequests();
estimationAuthorizeHttpRequests();
commandeTaxeAuthorizeHttpRequests();
commandeTaxeExpeditionAuthorizeHttpRequests();
commandeProduitAuthorizeHttpRequests();
commandeAuthorizeHttpRequests();
factureTaxeAuthorizeHttpRequests();
factureTaxeExpeditionAuthorizeHttpRequests();
factureProduitAuthorizeHttpRequests();
factureAuthorizeHttpRequests();
retourProduitProduitAuthorizeHttpRequests();
retourProduitAuthorizeHttpRequests();
noteCreditTaxeAuthorizeHttpRequests();
noteCreditProduitAuthorizeHttpRequests();
noteCreditAuthorizeHttpRequests();
remboursementTaxeAuthorizeHttpRequests();
remboursementProduitAuthorizeHttpRequests();
remboursementAuthorizeHttpRequests();
niveauStockAuthorizeHttpRequests();
bonCommandeTaxeAuthorizeHttpRequests();
bonCommandeTaxeExpeditionAuthorizeHttpRequests();
bonCommandeProduitAuthorizeHttpRequests();
bonCommandeAuthorizeHttpRequests();
livraisonTaxeExpeditionAuthorizeHttpRequests();
livraisonProduitAuthorizeHttpRequests();
livraisonAuthorizeHttpRequests();
destinataireEmployeAuthorizeHttpRequests();
alerteAuthorizeHttpRequests();
entrepriseAuthorizeHttpRequests();
devisAuthorizeHttpRequests();
nouvelleDeviseAuthorizeHttpRequests();
methodePaiementAuthorizeHttpRequests();
niveauPrixAuthorizeHttpRequests();
taxeAuthorizeHttpRequests();
addressAuthorizeHttpRequests();
countryAuthorizeHttpRequests();
appUserAuthorizeHttpRequests();
roleAuthorizeHttpRequests();
defaultAuthorizeHttpRequests();
}
private static void appUserAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/v1/user/**").hasAnyAuthority(UserPermission.READ.authority())
.requestMatchers(POST, "/api/v1/user/**").hasAnyAuthority(UserPermission.CREATE.authority())
.requestMatchers(PUT, "/api/v1/user/**").hasAnyAuthority(UserPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/v1/user/**").hasAnyAuthority(UserPermission.DELETE.authority())
.requestMatchers("/api/v1/user/**").hasAnyRole(RoleEnum.ADMIN.name())
);
}
private static void roleAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/v1/role/**").hasAnyAuthority(RolePermission.READ.authority())
.requestMatchers(POST, "/api/v1/role/**").hasAnyAuthority(RolePermission.CREATE.authority())
.requestMatchers(PUT, "/api/v1/role/**").hasAnyAuthority(RolePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/v1/role/**").hasAnyAuthority(RolePermission.DELETE.authority())
.requestMatchers("/api/v1/role/**").hasAnyRole(RoleEnum.ADMIN.name())
);
}
private static void fournisseurAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/fournisseur/**").hasAnyAuthority(FournisseurPermission.READ.authority())
.requestMatchers(POST, "/api/fournisseur/**").hasAnyAuthority(FournisseurPermission.CREATE.authority())
.requestMatchers(PUT, "/api/fournisseur/**").hasAnyAuthority(FournisseurPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/fournisseur/**").hasAnyAuthority(FournisseurPermission.DELETE.authority())
.requestMatchers("/api/fournisseur/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void clientTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/clienttaxe/**").hasAnyAuthority(ClientTaxePermission.READ.authority())
.requestMatchers(POST, "/api/clienttaxe/**").hasAnyAuthority(ClientTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/clienttaxe/**").hasAnyAuthority(ClientTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/clienttaxe/**").hasAnyAuthority(ClientTaxePermission.DELETE.authority())
.requestMatchers("/api/clienttaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void clientAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/client/**").hasAnyAuthority(ClientPermission.READ.authority())
.requestMatchers(POST, "/api/client/**").hasAnyAuthority(ClientPermission.CREATE.authority())
.requestMatchers(PUT, "/api/client/**").hasAnyAuthority(ClientPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/client/**").hasAnyAuthority(ClientPermission.DELETE.authority())
.requestMatchers("/api/client/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void adminAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/admin/**").hasAnyAuthority(AdminPermission.READ.authority())
.requestMatchers(POST, "/api/admin/**").hasAnyAuthority(AdminPermission.CREATE.authority())
.requestMatchers(PUT, "/api/admin/**").hasAnyAuthority(AdminPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/admin/**").hasAnyAuthority(AdminPermission.DELETE.authority())
.requestMatchers("/api/admin/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void employeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/employe/**").hasAnyAuthority(EmployePermission.READ.authority())
.requestMatchers(POST, "/api/employe/**").hasAnyAuthority(EmployePermission.CREATE.authority())
.requestMatchers(PUT, "/api/employe/**").hasAnyAuthority(EmployePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/employe/**").hasAnyAuthority(EmployePermission.DELETE.authority())
.requestMatchers("/api/employe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void produitTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/produittaxe/**").hasAnyAuthority(ProduitTaxePermission.READ.authority())
.requestMatchers(POST, "/api/produittaxe/**").hasAnyAuthority(ProduitTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/produittaxe/**").hasAnyAuthority(ProduitTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/produittaxe/**").hasAnyAuthority(ProduitTaxePermission.DELETE.authority())
.requestMatchers("/api/produittaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void produitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/produit/**").hasAnyAuthority(ProduitPermission.READ.authority())
.requestMatchers(POST, "/api/produit/**").hasAnyAuthority(ProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/produit/**").hasAnyAuthority(ProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/produit/**").hasAnyAuthority(ProduitPermission.DELETE.authority())
.requestMatchers("/api/produit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void commandeExpeditionAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/commandeexpedition/**").hasAnyAuthority(CommandeExpeditionPermission.READ.authority())
.requestMatchers(POST, "/api/commandeexpedition/**").hasAnyAuthority(CommandeExpeditionPermission.CREATE.authority())
.requestMatchers(PUT, "/api/commandeexpedition/**").hasAnyAuthority(CommandeExpeditionPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/commandeexpedition/**").hasAnyAuthority(CommandeExpeditionPermission.DELETE.authority())
.requestMatchers("/api/commandeexpedition/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void paiementAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/paiement/**").hasAnyAuthority(PaiementPermission.READ.authority())
.requestMatchers(POST, "/api/paiement/**").hasAnyAuthority(PaiementPermission.CREATE.authority())
.requestMatchers(PUT, "/api/paiement/**").hasAnyAuthority(PaiementPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/paiement/**").hasAnyAuthority(PaiementPermission.DELETE.authority())
.requestMatchers("/api/paiement/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void estimationTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/estimationtaxe/**").hasAnyAuthority(EstimationTaxePermission.READ.authority())
.requestMatchers(POST, "/api/estimationtaxe/**").hasAnyAuthority(EstimationTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/estimationtaxe/**").hasAnyAuthority(EstimationTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/estimationtaxe/**").hasAnyAuthority(EstimationTaxePermission.DELETE.authority())
.requestMatchers("/api/estimationtaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void estimationTaxeExpeditionAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/estimationtaxeexpedition/**").hasAnyAuthority(EstimationTaxeExpeditionPermission.READ.authority())
.requestMatchers(POST, "/api/estimationtaxeexpedition/**").hasAnyAuthority(EstimationTaxeExpeditionPermission.CREATE.authority())
.requestMatchers(PUT, "/api/estimationtaxeexpedition/**").hasAnyAuthority(EstimationTaxeExpeditionPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/estimationtaxeexpedition/**").hasAnyAuthority(EstimationTaxeExpeditionPermission.DELETE.authority())
.requestMatchers("/api/estimationtaxeexpedition/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void estimationProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/estimationproduit/**").hasAnyAuthority(EstimationProduitPermission.READ.authority())
.requestMatchers(POST, "/api/estimationproduit/**").hasAnyAuthority(EstimationProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/estimationproduit/**").hasAnyAuthority(EstimationProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/estimationproduit/**").hasAnyAuthority(EstimationProduitPermission.DELETE.authority())
.requestMatchers("/api/estimationproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void estimationAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/estimation/**").hasAnyAuthority(EstimationPermission.READ.authority())
.requestMatchers(POST, "/api/estimation/**").hasAnyAuthority(EstimationPermission.CREATE.authority())
.requestMatchers(PUT, "/api/estimation/**").hasAnyAuthority(EstimationPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/estimation/**").hasAnyAuthority(EstimationPermission.DELETE.authority())
.requestMatchers("/api/estimation/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void commandeTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/commandetaxe/**").hasAnyAuthority(CommandeTaxePermission.READ.authority())
.requestMatchers(POST, "/api/commandetaxe/**").hasAnyAuthority(CommandeTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/commandetaxe/**").hasAnyAuthority(CommandeTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/commandetaxe/**").hasAnyAuthority(CommandeTaxePermission.DELETE.authority())
.requestMatchers("/api/commandetaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void commandeTaxeExpeditionAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/commandetaxeexpedition/**").hasAnyAuthority(CommandeTaxeExpeditionPermission.READ.authority())
.requestMatchers(POST, "/api/commandetaxeexpedition/**").hasAnyAuthority(CommandeTaxeExpeditionPermission.CREATE.authority())
.requestMatchers(PUT, "/api/commandetaxeexpedition/**").hasAnyAuthority(CommandeTaxeExpeditionPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/commandetaxeexpedition/**").hasAnyAuthority(CommandeTaxeExpeditionPermission.DELETE.authority())
.requestMatchers("/api/commandetaxeexpedition/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void commandeProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/commandeproduit/**").hasAnyAuthority(CommandeProduitPermission.READ.authority())
.requestMatchers(POST, "/api/commandeproduit/**").hasAnyAuthority(CommandeProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/commandeproduit/**").hasAnyAuthority(CommandeProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/commandeproduit/**").hasAnyAuthority(CommandeProduitPermission.DELETE.authority())
.requestMatchers("/api/commandeproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void commandeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/commande/**").hasAnyAuthority(CommandePermission.READ.authority())
.requestMatchers(POST, "/api/commande/**").hasAnyAuthority(CommandePermission.CREATE.authority())
.requestMatchers(PUT, "/api/commande/**").hasAnyAuthority(CommandePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/commande/**").hasAnyAuthority(CommandePermission.DELETE.authority())
.requestMatchers("/api/commande/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void factureTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/facturetaxe/**").hasAnyAuthority(FactureTaxePermission.READ.authority())
.requestMatchers(POST, "/api/facturetaxe/**").hasAnyAuthority(FactureTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/facturetaxe/**").hasAnyAuthority(FactureTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/facturetaxe/**").hasAnyAuthority(FactureTaxePermission.DELETE.authority())
.requestMatchers("/api/facturetaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void factureTaxeExpeditionAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/facturetaxeexpedition/**").hasAnyAuthority(FactureTaxeExpeditionPermission.READ.authority())
.requestMatchers(POST, "/api/facturetaxeexpedition/**").hasAnyAuthority(FactureTaxeExpeditionPermission.CREATE.authority())
.requestMatchers(PUT, "/api/facturetaxeexpedition/**").hasAnyAuthority(FactureTaxeExpeditionPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/facturetaxeexpedition/**").hasAnyAuthority(FactureTaxeExpeditionPermission.DELETE.authority())
.requestMatchers("/api/facturetaxeexpedition/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void factureProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/factureproduit/**").hasAnyAuthority(FactureProduitPermission.READ.authority())
.requestMatchers(POST, "/api/factureproduit/**").hasAnyAuthority(FactureProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/factureproduit/**").hasAnyAuthority(FactureProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/factureproduit/**").hasAnyAuthority(FactureProduitPermission.DELETE.authority())
.requestMatchers("/api/factureproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void factureAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/facture/**").hasAnyAuthority(FacturePermission.READ.authority())
.requestMatchers(POST, "/api/facture/**").hasAnyAuthority(FacturePermission.CREATE.authority())
.requestMatchers(PUT, "/api/facture/**").hasAnyAuthority(FacturePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/facture/**").hasAnyAuthority(FacturePermission.DELETE.authority())
.requestMatchers("/api/facture/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void retourProduitProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/retourproduitproduit/**").hasAnyAuthority(RetourProduitProduitPermission.READ.authority())
.requestMatchers(POST, "/api/retourproduitproduit/**").hasAnyAuthority(RetourProduitProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/retourproduitproduit/**").hasAnyAuthority(RetourProduitProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/retourproduitproduit/**").hasAnyAuthority(RetourProduitProduitPermission.DELETE.authority())
.requestMatchers("/api/retourproduitproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void retourProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/retourproduit/**").hasAnyAuthority(RetourProduitPermission.READ.authority())
.requestMatchers(POST, "/api/retourproduit/**").hasAnyAuthority(RetourProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/retourproduit/**").hasAnyAuthority(RetourProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/retourproduit/**").hasAnyAuthority(RetourProduitPermission.DELETE.authority())
.requestMatchers("/api/retourproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void noteCreditTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/notecredittaxe/**").hasAnyAuthority(NoteCreditTaxePermission.READ.authority())
.requestMatchers(POST, "/api/notecredittaxe/**").hasAnyAuthority(NoteCreditTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/notecredittaxe/**").hasAnyAuthority(NoteCreditTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/notecredittaxe/**").hasAnyAuthority(NoteCreditTaxePermission.DELETE.authority())
.requestMatchers("/api/notecredittaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void noteCreditProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/notecreditproduit/**").hasAnyAuthority(NoteCreditProduitPermission.READ.authority())
.requestMatchers(POST, "/api/notecreditproduit/**").hasAnyAuthority(NoteCreditProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/notecreditproduit/**").hasAnyAuthority(NoteCreditProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/notecreditproduit/**").hasAnyAuthority(NoteCreditProduitPermission.DELETE.authority())
.requestMatchers("/api/notecreditproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void noteCreditAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/notecredit/**").hasAnyAuthority(NoteCreditPermission.READ.authority())
.requestMatchers(POST, "/api/notecredit/**").hasAnyAuthority(NoteCreditPermission.CREATE.authority())
.requestMatchers(PUT, "/api/notecredit/**").hasAnyAuthority(NoteCreditPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/notecredit/**").hasAnyAuthority(NoteCreditPermission.DELETE.authority())
.requestMatchers("/api/notecredit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void remboursementTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/remboursementtaxe/**").hasAnyAuthority(RemboursementTaxePermission.READ.authority())
.requestMatchers(POST, "/api/remboursementtaxe/**").hasAnyAuthority(RemboursementTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/remboursementtaxe/**").hasAnyAuthority(RemboursementTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/remboursementtaxe/**").hasAnyAuthority(RemboursementTaxePermission.DELETE.authority())
.requestMatchers("/api/remboursementtaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void remboursementProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/remboursementproduit/**").hasAnyAuthority(RemboursementProduitPermission.READ.authority())
.requestMatchers(POST, "/api/remboursementproduit/**").hasAnyAuthority(RemboursementProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/remboursementproduit/**").hasAnyAuthority(RemboursementProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/remboursementproduit/**").hasAnyAuthority(RemboursementProduitPermission.DELETE.authority())
.requestMatchers("/api/remboursementproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void remboursementAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/remboursement/**").hasAnyAuthority(RemboursementPermission.READ.authority())
.requestMatchers(POST, "/api/remboursement/**").hasAnyAuthority(RemboursementPermission.CREATE.authority())
.requestMatchers(PUT, "/api/remboursement/**").hasAnyAuthority(RemboursementPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/remboursement/**").hasAnyAuthority(RemboursementPermission.DELETE.authority())
.requestMatchers("/api/remboursement/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void niveauStockAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/niveaustock/**").hasAnyAuthority(NiveauStockPermission.READ.authority())
.requestMatchers(POST, "/api/niveaustock/**").hasAnyAuthority(NiveauStockPermission.CREATE.authority())
.requestMatchers(PUT, "/api/niveaustock/**").hasAnyAuthority(NiveauStockPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/niveaustock/**").hasAnyAuthority(NiveauStockPermission.DELETE.authority())
.requestMatchers("/api/niveaustock/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void bonCommandeTaxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/boncommandetaxe/**").hasAnyAuthority(BonCommandeTaxePermission.READ.authority())
.requestMatchers(POST, "/api/boncommandetaxe/**").hasAnyAuthority(BonCommandeTaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/boncommandetaxe/**").hasAnyAuthority(BonCommandeTaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/boncommandetaxe/**").hasAnyAuthority(BonCommandeTaxePermission.DELETE.authority())
.requestMatchers("/api/boncommandetaxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void bonCommandeTaxeExpeditionAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/boncommandetaxeexpedition/**").hasAnyAuthority(BonCommandeTaxeExpeditionPermission.READ.authority())
.requestMatchers(POST, "/api/boncommandetaxeexpedition/**").hasAnyAuthority(BonCommandeTaxeExpeditionPermission.CREATE.authority())
.requestMatchers(PUT, "/api/boncommandetaxeexpedition/**").hasAnyAuthority(BonCommandeTaxeExpeditionPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/boncommandetaxeexpedition/**").hasAnyAuthority(BonCommandeTaxeExpeditionPermission.DELETE.authority())
.requestMatchers("/api/boncommandetaxeexpedition/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void bonCommandeProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/boncommandeproduit/**").hasAnyAuthority(BonCommandeProduitPermission.READ.authority())
.requestMatchers(POST, "/api/boncommandeproduit/**").hasAnyAuthority(BonCommandeProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/boncommandeproduit/**").hasAnyAuthority(BonCommandeProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/boncommandeproduit/**").hasAnyAuthority(BonCommandeProduitPermission.DELETE.authority())
.requestMatchers("/api/boncommandeproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void bonCommandeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/boncommande/**").hasAnyAuthority(BonCommandePermission.READ.authority())
.requestMatchers(POST, "/api/boncommande/**").hasAnyAuthority(BonCommandePermission.CREATE.authority())
.requestMatchers(PUT, "/api/boncommande/**").hasAnyAuthority(BonCommandePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/boncommande/**").hasAnyAuthority(BonCommandePermission.DELETE.authority())
.requestMatchers("/api/boncommande/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void livraisonTaxeExpeditionAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/livraisontaxeexpedition/**").hasAnyAuthority(LivraisonTaxeExpeditionPermission.READ.authority())
.requestMatchers(POST, "/api/livraisontaxeexpedition/**").hasAnyAuthority(LivraisonTaxeExpeditionPermission.CREATE.authority())
.requestMatchers(PUT, "/api/livraisontaxeexpedition/**").hasAnyAuthority(LivraisonTaxeExpeditionPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/livraisontaxeexpedition/**").hasAnyAuthority(LivraisonTaxeExpeditionPermission.DELETE.authority())
.requestMatchers("/api/livraisontaxeexpedition/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void livraisonProduitAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/livraisonproduit/**").hasAnyAuthority(LivraisonProduitPermission.READ.authority())
.requestMatchers(POST, "/api/livraisonproduit/**").hasAnyAuthority(LivraisonProduitPermission.CREATE.authority())
.requestMatchers(PUT, "/api/livraisonproduit/**").hasAnyAuthority(LivraisonProduitPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/livraisonproduit/**").hasAnyAuthority(LivraisonProduitPermission.DELETE.authority())
.requestMatchers("/api/livraisonproduit/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void livraisonAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/livraison/**").hasAnyAuthority(LivraisonPermission.READ.authority())
.requestMatchers(POST, "/api/livraison/**").hasAnyAuthority(LivraisonPermission.CREATE.authority())
.requestMatchers(PUT, "/api/livraison/**").hasAnyAuthority(LivraisonPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/livraison/**").hasAnyAuthority(LivraisonPermission.DELETE.authority())
.requestMatchers("/api/livraison/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void destinataireEmployeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/destinataireemploye/**").hasAnyAuthority(DestinataireEmployePermission.READ.authority())
.requestMatchers(POST, "/api/destinataireemploye/**").hasAnyAuthority(DestinataireEmployePermission.CREATE.authority())
.requestMatchers(PUT, "/api/destinataireemploye/**").hasAnyAuthority(DestinataireEmployePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/destinataireemploye/**").hasAnyAuthority(DestinataireEmployePermission.DELETE.authority())
.requestMatchers("/api/destinataireemploye/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void alerteAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/alerte/**").hasAnyAuthority(AlertePermission.READ.authority())
.requestMatchers(POST, "/api/alerte/**").hasAnyAuthority(AlertePermission.CREATE.authority())
.requestMatchers(PUT, "/api/alerte/**").hasAnyAuthority(AlertePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/alerte/**").hasAnyAuthority(AlertePermission.DELETE.authority())
.requestMatchers("/api/alerte/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void entrepriseAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/entreprise/**").hasAnyAuthority(EntreprisePermission.READ.authority())
.requestMatchers(POST, "/api/entreprise/**").hasAnyAuthority(EntreprisePermission.CREATE.authority())
.requestMatchers(PUT, "/api/entreprise/**").hasAnyAuthority(EntreprisePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/entreprise/**").hasAnyAuthority(EntreprisePermission.DELETE.authority())
.requestMatchers("/api/entreprise/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void devisAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/devis/**").hasAnyAuthority(DevisPermission.READ.authority())
.requestMatchers(POST, "/api/devis/**").hasAnyAuthority(DevisPermission.CREATE.authority())
.requestMatchers(PUT, "/api/devis/**").hasAnyAuthority(DevisPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/devis/**").hasAnyAuthority(DevisPermission.DELETE.authority())
.requestMatchers("/api/devis/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void nouvelleDeviseAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/nouvelledevise/**").hasAnyAuthority(NouvelleDevisePermission.READ.authority())
.requestMatchers(POST, "/api/nouvelledevise/**").hasAnyAuthority(NouvelleDevisePermission.CREATE.authority())
.requestMatchers(PUT, "/api/nouvelledevise/**").hasAnyAuthority(NouvelleDevisePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/nouvelledevise/**").hasAnyAuthority(NouvelleDevisePermission.DELETE.authority())
.requestMatchers("/api/nouvelledevise/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void methodePaiementAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/methodepaiement/**").hasAnyAuthority(MethodePaiementPermission.READ.authority())
.requestMatchers(POST, "/api/methodepaiement/**").hasAnyAuthority(MethodePaiementPermission.CREATE.authority())
.requestMatchers(PUT, "/api/methodepaiement/**").hasAnyAuthority(MethodePaiementPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/methodepaiement/**").hasAnyAuthority(MethodePaiementPermission.DELETE.authority())
.requestMatchers("/api/methodepaiement/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void niveauPrixAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/niveauprix/**").hasAnyAuthority(NiveauPrixPermission.READ.authority())
.requestMatchers(POST, "/api/niveauprix/**").hasAnyAuthority(NiveauPrixPermission.CREATE.authority())
.requestMatchers(PUT, "/api/niveauprix/**").hasAnyAuthority(NiveauPrixPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/niveauprix/**").hasAnyAuthority(NiveauPrixPermission.DELETE.authority())
.requestMatchers("/api/niveauprix/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void taxeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/taxe/**").hasAnyAuthority(TaxePermission.READ.authority())
.requestMatchers(POST, "/api/taxe/**").hasAnyAuthority(TaxePermission.CREATE.authority())
.requestMatchers(PUT, "/api/taxe/**").hasAnyAuthority(TaxePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/taxe/**").hasAnyAuthority(TaxePermission.DELETE.authority())
.requestMatchers("/api/taxe/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void addressAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/address/**").hasAnyAuthority(AddressPermission.READ.authority())
.requestMatchers(POST, "/api/address/**").hasAnyAuthority(AddressPermission.CREATE.authority())
.requestMatchers(PUT, "/api/address/**").hasAnyAuthority(AddressPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/address/**").hasAnyAuthority(AddressPermission.DELETE.authority())
.requestMatchers("/api/address/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void countryAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/country/**").hasAnyAuthority(CountryPermission.READ.authority())
.requestMatchers(POST, "/api/country/**").hasAnyAuthority(CountryPermission.CREATE.authority())
.requestMatchers(PUT, "/api/country/**").hasAnyAuthority(CountryPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/country/**").hasAnyAuthority(CountryPermission.DELETE.authority())
.requestMatchers("/api/country/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYE.name())
);
}
private static void defaultAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers("/login").permitAll()
.requestMatchers("/api/login").permitAll()
.requestMatchers("/api/**").authenticated()
.anyRequest().authenticated());
}
}