Algoritmo Fibonnaci
    Definir n, Fibonacci Como Entero
    Escribir 'Introduce un entero:'
    Leer n
    Fibonacci <- FibonacciN(n)
    Escribir "El n-ésimo termino de ", n," es ", Fibonacci
FinAlgoritmo

Funcion Retornar <- FibonacciN(n)
    Si n=0 o n=1 Entonces 
        Retornar n
    SiNo
        Si n>=2 Entonces
            Retornar FibonacciN(n-1) + FibonacciN(n-2)
        FinSi
    FinSi
FinFuncion