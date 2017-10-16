package com.yingtaohuo

import org.junit.BeforeClass
import org.junit.Test

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/15
 * 微信: yin80871901
 */

class FeieClientTest {

    companion object {

        @JvmStatic lateinit var client : FeieClient

        @BeforeClass
        @JvmStatic
        fun setup() {
            client = FeieClient("80871901@qq.com", "uva5fA5ujzFN43EV")
        }

    }

    @Test
    fun testPrinterAddlist() {

        try {

            val result = client.printerAddlist(arrayListOf(
                    mapOf("sn" to "217506304", "key" to "a75npeqj", "remark" to "一台带切刀的测试机")
            ))

            val ret = result.getInt("ret")

            if ( ret != null ) {
                print(result.getString("msg"))
                print(result.getJSONObject("data").getJSONArray("no"))
                print(result.getJSONObject("data").getJSONArray("ok"))
            } else {
                print(result.getJSONObject("data").getJSONArray("no"))
                print(result.getJSONObject("data").getJSONArray("ok"))
            }

        } catch (ex: FeieException) {

            ex.printStackTrace()

        }

    }

    @Test
    fun printTestTicketTest() {
        try {
            val res = client.printTestTicket("217506304", 1)

            val ret = res.getInt("ret")

            if ( ret != 0 ) {
                println(res.getString("msg"))
            } else {
                println(res.getString("msg"))
            }

        } catch (ex: FeieException) {
            ex.printStackTrace()
        }
    }

    @Test
    fun queryPrinterStatusTest() {
        try {
            val res = client.queryPrinterStatus("217506304")

            val ret = res.getInt("ret")

            if ( ret != 0 ) {
                println(res.getString("msg"))
            } else {
                println(res.getString("data"))
                println(res.getString("msg"))
            }

        } catch (ex: FeieException) {
            ex.printStackTrace()
        }
    }

}