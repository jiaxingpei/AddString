package AddString;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 5/16/13
 * Time: 5:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestAddString {

    @Test
    public void returnZero(){
        assertEquals(0, AddString.Add(""));
    }
    @Test
    public void returnOneNumber(){
        assertEquals(5, AddString.Add("5"));
        assertEquals(5, AddString.Add(",5"));
    }
    @Test
    public void returnSumTwoNumber(){
        assertEquals(3, AddString.Add(",1,2"));
    }
    @Test
    public void returnSumOfMultipliNumbers(){
        assertEquals(6, AddString.Add("1,2,3"));
        assertEquals(10, AddString.Add(("1,2,3,4")));
    }
    @Test
    public void returnSumInCaseNewLine(){
        assertEquals(6, AddString.Add(",1\n2,3"));
        assertEquals(6, AddString.Add(("1,2\n3")));
        assertEquals(10, AddString.Add("1\n2\n3\n4"));

    }
    @Test
    public void returnSumInHaveDelimiters(){
        assertEquals(18, AddString.Add("2//4;1;11"));
        assertEquals(9, AddString.Add("//;2;3.4") );
        assertEquals(9, AddString.Add("//.\n;2;3.4") );
    }

    @Test
    public void returnExceptionWhenStringHasANegative(){
        try{
            AddString.Add("5,-4,-55,2");
        }catch (RuntimeException e){
            assertEquals("negative not allowed: -4 -55", e.getMessage());
        }
    }
    @Test
    public void shouldIgnoreWhenStringHaveANumberBiggerThan1000(){
        assertEquals(10, AddString.Add("1,2,3,4;1001"));
        assertEquals(6, AddString.Add("1,2,3,;1045"));
    }
    @Test
    public void returnSumInCaseDelimiterHaveLenghtThanOne(){
        assertEquals(10, AddString.Add("1***2***3***4"));
        assertEquals(10, AddString.Add("1***2***3*****4"));
        assertEquals(10, AddString.Add("****1***2*******3***4"));
    }
    @Test
    public void returnSumInCaseStringHaveMultipleDelimiter(){
        assertEquals(6, AddString.Add("//*%\n1*2%3"));
    }
    @Test
    public void returnSumInCaseMultipleDelimiterWithLengthLongThanOne(){
        assertEquals(6, AddString.Add("////**1,,,**%%;;;;%%\n\n*2*%3"));
        assertEquals(10, AddString.Add("////*****1,,,**%%;;;;%%\n\n*2*%3;;;;;;%%%%%%%%%4"));
        assertEquals(15, AddString.Add("////**1,,,*4*%%;;5;;%%\n\n*2*%3"));
    }
}
