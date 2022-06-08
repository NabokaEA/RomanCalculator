import java.util.Scanner;

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
    }

    //Метод принимает строку с арифметическим выражением между двумя числами и возвращет строку с результатом их выполнения.
    public static String calc(String input) {


        return result;
    }
}
