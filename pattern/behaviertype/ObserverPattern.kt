package com.fbkj.composedemo.pattern.behaviertype

import android.util.Log
import java.util.*

/**
- @author:  LZC
- @time:  2021/9/3
- @desc: 观察者模式：	到点通知,做到一个更新，其它调用均得到响应
 */
class ObserverPattern {
    fun runObserver() {
        val s: Subject = ConcreteSubject()
        s.addObs(ConcreteObserver())
    }

    abstract class Subject {
        //    之所以使用Vector而不使用List，是因为多线程操作时，Vector在是安全的，而List则是不安全的
        var observe: Vector<Observer> = Vector()

        fun addObs(obs: Observer) {
            this.observe.add(obs)
            doSomething()
        }

        fun removeObs(obs: Observer) {
            this.observe.remove(obs)
            doSomething()
        }

        fun notifyObs() {
            for (o in observe) {//遍历Vector，更新每个obs
                o.update()
            }
        }

        abstract fun doSomething()
    }

    class ConcreteSubject : Subject() {
        override fun doSomething() {//实现接口方法
            this.notifyObs()//被观察者事件反生
        }
    }

    interface Observer {
        fun update()
    }

    class ConcreteObserver : Observer {//实例化Observer
        //实例化接口函数
        override fun update() {
            Log.i("Ada", "深渊在凝视你...")
        }
    }

}


