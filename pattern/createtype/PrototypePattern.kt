package com.fbkj.composedemo.pattern.createtype

/**
- @author:  LZC
- @time:  2021/9/3
- @desc:原型模式,用于对象的复制：一变多
Kotlin 用数据类（data classes）提供了解决方案。 copy就行了
注：
1）某些对象构造非常简单的情况下，就不要滥用原型模式了；
2）使用原型模式复制对象不会调用类的构造方法(new一个对象才会调用构造方法)。因为对象的复制是通过调用Object类的clone方法来完成的，它直接在内存中复制数据，也就是内存中二进制流的拷贝；
3）原型模式分为深拷贝和浅拷贝
浅拷贝：Object类的clone方法只会拷贝对象中的基本的数据类型（8种基本数据类型byte,char,short,int,long,float,double，boolean）,
深拷贝：除了浅拷贝的8中基本数据类型，其他都属于深拷贝，例如数组、对象...
克隆用的是native方法，一般而言，对JVM来说，native方法的效率远比java中的普通方法高

 */
class PrototypePattern : Cloneable {
    //需要继承Cloneable接口
    var id: Int = 0
    var name: String = ""
    var action: Action = Action()

    //需要实现clone方法
    override fun clone(): Any {
        val pp: PrototypePattern = super.clone() as PrototypePattern
        pp.id = this.id
        pp.name = this.name
        //注：action是一个对象，只要是对象都要实现Clineable接口和他的方法
        pp.action = this.action.clone() as Action
        return pp
    }


    class Action : Cloneable {
        public override fun clone(): Any {
            return super.clone()
        }
    }
}