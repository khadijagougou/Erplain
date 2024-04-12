package org.sir.erplain.ws.converter.ventes;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.sir.erplain.ws.dto.ventes.CommandeExpeditionDto;
import org.sir.erplain.ws.converter.ventes.commande.CommandeConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CommandeExpeditionConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private CommandeConverter commandeConverter;
private boolean commande = true;
private boolean entreprise = true;
protected void configure(boolean value) {
this.entrepriseConverter.setCommandeExpedition(value);
this.commandeConverter.setCommandeExpedition(value);
}
public final CommandeExpeditionDto toDto(CommandeExpedition item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final CommandeExpedition toItem(CommandeExpeditionDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<CommandeExpedition> toItem(List<CommandeExpeditionDto> dtos) {
if (dtos == null) return null;
List<CommandeExpedition> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<CommandeExpeditionDto> toDto(List<CommandeExpedition> items) {
if (items == null) return null;
List<CommandeExpeditionDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected CommandeExpedition convertToItem(CommandeExpeditionDto dto) {
var item = new CommandeExpedition();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setDateCreation(dto.getDateCreation());
item.setDateExpedition(dto.getDateExpedition());
item.setStatut(dto.getStatut());
item.setCommande(commandeConverter.toItem(dto.getCommande()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
return item;
}
protected CommandeExpeditionDto convertToDto(CommandeExpedition item) {
var dto = new CommandeExpeditionDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setDateCreation(item.getDateCreation());
dto.setDateExpedition(item.getDateExpedition());
dto.setStatut(item.getStatut());
dto.setCommande(commande? commandeConverter.toDto(item.getCommande()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
return dto;
}
public void setCommande(boolean value) {
this.commande = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setCommandeConverter(CommandeConverter value) {
this.commandeConverter = value;
}
public CommandeConverter getCommandeConverter() {
return commandeConverter;
}
}