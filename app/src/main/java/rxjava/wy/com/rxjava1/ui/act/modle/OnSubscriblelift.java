package rxjava.wy.com.rxjava1.ui.act.modle;

/**
 * Created by WY on 2017/2/8.
 *
 * T想找开房的女
 * R 能开房的女生
 */

public class OnSubscriblelift<T,R> implements Subscrible<R>{
//男生
    Subscrible<T> boy;
    private Func<? super T,? extends R> transfromer;

    public OnSubscriblelift(Subscrible<T> boy, Func<? super T, ? extends R> transfromer) {
        this.boy = boy;
        this.transfromer = transfromer;
    }

    @Override
    public void call(Subscriblefemale<? super R> subscriblefemale) {
        Subscriblefemale<? super  T> wifi=new OperaChangge<>(subscriblefemale,transfromer);
        boy.call(wifi);

    }



    class  OperaChangge<T,R> extends Subscriblefemale<T>{



        Subscriblefemale <? super R> actual;

        private Func<? super T,? extends  R> transfrom;

        public OperaChangge(Subscriblefemale<? super R> actual, Func<? super T, ? extends R> transfrom) {
            this.actual = actual;
            this.transfrom = transfrom;
        }



        @Override
        public void OnNext(T t) {

            /**
             * 替换
             * */
            R r=this.transfrom.call(t);
            actual.OnNext(r);

        }
    }
}
