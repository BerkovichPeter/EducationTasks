public class Robot {
    public static void main(String args[]) {
        int maxSteps = 300;
        Thread threadLeft = new Thread() {
            public synchronized void run() {
                for (int i = 0; i < maxSteps; i++) {
                    System.out.println("Left");
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    notify();
                }
            }
        };
        Thread threadRight = new Thread() {
            public synchronized void  run() {
                for (int i = 0; i < maxSteps; i++) {
                    try {
                        wait();
                        sleep(3000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Right");
                    notify();
                }
            }
        };
        threadLeft.start();
        threadRight.start();
    }
}
