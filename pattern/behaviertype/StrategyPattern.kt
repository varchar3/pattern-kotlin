package com.fbkj.composedemo.pattern.behaviertype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/6
- @desc: 策略模式 ,挺简单的，由于策略类都实现同一个接口：条条大道通罗马，具体哪条你来定
优:1.因此他们能够互相替换,
2.耦低，
3.方便拓展,符合开闭原则
缺：1.策略的增多导致子类增多
2.客户端必须知道所有的策略类，并自行决定使用哪一个策略类
做人不要太DIO。JOJO我不做人啦！！！Wryyyyyyyyyyyyyyyyy！！！！！！
 */

class StrategyPattern {

    private val dio1 = Contexts(ChaseStrategy1())

    fun koNoDioDa(){
        dio1.chase()
        dio1.fuck()
        dio1.gift()
    }

    class Contexts(val s:Strategy){
        fun chase(){
            s.chase()
        }
        fun gift(){
            s.gift()
        }
        fun fuck(){
            s.fuck()
        }
    }

    interface Strategy{
        fun chase()
        fun gift()
        fun fuck()
    }

    class ChaseStrategy1 :Strategy{
        override fun chase() {
            Log.i("ChaseStrategy1", "追她的第一种方式")
        }

        override fun gift() {
            Log.i("ChaseStrategy1", "给她的第一份礼物")
        }

        override fun fuck() {
            Log.i("ChaseStrategy1", "跟他的第一次缠绵")
        }
    }

    class ChaseStrategy2 :Strategy{
        override fun chase() {
            Log.i("ChaseStrategy2", "追她的第二种方式")
        }

        override fun gift() {
            Log.i("ChaseStrategy2", "给她的第二份礼物")
        }

        override fun fuck() {
            Log.i("ChaseStrategy2", "跟他的第二次缠绵")
        }
    }
}