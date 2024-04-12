package org.sir.erplain.bean.enums;
public enum StatutLivraisonEnum {
LIVRE("LIVRE"),
;
private final String value;
StatutLivraisonEnum(String value) {
this.value = value;
}
public String value() {
return value;
}
}