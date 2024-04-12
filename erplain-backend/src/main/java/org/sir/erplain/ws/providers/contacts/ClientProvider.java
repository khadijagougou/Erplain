package org.sir.erplain.ws.providers.contacts;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/client")
public class ClientProvider {
@Autowired private ClientService service;
@Autowired private ClientConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<ClientDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<ClientDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<ClientDto> save(@RequestBody ClientDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<ClientDto>> save(@RequestBody List<ClientDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<ClientDto> update(@RequestBody ClientDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<ClientDto>> update(@RequestBody List<ClientDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<ClientDto> delete(@RequestBody ClientDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<ClientDto>> delete(@RequestBody List<ClientDto> dtos) {
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
@DeleteMapping("/address/id/{id}")
public ResponseEntity<Long> deleteByAddressId(@PathVariable Long id){
service.deleteByAddressId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/address/id/{id}")
public ResponseEntity<ClientDto> findByAddressId(@PathVariable Long id){
var result = service.findByAddressId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/entreprise/id/{id}")
public ResponseEntity<Long> deleteByEntrepriseId(@PathVariable Long id){
service.deleteByEntrepriseId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/entreprise/id/{id}")
public ResponseEntity<List<ClientDto>> findByEntrepriseId(@PathVariable Long id){
var result = service.findByEntrepriseId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/devis/id/{id}")
public ResponseEntity<Long> deleteByDevisId(@PathVariable Long id){
service.deleteByDevisId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/devis/id/{id}")
public ResponseEntity<List<ClientDto>> findByDevisId(@PathVariable Long id){
var result = service.findByDevisId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/niveauprix/id/{id}")
public ResponseEntity<Long> deleteByNiveauPrixId(@PathVariable Long id){
service.deleteByNiveauPrixId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/niveauprix/id/{id}")
public ResponseEntity<List<ClientDto>> findByNiveauPrixId(@PathVariable Long id){
var result = service.findByNiveauPrixId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}