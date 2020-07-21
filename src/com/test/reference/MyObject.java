package com.test.reference;

/**
 * @author <a href="mailto:dongyuxiang@vpgame.cn">dongyuxiang</a>
 * @date 2020/07/21 13:09
 **/

public class MyObject {
    private int id;
    public MyObject(int id){
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用finalize方法:" + this.toString());
    }

    @Override
    public String toString() {
        return "myObject-" + id;
    }
}
