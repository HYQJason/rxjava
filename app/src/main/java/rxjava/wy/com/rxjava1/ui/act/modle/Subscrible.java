package rxjava.wy.com.rxjava1.ui.act.modle;

/**
 * Created by WY on 2017/2/8.
 *
 *
 * 男生
 */
//1,T看电影,
//Subscriblefemale<? super T> 看电影得女生
// super 用于参数类型限定，
// extends 用于返回参数类型的限定，不能用于参数类型的限定
public interface Subscrible <T> extends Action<Subscriblefemale<? super T>>{


}
