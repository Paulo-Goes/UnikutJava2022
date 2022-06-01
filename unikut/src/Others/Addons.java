package Others;


public class Addons {

    // Insere delay entre os processos
    public static void delay(int op) {
        int timeMS = 0;

        if (op == 1) { // Delay 1: 350MS
            timeMS = 350;
        } else if (op == 2) { // Delay 2: 500MS
            timeMS = 500;
        } else if (op == 3) { // Delay 3: 1500MS
            timeMS = 1500;
        }
        try {
            Thread.sleep(timeMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
