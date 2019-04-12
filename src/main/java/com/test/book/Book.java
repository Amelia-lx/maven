package com.test.book;

public class Book {
    //1)添加四个属性
    private int id;
    private String name;
    private double price;
    private String author;
// 添加getter and setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
//添加无参构造方法：
    public Book() {
        System.out.println("无参构造方法");
    }
    //添加int型构造方法：

    public Book(int id) {
        this.id = id;
        System.out.println("id:"+this.id);
    }
    //添加String型构造方法：

    public Book(String name) {
        this.name = name;
        System.out.println("name:"+this.name);
    }
    //添加三个参数的构造方法：
    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
        System.out.println("name:"+this.name+""+"price:"+this.price+""+"author:"+this.author);
    }
    //public方法
    public void BookName(){
        System.out.println("BookName:"+this.name);
    }
    //private方法
    private int getNameLength(){
        return name.length();
    }
}

