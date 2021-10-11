import java.util.concurrent.atomic.AtomicBoolean;

public  class Robot {
    private boolean isRight;
    private AtomicBoolean isRunning = new AtomicBoolean(false);
    private int duration = 15000;
    Object footMonitor = new Object();

    public Robot() {
        Foot RightFoot = new Foot("LEFT");
        Foot LeftFoot = new Foot("RIGHT");
        RightFoot.start();
        LeftFoot.start();
        isRunning.set(true);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        isRunning.set(false);
    }

    private class Foot extends Thread {
        String side;

        public Foot(String side) {
            this.side = side;
        }

        @Override
        public void run() {
            isRunning.set(true);

            while (isRunning.get()) {
                synchronized (footMonitor) {
                    try {
                        while (isRight && side.equals("LEFT") || !isRight && side.equals("RIGHT")) {
                            footMonitor.wait();
                        }
                    System.out.println(side);
                    try {
                        sleep(3000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    isRight = !isRight;
                    footMonitor.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        isRunning.set(false);
                    }
                }
            }
        }


    }
    public static void main(String[] args){
        new Robot();
    }
}



