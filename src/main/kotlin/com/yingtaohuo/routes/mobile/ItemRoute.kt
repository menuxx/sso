package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBCategory
import com.yingtaohuo.db.DBItem
import com.yingtaohuo.db.fromRecord
import com.yingtaohuo.exception.InvalidParameterException
import com.yingtaohuo.exception.NotFoundException
import com.yingtaohuo.model.ItemModel
import com.yingtaohuo.page.Page
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.resp.OnlyID
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.sso.db.tables.records.TItemRecord
import com.yingtaohuo.util.coverImageToThumbnails
import com.yingtaohuo.util.getCurrentUser
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/items")
@PreAuthorize("hasRole('USER')")
class ItemRoute(val dbItem: DBItem, val dbCategory: DBCategory) {

    // page view
    @GetMapping("/list")
    fun itemList(model: Model, @RequestParam(name = "cateId", required = false) categoryId: Int?, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : String {
        // val user = getCurrentUser()
        // val categories = dbCategory.loadCategoryRangeShop(user.shopId)
        // val cateId = categoryId ?: categories.first().id
        // val itemList = dbItem.loadPageListByCategoryRangeOfShop(user.shopId, cateId, PageParam(pageNum, pageSize)).map { fromRecord<TItemRecord, ItemModel>(it) }
        // model.addAttribute("currentCateId", cateId)
        // model.addAttribute("pageNum", pageNum)
        // model.addAttribute("categories", categories)
        // model.addAttribute("itemList", itemList)
        model.addAttribute("title", "商品列表")
        return "mobile/item_list"
    }

    @GetMapping("/new")
    fun newItemView(model: Model) : String {
        val user = getCurrentUser()
        val categories = dbCategory.loadCategoryRangeShop(user.shopId)
        model.addAttribute("title", "创建商品")
        model.addAttribute("categories", categories)
        model.addAttribute("user", user)
        return "mobile/item_new"
    }

    @GetMapping("/{id}")
    fun editItemView(@PathVariable id: Int, model: Model) : String {
        val user = getCurrentUser()
        // 防止出现 编辑 不是 该店铺商品
        val item = dbItem.getById(id, user.shopId) ?: throw NotFoundException("item id:$id not found")
        val categories = dbCategory.loadCategoryRangeShop(user.shopId)
        model.addAttribute("categories", categories)
        model.addAttribute("item", fromRecord<TItemRecord, ItemModel>(item))
        model.addAttribute("title", "修改商品")
        return "mobile/item_edit"
    }

    @DeleteMapping("/{id}")
    fun delItem(@PathVariable("id") itemId: Int) : RespData<Int> {
        return RespData(dbItem.deleteItem(itemId)).success()
    }

    /**
     * 修改商品
     */
    @PutMapping("/{id}")
    @ResponseBody
    fun updateItem(@PathVariable("id") itemId: Int,  @RequestBody itemModel: ItemModel) : RespData<OnlyID> {
        val user = getCurrentUser()
        if ( itemModel.id == null || itemModel.corpId == null ) throw InvalidParameterException("缺少必要的参数")
        itemModel.thumbnails = coverImageToThumbnails(itemModel.coverImages)
        val num = dbItem.updateItemById(itemId, itemModel, withShopId = user.shopId)
        if ( num > 0 ) {
            return RespData(OnlyID(itemId)).success()
        }
        throw InvalidParameterException("您修改的商品不存在")
    }

    // page view
    @GetMapping("/")
    @ResponseBody
    fun itemListApi(model: Model, @RequestParam(name = "cateId", required = false) cateId: Int?, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : RespData<List<ItemModel>> {
        val user = getCurrentUser()
        val categories = dbCategory.loadCategoryRangeShop(user.shopId)
        val categoryId = cateId ?: categories.first().id
        val list = dbItem.loadPageListByCategoryRangeOfShop(user.shopId, categoryId, PageParam(pageNum, pageSize)).map { fromRecord<TItemRecord, ItemModel>(it) }
        return RespData(list).success(mapOf("cateId" to categoryId))
    }

    /**
     * 创建商品
     */
    @PostMapping("/")
    @ResponseBody
    fun postItem(@Valid @RequestBody item: ItemModel) : RespData<ItemModel> {
        val user = getCurrentUser()
        item.corpId = user.shopId
        val newItem = fromRecord<TItemRecord, ItemModel>(dbItem.insertItem(item))
        return RespData(newItem).success()
    }

}