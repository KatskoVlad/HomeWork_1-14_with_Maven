package homeWork.HomeWork13;
/*      Тема колл центр:
        В колл центре имеется заданное число операторов и определенная
        вместимость по клиентам, необходимо организовать эмуляцию работы колцентра,
        т.е. разговор оператора с клиентом. Те клиенты, для которых оператора не нашлось
        должны быть помещены в очередь для ожидания. А для кого нашлась должны провести
        разговор с оператором. Каждое действие должно быть записано и выведено на консоль.
        Колл центр должен обслужить всех клиентов и завершить свою работу. */
import java.util.ArrayList;
import java.util.List;

public class RunCallCenter {
    private final static int COUNT_OPERATORS = 4;
    private final static int COUNT_CLIENTS = 12;

    private RunCallCenter() {
    }
    //Debug:
    // F9 переход по breakam
    // F8 переход на следущую строку не зависимо от breakA
    // F7 debug с заходом в метод
    // alt+F8 -> Evaluate
    // Analyze Stack Trace

    public static void main(String[] args) {

        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < COUNT_OPERATORS; i++) {
            operators.add(new Operator(i));
        }
        CallCenter callCenter = new CallCenter(operators);
        for (int i = 1; i < COUNT_CLIENTS; i++) {
            Thread thread = new Thread(new Client(callCenter, i));
            thread.start();
        }
    }

}

