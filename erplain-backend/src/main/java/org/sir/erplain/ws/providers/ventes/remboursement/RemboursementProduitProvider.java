package org.sir.erplain.ws.providers.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementProduitService;
import org.sir.erplain.ws.converter.ventes.remboursement.RemboursementProduitConverter;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/remboursementproduit")
public class RemboursementProduitProvider {
@Autowired private RemboursementProduitService service;
@Autowired private RemboursementProduitConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<RemboursementProduitDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<RemboursementProduitDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<RemboursementProduitDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<RemboursementProduitDto> save(@RequestBody RemboursementProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<RemboursementProduitDto>> save(@RequestBody List<RemboursementProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<RemboursementProduitDto> update(@RequestBody RemboursementProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<RemboursementProduitDto>> update(@RequestBody List<RemboursementProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<RemboursementProduitDto> delete(@RequestBody RemboursementProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<RemboursementProduitDto>> delete(@RequestBody List<RemboursementProduitDto> dtos) {
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
@DeleteMapping("/remboursement/id/{id}")
public ResponseEntity<Long> deleteByRemboursementId(@PathVariable Long id){
service.deleteByRemboursementId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/remboursement/id/{id}")
public ResponseEntity<List<RemboursementProduitDto>> findByRemboursementId(@PathVariable Long id){
var result = service.findByRemboursementId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}