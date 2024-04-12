package org.sir.erplain.dao.parametres;
import org.sir.erplain.bean.core.parametres.MethodePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MethodePaiementDao extends JpaRepository<MethodePaiement, Long> {
int deleteByIdIn(List<Long> ids);
}