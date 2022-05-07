package com.fbkj.composedemo.pattern.structtype

import android.util.Log
import java.io.*

/**
- @author:  LZC
- @time:  2021/9/9
- @desc:  装饰器模式:为对象添加新功能->他大舅他二舅都是他舅
不改变接口的前提下，增强所考虑的类的性能
 */
class DecoratorPattern {
    //original function
    private val component: Component = ConcreteComponent()

    //original function + DecoratorA
    val decorator: Component =
        Decorator(
            ConcreteDecoratorA(
                component
            )
        )

    //original function + DecoratorA + DecoratorB
    val decorator2: Component =
        Decorator(
            ConcreteDecoratorA(
                ConcreteDecoratorB(
                    component
                )
            )
        )
/**---------------------------------------define------------------------------------------------*/
    interface Component {
        //抽象构件
        fun operation()
    }

    class ConcreteComponent : Component {
        //具体构件
        override fun operation() {
            Log.i("Component", "what?")
        }
    }

    open class Decorator(val c: Component) : Component {
        //装饰角色
        override fun operation() {
            c.operation()
        }
    }

    class ConcreteDecoratorA(c: Component) : Decorator(c) {
        //装饰角色
        override fun operation() {
            Log.i("decorator", "decor clazz with A")
            super.operation()
        }
    }

    class ConcreteDecoratorB(c: Component) : Decorator(c) {
        //装饰角色
        override fun operation() {
            Log.i("decorator", "decor clazz with B")
            super.operation()
        }
    }

    //例子 I/O
    fun ioOperations(){
        val data = DataInputStream(
            BufferedInputStream(
                FileInputStream("test.txt")
            )
        )
    }
}
