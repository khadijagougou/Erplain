package org.sir.erplain.dao.contacts;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface FournisseurDao extends JpaRepository<Fournisseur, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Fournisseur findByAddressId(Long id);
int deleteByEntrepriseId(Long id);
List<Fournisseur> findByEntrepriseId(Long id);
int deleteByNiveauPrixId(Long id);
List<Fournisseur> findByNiveauPrixId(Long id);
}