package org.sir.erplain.bean.enums;
public enum StatutRetourProduitEnum {
LIVRE("LIVRE"),
ENATTENTE("En attente"),
;
private final String value;
StatutRetourProduitEnum(String value) {
this.value = value;
}
public String value() {
return value;
}
}