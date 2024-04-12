package org.sir.erplain.dao.ventes.retourproduit;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduitProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface RetourProduitProduitDao extends JpaRepository<RetourProduitProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByRetourProduitId(Long id);
List<RetourProduitProduit> findByRetourProduitId(Long id);
}