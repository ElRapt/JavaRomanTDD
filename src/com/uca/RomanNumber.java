package com.uca;

public class RomanNumber extends Number implements Comparable<RomanNumber>{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	
	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	

    public int compareTo(RomanNumber other) {

        RomanNumber compareToEmp = (RomanNumber)other;

        if (this.value == compareToEmp.value) return 0;

        if (this.value > compareToEmp.value) return 1;

        return -1;        

    }
	
	
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		return (double) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {
		return (float) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		return (int) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		return (long) this.value;
	}

	@Override
	public String toString() {
		return "This roman number is equal to " + this.value + " in decimal and " + this.roman + " in roman";
	}
}