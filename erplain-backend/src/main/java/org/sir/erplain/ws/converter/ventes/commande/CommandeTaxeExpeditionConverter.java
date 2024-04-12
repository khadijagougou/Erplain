package org.sir.erplain.ws.converter.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.ws.dto.ventes.commande.CommandeTaxeExpeditionDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CommandeTaxeExpeditionConverter {
@Autowired private CommandeConverter commandeConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean commande = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.commandeConverter.setCommandeTaxeExpedition(value);
this.taxeConverter.setCommandeTaxeExpedition(value);
}
public final CommandeTaxeExpeditionDto toDto(CommandeTaxeExpedition item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final CommandeTaxeExpedition toItem(CommandeTaxeExpeditionDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<CommandeTaxeExpedition> toItem(List<CommandeTaxeExpeditionDto> dtos) {
if (dtos == null) return null;
List<CommandeTaxeExpedition> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<CommandeTaxeExpeditionDto> toDto(List<CommandeTaxeExpedition> items) {
if (items == null) return null;
List<CommandeTaxeExpeditionDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected CommandeTaxeExpedition convertToItem(CommandeTaxeExpeditionDto dto) {
var item = new CommandeTaxeExpedition();
item.setId(dto.getId());
item.setCommande(commandeConverter.toItem(dto.getCommande()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected CommandeTaxeExpeditionDto convertToDto(CommandeTaxeExpedition item) {
var dto = new CommandeTaxeExpeditionDto();
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