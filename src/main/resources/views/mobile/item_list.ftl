
<#include "./header.ftl" />
<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>

<div class="container wrap" id="container">

    <ul class="list-group">
        <li class="list-group-itemModel yth-list-group">
            <a href="javascript:alert('提示：该功能近期开放，敬请期待');" class="btn btn-default btn-block">+ 添加商品</a>
        </li>
        <#list itemList as itemModel>
            <li class="list-group-itemModel yth-list-group">
                <div class="media">
                        <div class="media-left media-middle">
                        <img class="media-object img-rounded itemModel-image" src="${app.cdnUrl}/1217.jpg?imageView2/1/w/200/h/200" alt="${itemModel.itemName}">
                    </div>
                    <div class="media-body">
                        <h5 class="media-heading">${itemModel.itemName}</h5>
                        <p>${itemModel.itemDesc}</p>
                        <p><span class="discounted-price">${itemModel.discountPrice / 100}</span><s class="original-price">${itemModel.productPrice / 100}</s></p>
                    </div>
                    <div class="media-right media-middle">
                        <a href="${app.siteUrl}/items/${itemModel.id}" class="btn btn-link">编辑</a>
                    </div>
                </div>
            </li>
        <#else>
            空空如也
        </#list>
    </ul>
    <a href="${app.siteUrl}/items/?pageNum=${pageNum+1}" class="btn btn-default btn-block refresh">加载更多</a>
</div>

<#include "./footer.ftl" />