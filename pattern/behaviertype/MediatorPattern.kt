package com.fbkj.composedemo.pattern.behaviertype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/3
- @desc:中介者模式 AKA 调停者模式 迪米特法则的典型应用 解耦一把手：联系方式我给你，怎么搞定我不管
用一个中介者对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，
从而使耦合松散，而且可以独立地改变它们之间的交互。
例如有AB 2个类
A类不可直接造作B类,B同理
需要有个25仔帮忙处理AB间的赋值与业务交互
 */
class MediatorPattern {

    fun handleSTH(){
        val p = Phone()//使用二五仔
        p.tellHimILoveHer()
        p.tellHimIMissHer()
        p.tellHimIScrewHer()
    }

    abstract class SameLogic {
        abstract var name :String
        fun iMissU(name: String): String {
            return "I miss $name"
        }

        fun iLoveU(name: String): String {
            return "I love $name"
        }

        fun iFuckU(name: String): String {
            return "$name ,can i fuck you tonight?"
        }

    }

    class XiaoHong : SameLogic(){
        override var name: String
            get() = "小红"
            set(value) {}
        fun receive(msg: String):Boolean{
            return msg.isNotEmpty()
        }
    }

    class XiaoBai : SameLogic(){
        override var name: String
            get() = "小白"
            set(value) {}
        fun boKi(sheSayYes:Boolean){
            if (sheSayYes){
                Log.i("XiaoBai","I BoKi!!!!!!!!!!!!!!要恋爱了！！！！")
            }else{
                Log.i("XiaoBai","是个舔狗")
            }

        }
    }

    //通过手机途径发消息,充当中介
    class Phone {
        private val hong = XiaoHong()
        private val bai = XiaoBai()
        fun tellHimILoveHer() {
            bai.boKi(
                hong.receive(
                    bai.iLoveU(hong.name)
                )
            )
        }
        fun tellHimIMissHer(){
            bai.boKi(
                hong.receive(
                    bai.iMissU(hong.name)
                )
            )
        }
        fun tellHimIScrewHer(){
            bai.boKi(
                hong.receive(
                    bai.iFuckU(hong.name)
                )
            )
        }
    }
}