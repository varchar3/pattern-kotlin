package com.fbkj.composedemo.pattern.structtype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/6
- @desc: 代理/委托模式 :没有资源没时间，得找别人来帮忙
 */
class ProxyPattern {

    fun fight(){
        val hitter :People = DaiDa(HitSb())
        hitter.hit()
    }

    interface People {//人
        fun hit()//具有打人的能力
    }

    class HitSb:People {//委托人想要hitSomeBody
        override fun hit() {
            Log.i("who","打谁谁谁")
        }
    }

    class DaiDa(var weiTuoRen :People):People{
        override fun hit() {
            weiTuoRen.hit()//我是滴滴代打,我拿委托人的拳头打你
        }
    }

}