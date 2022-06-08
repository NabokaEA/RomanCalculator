import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//Блок инициализации переменных result=a+-*/b
        byte a = 0; //первый операнд
        byte b = 0; //второй операнд
        byte result = 0; //результат
        String inputString; // строка ввода пользовательского выражения
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение типа a+(-*/)b=с арабскими, либо с римскими числами до 10:");
        inputString =scanner.next();
        System.out.printf("Введена строка: %s ", inputString);
    }

}
