package com.fbkj.composedemo.pattern.createtype

/**
- @author:  LZC
- @time:  2021/9/2
- @desc: 构建者模式，在Glide和Retrofit等框架中很多都有用到的，此下仅供参考：高配中配和低配，想选哪配就哪配
 不是把不是把，你他妈不是妈
 造孽啦造孽啦，拉稀都不会拉
 */
class BuilderPattern(builder: MyBuilder) {
    private var a: String = builder.a//必须
    private var b: String = builder.b//必须
    private var c: String = builder.c//必须
    private var d: String = builder.d?:""//可选
    private var e: String = builder.e?:""//可选
    private var f: String = builder.f?:""//可选

    class MyBuilder(
         var a: String,//必须
         var b: String,//必须
         var c: String//必须
    ) {
        lateinit var d: String//可选
        lateinit var e: String//可选
        lateinit var f: String//可选

        fun setD(d:String): MyBuilder {
            this.d = d
            return this
        }
        fun setE(e:String): MyBuilder {
            this.e = e
            return this
        }
        fun setF(f:String): MyBuilder {
            this.f = f
            return this
        }
        fun build(): BuilderPattern {
            return BuilderPattern(this)
        }
    }
}