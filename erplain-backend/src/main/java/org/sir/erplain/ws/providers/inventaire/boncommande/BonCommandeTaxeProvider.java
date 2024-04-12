package org.sir.erplain.ws.providers.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeService;
import org.sir.erplain.ws.converter.inventaire.boncommande.BonCommandeTaxeConverter;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeTaxeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/boncommandetaxe")
public class BonCommandeTaxeProvider {
@Autowired private BonCommandeTaxeService service;
@Autowired private BonCommandeTaxeConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<BonCommandeTaxeDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<BonCommandeTaxeDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<BonCommandeTaxeDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<BonCommandeTaxeDto> save(@RequestBody BonCommandeTaxeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<BonCommandeTaxeDto>> save(@RequestBody List<BonCommandeTaxeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<BonCommandeTaxeDto> update(@RequestBody BonCommandeTaxeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<BonCommandeTaxeDto>> update(@RequestBody List<BonCommandeTaxeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<BonCommandeTaxeDto> delete(@RequestBody BonCommandeTaxeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<BonCommandeTaxeDto>> delete(@RequestBody List<BonCommandeTaxeDto> dtos) {
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
@DeleteMapping("/boncommande/id/{id}")
public ResponseEntity<Long> deleteByBonCommandeId(@PathVariable Long id){
service.deleteByBonCommandeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/boncommande/id/{id}")
public ResponseEntity<List<BonCommandeTaxeDto>> findByBonCommandeId(@PathVariable Long id){
var result = service.findByBonCommandeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/taxe/id/{id}")
public ResponseEntity<Long> deleteByTaxeId(@PathVariable Long id){
service.deleteByTaxeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/taxe/id/{id}")
public ResponseEntity<List<BonCommandeTaxeDto>> findByTaxeId(@PathVariable Long id){
var result = service.findByTaxeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}