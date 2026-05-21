Algoritmo Funcion_Ackerman
    Definir m, n Como Real
    Escribir 'Introduce un número real(m):'
    Leer m
    Escribir 'Introduce un número real(n):'
    Leer n
    resultado <- Ackerman(m,n)
    Escribir "La funcion de Ackerman de m: ",m," y de n: ",n," es: ", resultado
FinAlgoritmo

Funcion Retornar <- Ackerman(m,n)
    Si m==0 Entonces
        Retornar n+1
    SiNo
        Si m>0 y n==0 Entonces
            Retornar Ackerman(m-1,1)
        SiNo
            Si m>0 y n>0 Entonces
                Retornar Ackerman(m-1, Ackerman(m, n-1))
            FinSi
        FinSi
    FinSi
FinFuncion