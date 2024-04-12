package org.sir.erplain.bean.core.address;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="country")
public class Country {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;
@OneToMany(mappedBy = "country")
private List<Address> addresses;
public Country() {
}
public Country(Long id, String label) {
// constructor to get optimized fields
this.id = id;
this.name = label;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public List<Address> getAddresses() {
return addresses;
}
public void setAddresses(List<Address> value) {
this.addresses = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Country country) {
return country.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}