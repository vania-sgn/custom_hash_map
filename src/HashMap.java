/**
 * Класс, что реализует хеш-таблицу
 * Хеш-таблица представляет собой масив узлов (нод, элементов), которые хранят в себе пары ключ-значение
 */
public class HashMap<K, V> { 

    // Размер по-умолчанию под хеш-таблицу в оперативной памяти (должен быть кратным 2).
    private static final int INITIAL_CAPACITY = 16;

    // Массив узлов (нод), который реализует хеш-таблицу.
    private Entry<K, V>[] entries;

    // Размер хеш-таблицы.
    private int size = 0;

    // Конструктор по-умолчанию.
    // Инициализирует размер в опреативной памяти под хеш-таблицу значением по-умолчанию.
    @SuppressWarnings("unchecked")
    public HashMap() {
        this.entries = new Entry[INITIAL_CAPACITY];
    }

    // Конструктор с параметрами.
    // Инициализирует размер в оперативной памяти значением, которое передал пользователь.
    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        this.entries = new Entry[capacity];
    }

    // Метод, который реализует вставку узла (ноды) в хеш-таблицу.
    public void put(K key, V value) {
        if (key == null) { // Если ключ равен null - генерируется исключение (ошибка времени выпонения).
            throw new RuntimeException("null key is not allowed!");
        }
        int hashValue = getHash(key); // Генерация хеш-значение элемента по ключу.
        Entry<K, V> entry = new Entry<>(key, value, null); // Создание узла хеш-тадлицы.
        if (entries[hashValue] == null) { // Если элемента с таким хеш-значением нет в таблице - вставляем его в нее.
            entries[hashValue] = entry; // Вставка значения в хеш-таблицу.
            size++; // Увеличиваем размер хеш-таблицы.
        } else { // Иначе.
            Entry<K, V> previous = null;
            Entry<K, V> current = entries[hashValue]; // Текущему элементу присваиваем ссылку на элемент, который был найден в таблице.
            while (current != null) { // Пока ссылка текущий элемент не равна null.
                if (current.getKey().equals(key)) { // Если ключ текущего элемента равен ключу.
                    if (previous == null) { // Если предыдущий элемент равен null.
                        entry.setNext(current.getNext()); // Устанавливаем ссылку на следующий элемент хеш-тыблицы в текущий элемент.
                        entries[hashValue] = entry; // Записываем новый элемент в хеш-тыблицу.
                    } else { // Иначе.
                        entry.setNext(current.getNext()); // Устанавливаем ссылку на следующий элемент хеш-тыблицы в текущий элемент.
                        previous.setNext(entry); // Предыдущему элементу устанавливаем ссылку на новый элемент.
                    }
                }
                previous = current; // Передвигаем указатель в предыдущий элемент с текущего.
                current = current.getNext(); // Передвигаем указатель с текущего элемента на следующий.
            }
            if (previous != null) { // Если предыдущий элемет равен null.
                previous.setNext(entry); // Предыдущему элементу устанавливаем ссылку на созданный элемент.
            }
            size++; // Увеличиваем размер хеш-таблицы.
        }
    }

    // Метод, который реализует получение значения из хеш-таблицы по ключу.
    public V get(K key) {
        if (key == null) { // Если ключ равен null.
            return null; // Возвращаем null.
        }
        int hashValue = getHash(key); // Генерация хеш-значение элемента по ключу.
        if (entries[hashValue] == null) { // Если элемента с таким хеш-значением нет в таблице - вставляем его в нее.
            return null; // Возвращаем null.
        } else { // Иначе.
            Entry<K, V> temp = entries[hashValue]; // Записуем найденный узел в переменную.
            while (temp != null) { // Пока найденный узел не равен null.
                if (temp.getKey().equals(key)) { // Если значения ключей элементов равны.
                    return temp.getValue(); // Возвращаем значение узла (ноды).
                }
                temp = temp.getNext(); // Передвигаемся по ссылкам вперед списка.
            }
        }
        return null; // Во всех остальных случаях возвращаем null.
    }

    // Метод, который реализует получение размера хеш-таблицы.
    public int size() {
        int count = 0; // Устанавливаем размер хеш-таблицы в 0.
        for (Entry<K, V> kvEntry : entries) { // Цыкл по хеш-таблице.
            if (kvEntry != null) { // Если узел в таблице не равен null.
                int nodesCount = 0; // Устанавливаем переменную, которая отвечает за количество узлов (нод) по одному хеш-значению, в 0.
                for (Entry<K, V> entry = kvEntry; entry.getNext() != null; entry = entry.getNext()) { // Цыкл по узлам по одному хеш-значению в хеш-таблице.
                    nodesCount++; // Увеличиваем количество узлов (нод), найденных в связном списке по одному хеш-значению.
                }
                count += nodesCount; // Добавляем к размеру количество узлов (нод), найденных по одному хеш-значению.
                count++; // Увеличиваем размер хеш-таблицы на 1.
            }
        }
        return count; //Возвращаем размер.
    }

    // Метод, который реализует проверку на пустоту хеш-таблицы.
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод, который реализует получение хеш-кода по ключу.
    public int getHash(K key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

}
