package org.sir.erplain.ws.providers.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeExpeditionService;
import org.sir.erplain.ws.converter.ventes.estimation.EstimationTaxeExpeditionConverter;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationTaxeExpeditionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/estimationtaxeexpedition")
public class EstimationTaxeExpeditionProvider {
@Autowired private EstimationTaxeExpeditionService service;
@Autowired private EstimationTaxeExpeditionConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<EstimationTaxeExpeditionDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<EstimationTaxeExpeditionDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<EstimationTaxeExpeditionDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<EstimationTaxeExpeditionDto> save(@RequestBody EstimationTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<EstimationTaxeExpeditionDto>> save(@RequestBody List<EstimationTaxeExpeditionDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<EstimationTaxeExpeditionDto> update(@RequestBody EstimationTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<EstimationTaxeExpeditionDto>> update(@RequestBody List<EstimationTaxeExpeditionDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<EstimationTaxeExpeditionDto> delete(@RequestBody EstimationTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<EstimationTaxeExpeditionDto>> delete(@RequestBody List<EstimationTaxeExpeditionDto> dtos) {
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
public ResponseEntity<List<EstimationTaxeExpeditionDto>> findByEstimationId(@PathVariable Long id){
var result = service.findByEstimationId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/taxe/id/{id}")
public ResponseEntity<Long> deleteByTaxeId(@PathVariable Long id){
service.deleteByTaxeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/taxe/id/{id}")
public ResponseEntity<List<EstimationTaxeExpeditionDto>> findByTaxeId(@PathVariable Long id){
var result = service.findByTaxeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}