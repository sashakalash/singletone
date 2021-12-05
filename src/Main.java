import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Logger logger;
    private static Scanner scanner;
    private static Filter filter;

    public static void main(String[] args) {
        logger = Logger.getInstance();
        scanner = new Scanner(System.in);

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int listSize;
        int topLimit;
        try {
            listSize = scanner.nextInt();
        } catch (IllegalArgumentException exception) {
            logger.log("Пользователь ввел неверный размер списка");
            throw new IllegalArgumentException();
        }
        System.out.print("Введите верхнюю границу для значений: ");
        try {
            topLimit = scanner.nextInt();
        } catch (IllegalArgumentException exception) {
            logger.log("Пользователь ввел неверную верхнюю границу для значений");
            throw new IllegalArgumentException();
        }
        logger.log("Создаём и наполняем список");

        ArrayList randomList = createList(listSize, topLimit);
        System.out.println("Вот случайный список: " + transformListToString(randomList));

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int treshold;
        try {
            treshold = scanner.nextInt();
        } catch (IllegalArgumentException exception) {
            logger.log("Пользователь ввел неверный порог для фильтра");
            throw new IllegalArgumentException();
        }

        logger.log("Запускаем фильтрацию");
        filter = new Filter(treshold);
        List<Integer> filteredList = filter.filterOut(randomList);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + transformListToString(filteredList));
        logger.log("Завершаем программу");
    }

    public static ArrayList createList(int listSize, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= listSize; i++) {
            list.add(random.nextInt(maxValue));
        }
        return list;
    }

    private static String transformListToString(List<Integer> list) {
        return list.stream().map(i->Integer.toString(i))
                .collect(Collectors.joining(", "));
    }
}