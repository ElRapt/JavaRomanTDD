package com.uca;


import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RomanConverter{
	
	// Table des symboles
	private static final Collection<RomanNumber> SYMBOLS = new ArrayList<>();
	static {
		SYMBOLS.add(new RomanNumber(1000, "M"));
		SYMBOLS.add(new RomanNumber(900, "CM"));
		SYMBOLS.add(new RomanNumber(500, "D"));
		SYMBOLS.add(new RomanNumber(400, "CD"));
		SYMBOLS.add(new RomanNumber(100, "C"));
		SYMBOLS.add(new RomanNumber(90, "XC"));
		SYMBOLS.add(new RomanNumber(50, "L"));
		SYMBOLS.add(new RomanNumber(40, "XL"));
		SYMBOLS.add(new RomanNumber(10, "X"));
		SYMBOLS.add(new RomanNumber(9, "IX"));
		SYMBOLS.add(new RomanNumber(5, "V"));
		SYMBOLS.add(new RomanNumber(4, "IV"));
		SYMBOLS.add(new RomanNumber(1, "I"));
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


	public static String getRomanFromNumber(int n) throws IllegalArgumentException{
		if(n<=0 || n>= 4000) {
			throw new IllegalArgumentException("Number must be in [1:3999]");
		}

        String result = "";
        for (RomanNumber symbol : SYMBOLS) {
            while (n >= symbol.getValue()) {
                result += symbol.getRoman();
                n -= symbol.getValue();
            }
        }
        return result;
	}
	

	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		if (a.length() == 0)
		{
			throw new IllegalArgumentException("String must be not empty");
		}
        int result = 0;
        int index = 0;
        for (RomanNumber symbol : SYMBOLS) {
            while (a.startsWith(symbol.getRoman(), index)) {
                result += symbol.getValue();
                index += symbol.getRoman().length();
            }
        }
        return result;
	}
}