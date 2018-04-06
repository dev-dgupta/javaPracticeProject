package multithreadingExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Divya.Gupta on 15-09-2016.
 */

public class MultiTaskExecutor {

    public static void main(String[] args) {

        BlockingQueue<Runnable> workersQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectedExecutionHandler = new RejectionExecutionHandlerImpl();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, workersQueue, rejectedExecutionHandler);
        threadPoolExecutor.prestartAllCoreThreads();

        List<Runnable> runnables=new ArrayList<Runnable>();
//        runnables.add(new TestOne());
        runnables.add(new TestThree());
//        runnables.add(new TestTwo());

        workersQueue.add(new MultipleRunnableClasses(runnables));

    }
}

class RejectionExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r + ":  I have been rejected!");
    }
}

class MultipleRunnableClasses implements Runnable {

    private final List<Runnable> runnableList;

    public MultipleRunnableClasses(List<Runnable> runnableList) {
        this.runnableList = runnableList;
    }


    @Override
    public void run() {
        for (Runnable runnable : runnableList)
            new Thread(runnable).start();
    }
}

class TestThree implements Runnable {

    @Override
    public void run() {

        System.out.println("Executing task 3" +Thread.currentThread().getName());

    }
}