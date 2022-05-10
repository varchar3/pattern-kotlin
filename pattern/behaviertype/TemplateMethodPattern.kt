package com.fbkj.composedemo.pattern.behaviertype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/2
- @desc: 模板方法模式
 */
class TemplateMethodPattern {

    private val naRuTo: AbstractSort = DetailSort() 
    fun use(array: Array<Int>) { 
        naRuTo.showSort(array) 
    }

    abstract class AbstractSort {
        //抽象出方法模板
        abstract fun sort(array: Array<Int>): Int
        fun showSort(what: Array<Int>) {
            for (i in 0..sort(what)) {
                Log.i("what", i.toString())
            }
        }
    }

    class DetailSort : AbstractSort() {
        //把抽象方法具体化
        override fun sort(array: Array<Int>): Int {
            return doSomeThings(array)
        }

        private fun doSomeThings(array: Array<Int>): Int {
            var temp = 0
            for (i in array.indices) {
                temp += i
            }
            return temp
        }
    }


}