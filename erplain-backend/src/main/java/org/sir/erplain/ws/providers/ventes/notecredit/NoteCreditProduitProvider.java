package org.sir.erplain.ws.providers.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditProduit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditProduitService;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditProduitConverter;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/notecreditproduit")
public class NoteCreditProduitProvider {
@Autowired private NoteCreditProduitService service;
@Autowired private NoteCreditProduitConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<NoteCreditProduitDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<NoteCreditProduitDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<NoteCreditProduitDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<NoteCreditProduitDto> save(@RequestBody NoteCreditProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<NoteCreditProduitDto>> save(@RequestBody List<NoteCreditProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<NoteCreditProduitDto> update(@RequestBody NoteCreditProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<NoteCreditProduitDto>> update(@RequestBody List<NoteCreditProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<NoteCreditProduitDto> delete(@RequestBody NoteCreditProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<NoteCreditProduitDto>> delete(@RequestBody List<NoteCreditProduitDto> dtos) {
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
@DeleteMapping("/notecredit/id/{id}")
public ResponseEntity<Long> deleteByNoteCreditId(@PathVariable Long id){
service.deleteByNoteCreditId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/notecredit/id/{id}")
public ResponseEntity<List<NoteCreditProduitDto>> findByNoteCreditId(@PathVariable Long id){
var result = service.findByNoteCreditId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}