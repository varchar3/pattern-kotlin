package com.fbkj.composedemo.pattern.createtype

/**
- @author:  LZC
- @time:  2021/9/2
- @desc: 单例模式，没啥好说的：世上只有一个我
（辛辣天蟹）
 */
class SinglePattern {

    companion object{
        @Volatile// volatile 保证线程可见性和禁止指令重排序,多线程不安全
        var INSTANCE : SinglePattern?=null

        fun getInstance() =
            INSTANCE ?: synchronized(SinglePattern::class.java) {//完整是两判空一同步
                INSTANCE ?: SinglePattern()
                    .also { INSTANCE = it }
            }
    }
}