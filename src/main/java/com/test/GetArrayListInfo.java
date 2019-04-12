package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//解析 ArrayList 类内的信息
public class GetArrayListInfo<get> {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取java中(任意)类 类型(3种方式）===获得一个具体的类<ArrayList>
        //1)Class<ArrayList>  类名.class
        // Class<ArrayList> x = ArrayList.class;
        //2) Class<? extends ArrayList>  对象.getClass()
       // ArrayList list=null;
       // Class<? extends ArrayList> x = list.getClass();
        // x : 类 类型的变量即类 类型的实例 就是一个具体的类！！！
        //3)  Class<?> Class.forName("全称类名")；推荐使用
        Class<?> clazz = Class.forName("java.util.ArrayList");
        //对类进行解析===获取类的信息
        //获取包名
        Package pkg = clazz.getPackage();
        String pkgName = pkg.getName();
        System.out.println(pkgName);
        //获取访修饰符
        int mod = clazz.getModifiers();
        String modStr = Modifier.toString(mod);
        if (Modifier.isInterface(mod))
            System.out.println(modStr);//输出 public interface
        else
            System.out.print(modStr + " class");
        //获取类名
        //clazz.getName();//全称类名（带有包名）
        String className = clazz.getSimpleName();
        System.out.println(className);
        //获取父类
        Class<?> supClz = clazz.getSuperclass();
        if (supClz !=null)
            System.out.print(" extends "+supClz .toGenericString());
            //获取接口(s)
        Class<?>[] ifs = clazz.getInterfaces();
        if (ifs !=null&& ifs.length !=0);
        System.out.print("implements ");
        for ( Class<?> ifName: ifs) {
            System.out.print(" " + ifName.toGenericString() + "");
        }
        //获取属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            //获取属性的修饰符
            //field.getModifiers();
            //获取属性的类型
            //Class<?> fieldType = field.getType();
            //获取属性的名称
             //String fieldName = field.getName();
        }
        //获取方法
        // clazz.getDeclaredMethod(String name,Class<?>...) ...说明它是可变参
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            //获取方法的修饰符
            method.getModifiers();
            //获取方法的返回值类型
            Class<?> returnType = method.getReturnType();
            //获取方法的名称
            //String methodName = method.ge0tName();
            //获取方法的参数类型
            //Class<?>[] pts = method.getParameterTypes();
            //获取方法抛出的异常
            //Class<?>[] ets = method.getExceptionTypes();
        }
        //获取构造方法
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor:constructors){
            //获取构造方法的名称
            // String constructorName = constructor.getName();
            //获取构造方法的参数类型
            //Class[] cpt = constructor.getParameterTypes();
            //获取构造方法抛出的异常
           //Class[] cets = constructor.getExceptionTypes();
        }
        //获取外部类
        Class<?> outClz = clazz.getDeclaringClass();
        //获取内部类
        Class<?>[] innerClz = clazz.getDeclaredClasses();
    }

}