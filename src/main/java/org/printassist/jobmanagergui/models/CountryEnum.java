package org.printassist.jobmanagergui.models;

public enum CountryEnum {
	AT("Österreich"),
	DE("Deutschland");

	CountryEnum(String country) {
	}

	public static CountryEnum getCountry(String country) {
		switch (country) {
			case "de": return DE;
			default: return AT;
		}
	}


	@Override
	public String toString() {
		return super.toString();
	}
}
