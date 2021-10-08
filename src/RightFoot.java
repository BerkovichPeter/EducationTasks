public class RightFoot extends Thread {
    Object footMonitor;

    public RightFoot(Object footMonitor) {
        this.footMonitor = footMonitor;
    }

    @Override
    public void run() {

        while (true) {
            try {
                synchronized (footMonitor) {
                    footMonitor.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RIGHT");
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            synchronized (footMonitor) {
                footMonitor.notify();
            }
        }
    }
}