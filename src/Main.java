import java.util.Scanner;

import static java.lang.Byte.parseByte;

public class Main {
    static String stringResult; //строковый результат
    static byte byteResult; //числовой результат
    static String inputString; // строка ввода пользовательского выражения

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // Читаем с консоли введееные данные
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите арифметическое выражение типа a+(-*/)b=с арабскими, либо с римскими числами до 10:");
            inputString = scanner.next();
            System.out.printf("Введена строка: %s ", inputString);
            calc(inputString);
        }
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
                opArrayBytes[i] = romanStringToArabBytes(opArrayStrings[i]);
            }
            byteResult=bytesCalculations(opArrayBytes);
            //Проверка результа на отрицательное значение для римских цифр
            if (byteResult<1){
                throw new RuntimeException("Римские числа не могут быть меньше 1");}
            stringResult=romanBytesToArabString(byteResult);
            System.out.println(stringResult);
        } else if (!isRoman(opArrayStrings[0]) & !isRoman(opArrayStrings[1])) {
            System.out.println("Арабские");
            //Арабские переобразуем в массив байт для вычислений парсингом
            for (int i = 0; i < 2; i++) {
                opArrayBytes[i] = arabStringToArabBytes(opArrayStrings[i]);
            }
            byteResult= bytesCalculations(opArrayBytes);
            System.out.println(byteResult);
        } else {
            throw new RuntimeException("используются одновременно разные системы счисления");
        }
// Вычисления


        return stringResult;
    }

    private static byte bytesCalculations(byte[] opArrayBytes) {
        if (inputString.contains("+")) {
            byteResult=(byte)(opArrayBytes[0]+ opArrayBytes[1]);
        } else if (inputString.contains("-")) {
            byteResult=(byte)(opArrayBytes[0]- opArrayBytes[1]);
        } else if (inputString.contains("/")) {
            byteResult=(byte)(opArrayBytes[0]/ opArrayBytes[1]);
        } else if (inputString.contains("*")) {
            byteResult = (byte) (opArrayBytes[0] * opArrayBytes[1]);
        }
        return byteResult;
    }

    // Метод преобразует строку в строковый массив, состоящий из операторов
    private static String[] inputStringToArray(String input2) {
        if (inputString.contains("+")) {
            return inputString.split("[+]");
        } else if (inputString.contains("-")) {
            return inputString.split("[-]");
        } else if (inputString.contains("/")) {
            return inputString.split("[/]");
        } else if (inputString.contains("*")) {
            return inputString.split("[*]");
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

    private static byte romanStringToArabBytes(String romanDigit) {
        for (RomanDigits digit : RomanDigits.values()) {
            if (digit.name().equals(romanDigit)) {
                int tmp = digit.ordinal()+1;
                if (tmp > 10) {
                    throw new RuntimeException("Значение больше 10");
                }
                return (byte) tmp;
            }
        }
        return 127;
    }

    private static byte arabStringToArabBytes(String arabDigit) {
        int tmp = parseByte(arabDigit);
        if (tmp > 10) {
            throw new RuntimeException("Значение больше 10");
        }
        return (byte) tmp;
    }
    private static String romanBytesToArabString(byte romanDigit) {
                return String.valueOf(RomanDigits.values()[romanDigit-1]);
            }
}
