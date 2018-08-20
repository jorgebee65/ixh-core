package com.ixh.util;

import java.text.NumberFormat;
import java.util.Locale;

public class AppFormatter {

	private static Locale locale = new Locale("es", "MX");
	
	public static String toCurrencyTx(Float amount) {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(amount);
	}
	
}
