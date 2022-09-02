package test;

import org.threadpool.CustomThreadPool;

//https://jenkov.com/tutorials/java-concurrency/thread-pools.html
//https://www.youtube.com/watch?v=ZcKt5FYd3bU&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=12
public class CustomThreadPoolTest {

    public static void main(String[] args) throws Exception{
        CustomThreadPool threadPool = new CustomThreadPool(4);

        for(int i=0;i<10;i++){
            int taskNo = i;
            threadPool.execute(() ->{
                        String message = Thread.currentThread().getName() +" : Task "+ taskNo;
                        System.out.println(message);
            });
        }

        threadPool.waitUtilAllTasksFinished();
        threadPool.stop();
    }
}
