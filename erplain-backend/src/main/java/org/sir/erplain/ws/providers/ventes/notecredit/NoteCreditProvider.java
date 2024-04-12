package org.sir.erplain.ws.providers.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditConverter;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/notecredit")
public class NoteCreditProvider {
@Autowired private NoteCreditService service;
@Autowired private NoteCreditConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<NoteCreditDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<NoteCreditDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<NoteCreditDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<NoteCreditDto> save(@RequestBody NoteCreditDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<NoteCreditDto>> save(@RequestBody List<NoteCreditDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<NoteCreditDto> update(@RequestBody NoteCreditDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<NoteCreditDto>> update(@RequestBody List<NoteCreditDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<NoteCreditDto> delete(@RequestBody NoteCreditDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<NoteCreditDto>> delete(@RequestBody List<NoteCreditDto> dtos) {
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
public ResponseEntity<List<NoteCreditDto>> findByClientId(@PathVariable Long id){
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
public ResponseEntity<List<NoteCreditDto>> findByRetourProduitId(@PathVariable Long id){
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
public ResponseEntity<List<NoteCreditDto>> findByEntrepriseId(@PathVariable Long id){
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
public ResponseEntity<List<NoteCreditDto>> findByDevisId(@PathVariable Long id){
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
public ResponseEntity<List<NoteCreditDto>> findByNiveauPrixId(@PathVariable Long id){
var result = service.findByNiveauPrixId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}