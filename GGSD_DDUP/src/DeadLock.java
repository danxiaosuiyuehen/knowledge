/*死锁*/

public class DeadLock {
    public static void main( String[] args) {
        
    Object o1 =new Object();
    Object o2 =new Object();
    Thread mythread1=new Mythread1(o1,o2);
    Thread mythread2=new Mythread2(o1,o2);
    mythread1.start();
    mythread2.start();
    }
}
class Mythread1 extends Thread{
      Object object1;
      Object object2;
    public  Mythread1(Object object1,Object object2){
        this.object1=object1;
        this.object2=object2;
    }
    public void run() {
        synchronized (object1){
            try {
                currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){
                System.out.println(object2+"2执行了22");
            }
        }
    }
}
class Mythread2 extends Thread{
      Object object1;
      Object object2;
    public  Mythread2(Object object1,Object object2){
        this.object1=object1;
        this.object2=object2;
    }
    public void run() {
        synchronized (object2){
            try {
                currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1){
                System.out.println(object1+"1执行了11");

            }
        }
    }
}