<#include "./header.ftl" />
<style type="text/css">
    .shop-item {

    }
    .shop-item .title {
        float: left;
    }
    .shop-item .btn-opts {
        float: right;
    }
</style>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">店铺列表</div>
        <div class="panel-body">
            <ul class="list-group">
            <#list shops as shop>
                <li class="list-group-item shop-item clearfix" data-shop-id="${shop.id}">
                    <h5 class="title">${shop.corpName}</h5>
                    <div class="btn-group btn-opts">
                        <a class="btn btn-link btn-manage">管理</a>
                        <a class="btn btn-link btn-category">分类</a>
                        <a class="btn btn-link btn-items">菜单</a>
                    </div>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</div>
<script>

    function bindShop(shopId) {
        return $.ajax('/auth/bind_shop', {
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify({ shopId: shopId })
        })
    }

    $('.btn-manage').on('click', function () {
        var shopId = $(this).parents(".shop-item").data('shop-id')
        bindShop(shopId).then(function (data) {
            location.href = "/"
        })
    })
    $('.btn-category').on('click', function () {
        var shopId = $(this).parents(".shop-item").data('shop-id')
        bindShop(shopId).then(function (data) {
            location.href = "/shops/"+ shopId +"/category_list"
        })
    })
    $('.btn-items').on('click', function () {
        var shopId = $(this).parents(".shop-item").data('shop-id')
        bindShop(shopId).then(function (data) {
            location.href = "/items/list"
        })
    })
</script>
<#include "./footer.ftl" />