package com.seven.eleven.helpers;

/**
 * Created by JPMPC-B210 on 1/21/2017.
 */
public class Helpers {
    public static String helpersNameTest(String name){
        System.out.println(name = name+"123");
        return name;
    }

    public static boolean helpersFibonacciTest(int inputFibonacci) {
        int fib1 = 0, fib2 = 1, fib3;
        boolean resultFibonacci;

        do {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
            //System.out.println(fib3);
        }while(fib3<inputFibonacci);
        resultFibonacci=(fib3==inputFibonacci);
        /* if (fib1==fibonacciTest){
                resultFibonacci = true;
            }else {
                resultFibonacci = false;
            }*/
        System.out.println(inputFibonacci+" is a " + resultFibonacci + " Fibonacci number");
        return resultFibonacci;
    }

    public static int arrayFibonacci(int fiboInput){
        //System.out.println(arrayFib[6]);
        int[] arrayFib = new int[fiboInput];
        for(int i=0;i<arrayFib.length;i++){
            //System.out.println(arrayFib[i]+"+"+arrayFib[i+1] + " = " + arrayFib[i+2]);
            System.out.println(arrayFib[i]);
        }
        return fiboInput;
    }
}


