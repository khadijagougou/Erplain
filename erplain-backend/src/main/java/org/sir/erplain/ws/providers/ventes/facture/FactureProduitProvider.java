package org.sir.erplain.ws.providers.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureProduit;
import org.sir.erplain.service.facade.ventes.facture.FactureProduitService;
import org.sir.erplain.ws.converter.ventes.facture.FactureProduitConverter;
import org.sir.erplain.ws.dto.ventes.facture.FactureProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/factureproduit")
public class FactureProduitProvider {
@Autowired private FactureProduitService service;
@Autowired private FactureProduitConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<FactureProduitDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<FactureProduitDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<FactureProduitDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<FactureProduitDto> save(@RequestBody FactureProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<FactureProduitDto>> save(@RequestBody List<FactureProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<FactureProduitDto> update(@RequestBody FactureProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<FactureProduitDto>> update(@RequestBody List<FactureProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<FactureProduitDto> delete(@RequestBody FactureProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<FactureProduitDto>> delete(@RequestBody List<FactureProduitDto> dtos) {
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
@DeleteMapping("/facture/id/{id}")
public ResponseEntity<Long> deleteByFactureId(@PathVariable Long id){
service.deleteByFactureId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/facture/id/{id}")
public ResponseEntity<List<FactureProduitDto>> findByFactureId(@PathVariable Long id){
var result = service.findByFactureId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}