public class LeftFoot extends Thread {
    Object footMonitor;

    public LeftFoot(Object footMonitor) {
        this.footMonitor = footMonitor;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("LEFT");
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            synchronized (footMonitor) {
                footMonitor.notify();
            }
            try {
                synchronized (footMonitor) {
                    footMonitor.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
