package lab6p1_lloydcooper;

import java.util.*;

public class Lab6P1_LloydCooper {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
    
    //Lloyd Cooper 12211056
    
    public static void menu(){
        System.out.println("----------MENU----------");
        System.out.println("1. Suma de Arreglos ");
        System.out.println("2. Vocales y consonantes ");
        System.out.println("3. Floor and Ceiling ");
        System.out.println("Ingrese una opcion: ");
        System.out.println("-------------------------");
    }
    public static void main(String[] args) {
        char resp = 's';
        do {
            menu();
            int opcion = leer.nextInt();
             switch (opcion){
                case 1:
                    System.out.print("Ingrese cantidad de clases de estudiante 1: ");
                    int cantClases1 = leer.nextInt();
                    int[] notas1 = notasRandom(cantClases1);
                    System.out.println("Notas estudiante 1: " + imprimirNotas(notas1));
                    
                    System.out.print("Ingrese cantidad de clases de estudiante 2: ");
                    int cantClases2 = leer.nextInt();
                    int[] notas2 = notasRandom(cantClases2);
                    System.out.println("Notas estudiante 2: " + imprimirNotas(notas2));
                    double promedio = calcularPromedio(notas1, notas2);

                    System.out.println("Promedio de notas de ambos estudiantes: " + promedio);
                
                    break;
                case 2:
                    System.out.print("Ingrese una cadena: ");
                    leer.nextLine();
                    String palabra = leer.nextLine();
                    char[] resultado = vocalesConsonantes(palabra);
                    System.out.print("Resultado: [");
                    for (int i = 0; i < resultado.length; i++) {
                        System.out.print(resultado[i]);
                        if (i < resultado.length - 1) {
                            System.out.print("][");
                        }
                    }
                    System.out.println("]");
                    break;
                case 3:
                System.out.print("Ingrese tamaño de arreglo: ");
                int size = leer.nextInt();
                int[] array = generarArregloAleatorio(size);
                System.out.println("Arreglo generado: " + Arrays.toString(array));
                int[] res = encontrarAlturas(array);
                System.out.println("Arreglo final: " + Arrays.toString(res));
                    break;
             }
          System.out.println("Desea continuar? [s/n]");
          resp = leer.next().charAt(0);
        } while (resp == 's' || resp == 'S');
            
        
    }
    
    //EJERCICIO 1:
    public static int[] notasRandom(int cantClases) {
        int[] notas = new int[cantClases];
        Random random = new Random();
        for (int i = 0; i < notas.length; i++) {
            notas[i] = random.nextInt(100)+1;
        }
        return notas;
    }
    
    public static String imprimirNotas(int[] notas) {
        String cadenaNotas = "[";
        for (int i = 0; i < notas.length; i++) {
            cadenaNotas += notas[i];
            if (i < notas.length-1) {
                cadenaNotas += ",";
            }
        }
        cadenaNotas += "]";
        return cadenaNotas;
    }
    
    public static int sumarNotas(int[] notas) {
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma;
    }
    
    public static double calcularPromedio(int[] notas1, int[] notas2) {
        int suma1 = sumarNotas(notas1);
        int suma2 = sumarNotas(notas2);
        int totalNotas = suma1 + suma2;
        double promedio = (double) totalNotas / (notas1.length + notas2.length);
        return promedio;
    }
    
    //EJERCICIO 2:
    public static char[] vocalesConsonantes(String x) {
        char[] arreglo = new char[x.length()];
        int index = 0;
        // Almacenar las vocales seguidas de las consonantes en el arreglo
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (esVocal(c)) {
                arreglo[index] = c;
                index++;
            }
        }
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (!esVocal(c)) {
                arreglo[index] = c;
                index++;
            }
        }
        return arreglo;
    }

    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }      
    
    //EJERCICIO 3:
    public static int[] generarArregloAleatorio(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1571) + 1000; // generar números entre 1000 y 2570
        }
        return array;
    }

    public static int[] encontrarAlturas(int[] array) {
        int[] resultado = new int[2];
        resultado[0] = array[0]; // asumimos que el primer elemento es el menor
        resultado[1] = array[0]; // asumimos que el primer elemento es el mayor
        for (int i = 1; i < array.length; i++) {
            if (array[i] < resultado[0]) { // si se encuentra un num menor al actual minimo lo actualizamos como el nuevo minimo
                resultado[0] = array[i]; 
            }
            if (array[i] > resultado[1]) { // si se encuentra un num mayor al actual maximo lo actualizamos como el nuevo maximo
                resultado[1] = array[i]; 
            }
        }
        return resultado;
    }
    
   
}
