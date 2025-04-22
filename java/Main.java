import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        int subopcion=0;
        System.out.println("Bienvenido(a)");
        System.out.println("Escriba el numero de la operacion que quiera hacer entre las siguientes opciones:");
        imprimirMenu();
        opcion= sc.nextInt();
        if (opcion== 1) {
            System.out.println("Elija una opcion: ");
            menuOperaciones();
            subopcion = sc.nextInt();
            if (subopcion==1) {
                division(sc);
            }
            if (subopcion==2) {
                mcm(sc);
            }
            if (subopcion==3) {
                mcd(sc);
            }
            if (subopcion==4){
                verificarNumPrimo(sc);
            }
        } else if (opcion==2) {
            System.out.println("Elija una opcion: ");
            menuSucesiones();
            subopcion = sc.nextInt();
            if (subopcion==1){
                secFibonacci(sc);
            }
            if (subopcion==2){
                congruencia(sc);
            }
            if (subopcion==3){
                euler(sc);
            }
            if (subopcion==4){
                sucAritmetica(sc);
            }
            if (subopcion==5){
                sucGeometrica(sc);
            }
        } else if (opcion==3) {
            System.out.println("Elija una opcion: ");
            menuOrden();
            subopcion = sc.nextInt();
            if (subopcion==1){
                numAscendentes(sc);
            }
            if (subopcion==2){
                numDescendentes(sc);
            }
        } else if (opcion==4) {
            System.out.println("Elija una opcion: ");
            menuProbabilidad();
            subopcion = sc.nextInt();
            if (subopcion==1){
                permutacion(sc);
            }
            if (subopcion==2){
                combinacion(sc);
            }
        }
    }
    public static void imprimirMenu() {
        System.out.println("1.Operaciones basicas");
        System.out.println("2.Sucesiones");
        System.out.println("3.Orden");
        System.out.println("4.Probabilidad");
    }
    public static void menuOperaciones() {
        System.out.println("1.Division");
        System.out.println("2.MCM");
        System.out.println("3.MCD");
        System.out.println("4.Verificar un numero primo");
    }
    public static void menuSucesiones() {
        System.out.println("1.Secuencia de Fibonacci");
        System.out.println("2.Congruencia");
        System.out.println("3.Teorema de Euler");
        System.out.println("4.Sucesion aritmetica");
        System.out.println("5.Sucesion geometrica");
    }
    public static void menuOrden() {
        System.out.println("1.Numeros Ascendentes");
        System.out.println("2.Numeros Descendentes");
    }
    public static void menuProbabilidad() {
        System.out.println("1.Permutacion");
        System.out.println("2.Combinacion");
    }
    public static void division(Scanner sc) {
        int dividendo = 0;
        int divisor = 0;
        float cociente = 0;
        System.out.println("Digite dividendo (Numero entero): ");
        dividendo = sc.nextInt();
        System.out.println("Digite divisor (Numero entero): ");
        divisor = sc.nextInt();
        if (divisor != 0) {
            cociente = (float) dividendo / divisor;
            System.out.println("El resultado de la division es: " + cociente + " Ya que " + dividendo + " dividido entre " + divisor + " es igual a " + cociente);
        } else {
            System.out.println("No se puede dividir por cero");
        }
    }
    public static void mcm(Scanner sc) {
        int resultado = 0;
        int a;
        int b;
        System.out.println("Ingrese el primer numero:");
        a = sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        b = sc.nextInt();
        int a1 = a;
        int b1 = b;
        int mcd;
        int temporalA = a;
        int temporalB = b;
        while (temporalB != 0) {
            int temporal = temporalB;
            temporalB = temporalA % temporalB;
            temporalA = temporal;
        }
        mcd = temporalA;
        resultado = (a1 * b1) / mcd;
        System.out.println("El MCM de " + a1 + " y " + b1 + " es: " + resultado);
        System.out.println("Ya que primero hay que hallar el Maximo Comun Divisor de estos numeros. Se divide "+a1+" entre "+b1+", despues "+a1+" entre el resultado de la division anterior, y asi sucesivamente hasta que el residuo sea igual a 0. Luego se multiplica "+a1+" por "+b1+" y se divide entre el Maximo Comun Divisor, que en este caso es "+mcd+" dando como resultado "+ resultado+".");
    }
    public static void mcd(Scanner sc) {
        int a;
        int b;
        System.out.println("Ingrese el primer numero:");
        a = sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        b = sc.nextInt();
        int temporalb=b;
        int temporala=a;
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        System.out.println("El MCD es: " + a) ;
        System.out.println("Ya que se divide "+temporala+" entre "+temporalb+", despues se divide "+temporala+" entre el resultado de la division anterior, y asi sucesivamente hasta que el residuo sea igual a 0. Cuando sea 0 se obtiene el MCD, en este caso es "+ a+".");
    }
    public static int mcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
    public static void verificarNumPrimo(Scanner sc){
        System.out.println("Ingrese un numero entero mayor a 1:");
        float num=sc.nextFloat();
        if (num<=1){
            System.out.println("El numero debe ser mayor a 1");
            return;
        }
        float primo=num;
        int cont=2;
        int contdivisores=0;
        double temporalPrimo=0;
        num=(float)Math.sqrt(num);
        while(cont<=num){
        temporalPrimo=primo%cont;
        cont+=1;
        if (temporalPrimo==0){
            contdivisores+=1;
        }
        }
    if (contdivisores==0){
        System.out.println(primo+" es primo");
        System.out.println("Ya que se saca la raiz cuadrada del numero, el cual es "+num+" esto para poder reducir el numero de comprobaciones entre 2 y "+primo+". Para verificar si hay un numero que divida a "+primo+" a parte de 1 y el mismo");
    }else{
        System.out.println(primo+" no es primo");
        System.out.println("Ya que se saca la raiz cuadrada del numero, el cual es "+num+" esto para poder reducir el numero de comprobaciones entre 2 y "+primo+". Para verificar si hay un numero que divida a "+primo+" a parte de 1 y el mismo. En este caso hay "+contdivisores+" numeros mas que dividen a "+ primo);
    }
    }
public static void secFibonacci(Scanner sc){
        System.out.println("Ingrese cuantos numeros quiere sumar en la secuencia de Fibonacci");
        int n=sc.nextInt();
        int f= 0;
        int t1=1;
        int t2;
        for (int i=1; i<=n; i++) {
        t2 = f;
        f = t1 + f;
        t1 = t2;
    }
    System.out.println(t1);
    System.out.print("En la secuencia de fibonacci es una sucesion de numeros en la que cada numero es la suma de los dos anteriores. Se empieza sumando 0 y 1 para dar 1, luego 1 y 1 para que de 2, 1 y 2 para que de 3 y asi sucesivamete hasta llegar al numero en la posicion "+n+" el cual es "+t1+".");
    }
public static void congruencia(Scanner sc){
        System.out.print("Ingresa el numero a: ");
        int a=sc.nextInt();
        System.out.print("Ingresa el numero b: ");
        int b=sc.nextInt();
        System.out.print("Ingresa el modulo n: ");
        int n=sc.nextInt();
        int diferencia = a - b;
        if (diferencia % n == 0) {
            System.out.println("\n" + a + " es congruente con " + b + " modulo " + n + ".");
            System.out.println( a + " - " + b + " = " + diferencia + ", y " + n + " divide exactamente a " + diferencia + ".");
        } else {
            int residuo = diferencia % n;
            System.out.println("\n" + a + " no es congruente con " + b + " modulo " + n + ".");
            System.out.println( a + " - " + b + " = " + diferencia + ", y " + n + " no divide a " + diferencia + ", el residuo es igual a: " + residuo + ".");
        }
}
public static int euler(Scanner sc) {
    System.out.println("Ingrese el valor de a:");
    int a = sc.nextInt();
    System.out.println("Ingrese el valor de k (exponente):");
    int k = sc.nextInt();
    System.out.println("Ingrese el valor de n (modulo):");
    int n = sc.nextInt();
    if (mcd(a, n) != 1) {
        return -1;
    }
    int phi = 0;
    for (int i = 1; i <= n; i++) {
        if (mcd(i, n) == 1) {
            phi++;
        }
    }
    int exp = k % phi;
    int resultado = 1;
    for (int i = 0; i < exp; i++) {
        resultado = (resultado * a) % n;
    }
    System.out.println("El resultado de " + a + "^" + k + " mod " + n + " es: " + resultado);
    return resultado;
}
public static void sucAritmetica(Scanner sc){
    System.out.println("Ingrese el primer termino");
    int n1=sc.nextInt();
    System.out.println("Ingrese la posicion del segundo termino");
    int n=sc.nextInt();
    System.out.println("Ingrese el segundo termino");
    int n2=sc.nextInt();
    float d=(float)(n2-n1)/(n-1);
    System.out.println(d);
}
public static void sucGeometrica(Scanner sc){
    System.out.println("Ingrese el primer termino");
    int n1=sc.nextInt();
    System.out.println("Ingrese la posicion del segundo termino");
    int n=sc.nextInt();
    System.out.println("Ingrese el segundo termino");
    int n2=sc.nextInt();
    double d = Math.pow((double)n2 / n1, 1.0 / (n - 1));
    System.out.println(d);
}
public static void numAscendentes(Scanner sc){
    System.out.println("Ingrese un numero:");
        int numero=sc.nextInt();
        System.out.println("Aumentando numeros desde 1 hasta " +numero+ ":");
        for (int i=1; i<=numero; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Se muestra todos los numeros entre 1 y "+numero+" de forma ascendente.");
}
public static void numDescendentes(Scanner sc){
    System.out.println("Ingrese un numero:");
        int numero=sc.nextInt();
        System.out.println("Disminuyendo numeros desde " +numero+ " hasta 1:");
        for (int i=numero; i>=1; i--) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Se muestra todos los numeros entre 1 y "+numero+" de forma descendente");
    }
public static void permutacion(Scanner sc){
    System.out.print("Ingrese el total de elementos: ");
    int n = sc.nextInt();
    System.out.print("Ingrese el numero de elementos que queremos seleccionar y ordenar: ");
    int r = sc.nextInt();
    
    if (r > n || n < 0 || r < 0) {
        System.out.println("Valores inválidos: r no puede ser mayor que n y ambos deben ser >= 0.");
        return;
    }
    
    long factorialN = factorial(n);
    long factorialNR = factorial(n - r);
    long permutacion = factorialN / factorialNR;
    
    System.out.println("P(" + n + ", " + r + ") = " + permutacion);
    System.out.println("Esto se calcula usando la formula P(n, r) = n! / (n - r)!");
}
public static void combinacion(Scanner sc){
    System.out.print("Ingrese el numero total de elementos: ");
    int n = sc.nextInt();
    System.out.print("Ingrese el numero de elementos que se van a seleccionar: ");
    int r = sc.nextInt();
    if (r > n || n < 0 || r < 0) {
        System.out.println("Valores inválidos: r no puede ser mayor que n y ambos deben ser >= 0.");
        return;
    }
    long factorialN = factorial(n);
    long factorialR = factorial(r);
    long factorialNR = factorial(n - r);
    long combinacion = factorialN / (factorialR * factorialNR);
    System.out.println("C(" + n + ", " + r + ") = " + combinacion);
    System.out.println("Esto se calcula usando la formula C(n, r) = n! / (r! * (n - r)!)");
}
public static long factorial(int num) {
    long resultado = 1;
    for (int i = 1; i <= num; i++) {
        resultado *= i;
    }
    return resultado;
}
}


