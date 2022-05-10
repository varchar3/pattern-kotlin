package com.fbkj.composedemo.pattern.createtype

import android.util.Log
import com.fbkj.composedemo.Constants
import com.fbkj.composedemo.Constants.IPHONE
import com.fbkj.composedemo.Constants.XIAOMI

/**
- @author:  LZC
- @time:  2021/9/2
- @desc: 工厂模式可分三类 1.简单工厂模式 2.方法工厂模式 3.抽象工厂模式 ：产品标准化，生产更高效
查理的巧克力工厂全是shit
 */
class FactoryPattern {

    fun makeAPhone() {//简单工厂模式
        Factory().makePhone(XIAOMI)
    }

    fun makeAPhone2() {//方法工厂模式
        val mf: AbstractFactory = XiaoMiFactory()
        val af: AbstractFactory = AppleFactory()
        mf.makePhone()
        af.makePhone()
    }

    fun makeAPhone3() {

    }

    interface Phone {
        fun make(name: String)
    }


    class XiaoMi : Phone {
        init {
            make("XiaoMi")
        }

        override fun make(name: String) {
            Log.i("make", "制造了一台Xiaomi")
        }
    }

    class Iphone : Phone {
        init {
            make("Iphone")
        }

        override fun make(name: String) {
            Log.i("make", "制造了一台Iphone")
        }
    }

    /**-------------------------------------简单工厂模式-------------------------------------------**/

    class Factory { //代工厂
        fun makePhone(@Constants.PhoneTypes name: String) = when (name) {
            XIAOMI -> XiaoMi()
            IPHONE -> Iphone()
            else -> XiaoMi()
        }
    }

    /**-------------------------------------方法工厂模式-------------------------------------------**/

    interface AbstractFactory {
        //抽象工厂模式无疑是吧工厂抽象出来里边定义多种不同类型的作坊
        fun makePhone(): Phone//手机小作坊
        fun makeComputer(): Computer//电脑小作坊
    }

    class XiaoMiFactory : AbstractFactory {
        //工厂方法模式将生成具体产品的任务分发给具体的产品工厂
        override fun makePhone(): Phone {
            return XiaoMi()
        }

        override fun makeComputer(): Computer {
            //抽象工厂模式建造computer
            return XiaoMiPc()
        }
    }

    class AppleFactory : AbstractFactory {
        //工厂方法模式将生成具体产品的任务分发给具体的产品工厂
        override fun makePhone(): Phone {
            return Iphone()
        }

        override fun makeComputer(): Computer {
            //抽象工厂模式建造computer
            return Mac()
        }
    }

    /**-------------------------------------抽象工厂模式-------------------------------------------**/

    //无非就是两种模式在加一个制作工厂的接口
    interface Computer {
        fun make(name: String)
    }

    class XiaoMiPc : Computer {
        init {
            make("XiaoMiPc")
        }

        override fun make(name: String) {
            Log.i("make", "制造了一台XiaoMiPc")
        }
    }

    class Mac : Computer {
        init {
            make("Mac")
        }

        override fun make(name: String) {
            Log.i("make", "制造了一台Mac")
        }
    }

}
