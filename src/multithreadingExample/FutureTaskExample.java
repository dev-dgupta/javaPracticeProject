package multithreadingExample;

import java.util.concurrent.*;

/**
 * Created by Divya.Gupta on 16-09-2016.
 */
public class FutureTaskExample {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        CalculateFactorial task = new CalculateFactorial(5);
        System.out.println("Task submitted ");

        Future future = executorService.submit(task);

        try {

            if (!future.isDone()) {
                System.out.println("Task not completed yet!");
                Thread.sleep(1);
            }

            int fact = (Integer) future.get();
            System.out.println("Factorial is: " + fact);

            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}


class CalculateFactorial implements Callable {

    private int number;

    public CalculateFactorial(int number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        return calculateFactorialOfNumber(number);
    }

    private int calculateFactorialOfNumber(int number) {
        int fact = 1;
        if (number <= 0)
            fact = 0;
        if (number == 1)
            fact = 1;
        while (number > 1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fact = fact * number;
            number--;
        }

        return fact;
    }

}
