package org.sir.erplain.ws.converter.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import org.sir.erplain.ws.dto.ventes.commande.CommandeTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CommandeTaxeConverter {
@Autowired private CommandeConverter commandeConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean commande = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.commandeConverter.setCommandeTaxe(value);
this.taxeConverter.setCommandeTaxe(value);
}
public final CommandeTaxeDto toDto(CommandeTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final CommandeTaxe toItem(CommandeTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<CommandeTaxe> toItem(List<CommandeTaxeDto> dtos) {
if (dtos == null) return null;
List<CommandeTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<CommandeTaxeDto> toDto(List<CommandeTaxe> items) {
if (items == null) return null;
List<CommandeTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected CommandeTaxe convertToItem(CommandeTaxeDto dto) {
var item = new CommandeTaxe();
item.setId(dto.getId());
item.setCommande(commandeConverter.toItem(dto.getCommande()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected CommandeTaxeDto convertToDto(CommandeTaxe item) {
var dto = new CommandeTaxeDto();
dto.setId(item.getId());
dto.setCommande(commande? commandeConverter.toDto(item.getCommande()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setCommande(boolean value) {
this.commande = value;
}
public void setTaxe(boolean value) {
this.taxe = value;
}
public void setCommandeConverter(CommandeConverter value) {
this.commandeConverter = value;
}
public CommandeConverter getCommandeConverter() {
return commandeConverter;
}
public void setTaxeConverter(TaxeConverter value) {
this.taxeConverter = value;
}
public TaxeConverter getTaxeConverter() {
return taxeConverter;
}
}