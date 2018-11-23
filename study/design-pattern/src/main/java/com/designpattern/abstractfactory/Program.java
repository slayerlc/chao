package com.designpattern.abstractfactory;


import com.designpattern.abstractfactory.concrete.IUser;
import com.designpattern.abstractfactory.entity.User;
import com.designpattern.abstractfactory.factory.AccessFactory;
import com.designpattern.abstractfactory.factory.IFactory;
import com.designpattern.abstractfactory.factory.SqlserverFactory;

public class Program {
	
	/*public static void main(String[] args) {
		IFactory factory = new AccessFactory();
		
		IUser iUser = factory.createUser();
		
		iUser.insertUser(new User());
		iUser.getUser(1L);
		
		
		factory = new SqlserverFactory();
		
		iUser = factory.createUser();
		
		iUser.insertUser(new User());
		iUser.getUser(1L);
	}*/

    public static void main(String[] args) throws InterruptedException {
        Object A = new Object();
        Object B = new Object();

        Thread t1 = new Thread(new SyncThread(A, B), "t1");
        Thread t2 = new Thread(new SyncThread(B, A), "t2");
        //Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

        t1.start();
        //Thread.sleep(5000);
        t2.start();
        //Thread.sleep(5000);
        //t3.start();

    }

}

class SyncThread implements Runnable{
    private Object A;
    private Object B;
    private static int i = 1;

    public SyncThread(Object o1, Object o2){
        this.A=o1;
        this.B=o2;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " A 1");
        synchronized (A) {
            System.out.println(name + " A 2");
            work();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " B 1");
            synchronized (B) {
                System.out.println(name + " B 2");
                work();
            }
            System.out.println(name + " B 完成");
        }
        System.out.println(name + " A 完成");
    }
    private void work() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
