package org.printassist.jobmanagergui;

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
}
