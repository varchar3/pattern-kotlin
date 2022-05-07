package com.fbkj.composedemo.pattern.behaviertype

/**
- @author:  LZC
- @time:  2021/9/22
- @desc: 备忘录模式 -> 在不破坏封闭的前提下，捕获一个对象的内部状态，
并在该对象之外保存这个状态。这样，以后就可以将该对象恢复到原先保存的状态。
例子： 1、后悔药。 2、打游戏时的存档。 3、Windows 里的 ctrl + z。
优点： 1、给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态。
2、实现了信息的封装，使得用户不需要关心状态的保存细节。
缺点：消耗资源。如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存。
 */
class MementoPattern {

    class Memento(var state: String)

    //发起人
    class Creator {
        var state: String = ""

        fun setMyState(state: String) {
            this.state = state
            println("当前状态:$state")
        }

        fun createMemento(): Memento = Memento(state)

        //将发起人的状态恢复到备忘录对象所记录的状态
        fun restoreMemento(m: Memento) {
            this.state = m.state
        }
    }

    //负责人
    class CareTaker(var m: Memento)

    fun use() {
        val c = Creator()
        c.setMyState("state1")
        println(c)
        val careTaker = CareTaker(c.createMemento())
        c.setMyState("state2")
        println(c)
        c.restoreMemento(careTaker.m)
        println(c)
    }
}