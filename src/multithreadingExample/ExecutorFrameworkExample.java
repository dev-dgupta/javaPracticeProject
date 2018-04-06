package multithreadingExample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Divya.Gupta on 15-09-2016.
 */
public class ExecutorFrameworkExample {

    private static ExecutorService executorService = null;
    private static volatile Future taskOne = null;
    private static volatile Future taskTwo = null;


    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(2);
        while (true) {
            checkTasks();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkTasks() {
        if (taskOne == null || taskOne.isDone() || taskOne.isCancelled())
            taskOne = executorService.submit(new TestTwo().callMethod1());

        if (taskTwo == null || taskTwo.isCancelled() || taskTwo.isDone())
            taskTwo = executorService.submit(new TestTwo().callMethod2());

    }


}


class TestOne implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("*********Executing task 2" + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }
}


class TestTwo implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Executing task 1*******" + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public TestTwo callMethod1() {
        System.out.println(Thread.currentThread().getName());
        return this;
    }

    public TestTwo callMethod2() {
        System.out.println(Thread.currentThread().getName());
        return this;
    }

}