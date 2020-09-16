package multithreadingExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorS {

    public static void main(String[] args) {

        ThreadPoolExecutor newExec=
                new ThreadPoolExecutor(5,10,3, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(50));
    }
}
