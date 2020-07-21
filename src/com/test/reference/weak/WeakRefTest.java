package com.test.reference.weak;

import com.test.reference.CheckRefQueue;
import com.test.reference.MyObject;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author <a href="mailto:dongyuxiang@vpgame.cn">dongyuxiang</a>
 * @date 2020/07/21 15:45
 **/

public class WeakRefTest {

    private static ReferenceQueue<MyObject> weakQueue = new ReferenceQueue<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            MyObject object = new MyObject(i);
            Reference<MyObject> weakRef = new WeakReference<>(object, weakQueue);
            System.out.println("创建的弱引用为：" + weakRef);
            CheckRefQueue checkRefQueue = new CheckRefQueue(weakQueue);
            new Thread(checkRefQueue).start();
            object = null;
            System.out.println("Before GC: " + weakRef.get());
            System.gc();
            System.out.println("After GC: " + weakRef.get());
        }
    }
}
