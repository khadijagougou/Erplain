package org.sir.erplain.ws.providers.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.sir.erplain.service.facade.ventes.estimation.EstimationProduitService;
import org.sir.erplain.ws.converter.ventes.estimation.EstimationProduitConverter;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/estimationproduit")
public class EstimationProduitProvider {
@Autowired private EstimationProduitService service;
@Autowired private EstimationProduitConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<EstimationProduitDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<EstimationProduitDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<EstimationProduitDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<EstimationProduitDto> save(@RequestBody EstimationProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<EstimationProduitDto>> save(@RequestBody List<EstimationProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<EstimationProduitDto> update(@RequestBody EstimationProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<EstimationProduitDto>> update(@RequestBody List<EstimationProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<EstimationProduitDto> delete(@RequestBody EstimationProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<EstimationProduitDto>> delete(@RequestBody List<EstimationProduitDto> dtos) {
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
@DeleteMapping("/estimation/id/{id}")
public ResponseEntity<Long> deleteByEstimationId(@PathVariable Long id){
service.deleteByEstimationId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/estimation/id/{id}")
public ResponseEntity<List<EstimationProduitDto>> findByEstimationId(@PathVariable Long id){
var result = service.findByEstimationId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}