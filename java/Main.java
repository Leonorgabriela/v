import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int subopcion = 0;
        
        System.out.println("Bienvenido(a)");
        System.out.println("Escriba el numero de la operacion que quiera hacer entre las siguientes opciones:");
        imprimirMenu();
        opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("Elija una opcion: ");
                menuOperaciones();
                subopcion = sc.nextInt();
                switch (subopcion) {
                    case 1: division(sc); break;
                    case 2: mcm(sc); break;
                    case 3: mcd(sc); break;
                    case 4: verificarNumPrimo(sc); break;
                    default: System.out.println("Opción no válida");
                }
                break;
                
            case 2:
                System.out.println("Elija una opcion: ");
                menuSucesiones();
                subopcion = sc.nextInt();
                switch (subopcion) {
                    case 1: secFibonacci(sc); break;
                    case 2: congruencia(sc); break;
                    case 3: teoremaEuler(sc); break;
                    default: System.out.println("Opción no válida");
                }
                break;
                
            case 3:
                System.out.println("Elija una opcion: ");
                menuOrden();
                subopcion = sc.nextInt();
                switch (subopcion) {
                    case 1: aumentarNumero(sc); break;
                    case 2: disminuirNumero(sc); break;
                    default: System.out.println("Opción no válida");
                }
                break;
                
            case 4:
                System.out.println("Elija una opcion: ");
                menuProbabilidad();
                subopcion = sc.nextInt();
                switch (subopcion) {
                    case 1: permutacionesSimples(sc); break;
                    case 2: combinacion(sc); break;
                    default: System.out.println("Opción no válida");
                }
                break;
                
            default:
                System.out.println("Opción no válida");
        }
        sc.close();
    }

    // Menús
    public static void imprimirMenu() {
        System.out.println("1. Operaciones basicas");
        System.out.println("2. Sucesiones");
        System.out.println("3. Orden");
        System.out.println("4. Probabilidad");
    }

    public static void menuOperaciones() {
        System.out.println("1. Division");
        System.out.println("2. MCM");
        System.out.println("3. MCD");
        System.out.println("4. Verificar un numero primo");
    }

    public static void menuSucesiones() {
        System.out.println("1. Secuencia de Fibonacci");
        System.out.println("2. Congruencia");
        System.out.println("3. Teorema de Euler/Fermat");
    }

    public static void menuOrden() {
        System.out.println("1. Aumentar número");
        System.out.println("2. Disminuir número");
    }

    public static void menuProbabilidad() {
        System.out.println("1. Permutacion");
        System.out.println("2. Combinacion");
    }

    // Funciones de operaciones básicas
    public static void division(Scanner sc) {
        System.out.println("Digite dividendo (Numero entero): ");
        int dividendo = sc.nextInt();
        System.out.println("Digite divisor (Numero entero): ");
        int divisor = sc.nextInt();
        
        if (divisor != 0) {
            float cociente = (float) dividendo / divisor;
            System.out.println("El resultado de la division es: " + cociente + 
                             " Ya que " + dividendo + " dividido entre " + 
                             divisor + " es igual a " + cociente);
        } else {
            System.out.println("No se puede dividir por cero");
        }
    }

    public static void mcm(Scanner sc) {
        System.out.println("Ingrese el primer numero:");
        int a = sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        int b = sc.nextInt();
        
        int a1 = a;
        int b1 = b;
        int temporalA = a;
        int temporalB = b;
        
        while (temporalB != 0) {
            int temporal = temporalB;
            temporalB = temporalA % temporalB;
            temporalA = temporal;
        }
        
        int mcd = temporalA;
        int resultado = (a1 * b1) / mcd;
        System.out.println("El MCM de " + a1 + " y " + b1 + " es: " + resultado);
        System.out.println("Ya que primero hay que hallar el Maximo Comun Divisor de estos numeros. Se divide " + 
                          a1 + " entre " + b1 + ", despues " + a1 + 
                          " entre el resultado de la division anterior, y asi sucesivamente hasta que el residuo sea igual a 0. Luego se multiplica " + 
                          a1 + " por " + b1 + " y se divide entre el Maximo Comun Divisor, que en este caso es " + 
                          mcd + " dando como resultado " + resultado + ".");
    }

    public static void mcd(Scanner sc) {
        System.out.println("Ingrese el primer numero:");
        int a = sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        int b = sc.nextInt();
        
        int temporala = a;
        int temporalb = b;
        
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        
        System.out.println("El MCD es: " + a);
        System.out.println("Ya que se divide " + temporala + " entre " + temporalb + 
                         ", despues se divide " + temporala + 
                         " entre el resultado de la division anterior, y asi sucesivamente hasta que el residuo sea igual a 0. Cuando sea 0 se obtiene el MCD, en este caso es " + 
                         a + ".");
    }

    public static void verificarNumPrimo(Scanner sc) {
        System.out.println("Ingrese un numero entero mayor a 1:");
        int num = sc.nextInt();
        
        if (num <= 1) {
            System.out.println("El numero debe ser mayor a 1");
            return;
        }
        
        boolean esPrimo = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                esPrimo = false;
                break;
            }
        }
        
        if (esPrimo) {
            System.out.println(num + " es primo");
        } else {
            System.out.println(num + " no es primo");
        }
    }

    // Funciones de sucesiones
    public static void secFibonacci(Scanner sc) {
        System.out.println("Ingrese cuantos terminos quiere en la secuencia de Fibonacci:");
        int num = sc.nextInt();
        
        if (num <= 0) {
            System.out.println("Debe ingresar un número positivo mayor que cero");
            return;
        }
        
        int a = 0;
        int b = 1;
        System.out.println("Secuencia de Fibonacci:");
        
        for (int i = 0; i < num; i++) {
            System.out.print(a + " ");
            int sumanums = a + b;
            a = b;
            b = sumanums;
        }
        System.out.println();
    }

    public static void teoremaEuler(Scanner sc) {
        System.out.print("Ingresa el valor de a: ");
        int a = sc.nextInt();

        System.out.print("Ingresa el valor de n: ");
        int n = sc.nextInt();

        if (gcd(a, n) != 1) {
            System.out.println("a y n no son coprimos. El teorema no aplica.");
        } else {
            int phi = totiente(n);
            long resultado = modPow(a, phi, n);
            System.out.println("φ(" + n + ") = " + phi);
            System.out.println(a + "^" + phi + " mod " + n + " = " + resultado);
        }
    }

    public static void congruencia(Scanner sc) {
        System.out.print("Ingresa el número a: ");
        int a = sc.nextInt();

        System.out.print("Ingresa el número b: ");
        int b = sc.nextInt();

        System.out.print("Ingresa el módulo n: ");
        int n = sc.nextInt();

        if ((a - b) % n == 0) {
            System.out.println("\n✅ " + a + " ≡ " + b + " mod " + n);
        } else {
            System.out.println("\n❌ " + a + " no es congruente con " + b + " mod " + n);
        }

        System.out.println("\n--- Operaciones módulo " + n + " ---");
        System.out.println("Suma: (" + a + " + " + b + ") mod " + n + " = " + ((a + b) % n));
        System.out.println("Resta: (" + a + " - " + b + ") mod " + n + " = " + (((a - b) % n + n) % n));
        System.out.println("Multiplicación: (" + a + " * " + b + ") mod " + n + " = " + ((a * b) % n));
    }

    // Funciones de orden
    public static void aumentarNumero(Scanner sc) {
        System.out.println("Ingrese un número:");
        int numero = sc.nextInt();

        System.out.println("Aumentando desde 1 hasta " + numero + ":");
        for (int i = 1; i <= numero; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void disminuirNumero(Scanner sc) {
        System.out.println("Ingrese un número:");
        int numero = sc.nextInt();

        System.out.println("Disminuyendo desde " + numero + " hasta 1:");
        for (int i = numero; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Funciones de probabilidad
    public static void permutacionesSimples(Scanner sc) {
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingresa los números separados por espacio: ");
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }

        System.out.println("Permutaciones:");
        generarPermutaciones(numeros, 0);
    }

    public static void combinacion(Scanner sc) {
        System.out.print("Ingrese el valor de n: ");
        int n = sc.nextInt();
        System.out.print("Ingrese el valor de r: ");
        int r = sc.nextInt();

        if (r > n || n < 0 || r < 0) {
            System.out.println("Los valores deben cumplir 0 ≤ r ≤ n");
            return;
        }

        // C(n, r) = C(n, n - r)
        if (r > n - r) {
            r = n - r;
        }

        long numerador = 1;
        long denominador = 1;

        for (int i = 1; i <= r; i++) {
            numerador *= (n - i + 1);
            denominador *= i;
        }

        long resultado = numerador / denominador;
        System.out.println("La combinación C(" + n + ", " + r + ") es: " + resultado);
    }

    // Funciones auxiliares
    public static int totiente(int n) {
        int result = n;
        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }

    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void generarPermutaciones(int[] arr, int inicio) {
        if (inicio == arr.length) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = inicio; i < arr.length; i++) {
            int temp = arr[inicio];
            arr[inicio] = arr[i];
            arr[i] = temp;

            generarPermutaciones(arr, inicio + 1);

            // Volver al estado anterior
            temp = arr[inicio];
            arr[inicio] = arr[i];
            arr[i] = temp;
        }
    }
}
