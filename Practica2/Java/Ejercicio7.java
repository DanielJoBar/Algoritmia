package Practica2.Java;

public class Ejercicio7 {
    public static String cambioDeBase (double n, double b) {
    if (n < b) {
        return String.valueOf((char) ('0' + n));
    }
    double r = n % b;
    double c = Math.floor(n / b); 
    return cambioDeBase(c, b) + (char)('0' + r);
    }
}
