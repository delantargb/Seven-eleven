package com.seven.eleven.helpers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by JPMPC-B210 on 1/21/2017.
 */
public class HelpersTest /*extends TestCase*/ {

    //expectations
    //testArrayFibonacci
    int mockTest = 21;
    String testName = "Gab123";
    //variable
    String nameSample = "Gab";
    //reality

    @Mock
    Helpers mock;
    @Before
    public void Create(){
    initMocks(this);
    //Helpers helper = mock(Helpers.class);
    //when(helpers.helpersFibonacciTest(21)).thenReturn(true);
    when(mock.helpersNameTest(nameSample)).thenReturn(testName);
    }

    @Test
    public void testMethod(){
        String nameTest = "Gab";
        assertEquals(testName, mock.helpersNameTest(nameTest));
    }
    public void testFibonacciMethod(){
        int inputFibonacci = 21;
        assertTrue(Helpers.helpersFibonacciTest(inputFibonacci));
        int inputFibonacci0 = 5;
        assertTrue(Helpers.helpersFibonacciTest(inputFibonacci0));
        int inputFibonacci1 = 3;
        assertTrue(Helpers.helpersFibonacciTest(inputFibonacci1));
        //assertEquals(testFibonacci,Helpers.helpersFibonacciTest(inputFibonacci));
    }
    /*public void testArrayFibonacci(){
        int arrayFibTest = 5;
        assertEquals(arrayFibExpctd,Helpers.arrayFibonacci(arrayFibTest));

    }*/


}
