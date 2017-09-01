package com.yingtaohuo.model

import java.util.Date

class TItem {

    var id: Int? = null

    var corpId: Int? = null

    var itemName: String? = null
        set(itemName) {
            field = itemName?.trim { it <= ' ' }
        }

    var itemDesc: String? = null
        set(itemDesc) {
            field = itemDesc?.trim { it <= ' ' }
        }

    var categoryId: Int? = null

    var productPrice: Int? = null

    var discountPrice: Int? = null

    var unit: String? = null
        set(unit) {
            field = unit?.trim { it <= ' ' }
        }

    var specialPrice: Int? = null

    var weekday: Int? = null

    var soldout: Int? = null

    var sortId: Int? = null

    var formatId: Int? = null

    var barCode: String? = null
        set(barCode) {
            field = barCode?.trim { it <= ' ' }
        }

    var itemCode: String? = null
        set(itemCode) {
            field = itemCode?.trim { it <= ' ' }
        }

    var suppliers: String? = null
        set(suppliers) {
            field = suppliers?.trim { it <= ' ' }
        }

    var packageFlag: Int? = null

    var thumbnails: String? = null
        set(thumbnails) {
            field = thumbnails?.trim { it <= ' ' }
        }

    var coverImages: String? = null
        set(coverImages) {
            field = coverImages?.trim { it <= ' ' }
        }

    var joinActMinus: Int? = null

    var offline: Int? = null

    var createTime: Date? = null
}