package org.sir.erplain.ws.providers.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditTaxeService;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditTaxeConverter;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditTaxeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/notecredittaxe")
public class NoteCreditTaxeProvider {
@Autowired private NoteCreditTaxeService service;
@Autowired private NoteCreditTaxeConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<NoteCreditTaxeDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<NoteCreditTaxeDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<NoteCreditTaxeDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<NoteCreditTaxeDto> save(@RequestBody NoteCreditTaxeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<NoteCreditTaxeDto>> save(@RequestBody List<NoteCreditTaxeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<NoteCreditTaxeDto> update(@RequestBody NoteCreditTaxeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<NoteCreditTaxeDto>> update(@RequestBody List<NoteCreditTaxeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<NoteCreditTaxeDto> delete(@RequestBody NoteCreditTaxeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<NoteCreditTaxeDto>> delete(@RequestBody List<NoteCreditTaxeDto> dtos) {
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
public ResponseEntity<List<NoteCreditTaxeDto>> findByNoteCreditId(@PathVariable Long id){
var result = service.findByNoteCreditId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/taxe/id/{id}")
public ResponseEntity<Long> deleteByTaxeId(@PathVariable Long id){
service.deleteByTaxeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/taxe/id/{id}")
public ResponseEntity<List<NoteCreditTaxeDto>> findByTaxeId(@PathVariable Long id){
var result = service.findByTaxeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}