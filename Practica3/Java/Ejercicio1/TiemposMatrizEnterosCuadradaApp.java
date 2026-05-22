package Practica3.Java.Ejercicio1;

import java.util.Arrays;
import java.util.Random;

class MatrizEnterosCuadrada {
    private int[][] matriz;


    public MatrizEnterosCuadrada(int numeroFilasCol) {
        matriz = new int[numeroFilasCol][numeroFilasCol];
        Random rand = new Random();
        for (int i = 0; i < numeroFilasCol; i++) {
            for (int j = 0; j < numeroFilasCol; j++) {
                matriz[i][j] = rand.nextInt(100); 
            }
        }
    }


    public MatrizEnterosCuadrada(int[][] m) {
        int n = m.length;
        matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            matriz[i] = m[i].clone(); 
        }
    }

    
    public int[][] getMatriz() {
        return matriz;
    }

    // Método: Ordenación por selección (Selection Sort)
    public static void ordenaSeleccion(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }


    public MatrizEnterosCuadrada matrizOrdenadaPorFilas() {
       
        MatrizEnterosCuadrada nuevaMatriz = new MatrizEnterosCuadrada(this.matriz);
        

        for (int i = 0; i < nuevaMatriz.matriz.length; i++) {
            ordenaSeleccion(nuevaMatriz.matriz[i]);
        }
        
        return nuevaMatriz;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz) {
            sb.append(Arrays.toString(fila)).append("\n");
        }
        return sb.toString();
    }
}


public class TiemposMatrizEnterosCuadradaApp {
    
    public static void main(String[] args) {

        System.out.printf("%-10s | %-15s\n", "Tamaño (n)", "Tiempo Medio (ms)");
        System.out.println("----------------------------------");


        for (int n = 32; n <= 8192; n *= 2) {
            
            MatrizEnterosCuadrada matrizOriginal = new MatrizEnterosCuadrada(n);
            long[] tiempos = new long[10];


            for (int rep = 0; rep < 10; rep++) {
                long inicio = System.nanoTime(); 
                matrizOriginal.matrizOrdenadaPorFilas();
                long fin = System.nanoTime();
                
                tiempos[rep] = (fin - inicio);
            }


            long maxTiempo = tiempos[0];
            long sumaTiempos = 0;
            
            for (long t : tiempos) {
                if (t > maxTiempo) {
                    maxTiempo = t;
                }
                sumaTiempos += t;
            }


            long mediaNano = (sumaTiempos - maxTiempo) / 9;
            

            double mediaMilis = mediaNano / 1000000.0;

            System.out.printf("%-10d | %-15.4f\n", n, mediaMilis);
        }
        
        System.out.println("\n(Nota: Las ejecuciones con n=4096 y n=8192 pueden tardar varios minutos en terminar).");
    }
}