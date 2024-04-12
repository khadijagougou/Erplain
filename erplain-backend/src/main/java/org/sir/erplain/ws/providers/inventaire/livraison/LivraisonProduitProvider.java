package org.sir.erplain.ws.providers.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonProduit;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonProduitService;
import org.sir.erplain.ws.converter.inventaire.livraison.LivraisonProduitConverter;
import org.sir.erplain.ws.dto.inventaire.livraison.LivraisonProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/livraisonproduit")
public class LivraisonProduitProvider {
@Autowired private LivraisonProduitService service;
@Autowired private LivraisonProduitConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<LivraisonProduitDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<LivraisonProduitDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<LivraisonProduitDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<LivraisonProduitDto> save(@RequestBody LivraisonProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<LivraisonProduitDto>> save(@RequestBody List<LivraisonProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<LivraisonProduitDto> update(@RequestBody LivraisonProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<LivraisonProduitDto>> update(@RequestBody List<LivraisonProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<LivraisonProduitDto> delete(@RequestBody LivraisonProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<LivraisonProduitDto>> delete(@RequestBody List<LivraisonProduitDto> dtos) {
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
public ResponseEntity<List<LivraisonProduitDto>> findByLivraisonId(@PathVariable Long id){
var result = service.findByLivraisonId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}