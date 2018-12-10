package com.test.demos.demos.rxjava;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.test.demos.demos.R;
import java.util.ArrayList;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxjavaActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        textView = findViewById(R.id.tv);
        ApplicationInfo applicationInfo = null;
//        rx.Observer observer = new rx.Observer() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Object o) {
//
//            }
//        };
//        Subscriber subscriber = new Subscriber() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Object o) {
//
//            }
//        };
//        rx.Observable<String> observable = rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//            }
//        });
//
//        observable.subscribe(subscriber);
//        observable.subscribe(observer);
//        observable.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//
//            }
//        }, new Action0() {
//            @Override
//            public void call() {
//
//            }
//        });

        String[] sskg = {"skjg","sjkagj","sljgljg","sljgkjg"};
        rx.Observable.from(sskg).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.v("verf","遍历数组 " + s);
            }
        });
        final int drawRs = R.drawable.ic_launcher_background;
        rx.Observable
                .create(new rx.Observable.OnSubscribe<Drawable>() {
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        Log.v("verf","create 线程 " + Thread.currentThread().getId());
                        Drawable drawable = getResources().getDrawable(drawRs);
                        subscriber.onNext(drawable);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .flatMap(new Func1<Drawable, Observable<? extends Names>>() {
                    @Override
                    public Observable<? extends Names> call(Drawable drawable) {
                        final Names names = new Names();
                        return Observable.create(new Observable.OnSubscribe<Names>() {
                            @Override
                            public void call(Subscriber<? super Names> subscriber) {
                                subscriber.onNext(names);
                            }
                        }) ;
                    }
                })
                .flatMap(new Func1<Names, Observable<? extends String>>() {
                    @Override
                    public Observable<? extends String> call(Names names) {
                        final String name = "我在这里发生了转换";
                        Log.v("verf","flatMap1 线程 " + Thread.currentThread().getId());
                        return Observable.create(new Observable.OnSubscribe<String>() {
                            @Override
                            public void call(Subscriber<? super String> subscriber) {
                                subscriber.onNext(name);
                            }
                        });
                    }
                })
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.v("verf","doOnnext 线程 " + Thread.currentThread().getId());
                        Log.v("verf","下一步添加一个样式哦");
                        s += "string";
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String integer) {
                        Log.v("verf","onNext 设置图片2 " + Thread.currentThread().getId());
                        textView.setText(integer);
                    }
                });

    }

    public class Names{
        public ArrayList<String> strings= new ArrayList<>();
        public Names(){
            strings.add("name");
            strings.add("kkk");
            strings.add("sskjg");
        }
    }
}
