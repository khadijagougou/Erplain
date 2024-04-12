package org.sir.erplain.ws.providers.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
import org.sir.erplain.ws.converter.ventes.remboursement.RemboursementConverter;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/remboursement")
public class RemboursementProvider {
@Autowired private RemboursementService service;
@Autowired private RemboursementConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<RemboursementDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<RemboursementDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<RemboursementDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<RemboursementDto> save(@RequestBody RemboursementDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<RemboursementDto>> save(@RequestBody List<RemboursementDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<RemboursementDto> update(@RequestBody RemboursementDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<RemboursementDto>> update(@RequestBody List<RemboursementDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<RemboursementDto> delete(@RequestBody RemboursementDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<RemboursementDto>> delete(@RequestBody List<RemboursementDto> dtos) {
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
@DeleteMapping("/client/id/{id}")
public ResponseEntity<Long> deleteByClientId(@PathVariable Long id){
service.deleteByClientId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/client/id/{id}")
public ResponseEntity<List<RemboursementDto>> findByClientId(@PathVariable Long id){
var result = service.findByClientId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/retourproduit/id/{id}")
public ResponseEntity<Long> deleteByRetourProduitId(@PathVariable Long id){
service.deleteByRetourProduitId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/retourproduit/id/{id}")
public ResponseEntity<List<RemboursementDto>> findByRetourProduitId(@PathVariable Long id){
var result = service.findByRetourProduitId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/entreprise/id/{id}")
public ResponseEntity<Long> deleteByEntrepriseId(@PathVariable Long id){
service.deleteByEntrepriseId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/entreprise/id/{id}")
public ResponseEntity<List<RemboursementDto>> findByEntrepriseId(@PathVariable Long id){
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
public ResponseEntity<List<RemboursementDto>> findByDevisId(@PathVariable Long id){
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
public ResponseEntity<List<RemboursementDto>> findByNiveauPrixId(@PathVariable Long id){
var result = service.findByNiveauPrixId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}