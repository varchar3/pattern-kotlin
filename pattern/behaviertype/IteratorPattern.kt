package com.fbkj.composedemo.pattern.behaviertype

import android.util.Log

/**
- @author:  LZC
- @time:  2021/9/3
- @desc: 迭代器模式 ：流水线上坐一天，每个包裹扫一遍
提供一种方法顺序访问一个聚合对象中的各种元素，而又不暴露该对象的内部表示,让外部代码透明地访问聚合的内部数据。
 */
class IteratorPattern {
    fun test() {
        val bs = BookShelf()
        bs.appendBook(Book(0, "JoJo的奇妙冒险 第一季"))
        bs.appendBook(Book(1, "JoJo的奇妙冒险 第二季"))
        bs.appendBook(Book(2, "JoJo的奇妙冒险 第仨季"))
        bs.appendBook(Book(3, "JoJo的奇妙冒险 第四季"))
        bs.appendBook(Book(4, "JoJo的奇妙冒险 第五季"))
        val i: Iterator = bs.iterator()
        while (i.hasNext()){
//            if () i符合某种逻辑对集合做某种操作
            Log.i("BookName",i.next()!!.name)
        }
    }

    interface Aggregate {
        operator fun iterator(): Iterator //operator ->给我们的类提供一些自己定义的操作运算符
    }

    interface Iterator {
        operator fun hasNext(): Boolean
        operator fun next(): Book?
    }

    //这里不用data class 还原一下
    data class Book(
        var id: Int,
        var name: String
    )

    class BookShelf : Aggregate {
        private var books: ArrayList<Book> = arrayListOf()

        fun appendBook(b: Book) {
            books.add(b)
        }

        fun fetchBookAt(index: Int): Book {
            return books[index]
        }

        fun getLength(): Int {
            return books.size
        }

        override fun iterator(): Iterator {
            return BookShelfIterator(this, 0)
        }
    }

    class BookShelfIterator(
        private val bookShelf: BookShelf,
        var index: Int
    ) : Iterator {
        override fun hasNext(): Boolean {
            return index < bookShelf.getLength()
        }

        override fun next(): Book {
            val book = bookShelf.fetchBookAt(index)
            index++
            return book
        }
    }

}