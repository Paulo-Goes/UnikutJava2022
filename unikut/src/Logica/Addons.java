package Logica;

public class Addons {

        public static void delay(int timeMS){
            try {
                Thread.sleep(timeMS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
