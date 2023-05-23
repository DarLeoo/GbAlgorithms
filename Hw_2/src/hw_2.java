import java.util.Arrays;

public class hw_2 {

    public static void main(String[] args) {
        int array[] = new int[100];
        for(int i = 0; i < 100; i++)
            array[i] = (int)(Math.random() * 100);
        System.out.println(Arrays.toString(array));
        System.out.println("\nПосле сортировки\n");
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortArray(int[] array) {
        // Построение кучи (перегруппировка массива)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    // Функция для перегруппировки поддерева с корнем i, который является
    // индексом в array[]. heapSize - размер кучи
    static void heapify(int[] array, int heapSize, int i) {
        int upperPos = i; // Инициализируем наибольший элемент как корень
        int leftPos = 2 * i + 1; // левый = 2*i + 1
        int rightPos = 2 * i + 2; // правый = 2*i + 2

        // Левый дочерний элемент больше корня
        if (leftPos < heapSize && array[leftPos] > array[upperPos])
            upperPos = leftPos;

        // Правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightPos < heapSize && array[rightPos] > array[upperPos])
            upperPos = rightPos;

        // Самый большой элемент не корень
        if (upperPos != i) {
            int temp = array[i];
            array[i] = array[upperPos];
            array[upperPos] = temp ;

            // Рекурсивно перегруппировываем поддерево
            heapify(array, heapSize, upperPos);
        }
    }
}
