package com.fbkj.composedemo.pattern.behaviertype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/6
- @desc: 策略模式 ,由于策略类都实现同一个接口：条条大道通罗马，具体哪条你来定
优: 1.因此他们能够互相替换,
2.低耦，
3.方便拓展,符合开闭原则
缺：1.策略的增多导致子类增多
2.客户端必须知道所有的策略类，并自行决定使用哪一个策略类
 */

class StrategyPattern {

    private val  way = Contexts(ChaseStrategyWayOne())

    fun onTheWay() {
         way.chase()
         way.fuck()
         way.gift()
    }

    class Contexts(private val s: Strategy) {
        fun chase() {
            s.chase()
        }

        fun gift() {
            s.gift()
        }

        fun fuck() {
            s.fuck()
        }
    }

    interface Strategy {
        fun chase()
        fun gift()
        fun fuck()
    }

    class ChaseStrategyWayOne : Strategy {
        override fun chase() {
            Log.i("ChaseStrategy", "追她的第一种方式")
        }

        override fun gift() {
            Log.i("ChaseStrategy", "给她的第一份礼物")
        }

        override fun fuck() {
            Log.i("ChaseStrategy", "跟他的第一次缠绵")
        }
    }

    class ChaseStrategyWaySecond : Strategy {
        override fun chase() {
            Log.i("ChaseStrategy", "追她的第二种方式")
        }

        override fun gift() {
            Log.i("ChaseStrategy", "给她的第二份礼物")
        }

        override fun fuck() {
            Log.i("ChaseStrategy", "跟他的第二次缠绵")
        }
    }
}