package rxjava.wy.com.rxjava1.ui.act.modle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by WY on 2017/2/8.
 */

public class SubscribleThread<T> implements  Subscrible<T> {
    private  static ExecutorService executorService= Executors.newCachedThreadPool();



    Observable<T> source;
    public SubscribleThread(Observable<T> source) {
        this.source = source;
    }

    @Override
    public void call(final Subscriblefemale<? super T> subscriblefemale) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                source.Subscriblefemale(subscriblefemale);
            }
        };
        executorService.submit(runnable);


    }
}
