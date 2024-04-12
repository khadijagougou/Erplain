package org.sir.erplain.ws.providers.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeExpeditionService;
import org.sir.erplain.ws.converter.ventes.commande.CommandeTaxeExpeditionConverter;
import org.sir.erplain.ws.dto.ventes.commande.CommandeTaxeExpeditionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/commandetaxeexpedition")
public class CommandeTaxeExpeditionProvider {
@Autowired private CommandeTaxeExpeditionService service;
@Autowired private CommandeTaxeExpeditionConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<CommandeTaxeExpeditionDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<CommandeTaxeExpeditionDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<CommandeTaxeExpeditionDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<CommandeTaxeExpeditionDto> save(@RequestBody CommandeTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<CommandeTaxeExpeditionDto>> save(@RequestBody List<CommandeTaxeExpeditionDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<CommandeTaxeExpeditionDto> update(@RequestBody CommandeTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<CommandeTaxeExpeditionDto>> update(@RequestBody List<CommandeTaxeExpeditionDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<CommandeTaxeExpeditionDto> delete(@RequestBody CommandeTaxeExpeditionDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<CommandeTaxeExpeditionDto>> delete(@RequestBody List<CommandeTaxeExpeditionDto> dtos) {
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
@DeleteMapping("/commande/id/{id}")
public ResponseEntity<Long> deleteByCommandeId(@PathVariable Long id){
service.deleteByCommandeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/commande/id/{id}")
public ResponseEntity<List<CommandeTaxeExpeditionDto>> findByCommandeId(@PathVariable Long id){
var result = service.findByCommandeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/taxe/id/{id}")
public ResponseEntity<Long> deleteByTaxeId(@PathVariable Long id){
service.deleteByTaxeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/taxe/id/{id}")
public ResponseEntity<List<CommandeTaxeExpeditionDto>> findByTaxeId(@PathVariable Long id){
var result = service.findByTaxeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}