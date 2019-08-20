import java.util.concurrent.*;
class FooBar {
    private int n;
    Semaphore s, a;
    public FooBar(int n) {
        this.n = n;
        s = new Semaphore(1);
        a = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            s.acquire();
        	printFoo.run();
            a.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            a.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            s.release();
        }
    }
}