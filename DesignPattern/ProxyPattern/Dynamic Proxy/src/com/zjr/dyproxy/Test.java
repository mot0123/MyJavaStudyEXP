package com.zjr.dyproxy;

public class Test {
    public static void main(String[] args) {
        JdkFuDao jdkFuDao = new JdkFuDao();

        /* 调用代理 */
        IPerson zhaoliu = jdkFuDao.getInstance(new ZhaoLiu());
        zhaoliu.findteachers();
    }
}
