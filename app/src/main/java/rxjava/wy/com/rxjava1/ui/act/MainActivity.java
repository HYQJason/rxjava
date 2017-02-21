package rxjava.wy.com.rxjava1.ui.act;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * 响应式编程，观察着模式
 * 建构模式，责任模式
 * 链式调度
 * 事件变化
 * 线程切换
*
* */
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import rxjava.wy.com.rxjava1.R;
/*import rxjava.wy.com.rxjava1.ui.act.modle.Func;
import rxjava.wy.com.rxjava1.ui.act.modle.Observable;
import rxjava.wy.com.rxjava1.ui.act.modle.Subscrible;
import rxjava.wy.com.rxjava1.ui.act.modle.Subscriblefemale;*/

public class MainActivity extends Activity {
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


  /*  public void viewOnClick(View view) {
        Observable.create(new Subscrible<String>() {
            @Override
            public void call(Subscriblefemale<? super String> subscriblefemale) {
                subscriblefemale.OnNext("男生:看电影");

                Log.i(TAG,"线程:"+Thread.currentThread().getName());
            }
        }).map(new Func<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Log.i(TAG,s);
                Log.i(TAG,"老婆:不愿意和你开房");
                return BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
            }
        }).tObservable().Subscriblefemale(new Subscriblefemale<Bitmap>() {
            @Override
            public void OnNext(Bitmap bitmap) {
                Log.i(TAG,"Bitmap==="+bitmap);

                Log.i(TAG,"开房的女生:走开房去");
            }
        });
    }*/
  public void viewOnClick(View view) {
      rxjava();

  }



    /*
    *
    *
    *
    *     Observable.create(new Observable.OnSubscribe<List<User>>() {
          @Override
          public void call(Subscriber<? super List<User>> subscriber) {
              List<User> userList = null;
              ···
              //从数据库获取用户表数据并赋给userList
              ···
              subscriber.onNext(userList);
          }
      }).subscribe(new Action1<List<User>>() {
          @Override
          public void call(List<User> users) {

              //获取到用户信息列表
          }
      });
    *
    *
    * */

    private void rxjava(){

     //   Observable//可观测的
       // Observer//观察者
      //  它们之间的连接就对应着subscribe()


        //创建一个上游 Observable：
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //创建一个下游 Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        };
        //建立连接
        observable.subscribe(observer);

    }

}