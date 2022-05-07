package com.fbkj.composedemo.pattern.behaviertype

/**
- @author:  LZC
- @time:  2021/9/3
- @desc: 访问者模式 ->最复杂的设计模式，并且使用频率不高：	横看成岭侧成峰，远近高低各不同
 1.符合单一职责原则
 2.被封装的操作通常来说都是易变的，所以当发生变化时，就可以在不改变元素类本身的前提下，实现对变化部分的扩展
 */
class VisitorPattern {
    abstract class Element{
        abstract fun accept(v: IVisitor)
        abstract fun doSomethings()
    }

    interface IVisitor{

    }

    class ConcreteElement1: Element(){
        override fun accept(v: IVisitor) {

        }

        override fun doSomethings() {

        }

    }

    class ConcreteElement2: Element(){
        override fun accept(v: IVisitor) {
            TODO("Not yet implemented")
        }

        override fun doSomethings() {
            TODO("Not yet implemented")
        }

    }
}