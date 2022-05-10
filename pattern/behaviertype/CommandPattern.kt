package com.fbkj.composedemo.pattern.behaviertype

/**
- @author:  LZC
- @time:  2021/9/22
- @desc: 命令模式 ->将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化，
对请求排队或记录请求日志。以及支持可撤销的操作。
例如：遥控器和服务员，遥控器接收某一对象并集中于一个按钮控制开关
服务员不需要了解菜的内容，只需要把顾客点餐的餐牌给厨师就ok 顾客-命令->服务员
 */
class CommandPattern {

    fun test() {
        RemoteControlSet(
            LightOnCommand(Light())//传入灯开关控制值对象
        ).buttonOnPressed()

        RemoteControlSet(
            WashOnCommand(WashMachine())//传入洗衣机开关控制值对象
        ).buttonOnPressed()
    }

    interface Command {
        fun execute()
    }

    /**----------------------------灯------------------------------*/
    class Light {
        fun on() {
            println("开灯")
        }
    }

    class LightOnCommand(var light: Light) : Command {
        override fun execute() {
            light.on()
        }
    }
    /**-----------------------------洗衣机-----------------------------*/
    class WashMachine {
        fun on() {
            println("洗衣服")
        }
    }

    class WashOnCommand(var w: WashMachine) : Command {
        override fun execute() {
            w.on()
        }
    }
    /**----------------------------------------------------------------*/
    //控制集
    class RemoteControlSet(var slot: Command) {
        fun buttonOnPressed() {
            slot.execute()
        }
    }


}