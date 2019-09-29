package com.hy.tt.spring.beans.functionalInterface;

/**
 * 函数式声明接口
 *    *** 被它修饰的接口,有且只有一个抽象方法
 *     要不然就编译报错
 *
 *     加不加它对于函数式实现没影响 去掉一样可以使用函数式编程
 */
@FunctionalInterface
public interface IHelloService {

    void say(String name);

    default void sayDefault(){
        System.out.println("1");
    }
}
