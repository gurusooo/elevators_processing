import  java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("HSE office decided to build a new campus with 20 floors and two elevators. This is how elevators' calls are processed. Completed by M. Shkuleva");
        Elev_work system = new Elev_work(2);
        Thread reqThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    int reqFloor = random.nextInt(20) + 1;
                    system.reqElevator(reqFloor);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread movThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    system.step();
                    system.printCondition();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        reqThread.start();
        movThread.start();
    }
}
