public  class Robot{
    Object footMonitor = new Object();
    RightFoot RightFoot = new RightFoot(footMonitor);
    LeftFoot LeftFoot = new LeftFoot(footMonitor);

    public Robot(){
        RightFoot.start();
        LeftFoot.start();
    }

    public static void main(String[] args) {
        new Robot();
    }
}



