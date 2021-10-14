import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor  implements Runnable{

    private String Leg;
    public Executor(String Leg){
        this.Leg = Leg;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + Leg + " ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

 class ScheduledThreadPoolMain {

    public static void main(String[] args) throws InterruptedException {
        int maxTime = 15000;
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        Executor LeftFoot = new Executor("LEFT");
        Executor RightFoot = new Executor("RIGHT");
        scheduledThreadPool.scheduleWithFixedDelay(LeftFoot, 0, 3,TimeUnit.SECONDS);
        scheduledThreadPool.scheduleWithFixedDelay(RightFoot, 3, 3,TimeUnit.SECONDS);

        Thread.sleep(maxTime);
        scheduledThreadPool.shutdown();
    }

    {
    }
}
