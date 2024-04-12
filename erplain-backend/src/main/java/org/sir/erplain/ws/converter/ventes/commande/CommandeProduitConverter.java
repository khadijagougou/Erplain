package org.sir.erplain.ws.converter.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeProduit;
import org.sir.erplain.ws.dto.ventes.commande.CommandeProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CommandeProduitConverter {
@Autowired private CommandeConverter commandeConverter;
private boolean commande = true;
protected void configure(boolean value) {
this.commandeConverter.setCommandeProduit(value);
}
public final CommandeProduitDto toDto(CommandeProduit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final CommandeProduit toItem(CommandeProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<CommandeProduit> toItem(List<CommandeProduitDto> dtos) {
if (dtos == null) return null;
List<CommandeProduit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<CommandeProduitDto> toDto(List<CommandeProduit> items) {
if (items == null) return null;
List<CommandeProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected CommandeProduit convertToItem(CommandeProduitDto dto) {
var item = new CommandeProduit();
item.setId(dto.getId());
item.setTotal(dto.getTotal());
item.setQuantite(dto.getQuantite());
item.setDisque(dto.getDisque());
item.setCommande(commandeConverter.toItem(dto.getCommande()));
return item;
}
protected CommandeProduitDto convertToDto(CommandeProduit item) {
var dto = new CommandeProduitDto();
dto.setId(item.getId());
dto.setTotal(item.getTotal());
dto.setQuantite(item.getQuantite());
dto.setDisque(item.getDisque());
dto.setCommande(commande? commandeConverter.toDto(item.getCommande()): null);
return dto;
}
public void setCommande(boolean value) {
this.commande = value;
}
public void setCommandeConverter(CommandeConverter value) {
this.commandeConverter = value;
}
public CommandeConverter getCommandeConverter() {
return commandeConverter;
}
}