package com.fbkj.composedemo.pattern.structtype

/**
- @author:  LZC
- @time:  2021/9/22
- @desc: 外观模式
例： 药材店
好处:就是能够有选择性地暴露方法
 */
class FacadePattern {

    fun test() {
        ModelA().fetchDangGui()
        ModelB().fetchRenSen()
        ModelC().fetchPangDaHai()
    }

    class ModelA {
        fun fetchDangGui() {//暴露给外部使用的方法
            if (fetch("danggui")) {
                println("拿点当归")
            } else {
                return
            }
        }

        private fun fetch(name: String): Boolean {
            //DO SOMETHING 可以i有自己内部的实现方法，仅仅提供自己使用
            return true
        }
    }

    class ModelB {
        fun fetchRenSen() {
            println("拿点人参")
        }
    }

    class ModelC {
        fun fetchPangDaHai() {
            println("拿点胖大海")
        }
    }

}