package com.fbkj.composedemo.pattern.behaviertype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/6
- @desc: 状态模式，跟策略模式差不多：状态驱动行为，行为决定状态
 优：1.每个状态都是一个子类，易于扩展和维护
    2.避免过多的条件语句，使得结构更清晰，提高代码的可维护性
 缺：1.可能会导致状态子类会过多
 饿货，不在状态？来一条士力架吧
 */
class StatePattern {

    private val c:Contexts = Contexts()

    fun myState(){
        c.onWork()
        c.onRest()
    }
    class Contexts{
        private lateinit var workerState:State
        private fun setState(state:State){
            workerState = state
        }

        fun onWork(){//你的·状态
            setState(WorkingState())
        }
        fun onRest(){//你的·状态
            setState(RestingState())
        }
    }

    interface State{
        fun working()
        fun resting()
    }
    //ConcreteState1
    class WorkingState:State{
        override fun working() {
            Log.i("states","做工噶时候做工！")
        }

        override fun resting() {
            //做工啊，休咩息啊！
        }
    }

    //ConcreteState2
    class RestingState:State{
        override fun working() {
            Log.i("states","休息时都可以做工，但一定要有钱带！OK？！")
        }

        override fun resting() {
            Log.i("states","休息噶时候休息！五使做甘多！坐低~饮下靓靓噶杯，饮奶茶饮果茶OK？！")
        }
    }

}