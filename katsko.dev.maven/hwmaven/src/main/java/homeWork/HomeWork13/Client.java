package homeWork.HomeWork13;

public class Client implements Runnable {

    private final static int TIME_WAITING = 100;
    private int id;
    private CallCenter callCenter = new CallCenter();

    public int getId() {
        return id;
    }

    public Client(CallCenter callCenter, int id) {
        this.callCenter = callCenter;
        this.id = id;
    }

    public void run() {
        Operator operator = null;
        try {
            while (operator == null) {
                System.out.println("Call center is calling client");
                operator = callCenter.tryCallClient(this, TIME_WAITING);
            }
            System.out.println("Call center talking to a customer");
            operator.talk();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (operator != null) {
                System.out.println("Client has finished talking");
                callCenter.endCallClient(operator);
            }
        }
    }
}

