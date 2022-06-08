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
        calc(inputString);
    }

    //Метод принимает строку с арифметическим выражением между двумя числами и возвращет строку с результатом их выполнения.
    public static String calc(String input) {
        String[] opArray=inputStringToArray(input);
        if (opArray.length!=2){
            throw new RuntimeException("Математическая операция не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
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
        } else{
            throw new RuntimeException("Строка не является математической операцией");
        }

    }
}
