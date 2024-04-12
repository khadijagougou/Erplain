package org.sir.erplain.ws.providers.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeService;
import org.sir.erplain.ws.converter.inventaire.boncommande.BonCommandeConverter;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/boncommande")
public class BonCommandeProvider {
@Autowired private BonCommandeService service;
@Autowired private BonCommandeConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<BonCommandeDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<BonCommandeDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<BonCommandeDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<BonCommandeDto> save(@RequestBody BonCommandeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<BonCommandeDto>> save(@RequestBody List<BonCommandeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<BonCommandeDto> update(@RequestBody BonCommandeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<BonCommandeDto>> update(@RequestBody List<BonCommandeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<BonCommandeDto> delete(@RequestBody BonCommandeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<BonCommandeDto>> delete(@RequestBody List<BonCommandeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
service.delete(item);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/id/{id}")
public ResponseEntity<Long> deleteById(@PathVariable Long id) {
service.deleteById(id);
return ResponseEntity.ok(id);
}
@DeleteMapping("/ids")
public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
service.deleteByIdIn(ids);
return ResponseEntity.ok(ids);
}
@DeleteMapping("/livraison/id/{id}")
public ResponseEntity<Long> deleteByLivraisonId(@PathVariable Long id){
service.deleteByLivraisonId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/livraison/id/{id}")
public ResponseEntity<BonCommandeDto> findByLivraisonId(@PathVariable Long id){
var result = service.findByLivraisonId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/fournisseur/id/{id}")
public ResponseEntity<Long> deleteByFournisseurId(@PathVariable Long id){
service.deleteByFournisseurId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/fournisseur/id/{id}")
public ResponseEntity<List<BonCommandeDto>> findByFournisseurId(@PathVariable Long id){
var result = service.findByFournisseurId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/entreprise/id/{id}")
public ResponseEntity<Long> deleteByEntrepriseId(@PathVariable Long id){
service.deleteByEntrepriseId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/entreprise/id/{id}")
public ResponseEntity<List<BonCommandeDto>> findByEntrepriseId(@PathVariable Long id){
var result = service.findByEntrepriseId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/devis/id/{id}")
public ResponseEntity<Long> deleteByDevisId(@PathVariable Long id){
service.deleteByDevisId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/devis/id/{id}")
public ResponseEntity<List<BonCommandeDto>> findByDevisId(@PathVariable Long id){
var result = service.findByDevisId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/niveauprix/id/{id}")
public ResponseEntity<Long> deleteByNiveauPrixId(@PathVariable Long id){
service.deleteByNiveauPrixId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/niveauprix/id/{id}")
public ResponseEntity<List<BonCommandeDto>> findByNiveauPrixId(@PathVariable Long id){
var result = service.findByNiveauPrixId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}