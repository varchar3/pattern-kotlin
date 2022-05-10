package com.fbkj.composedemo.pattern.structtype

/**
- @author:  LZC
- @time:  2021/9/9
- @desc: 适配器模式,把一个类的接口变换成客户端所期待的另一种接口，从而使原本接口不匹配而无法一起工作的两个类能够在一起工作
此适配器非彼适配器(RecyclerView的Adapter)
- @advantages:
1.更好的复用性
2.透明，简洁
3.扩展性好
4.解耦
5.符合开闭原则
- @disadvantage:
过多使用，系统会非常乱，不易于整体把控
 */
class AdaptorPattern {
    fun killSomeOne(){
        val b:Blade = Adapter1()
        b.engage()
        val data:Int= 0
    }

    /**-----------sample1--------------*/
    //小剑
    interface Blade {
        fun engage()//自带啮合接口
    }

    //护手
    open class ArmGuard {
        fun protectArm() {
        }
    }

    class Adapter1 : Blade, ArmGuard() {
        //小剑适配上护手，变成袖剑
        override fun engage() {
            this.protectArm()
        }
    }

    /**-----------sample2--------------*/
    interface Tv110interface {//110v的接口自带转换,只需实现
        fun convertToV110()
    }

    open class V220 {
        fun v220interface() {
        }
    }

    class Adapter2 : Tv110interface, V220() {//电视转换220v接口到110v
        override fun convertToV110() {
            this.v220interface()
        }

    }
}