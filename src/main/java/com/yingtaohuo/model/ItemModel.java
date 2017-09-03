package com.yingtaohuo.model;

import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ItemModel {

    private Integer id;

    private Integer corpId;

    @NotNull
    private String itemName;

    private String itemDesc;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Integer productPrice;

    private Integer discountPrice;

    private String unit;

    private Integer specialPrice;

    private Integer weekday;

    private Integer soldout;

    private Integer sortId;

    private Integer formatId;

    private String barCode;

    private String itemCode;

    private String suppliers;

    private Integer packageFlag;

    private String thumbnails;

    private String coverImages;

    private Integer joinActMinus;

    private Integer offline;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Integer specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getSoldout() {
        return soldout;
    }

    public void setSoldout(Integer soldout) {
        this.soldout = soldout;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getFormatId() {
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers = suppliers == null ? null : suppliers.trim();
    }

    public Integer getPackageFlag() {
        return packageFlag;
    }

    public void setPackageFlag(Integer packageFlag) {
        this.packageFlag = packageFlag;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails == null ? null : thumbnails.trim();
    }

    public String getCoverImages() {
        return coverImages;
    }

    public void setCoverImages(String coverImages) {
        this.coverImages = coverImages == null ? null : coverImages.trim();
    }

    public Integer getJoinActMinus() {
        return joinActMinus;
    }

    public void setJoinActMinus(Integer joinActMinus) {
        this.joinActMinus = joinActMinus;
    }

    public Integer getOffline() {
        return offline;
    }

    public void setOffline(Integer offline) {
        this.offline = offline;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<String> getCoverImageUrls() {
    	if (coverImages != null && !StringUtils.isEmpty(coverImages)) {
				return Arrays.asList(coverImages.split(":"));
			}
			return Collections.emptyList();
		}

}