
<#include "./header.ftl" />
<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>

<div class="container wrap" id="container">

    <ul class="list-group list-wrap">
        <li class="list-group-item yth-list-group">
            <a href="javascript:alert('该功能近期开放，敬请期待');" class="btn btn-default btn-block">+ 添加商品</a>
        </li>
        <#list itemList as item>
            <li class="list-group-item yth-list-group">
                <div class="media">
                        <div class="media-left media-middle">
                        <img class="media-object img-rounded item-image" src="${defaultUrl(item.thumbnail, app.cdnUrl, "https://file.menuxx.com/")}" alt="${item.itemName}">
                    </div>
                    <div class="media-body">
                        <h5 class="media-heading">${item.itemName}</h5>
                        <p>${item.itemDesc}</p>
                        <p><span class="discounted-price">${item.discountPrice / 100}</span><s class="original-price">${item.productPrice / 100}</s></p>
                    </div>
                    <div class="media-right media-middle">
                        <a href="${app.siteUrl}/items/${item.id}" class="btn btn-link">编辑</a>
                    </div>
                </div>
            </li>
        <#else>
            空空如也
        </#list>
    </ul>
    <a href="${app.siteUrl}/items/?pageNum=${pageNum+1}" class="refresh">加载更多</a>
</div>

<#include "./footer.ftl" />