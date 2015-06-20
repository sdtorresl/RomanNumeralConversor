package com.sdtorresl.numbers;

public class RomanNumber {
	
	private int decimalNumber;
	private String romanNumber;
	
	private static final int[] DECIMAL_VALUE = 
		{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
	private static final String[] ROMAN_SYMBOL = 
		{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

	public RomanNumber() {};
	
	public RomanNumber(int number) throws Exception {
		if(number < 0) {
			throw new Exception("No se aceptan números negativos");
		}
		if(number > 4000) {
			throw new Exception("No se aceptan números mayores a 4000");
		}
		setDecimalNumber(number);
		setRomanNumber(toRoman(number));
	}
	
	public void setDecimalNumber(int number) throws Exception {
		if(number < 0) {
			throw new Exception("No se aceptan números negativos");
		}
		if(number > 4000) {
			throw new Exception("No se aceptan números mayores a 4000");
		}
		decimalNumber = number;
		romanNumber = toRoman(number);
	}
	
	public int getDecimalNumber() {
		return toDecimal(romanNumber);
	}
	
	public void setRomanNumber(String roman) {
		romanNumber = roman;
	}
	
	public String getRomanNumber() {
		return romanNumber;
	}
	
	private String toRoman(int number) {
		romanNumber = "";
		int numberValue = 1;
		
		int i = 1;
		while (number > 0) {
			numberValue = DECIMAL_VALUE[DECIMAL_VALUE.length - i];
					
			while(number >= numberValue) {
				number -= numberValue;
				romanNumber += ROMAN_SYMBOL[ROMAN_SYMBOL.length - i];
			}
			
			i++;
		}
				
		return romanNumber;
	}
	
	private int toDecimal(String roman) {
		decimalNumber = 0;
		String symbol;
		int major = 0;

		for(int i = roman.length()-1; i>=0; i--) {
			for (int j = ROMAN_SYMBOL.length-1; j >= 0; j--) {
				symbol = String.valueOf(roman.charAt(i));

				if (symbol.equals(ROMAN_SYMBOL[j])) {
					if (major <= DECIMAL_VALUE[j]) {
						decimalNumber += DECIMAL_VALUE[j];
						major = DECIMAL_VALUE[j];
					}
					else
						decimalNumber -= DECIMAL_VALUE[j];
				}
			}
		}
		
		return decimalNumber;
	}
}
