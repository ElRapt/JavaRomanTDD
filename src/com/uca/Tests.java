package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(4));

        assertThat(RomanConverter.getRomanFromNumber(9), equalTo("IX"));
        assertThat(RomanConverter.getNumberFromRoman("IX"), equalTo(9));

        assertThat(RomanConverter.getRomanFromNumber(40), equalTo("XL"));
        assertThat(RomanConverter.getNumberFromRoman("XL"), equalTo(40));

        assertThat(RomanConverter.getRomanFromNumber(600), equalTo("DC"));
        assertThat(RomanConverter.getNumberFromRoman("DC"), equalTo(600));

        assertThat(RomanConverter.getRomanFromNumber(400), equalTo("CD"));
        assertThat(RomanConverter.getNumberFromRoman("CD"), equalTo(400));

        assertThat(RomanConverter.getRomanFromNumber(17), equalTo("XVII"));
        assertThat(RomanConverter.getNumberFromRoman("XVII"), equalTo(17));

        assertThat(RomanConverter.getRomanFromNumber(19), equalTo("XIX"));
        assertThat(RomanConverter.getNumberFromRoman("XIX"), equalTo(19));

        assertThat(RomanConverter.getRomanFromNumber(3999), equalTo("MMMCMXCIX"));
        assertThat(RomanConverter.getNumberFromRoman("MMMCMXCIX"), equalTo(3999));       

		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("0XV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XVXV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
        

        for(int i =1; i<3999; i++)
        {
            assertThat(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i)), equalTo(i));
        }
	}
    
	//TODO : les autres tests
	
    @Test
    public void numberConverter()
    {
        RomanNumber twelve = new RomanNumber("XII");
        assertThat(twelve.floatValue(), equalTo(12.0f));
        assertThat(twelve.doubleValue(), equalTo(12.0));
        assertThat(twelve.intValue(), equalTo(12));
        assertThat(twelve.longValue(), equalTo(12L));
        assertThat(twelve.toString(), equalTo("This roman number is equal to " + twelve.getValue() + " in decimal and " + twelve.getRoman() + " in roman"));
    }

    @Test
    public void compareTo()
    {
        RomanNumber twelve = new RomanNumber("XII");
        RomanNumber thirteen = new RomanNumber("XIII");
        RomanNumber twelve2 = new RomanNumber("XII");

        assertThat(twelve.compareTo(twelve2), equalTo(0));
        assertThat(twelve.compareTo(thirteen), equalTo(-1));
        assertThat(thirteen.compareTo(twelve), equalTo(1));

        assertThat(twelve.compareTo(12), equalTo(0));
        assertThat(twelve.compareTo(13), equalTo(-1));
        assertThat(thirteen.compareTo(12), equalTo(1));
    }
    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
