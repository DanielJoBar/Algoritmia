package Practica3.Java.Ejercicio1;

public class MatrizEnterosCuadrada {
    //  Almacena la matriz que se va a manipular
    private int[][] matriz; 

    //  Recibe el tamaño de la matriz y crea una nueva almacenandola en la variable "matriz"
    MatrizEnterosCuadrada(int numeroFilasCol){
        int[][] copy = new int[numeroFilasCol][numeroFilasCol];
        for(int i = 0; i < numeroFilasCol ; i++){
            for(int j = 0; j < numeroFilasCol ;j++){
            copy[i][j] = (int)(Math.random()*100);
            }
        }
        this.matriz = copy.clone();
    }
    //  la array pasada por parámetro a "matriz"
    MatrizEnterosCuadrada(int[][]array){
        this.matriz =  array.clone(); 
    }

    //  Ordena la array pasada por parámetro usando el método de selección
    public static void ordenaSeleccion(int[] array){
        int menor;
        int pos;
        for (int i = 0 ; i < array.length-1 ; i++) {
            menor  = array[i];
            pos = i;
            for( int k = i+1 ; k < array.length-1 ; k++){
                if( array[k] < menor ){
                    menor = array[k];
                    pos = k;
                }
            }
            if(pos != i){
                int aux = array[pos];
                array[pos] = array[i];
                array[i] = aux;
            }
        }
        
    }
    public MatrizEnterosCuadrada matrizOrdenadaPorFilas(){
        int n = this.matriz.length;
        int[][] sorted = new int[n][n];
        for (int[] fila : sorted) {
            ordenaSeleccion(fila);
        }
        return new MatrizEnterosCuadrada(sorted);
    }
    @Override
    public String toString(){
        String result="";
        for(int i = 0; i < matriz.length ; i++){
            for(int j = 0; j < matriz.length ;j++){
                result+="[ "+matriz[i][j]+" ] ";
            }
            result+='\n';
        }
        return result;
    }
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    public int[][] getMatriz() {
        return matriz;
    }
}
