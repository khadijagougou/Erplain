package org.sir.erplain.bean.enums;
public enum StatutBonCommandeEnum {
ACTIF("ACTIF"),
;
private final String value;
StatutBonCommandeEnum(String value) {
this.value = value;
}
public String value() {
return value;
}
}