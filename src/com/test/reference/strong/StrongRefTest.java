package com.test.reference.strong;

import com.test.reference.MyObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:dongyuxiang@vpgame.cn">dongyuxiang</a>
 * @date 2020/07/21 16:13
 **/

public class StrongRefTest {
    public static List<MyObject> list = new ArrayList<>();

    public static void main(String[] args) {
        //局部变量强引用对象gc
//        makeObject();

        //全局变量强引用对象gc
        list.add(new MyObject(0));
        list.add(new MyObject(1));
        list.add(new MyObject(2));

//        list = null;
        clearList(list);

        System.gc();
    }

    private static void clearList(List<MyObject> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, null);
        }
    }

    private static void makeObject(){
        MyObject myObject = new MyObject(4);
        System.gc();
    }
}
