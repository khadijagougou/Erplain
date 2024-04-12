package org.sir.erplain.zsecurity.permissions;

import org.sir.erplain.zsecurity.entity.Permission;
import org.sir.erplain.zsecurity.entity.Role;
import org.sir.erplain.zsecurity.permissions.resources.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleEnum {
    ADMIN(
            UserPermission.values(),
            RolePermission.values(),
            FournisseurPermission.values(),
            ClientTaxePermission.values(),
            ClientPermission.values(),
            AdminPermission.values(),
            EmployePermission.values(),
            ProduitTaxePermission.values(),
            ProduitPermission.values(),
            CommandeExpeditionPermission.values(),
            PaiementPermission.values(),
            EstimationTaxePermission.values(),
            EstimationTaxeExpeditionPermission.values(),
            EstimationProduitPermission.values(),
            EstimationPermission.values(),
            CommandeTaxePermission.values(),
            CommandeTaxeExpeditionPermission.values(),
            CommandeProduitPermission.values(),
            CommandePermission.values(),
            FactureTaxePermission.values(),
            FactureTaxeExpeditionPermission.values(),
            FactureProduitPermission.values(),
            FacturePermission.values(),
            RetourProduitProduitPermission.values(),
            RetourProduitPermission.values(),
            NoteCreditTaxePermission.values(),
            NoteCreditProduitPermission.values(),
            NoteCreditPermission.values(),
            RemboursementTaxePermission.values(),
            RemboursementProduitPermission.values(),
            RemboursementPermission.values(),
            NiveauStockPermission.values(),
            BonCommandeTaxePermission.values(),
            BonCommandeTaxeExpeditionPermission.values(),
            BonCommandeProduitPermission.values(),
            BonCommandePermission.values(),
            LivraisonTaxeExpeditionPermission.values(),
            LivraisonProduitPermission.values(),
            LivraisonPermission.values(),
            DestinataireEmployePermission.values(),
            AlertePermission.values(),
            EntreprisePermission.values(),
            DevisPermission.values(),
            NouvelleDevisePermission.values(),
            MethodePaiementPermission.values(),
            NiveauPrixPermission.values(),
            TaxePermission.values(),
            AddressPermission.values(),
            CountryPermission.values()
    ),
    EMPLOYE(
            FournisseurPermission.values(),
            ClientTaxePermission.values(),
            ClientPermission.values(),
            AdminPermission.values(),
            EmployePermission.READ,
            ProduitTaxePermission.values(),
            ProduitPermission.values(),
            CommandeExpeditionPermission.values(),
            PaiementPermission.values(),
            EstimationTaxePermission.values(),
            EstimationTaxeExpeditionPermission.values(),
            EstimationProduitPermission.values(),
            EstimationPermission.values(),
            CommandeTaxePermission.values(),
            CommandeTaxeExpeditionPermission.values(),
            CommandeProduitPermission.values(),
            CommandePermission.values(),
            FactureTaxePermission.values(),
            FactureTaxeExpeditionPermission.values(),
            FactureProduitPermission.values(),
            FacturePermission.values(),
            RetourProduitProduitPermission.values(),
            RetourProduitPermission.values(),
            NoteCreditTaxePermission.values(),
            NoteCreditProduitPermission.values(),
            NoteCreditPermission.values(),
            RemboursementTaxePermission.values(),
            RemboursementProduitPermission.values(),
            RemboursementPermission.values(),
            NiveauStockPermission.values(),
            BonCommandeTaxePermission.values(),
            BonCommandeTaxeExpeditionPermission.values(),
            BonCommandeProduitPermission.values(),
            BonCommandePermission.values(),
            LivraisonTaxeExpeditionPermission.values(),
            LivraisonProduitPermission.values(),
            LivraisonPermission.values(),
            DestinataireEmployePermission.values(),
            AlertePermission.values(),
            EntreprisePermission.values(),
            DevisPermission.values(),
            NouvelleDevisePermission.values(),
            MethodePaiementPermission.values(),
            NiveauPrixPermission.values(),
            TaxePermission.values(),
            AddressPermission.values(),
            CountryPermission.values()
    ),
    ;
    private Set<PermissionResource> permissions = null;

    RoleEnum() {
    }

    RoleEnum(Object... permissionsList) {
        this.permissions = Arrays.stream(permissionsList)
                .flatMap(o -> {
                    if (o instanceof PermissionResource[]) {
                        return Arrays.stream((PermissionResource[]) o);
                    } else if (o instanceof PermissionResource) {
                        return Arrays.stream(new PermissionResource[]{(PermissionResource) o});
                    } else {
                        throw new IllegalArgumentException("Unsupported type in permissionsList");
                    }
                }).collect(Collectors.toUnmodifiableSet());
    }

    public Set<PermissionResource> getPermissions() {
        return permissions;
    }

    public Role getRole() {
        var result = new Role();
        result.setName(this.name());
        result.setPermissions(
                this.getPermissions().stream()
                        .map(p -> new Permission(p.authority()))
                        .collect(Collectors.toSet())
        );
        return result;
    }
}