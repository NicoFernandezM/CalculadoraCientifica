import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraCientificaCompleta {
    public static void main(String[] args) {
        int menuOption;
        int minOption = 1;
        int maxOption = 6;

        do {
            printMainMenu();
            menuOption = getMenuOption(minOption, maxOption);
            callMethods(menuOption);
        }while(menuOption != 6);
    }

    public static int getMenuOption(int minOption, int maxOption) {
        int menuOption;
        int counter = 0;

        do {
            if(counter != 0) {
                System.out.println("Por favor ingrese un número dentro de las opciones.");
            }

            menuOption = chooseMenuOption();
            counter++;
        }while(menuOption < minOption || menuOption > maxOption);

        return menuOption;
    }

    public static void printMainMenu() {
        System.out.println("Por favor ingrese su opción.\n" +
                "1. Operaciones aritméticas\n" +
                "2. Ecuación cuadrática\n" +
                "3. Figuras geométricas\n" +
                "4. Sistema ecuaciones lineales\n" +
                "5. Ecuación de la recta\n" +
                "6. Salir");
    }

    public static int chooseMenuOption() {
        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        }catch(InputMismatchException e) {
            return 0;
        }
    }

    public static void callMethods(int menuOption) {
        switch (menuOption) {
            case 1:
                resolveArithmeticOperations();
                break;
            case 2:
                resolveQuadraticEquation();
                break;
            case 3:
                resolveGeometricalShapes();
                break;
            case 4:
                resolveEquationSystem();
                break;
            case 5:
                resolveEquationOfStraightLine();
                break;
            case 6:
                System.out.println("Programa finalizado");
                break;
        }
    }

    //----------------------------------------------------------------------------------------

    public static void resolveArithmeticOperations() {
        int minOption = 1;
        int maxOption = 8;

        printArithmeticOperationsMenu();

        int menuOption = getMenuOption(minOption, maxOption);

        System.out.println("Por favor ingrese el primer número.");
        double number1 = getVariable();
        System.out.println("Por favor ingrese el segundo número.");
        double number2 = getVariable();

        arithmeticOptions(menuOption, number1, number2);
    }

    public static void arithmeticOptions(int menuOption, double number1, double number2) {
        switch (menuOption) {
            case 1:
                addOption(number1, number2);
                break;
            case 2:
                subtractOption(number1, number2);
                break;
            case 3:
                multiplyOption(number1, number2);
                break;
            case 4:
                divideOption(number1, number2);
                break;
            case 5:
                calculateGreater(number1, number2);
                break;
            case 6:
                calculateSmaller(number1, number2);
                break;
            case 7:
                calculatePow(number1, number2);
                break;
            case 8:
                calculatePercentage(number1, number2);
                break;
        }
    }

    public static void printArithmeticOperationsMenu() {
        System.out.println("Por favor ingrese una opción.\n" +
                "1.Suma\n" +
                "2.Resta\n" +
                "3.Multiplicación\n" +
                "4.División\n" +
                "5.Mayor entre 2 números\n" +
                "6.Menor entre 2 números\n" +
                "7.Potencia\n" +
                "8.Porcentaje de un número");
    }

    public static double getVariable() {

        while(true) {
            Scanner scanner = new Scanner(System.in);

            try {
                return scanner.nextDouble();
            }catch(InputMismatchException e) {
                System.out.println("Por favor ingrese un número");
            }
        }
    }

    //----------------------------------------------------------------------------------------

    public static void addOption(double number1, double number2) {
        double result = number1 + number2;
        System.out.println(number1 + "+" + number2 + ": " + result);
    }

    public static void subtractOption(double number1, double number2) {
        double result = number1 - number2;
        System.out.println(number1 + "-" + number2 + ": " + result);
    }

    public static void multiplyOption(double number1, double number2) {
        double result = number1 * number2;
        System.out.println(number1 + "*" + number2 + ": " + result);
    }

    public static void divideOption(double number1, double number2) {
        if(number2 == 0) {
            System.out.println("No es posible dividir por cero.");
        }else {
            double result = number1 / number2;
            System.out.println(number1 + "/" + number2 + ": " + result);
        }
        // Intenté resolverlo con un try-catch pero no me imprimía el mensaje deseado.
        /*try {
            double result = number1 / number2;
            System.out.println(number1 + " / " + number2 + ": " + result);
        }catch(ArithmeticException e) {
            System.out.println("No es posible dividir por cero.");
        }*/
    }

    public static void calculateGreater(double number1, double number2) {
        double result = Math.max(number1, number2);
        System.out.println(result + " es el número mayor.");
    }

    public static void calculateSmaller(double number1, double number2) {
        double result = Math.min(number1, number2);
        System.out.println(result + " es el número menor.");
    }

    public static void calculatePow(double number1, double number2) {
        if(number2 == 0) {
            System.out.println("No es posible elevar 0 sobre 0.");
        }else {
            double result = Math.pow(number1, number2);;
            System.out.println(number1 + "^" + number2 + ": " + result);
        }

        // Intenté resolverlo con un try-catch pero no me imprimía el mensaje deseado.
        /*try {
            double result = Math.pow(number1, number2);;
            System.out.println(number1 + "^" + number2 + ": " + result);
        }catch(ArithmeticException e) {
            System.out.println("No es posible dividir por cero.");
        }*/
    }

    public static void calculatePercentage(double number1, double number2) {

        if(number1 == 0) {
            System.out.println("El " + number1 + " % de " + number2 + " es: 0.");
        }else {
            double result = ((number2 / number1) * 100);
            System.out.println("El " + number1 + " % de " + number2 + " es: " + result);
        }

        // Intenté resolverlo con un try-catch pero no me imprimía el mensaje deseado.
        /*try {
            double result = ((number2 / number1) * 100);
            System.out.println("El " + number1 + " % de " + number2 + " es: " + result);
        }catch(ArithmeticException e) {
            System.out.println("El " + number1 + " % de " + number2 + " es: 0.");
        }*/
    }

    //----------------------------------------------------------------------------------------

    public static void resolveQuadraticEquation() {
        System.out.println("Ax^2 + Bx + C\nPor favor ingrese el valor de A.");
        double a = getVariable();
        System.out.println("Por favor ingrese el valor de B.");
        double b = getVariable();
        System.out.println("Por favor ingrese el valor de C.");
        double c = getVariable();

        double discriminant = calculateDiscriminant(a, b, c);

        if(discriminant < 0) {
            System.out.println("La ecuación ingresada no tiene solución en los reales");
        } else {
            discriminant = Math.sqrt(discriminant);

            double x1 = ((-b + discriminant) / (2 * a));
            double x2 = ((-b - discriminant) / (2 * a));
            printQuadraticEquationSolution(a, x1, x2);
        }
    }

    public static double calculateDiscriminant(double a, double b, double c) {
        return (Math.pow(b, 2) - (4 * a * c));
    }

    public static void printQuadraticEquationSolution(double a, double x1, double x2) {
        if(a == 0) {
            System.out.println("La ecuación ingresada no es cuadrática.");
        }else {
            System.out.println("Las soluciones son: " + x1 + " y " + x2);
        }
    }

    //----------------------------------------------------------------------------------------

    public static void resolveGeometricalShapes() {
        int minOption = 1;
        int maxOption = 6;

        printGeometricalShapesMenu();

        int menuOption = getMenuOption(minOption, maxOption);
        geometricalShapesOptions(menuOption);
    }

    public static void printGeometricalShapesMenu() {
        System.out.println("Por favor ingrese su figura.\n" +
                "1.Cuadrado\n" +
                "2.Rectangulo\n" +
                "3.Circulo\n" +
                "4.Esfera\n" +
                "5.Cubo\n" +
                "6.Cono\n");

    }

    public static void geometricalShapesOptions(int menuOption) {
        switch (menuOption) {
            case 1:
                calculateSquare();
                break;
            case 2:
                calculateRectangle();
                break;
            case 3:
                calculateCircle();
                break;
            case 4:
                calculateSphere();
                break;
            case 5:
                calculateCube();
                break;
            case 6:
                calculateCone();
                break;
        }
    }

    public static void calculateSquare() {
        System.out.println("Por favor ingrese el lado del cuadrado.");

        double a = getVariable();
        double perimeter = 4 * a;
        double area = a * a;

        System.out.println("El perímetro es: " + perimeter);
        System.out.println("El área es: " + area);
    }

    public static void calculateRectangle() {
        System.out.println("Por favor ingrese la base del rectangulo.");
        double a = getVariable();
        System.out.println("Por favor ingrese la altura del rectangulo.");
        double b = getVariable();

        double perimeter = (2 * a) + (2 * b);
        double area = a * b;

        System.out.println("El perímetro es: " + perimeter);
        System.out.println("El área es: " + area);
    }

    public static void calculateCircle() {
        System.out.println("Por favor ingrese el radio del circulo.");

        double radius = getVariable();
        double pi = 3.14;
        double perimeter = (2 * pi * radius);
        double area = pi * Math.pow(radius, 2);

        System.out.println("El perímetro es: " + perimeter);
        System.out.println("El área es: " + area);
    }

    public static void calculateSphere() {
        System.out.println("Por favor ingrese el radio de la esfera.");

        double radius = getVariable();
        double pi = 3.14;
        double area = 4 * pi * Math.pow(radius, 2);
        double volume = (4 * pi * Math.pow(radius, 3)) / 3;

        System.out.println("El área es: " + area);
        System.out.println("El volumen es: " + volume);
    }

    public static void calculateCube() {
        System.out.println("Por favor ingrese el lado del cubo.");

        double a = getVariable();
        double area = 6 * Math.pow(a, 2);
        double volume = Math.pow(a, 3);

        System.out.println("El área es: " + area);
        System.out.println("El volumen es: " + volume);
    }

    public static void calculateCone() {
        System.out.println("Por favor ingrese el radio del cono.");
        double radius = getVariable();
        System.out.println("Por favor ingrese la altura del cono.");
        double a = getVariable();

        double pi = 3.14;
        double area = (pi * radius) * (radius + a);
        double volume = (a * pi * Math.pow(radius, 2)) / 3 ;

        System.out.println("El área es: " + area);
        System.out.println("El volumen es: " + volume);
    }

    //----------------------------------------------------------------------------------------

    public static void resolveEquationSystem() {
        printEquationSystem();

        System.out.println("Por favor ingrese A.");
        double a = getVariable();
        System.out.println("Por favor ingrese B.");
        double b = getVariable();
        System.out.println("Por favor ingrese C.");
        double c = getVariable();
        System.out.println("Por favor ingrese D.");
        double d = getVariable();
        System.out.println("Por favor ingrese E.");
        double e = getVariable();
        System.out.println("Por favor ingrese F.");
        double f = getVariable();

        double finalX = (c * e - b * f) / (a * e - b * d);
        double finalY = (a * f - c * d) / (a * e - b * d);

        System.out.println("El valor de x es: " + finalX +
                "\nEl valor de y es = " + finalY);
    }

    public static void printEquationSystem() {
        System.out.println("Ax + By = C\n" +
                "Dx + Ey = F");
    }

    //----------------------------------------------------------------------------------------

    public static void resolveEquationOfStraightLine() {
        System.out.println("Por favor ingrese x1.");
        double x1 = getVariable();
        System.out.println("Por favor ingrese y1.");
        double y1 = getVariable();
        System.out.println("Por favor ingrese x2.");
        double x2 = getVariable();
        System.out.println("Por favor ingrese y2.");
        double y2 = getVariable();

        double gradient = calculateGradient(x1, x2, y1, y2);
        double b = (gradient * -x1) + y1;
        printEquationOfStraightLineSolution(gradient, b, x1);
    }

    public static double calculateGradient(double x1, double x2, double y1, double y2) {
        if(x1 != x2) {
            return ((y2 - y1) / (x2 - x1));
        } else {
            return 0;
        }
        //return ((y2 - y1) / (x2 - x1));
    }

    public static void printEquationOfStraightLineSolution(double gradient, double b, double x1) {
        if(gradient != 0) {
            System.out.println("y = " + gradient + "x + " + b) ;
        } else {
            System.out.println("x = " + x1);
        }

    }
}
