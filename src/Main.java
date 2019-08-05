/**
 * Класс, что реализует тестирование кода для работы с хеш-таблицами с помощью метода main
 */
public class Main {

    // Главный метод (стартовая точка программы), который тестирует код для работы с хеш-таблицами.
    public static void main(String[] args) { 

        // Обьявление и инициализация хеш-таблицы.
        HashMap<Integer, Long> hashMap = new HashMap<>(10);

        // Вывод размера хеш-таблицы после ее создания.
        System.out.println("Size: " + hashMap.size() + "\n");

        // Добавеление узлов (нод, элементов) в хеш-таблицу.
        System.out.println("Start adding items!");
        hashMap.put(1, 199L);
        hashMap.put(2, Long.MAX_VALUE);
        hashMap.put(3, -199L);
        hashMap.put(4, 0L);
        hashMap.put(5, Long.MIN_VALUE);
        System.out.println("All items added!");

        // Проверка хеш-таблицы на пустоту.
        System.out.println("Is empty: " + hashMap.isEmpty());
        // Вывод размера хеш-таблицы после добавления в нее элементов.
        System.out.println("Size: " + hashMap.size() + "\n");

        // Вывод значений из хеш-таблицы, которые достаются из нее по ключу.
        System.out.println("Get value by key 1: " + hashMap.get(1));
        System.out.println("Get value by key 2: " + hashMap.get(2));
        System.out.println("Get value by key 3: " + hashMap.get(3));
        System.out.println("Get value by key 4: " + hashMap.get(4));
        System.out.println("Get value by key 5: " + hashMap.get(5));
    }

}
