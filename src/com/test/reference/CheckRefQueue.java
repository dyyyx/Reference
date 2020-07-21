package com.test.reference;

import com.test.reference.MyObject;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @author <a href="mailto:dongyuxiang@vpgame.cn">dongyuxiang</a>
 * @date 2020/07/21 13:13
 **/

public class CheckRefQueue implements Runnable {

    Reference<MyObject> obj = null;

    ReferenceQueue<MyObject> refQueue;

    public CheckRefQueue(ReferenceQueue<MyObject> refQueue) {
        this.refQueue = refQueue;
    }

    @Override
    public void run() {
        try {
            obj = (Reference<MyObject>) refQueue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obj != null) {
            System.out.println("Object in queue is :" + obj.get() + ",ref in queue is :" + obj);
        }
    }
}
