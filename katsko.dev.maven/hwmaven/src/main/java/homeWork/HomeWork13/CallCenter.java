package homeWork.HomeWork13;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {
    private final static int NUM_TRYING = 3;
    List<Operator> operators = new ArrayList<>();

    public CallCenter(List<Operator> operators) {
        this.operators.addAll(operators);
    }

    public CallCenter() {
    }

    public synchronized Operator tryCallClient(Client client, int waitingTime) {
        int numTrying = 0;
        boolean success = false;
        while (!success) {
            for (Operator operator : operators) {
                if (searchFreeOperator(operator, client)) {
                    return operator;
                }
            }
            if (!success) {
                try {
                    numTrying++;
                    if (checkCountTrying(numTrying, waitingTime, client)) {
                        return null;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public synchronized void endCallClient(Operator operator) {
        operator.setClient(null);
        operators.add(operator);
        notify();
    }

    private synchronized boolean checkCountTrying(int numTrying,
                                                  int waitingTime, Client client) throws InterruptedException {
        if (numTrying == NUM_TRYING) {
            System.out.println("Сall Center ended the call");
            wait(waitingTime);
            return true;
        } else {
            System.out.println("Сall Center wait operator");
            wait(waitingTime);
        }
        return false;
    }

    private boolean searchFreeOperator(Operator operator, Client client) {
        if (operator.getClient() == null) {
            operator.setClient(client);
            operators.remove(operator);
            return true;
        }
        return false;
    }

}

