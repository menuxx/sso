
<#include "./header.ftl" />
<#setting number_format="0">

<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>

<div class="container wrap" id="container">

    <ul class="list-group list-wrap list item-list">
        <li class="list-group-item yth-list-group">
            <a href="javascript:alert('该功能近期开放，敬请期待');" class="btn btn-default btn-block">+ 添加商品</a>
        </li>
        <#list itemList as item>
            <li class="list-group-item yth-list-group">
                <div class="media">
                        <div class="media-left media-middle">
                        <img class="media-object img-rounded item-image thumbnailUrl thumbnailAlt" src="<#if item.thumbnail??>${app.cdnUrl}/${item.thumbnail}<#else>${app.cdnUrl}/default_image_item.jpg</#if>" alt="${item.itemName}">
                    </div>
                    <div class="media-body">
                        <h5 class="media-heading itemName">${item.itemName}</h5>
                        <p class="itemDesc">${item.itemDesc}</p>
                        <p><span class="discounted-price discountPrice">¥${item.discountPrice / 100}</span><s class="original-price productPrice">¥${item.productPrice / 100}</s></p>
                    </div>
                    <div class="media-right media-middle">
                        <a href="${app.siteUrl}/items/${item.id?string["0"]}" class="btn btn-link itemEditLink">编辑</a>
                    </div>
                </div>
            </li>
        <#else>
            空空如也
        </#list>
    </ul>
    <a class="refresh">加载更多</a>
</div>
<script src="${app.siteUrl}/${assets('js/list.js', app.envs)}"></script>
<script>
    var pageNum = 2
    var options = {
        valueNames: [
            { name: 'thumbnailUrl', attr: 'src' },
            { name: 'thumbnailAlt', attr: 'alt' },
            'itemName',
            'itemDesc',
            'discountPrice',
            'productPrice',
            { name: 'itemEditLink', attr: 'href' }
        ],
        item: $("<div />").append($('.yth-list-group:eq(1)').clone() ).html()
    }
    var hackerList = new List('container', options, [])
    $(".refresh").on("click", function(){
        $.ajax("/items/?pageNum=" + pageNum).success(function(res) {
            var list = res.data.map(function (item) {
                item.discountPrice /= 100
                item.productPrice /= 100
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