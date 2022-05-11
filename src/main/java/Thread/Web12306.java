package Thread;

/**
 * Created：Jeffrey
 * date   ：2020/1/3 14:56
 */
public class Web12306 implements Runnable {
    int ticketNumber = 50;

    public void run() {
        while (true) {
            if (ticketNumber <= 0) {
                break;
            }
            System.out.println("线程" + Thread.currentThread().getName() + "抢到票了！！" + ticketNumber--);
//            sum--;
        }
    }

    //测试3个APP抢票过程
    public static void main(String[] args) {
        //创建真实角色12306系统，票数是50张
        Web12306 web12306 = new Web12306();
        //三个代理角色代理同一个真实角色！！
        Thread xieChen = new Thread(web12306, "携程");  //Thread构造方法，  name-->线程名称，target-->
        Thread tuNiu = new Thread(web12306, "途牛");
        Thread daoNaQu = new Thread(web12306, "到哪去");

        xieChen.start();
        tuNiu.start();
        daoNaQu.start();

    }
}
