import java.util.Scanner;

import static java.lang.Byte.parseByte;

public class Main {
    static String result; //результат
    static String inputString; // строка ввода пользовательского выражения
    //Блок инициализации переменных result=a+-*/b
    byte a = 0; //первый операнд
    byte b = 0; //второй операнд

    public static void main(String[] args) {

        // Читаем с консоли введееные данные
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение типа a+(-*/)b=с арабскими, либо с римскими числами до 10:");
        inputString = scanner.next();
        System.out.printf("Введена строка: %s ", inputString);
        calc(inputString);
    }

    //Метод принимает строку с арифметическим выражением между двумя числами и возвращет строку с результатом их выполнения.
    public static String calc(String input) {
        //Получим массив строковых операторов:
        String[] opArrayStrings = inputStringToArray(input);
        byte[] opArrayBytes = new byte[2];
        //Проверка количества операций на неравенство 2:
        if (opArrayStrings.length != 2) {
            throw new RuntimeException("Математическая операция не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        //Проверим операнды на принадлежность к римской или арабской системе:
        if (isRoman(opArrayStrings[0]) & isRoman(opArrayStrings[1])) {
            System.out.println("Римские");
            //Римские переобразуем в массив байт для вычислений с помощью метода
            for (int i = 0; i < 2; i++) {
                opArrayBytes[i] = romanStringToArabByts(opArrayStrings[i]);
                System.out.println(opArrayBytes[i]);
            }
        } else if (!isRoman(opArrayStrings[0]) & !isRoman(opArrayStrings[1])) {
            System.out.println("Арабские");
            //Арабские переобразуем в массив байт для вычислений парсингом
            for (int i = 0; i < 2; i++) {
                opArrayBytes[i] = arabStringToArabByts(opArrayStrings[i]);
                System.out.println(opArrayBytes[i]);
            }
        } else {
            throw new RuntimeException("используются одновременно разные системы счисления");
        }


        return "ОК";
    }

    // Метод преобразует строку в строковый массив, состоящий из операторов
    private static String[] inputStringToArray(String input2) {
        if (inputString.contains("+")) {
            String[] inputAsArray = inputString.split("[+]");
            Operation operation = Operation.ADD;
            return inputAsArray;
        } else if (inputString.contains("-")) {
            String[] inputAsArray = inputString.split("[-]");
            Operation operation = Operation.SUB;
            return inputAsArray;
        } else if (inputString.contains("/")) {
            String[] inputAsArray = inputString.split("[/]");
            Operation operation = Operation.DIV;
            return inputAsArray;
        } else if (inputString.contains("*")) {
            String[] inputAsArray = inputString.split("[*]");
            Operation operation = Operation.MUL;
            return inputAsArray;
        } else {
            throw new RuntimeException("Строка не является математической операцией");
        }
    }

    // Метод определения системы, к которой относится сначение операнда
    private static boolean isRoman(String operator) {
        for (RomanDigits digit : RomanDigits.values()) {
            if (digit.name().equals(operator)) {
                return true;
            }
        }
        return false;
    }

    private static byte romanStringToArabByts(String romanDigit) {
        for (RomanDigits digit : RomanDigits.values()) {
            if (digit.name().equals(romanDigit)) {
                return (byte) digit.ordinal();
            }
        }
        return 127;
    }

    private static byte arabStringToArabByts(String arabDigit) {
        return parseByte(arabDigit);
    }
}
