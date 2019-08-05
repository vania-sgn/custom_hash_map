// Подключение библиотек
import java.util.Objects;

/**
 * Класс, что реализует узел (ноду) в хеш-таблице
 * Узел представляет собой одну пару ключ-значение, что хранится в хеш-таблице
 */
public class Entry<K, V> { 

    // Ключ узла в хеш-таблице.
    private final K key;

    // Значение узла в хеш-таблице.
    private V value;

    // Ссылка на следующий узел в хеш-таблице.
    private Entry<K, V> next;

    // Конструктор.
    // Принимает на вход ключ, значение и ссылку на следующий узел в хеш-таблице.
    // Устанавливает эти значения в соответствующие переменные.
    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    // Метод, который позволяет получить ключ узла.
    public K getKey() {
        return this.key;
    }

    // Метод, который позволяет получить значение узла.
    public V getValue() {
        return this.value;
    }

    // Метод, который позволяет получить ссылку на следующий узел после данного узла.
    public Entry<K, V> getNext() {
        return this.next;
    }

    // Метод, который позволяет установить ссылку на следующий узел после данного узла.
    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    // Переопределенный метод, который представляет обьект данного класса в виде строки, понятной для человека.
    @Override
    public String toString() {

        return key + " = " + value;
    }

    // Переопрееленный метод, который возвращает хеш-код обьекта в числовом виде.
    @Override
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    // Переопределенный метод, который проверяет, равны ли обьекты данного класса.
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
