package Practica3.Java.Ejercicio2;

public class Subsecuencia {
    private int[] array;
    private static int IPrimero = 0; 
    private static int IUltimo = 0; 
    private int suma = 0;   

    public Subsecuencia(int numeroElementos) {
        array = new int[numeroElementos];
        for (int i = 0; i < numeroElementos; i++) {
            array[i] = (int)((Math.random()*198)-99);
        }
    }

    public Subsecuencia(int[] arrayEnteros) {
        array = arrayEnteros.clone();
    }

    public int getPrimer() {
        return IPrimero;
    }

    public int getUltimo() {
        return IUltimo;
    }

    public int getSuma() {
        return suma;
    }

    public int[] getArray() {
        return array;
    }
    

    public static int SubsecuenciaFuerzaBruta( int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                    IPrimero = i;
                    IUltimo = j;
                }
            }
        }
        return maxSum;
    }
    
    public static int SubsecuenciaMejorado( int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                    IPrimero = i;
                    IUltimo = j;
                }
            }
        }
        return maxSum;
    }

    public static int SubsecuenciaLineal( int[] a) {
        int maxSum = 0;
        int thisSum = 0;
        int tempStart = 0;
        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];
            if (thisSum > maxSum) {
                maxSum = thisSum;
                IPrimero = tempStart;
                IUltimo = j;
            } else if (thisSum < 0) {
                thisSum = 0;
                tempStart = j + 1;
            }
        }
        return maxSum;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: ");
        for (int num : array) {
            sb.append(num).append(" ");
        }
        sb.append("\nMax Sum: ").append(suma)
          .append(" (desde índice ").append(IPrimero)
          .append(" hasta ").append(IUltimo).append(")");
        return sb.toString();
    }
}
