package com.vens.redis;

/**
 * @author LuZhiqing
 * @Description: �ù��հ��Ա����޸ĵ�����
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
