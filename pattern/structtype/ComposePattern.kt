package com.fbkj.composedemo.pattern.structtype

/**
- @author:  LZC
- @time:  2021/9/22
- @desc: 组合模式也称为 整体-部分（Part-Whole）模式
组合模式 核心：借助同一接口，使叶子节点和树枝节点的操作具备一致性。
 */
class ComposePattern {

    var root = Composite("鞋子")//节点1
    var c1 = Composite("休闲鞋")//节点2
    var c2 = Composite("跑鞋")//节点3
    var c3 = Composite("马丁鞋")//节点3

    var l1 = Leaf("nike")
    var l2 = Leaf("adidas")
    var l3 = Leaf("convers")
    var l4 = Leaf("liling")
    var l5 = Leaf("anta")
    var l6 = Leaf("puma")
    var l7 = Leaf("new balance")

    fun main() {
        root.apply {
            addComposite(c1)
            addComposite(c2)
            addComposite(c3)
        }

        c1.apply {
            addLeaf(l1)
            addLeaf(l2)
        }
        c2.apply {
            addLeaf(l3)
            addLeaf(l4)
        }
        c3.apply {
            addLeaf(l5)
            addLeaf(l6)
            addLeaf(l7)
        }

        root.printStruct("\n")
    }
    class Leaf(var name: String) {
        fun printName(pre: String) {
            println(pre+this.name)
        }
    }


    class Composite(var name: String) {
        private var arrayLeaf: MutableCollection<Leaf> = ArrayList()
        var arrayComposite: MutableCollection<Composite> = ArrayList()

        fun addLeaf(l: Leaf) {
            this.arrayLeaf.add(l)
        }

        fun addComposite(c: Composite) {
            this.arrayComposite.add(c)
        }

        fun printStruct(preStr:String) {
            //先把自己输出去
            println(preStr + this.name)
            //然后添加一个空格，表示向后缩进一个空格，输出自己包含的叶子对象
            for (l in arrayLeaf){
                l.printName("    ")
            }
            //输出当前对象的子对象了
            for (c in arrayComposite){
                c.printStruct("")
            }
        }

    }
}