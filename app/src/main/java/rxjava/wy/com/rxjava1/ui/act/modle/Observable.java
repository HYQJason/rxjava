package rxjava.wy.com.rxjava1.ui.act.modle;

/**
 * Created by WY on 2017/2/8.
 *
 *Observable源，英文释义“可观察的”
 *
 * 黑屋子黑屋子
 * Observer：接收源，英文释义“观察者”，没错！就是观察者模式中的“观察者”T
 *
 * T
 *
 */

public class Observable <T>{

    private Subscrible<T> subscrible;


    public static <T> Observable<T> create( Subscrible<T> subscrible){


        return new Observable<>(subscrible);
    }

    public Observable(Subscrible<T> subscrible){
        this.subscrible=subscrible;

    }

    public void  Subscriblefemale(Subscriblefemale<? super T> subscriblefemale ){
        subscrible.call(subscriblefemale);

    }

    public <R> Observable<R> map(Func<? super T,?extends R> func){

        return new Observable<R>(new OnSubscriblelift<T,R>(subscrible,func));
    }

    public Observable<T> tObservable(){
        return create(new SubscribleThread<T>(this));
    }
}
