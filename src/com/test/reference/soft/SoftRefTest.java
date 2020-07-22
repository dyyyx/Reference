package com.test.reference.soft;

import com.test.reference.CheckRefQueue;
import com.test.reference.MyObject;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @author <a href="mailto:dongyuxiang@vpgame.cn">dongyuxiang</a>
 * @date 2020/07/21 14:02
 **/

public class SoftRefTest {

    private static ReferenceQueue<MyObject> softQueue = new ReferenceQueue<>();
    public static void main(String[] args) {

//        SoftReference<MyObject> reference = new SoftReference<>(new MyObject(0));

        MyObject myObject = new MyObject(1);
        SoftReference<MyObject> softReference = new SoftReference<>(myObject, softQueue);
        System.out.println("创建的软引用为：" + softReference);
        CheckRefQueue checkRefQueue = new CheckRefQueue(softQueue);
        new Thread(checkRefQueue).start();

        myObject = null;
        System.gc();
        System.out.println("After GC soft Ref :" + softReference.get());
        System.out.println("分配大块内存");
        byte[] b = new byte[5 * 1024 * 694];
        System.out.println("After new byte[] Soft Ref :" + softReference.get());
        System.gc();
    }
}
