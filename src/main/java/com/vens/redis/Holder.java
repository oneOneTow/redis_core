package com.vens.redis;

/**
 * @author LuZhiqing
 * @Description: 让过闭包对变量修改的限制
 * @date 2018/12/13
 */
public class Holder <T>{
    private T value;

    public Holder() {
    }
    public Holder(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
