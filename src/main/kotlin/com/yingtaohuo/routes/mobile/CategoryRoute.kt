package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBCategory
import com.yingtaohuo.db.fromRecord
import com.yingtaohuo.model.CategoryModel
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.util.getCurrentUser
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/1
 * 微信: yin80871901
 */
@AllOpen
@RestController
@RequestMapping("/categories")
@PreAuthorize("hasRole('USER')")
class CategoryRoute (val dbCategory: DBCategory) {

    @GetMapping("/")
    fun getCategoriesRangeOfShop() : RespData<List<CategoryModel>> {
        val user = getCurrentUser()
        val list: List<CategoryModel> = dbCategory.loadCategoryRangeShop(user.shopId).map(::fromRecord)
        return RespData(list).success()
    }

    data class PostCategory(@NotEmpty val categoryName: String)
    @PostMapping("/")
    fun createCategory(@Valid @RequestBody cate: PostCategory) : CategoryModel {
        val user = getCurrentUser()
        val newCate = CategoryModel()
        newCate.categoryName = cate.categoryName
        newCate.corpId = user.shopId
        newCate.sortId = 6
        return fromRecord(dbCategory.insertCategory(newCate))
    }


}