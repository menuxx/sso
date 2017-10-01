
<#include "./header.ftl" />
<#setting number_format="000">

<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>

<div class="container wrap" id="container">
    <div class="list-group-item yth-list-group-one">
        <a href="/items/new" class="btn btn-default btn-block">+ 添加商品</a>
    </div>

    <div class="yth-nav-list">
        <ul class="category-list nav nav-pills nav-stacked yth-nav-stacked">
            <#list categories as cate>
                <li role="presentation" data-category-id="${cate.id?string('0')}" <#if currentCateId=cate.id>class="active"</#if>><a class="nav-link">${cate.categoryName}</a></li>
            </#list>
        </ul>
        <ul class="list-group list-wrap list item-list">
        <#list itemList as item>
            <li class="list-group-item yth-list-group">
                <div class="media">
                    <div class="media-left media-middle">
                        <img class="media-object img-rounded item-image thumbnailUrl thumbnailAlt" src="<#if item.thumbnail??>${app.cdnUrl}/${item.thumbnail}<#else>${app.cdnUrl}/default_image_item.jpg</#if>" alt="${item.itemName}">
                    </div>
                    <div class="media-body">
                        <h5 class="media-heading itemName">${item.itemName}</h5>
                        <p class="itemDesc">${item.itemDesc}</p>
                        <p><span class="discounted-price discountPrice">¥${(item.discountPrice / 100)?string("0.00")}</span><s class="original-price productPrice">¥${(item.productPrice / 100)?string("0.00")}</s></p>
                    </div>
                    <div class="media-right media-middle">
                        <a href="${app.siteUrl}/items/${item.id}" class="btn btn-link itemEditLink">编辑</a>
                    </div>
                </div>
            </li>
        <#else>
            空空如也
        </#list>
        </ul>
    </div>
    <a class="refresh">加载更多</a>
</div>
<script src="${app.siteUrl}/${assets('js/list.js', app.envs)}"></script>
<script>

    function getCurrentCategoryId(){
        return $(".category-list li.active").data("category-id")
    }

    var pageNum = 2
    var options = {
        valueNames: [
            { name: 'thumbnailUrl', attr: 'src' },
            { name: 'thumbnailAlt', attr: 'alt' },
            'itemName',
            'itemDesc',
            'discountPrice',
            'productPrice',
            { name: 'itemEditLink', attr: 'href'}
        ],
        item: $("<div />").append($('.yth-list-group:eq(1)').clone() ).html()
    }
    var hackerList = new List('container', options, [])

    $(".category-list").delegate("li", "click", function () {
        var li = $(this)
        var cateId = li.data('category-id')
        $.ajax("/items/?pageNum=1&cateId=" + cateId).success(function(res) {
            var list = res.data.map(function (item) {
                item.discountPrice = "¥" + (item.discountPrice /= 100)
                item.productPrice = "¥" + (item.productPrice /= 100)
                item.thumbnailAlt = item.itemName
                if (item.thumbnail) {
                    item.thumbnailUrl = '${app.cdnUrl}/' + item.thumbnail
                } else {
                    item.thumbnailUrl = '${app.cdnUrl}/default_image_item.jpg'
                }
                item.itemEditLink = '${app.siteUrl}/items/' + item.id
                return item
            })
            pageNum = 1
            hackerList.clear()
            hackerList.add(list)
            pageNum++
            $(".category-list li.active").removeClass("active")
            li.addClass("active")
        })
    })

    $(".refresh").on("click", function(){
        var cateId = getCurrentCategoryId()
        $.ajax("/items/?pageNum=" + pageNum + '&cateId=' + cateId).success(function(res) {
            var list = res.data.map(function (item) {
                item.discountPrice = "¥" + (item.discountPrice /= 100)
                item.productPrice = "¥" + (item.productPrice /= 100)
                item.thumbnailAlt = item.itemName
                if (item.thumbnail) {
                    item.thumbnailUrl = '${app.cdnUrl}/' + item.thumbnail
                } else {
                    item.thumbnailUrl = '${app.cdnUrl}/default_image_item.jpg'
                }
                item.itemEditLink = '${app.siteUrl}/items/' + item.id
                return item
            })
            if(list.length > 0){
                hackerList.add(list)
                pageNum++
            } else{
                alert("没有更多了...")
            }
        })
    })
</script>

<#include "./footer.ftl" />