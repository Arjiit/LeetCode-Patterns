import java.util.concurrent.*;
class Foo {
        Semaphore run2, run3;
    public Foo() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release(); // means you release one marble in the run2 box
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        run2.acquire(); // run2 acquires that one marble and runs.
        /* A thread can take marble and release any number of it at any time.
        Here, it takes marble from run2 and also releases one into run3 */
        printSecond.run();
        run3.release(); // you release one marble in run3 box.
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        run3.acquire(); // you acquire the run3, for the next line to run.
        printThird.run();
    }
}