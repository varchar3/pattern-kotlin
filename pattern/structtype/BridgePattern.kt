package com.fbkj.composedemo.pattern.structtype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/8
- @desc:  桥接模式，树式结构图拆分成双树子叶对怼型：约定优于配置
- @advance: 1.桥接模式可以取代多层继承方案，多层继承方案违背了“单一职责原则”，复用性较差，
且类的个数非常多，桥接模式是比多层继承方案更好的解决方法，它极大减少了子类的个数。
2.桥接模式提高了系统的可扩展性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统，符合“开闭原则”
3.对象间的关联关系”解耦了抽象和实现之间固有的绑定关系，使得抽象和实现可以沿着各自的维度来变化
- @disadvantage 1.增加系统的理解与设计难度 2.正确识别出系统中两个独立变化的维度，
因此其使用范围具有一定的局限性，如何正确识别两个独立维度也需要一定的经验积累
AMD YES!!!
Inter NO!!!
 */
class BridgePattern {
    fun makeAPhone() {
        val p: Phone = XiaoMi().apply {//要啥手机
            setPhoneShell(ShellOne())//要啥手机外壳
            setPhoneCpu(Inter())//里边装啥cpu
        }
        p.callSb()//然后再是可以用
        p.playMusic()//然后再是可以用

        val p2: Phone = OnePlus().apply {//要啥手机
            setPhoneShell(ShellTwo())//要啥手机外壳
            setPhoneCpu(Amd())//里边装啥cpu
        }
        p2.callSb()//然后再是可以用
        p2.playMusic()//然后再是可以用
    }

    /**-----------------------------------桥的一边-------------------------------------------*/
    abstract class Phone { //抽象类里边定义好手机的各种软硬和功能，当然也可以拆分
        var shell: PhoneShell? = null
        var cpu: PhoneCpu? = null

        fun setPhoneShell(shell: PhoneShell) {
            this.shell = shell
        }

        fun setPhoneCpu(cpu: PhoneCpu) {
            this.cpu = cpu
        }

        abstract fun playMusic()
        abstract fun callSb()
    }

    class XiaoMi : Phone() {
        override fun playMusic() {
            Log.i("phone", "XiaoMi->playMusic")
        }

        override fun callSb() {
            Log.i("phone", "XiaoMi->callSb")
        }
    }

    class OnePlus : Phone() {
        override fun playMusic() {
            Log.i("phone", "OnePlus->playMusic")
        }

        override fun callSb() {
            Log.i("phone", "OnePlus->callSb")
        }
    }

    class Iphone : Phone() {
        override fun playMusic() {
            Log.i("phone", "Iphone->playMusic")
        }

        override fun callSb() {
            Log.i("phone", "Iphone->callSb")
        }
    }

    /**-----------------------------------桥的另一边-------------------------------------------*/


    interface PhoneShell {
        fun shell()
    }

    interface PhoneCpu {
        fun cpu()
    }

    class ShellOne : PhoneShell {
        override fun shell() {
            Log.i("phone", "第一种手机壳")
        }
    }

    class ShellTwo : PhoneShell {
        override fun shell() {
            Log.i("phone", "第二种手机壳")
        }
    }

    class Amd : PhoneCpu {
        override fun cpu() {
            Log.i("phone", "AMD的cpu")
        }
    }

    class Inter : PhoneCpu {
        override fun cpu() {
            Log.i("phone", "INTER的cpu")
        }
    }

}