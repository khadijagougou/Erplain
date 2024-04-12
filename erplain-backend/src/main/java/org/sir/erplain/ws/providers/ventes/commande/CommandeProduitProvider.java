package org.sir.erplain.ws.providers.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeProduit;
import org.sir.erplain.service.facade.ventes.commande.CommandeProduitService;
import org.sir.erplain.ws.converter.ventes.commande.CommandeProduitConverter;
import org.sir.erplain.ws.dto.ventes.commande.CommandeProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/commandeproduit")
public class CommandeProduitProvider {
@Autowired private CommandeProduitService service;
@Autowired private CommandeProduitConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<CommandeProduitDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<CommandeProduitDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<CommandeProduitDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<CommandeProduitDto> save(@RequestBody CommandeProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<CommandeProduitDto>> save(@RequestBody List<CommandeProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<CommandeProduitDto> update(@RequestBody CommandeProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<CommandeProduitDto>> update(@RequestBody List<CommandeProduitDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<CommandeProduitDto> delete(@RequestBody CommandeProduitDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<CommandeProduitDto>> delete(@RequestBody List<CommandeProduitDto> dtos) {
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
public ResponseEntity<List<CommandeProduitDto>> findByCommandeId(@PathVariable Long id){
var result = service.findByCommandeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}