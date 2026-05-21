Algoritmo ejercicio_4
    Definir x,n, resultado Como Entero
    Escribir 'introduce un numero'
    Leer x
    Escribir 'introducir la potencia'
    Leer n
    resultado <- potencia(x,n)
    Escribir resultado
FinAlgoritmo

Funcion resultado <- potencia(x,n)
    si n==0 Entonces
        resultado <- 1
    SiNo
        resultado <- x * potencia(x,n-1)
    FinSi
FinFuncion