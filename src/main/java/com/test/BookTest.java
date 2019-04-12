package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BookTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
       //获取Book 类 类型的实例
        Class<?> clazz = Class.forName("com.test.book.Book");
        //操作类（1.实例化 2.读取属性 3.调用方法）
        //实例化（本质上是调用构造方法）
        //调用缺省无参的构造方法
        Object book = clazz.newInstance();
        System.out.println("book");
         //调用指定的构造方法（2步)
        // 1）找到指定的构造方法；)
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);//找参数类型为String的构造方法
        //2）调用找到的指定的构造方法
        Object book1 = constructor.newInstance("Java");
        System.out.println("book1");
        //读写属性(3步）
        //1）获取指定的属性；
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);//私有属性可以读写
        // 2）写属性；
        nameField.set(book,"Maven");//私有属性不能直接赋值
        // 3）读属性
        Object bookname = nameField.get(book);
        System.out.println(bookname);
        //方法的调用（2步）
        // 1）获取指定的方法
        Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
        // 2)调用方法(setName 方法）方法、哪个对象调用该方法及该方法所接受的参数值
        setNameMethod.invoke(book,"Oracle");



    }

}
