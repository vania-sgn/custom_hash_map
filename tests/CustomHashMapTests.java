// Подключение библиотек для тестирования.
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
 
/**
 * Класс, который реализует тестирование кода для работы с хеш-таблицами
 * с помощью фреймворка для тестирования кода junit версии 5
 */
@DisplayName("Custom hash map tests")
public class CustomHashMapTests {

    // Переменная хеш-таблицы, которая используется в тестах.
    private HashMap<Integer, Long> hashMap;

    // Метод, который выполняется перед каждым тестом.
    // В нем инициализируется переменная хеш-таблицы (под нее выделяется место в оперативной памяти компьютера).
    @BeforeEach
    public void init() {
        hashMap = new HashMap<>(10);
    }

    // Метод, который тестирует код, что отвечает за вставку узла (ноды) в хеш-таблицу
    // и получение значения узла (ноды) из хеш-таблицы по ключу.
    @Test
    @DisplayName("Put and get element test")
    public void getElementTest() {
        // Вставка 3 элементов в хеш-таблицу.
        hashMap.put(1, Long.MAX_VALUE);
        hashMap.put(2, Long.MIN_VALUE);
        hashMap.put(3, 0L);
        // Проверка, правильно ли были записаны значения в хеш-таблицу.
        // Проверка осуществляется способом получения значения по его ключу.
        assertEquals(Long.MAX_VALUE, hashMap.get(1));
        assertEquals(Long.MIN_VALUE, hashMap.get(2));
        assertEquals(0L, hashMap.get(3));
    }

    // Метод, который тестирует код, что возвращает размер хеш-тыблицы.
    @Test
    @DisplayName("Hash map size test")
    public void getSizeTest() {
        // Вставка 1 элемента в хеш-таблицу.
        hashMap.put(1, Long.MAX_VALUE);
        // Проверка, равен ли размер хеш-таблицы 1 после вставки 1 элемента (0 + 1 = 1).
        assertEquals(1, hashMap.size());
        // Вставка 2 элементов в хеш-таблицу.
        hashMap.put(2, 199L);
        hashMap.put(3, Long.MIN_VALUE);
        // Проверка, равен ли размер хеш-таблицы 3 после вставки еще 2 элемента (2 + 1 = 3).
        assertEquals(3, hashMap.size());
    }

    // Метод, который тестирует код, что проверяет хеш-таблицу на пустоту.
    @Test
    @DisplayName("Is hash map empty true test")
    public void isEmptyTrueTest() {
        // Проверка на пустоту (таблица должна сбыть пустой, тест завершиться успешно).
        assertTrue(hashMap.isEmpty());
    }

    // Метод, который тестирует код, что проверяет хеш-таблицу на пустоту.
    @Test
    @DisplayName("Is hash map empty false test")
    public void isEmptyFalseTest() {
        // Вставка элемента в хеш-таблицу
        hashMap.put(1, Long.MAX_VALUE);
        // Проверка на пустоту (таблица должна состоять из одного элемента,
        // значит она не пустая и тест завершиться успешно).
        assertFalse(hashMap.isEmpty());
    }

    // Метод, который выполняется после каждого теста.
    // В нем освобождается место в оперативной памяти, где хранилась хеш-таблица.

    @AfterEach
    public void destroy() {
        hashMap = null;
    }
}
