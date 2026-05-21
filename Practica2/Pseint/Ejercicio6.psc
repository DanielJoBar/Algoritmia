Algoritmo MCD
    Definir m, n Como Real
    Escribir 'Introduce un número real(m)'
    Leer m
    Escribir 'Introduce un número real(n)'
    Leer n
    resultado <- MCD(m,n)
    Escribir "El MCD de m: ",m," y de n: ",n," es: ", resultado
FinAlgoritmo

Funcion Retornar <- MCD(m,n)
    Si n==0 Entonces
        Retornar m
    SiNo
        Retornar MCD(n, m mod n)
    FinSi
FinFuncion