package org.sir.erplain.ws.providers.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonTaxeExpeditionService;
import org.sir.erplain.ws.converter.inventaire.livraison.LivraisonTaxeExpeditionConverter;
import org.sir.erplain.ws.dto.inventaire.livraison.LivraisonTaxeExpeditionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/livraisontaxeexpedition")
public class LivraisonTaxeExpeditionProvider {
@Autowired private LivraisonTaxeExpeditionService service;
@Autowired private LivraisonTaxeExpeditionConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<LivraisonTaxeExpeditionDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<LivraisonTaxeExpeditionDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<LivraisonTaxeExpeditionDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<LivraisonTaxeExpeditionDto> save(@RequestBody LivraisonTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<LivraisonTaxeExpeditionDto>> save(@RequestBody List<LivraisonTaxeExpeditionDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<LivraisonTaxeExpeditionDto> update(@RequestBody LivraisonTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<LivraisonTaxeExpeditionDto>> update(@RequestBody List<LivraisonTaxeExpeditionDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<LivraisonTaxeExpeditionDto> delete(@RequestBody LivraisonTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<LivraisonTaxeExpeditionDto>> delete(@RequestBody List<LivraisonTaxeExpeditionDto> dtos) {
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
public ResponseEntity<List<LivraisonTaxeExpeditionDto>> findByLivraisonId(@PathVariable Long id){
var result = service.findByLivraisonId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/taxe/id/{id}")
public ResponseEntity<Long> deleteByTaxeId(@PathVariable Long id){
service.deleteByTaxeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/taxe/id/{id}")
public ResponseEntity<List<LivraisonTaxeExpeditionDto>> findByTaxeId(@PathVariable Long id){
var result = service.findByTaxeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}