package Practica3.Java.Ejercicio2;

public class TiemposSubsecuenciaApp {
    public static void main(String[] args) {

        System.out.printf("%-10s %-25s %-25s %-25s\n", 
                          "n", "Fuerza Bruta (ms)", "Mejorado (ms)", "Lineal (ms)");
        

        for (int n = 32; n <= 8192; n *= 2) {
            Subsecuencia subsecuencia = new Subsecuencia(n);
            int[] originalArray = subsecuencia.getArray();

            long[] tiemposFuerzaBruta = new long[10];
            long[] tiemposMejorado   = new long[10];
            long[] tiemposLineal     = new long[10];
            
            for (int i = 0; i < 10; i++) {
                long inicio = System.nanoTime();
                int res = Subsecuencia.SubsecuenciaFuerzaBruta(originalArray);
                long fin = System.nanoTime();
                tiemposFuerzaBruta[i] = fin - inicio;
            }
            
            for (int i = 0; i < 10; i++) {
                long inicio = System.nanoTime();
                int res = Subsecuencia.SubsecuenciaMejorado(originalArray);
                long fin = System.nanoTime();
                tiemposMejorado[i] = fin - inicio;
            }
            
            for (int i = 0; i < 10; i++) {
                long inicio = System.nanoTime();
                int res = Subsecuencia.SubsecuenciaLineal(originalArray);
                long fin = System.nanoTime();
                tiemposLineal[i] = fin - inicio;
            }
            
            double avgFuerzaBruta = averageExcludingMax(tiemposFuerzaBruta) / 1e6;
            double avgMejorado   = averageExcludingMax(tiemposMejorado)   / 1e6;
            double avgLineal     = averageExcludingMax(tiemposLineal)     / 1e6;
            
            System.out.printf("%-10d %-25.4f %-25.4f %-25.4f\n", 
                              n, avgFuerzaBruta, avgMejorado, avgLineal);
        }
    }

    public static double averageExcludingMax(long[] times) {
        long max = times[0];
        long suma = 0;
        for (long t : times) {
            if (t > max) {
                max = t;
            }
            suma += t;
        }
        // Descartamos el mayor tiempo
        suma -= max;
        return suma / 9.0;
    }
}
