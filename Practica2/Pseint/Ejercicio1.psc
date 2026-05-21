Algoritmo Factorial_De_N
    Definir n, Factorial Como Entero
    Escribir 'Introduce un entero:'
    Leer n
    Factorial <- FactorialN(n)
    Escribir "El factorial de ", n, " es ", Factorial
FinAlgoritmo

Funcion Retornar <- FactorialN(n)
    Si n=0 Entonces
        Retornar 1
    SiNo
        Retornar n * FactorialN(n-1)
    FinSi
FinFuncion