package com.fbkj.composedemo.pattern.structtype

/**
- @author:  LZC
- @time:  2021/9/22
- @desc: 享元模式（FlyWeight翻译过来就是轻量级）->运用共享技术有效地支持大量细粒度的对象
-第一个想到的应该就是池技术了，
-String常量池、数据库连接池、缓冲池等等都是享元模式的应用，
-所以说享元模式是池技术的重要实现方式。
例：每次创建字符串对象时，都需要创建一个新的字符串对象的话，内存开销会很大，
所以如果第一次创建了字符串对象“adam“，下次再创建相同的字符串”adam“时，
只是把它的引用指向”adam“，这样就实现了”adam“字符串再内存中的共享
 */
class FlyweightPattern {

    abstract class Flyweight(var extrinsic: String) {
        //内部状态
        var intrinsic: String = ""
        //业务操作定义
        abstract fun operate(extrinsic: Int)
    }

    //继承Flyweight超类或实现Flyweight接口，并为其内部状态增加存储空间
    class ConcreteFlyWeight(extrinsic: String) : Flyweight(extrinsic) {
        //接受外部状态
        //根据外部状态进行逻辑处理
        override fun operate(extrinsic: Int) {
            println("具体flyweight:$extrinsic")
        }
    }

    //指那些不需要共享的Flyweight子类。
    class UnsharedConcreteFlyweight(extrinsic: String) : Flyweight(extrinsic) {
        //接受外部状态
        //根据外部状态进行逻辑处理
        override fun operate(extrinsic: Int) {
            println("具体flyweight:$extrinsic")
        }
    }

    /**
     * 一个享元工厂，用来创建并管理 Flyweight对象，
     * 主要是用来确保合理地共享Flyweight，当用户请求一个 Flyweight时，
     * FlyweightFactory对象提供一个已创建的实例或创建一个实例。
     */
    class FlyweightFactory {
        companion object {
            //再定义一个池容器
            var pool: HashMap<String, Flyweight> = HashMap()
        }
        fun getFlyweight(extrinsic: String): Flyweight =
            if (pool.containsKey(extrinsic)){//有则拿
                println("有则 从池中 取出<--")
                pool[extrinsic]!!
            }else{//没有则新建
                println("无则 从池中 创建-->")
                val newFlyWeight = ConcreteFlyWeight(extrinsic)
                pool[extrinsic] = newFlyWeight
                newFlyWeight
            }

    }

    fun use(){
        val f1 = FlyweightFactory().getFlyweight("flyweight1")
        f1.operate(1234)
    }


}