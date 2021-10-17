import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestApp3 {
    public static void main(String[] args) {
        Iterator numberIterator =  process(Arrays.asList(22,22,24,25,25,66,67,123,124,125,8000, 8000, 80000, 90000).iterator(),90000);
        numberIterator.forEachRemaining(System.out::println);
    }

    /**
     * Возвращает итератор, который позволяет обойти только часть source,
     * ограниченную number, оставляя только элементы, значение которых меньше number
     *
     * @param source неубывающая бесконечная последовательность чисел.
     *               бесконечная - значит нельзя пытаться обработать source,
     *               например, использовать копирование итератора, удаление элементов и т.д.
     * @param number значение для отделения хвоста итератора
     *               <p>
     *               Пример:
     *               на вход подаётся бесконечная последовательность типа
     *               [22,22,24,25,25,66,67 ... 8000, 8000, 80000, 90000 ...]
     *               доступная для обхода часть source
     *               при number = 90000:
     *               [22,22,24,25,25,66,67 ... 8000, 8000, 80000]
     *               при number = 23:
     *               [22,22]
     * @return
     */
    public static Iterator process(Iterator source, Number number) {
        Iterator iter;
        try {
            iter = processDouble(source,(Double) number);
        }
        catch (Exception e){
            iter = processInteger(source,(Integer) number);
        }
        return iter;
    }

    public static Iterator processDouble(Iterator<Double> source, Double number) {
        List<Double> numbers = new ArrayList<>();
        Double aNumber;
        while (source.hasNext()) {
            aNumber = source.next();
                if (aNumber < number) {
                    numbers.add(aNumber);
                } else {
                    break;
                }
            }
        return numbers.iterator();
    }

    public static Iterator processInteger(Iterator<Integer> source, Integer number) {
        List<Integer> numbers = new ArrayList<>();
        Integer aNumber;
        while (source.hasNext()) {
            aNumber = source.next();
            if (aNumber < number) {
                numbers.add(aNumber);
            } else {
                break;
            }
        }
        return numbers.iterator();
    }
}

