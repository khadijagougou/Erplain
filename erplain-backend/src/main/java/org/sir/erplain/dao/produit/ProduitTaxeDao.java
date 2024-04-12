package org.sir.erplain.dao.produit;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ProduitTaxeDao extends JpaRepository<ProduitTaxe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByProduitId(Long id);
List<ProduitTaxe> findByProduitId(Long id);
int deleteByTaxeId(Long id);
List<ProduitTaxe> findByTaxeId(Long id);
}