Algoritmo Polinomio_de_legendre
    Definir n, x Como Real 
    Escribir 'Introduce un número real (n):'
    Leer n
    Escribir 'Introduce un número real(x):'
    Leer x
    resultado <- Legendre(n,x)
    Escribir "El valor del polinomio de Legendre P ", n, "(", x, ") es: ", resultado
FinAlgoritmo

Funcion Retornar <- Legendre(n,x)
    Si n=0 Entonces
        Retornar 1
    SiNo
        Si n=1 Entonces
            Retornar x
        SiNo
            Retornar ((2*n-1)/n) * x * Legendre(n-1, x) - ((n-1)/n) * Legendre(n-2, x)
        FinSi
    FinSi
FinFuncion