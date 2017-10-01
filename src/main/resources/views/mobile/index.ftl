
<#include "./header.ftl" />
<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>
<div class="container container-wrap">
    <a type="button" class="btn btn-info btn-lg btn-block" href="${app.siteUrl}/items/list">商品管理</a>
    <a type="button" class="btn btn-info btn-lg btn-block" href="${app.siteUrl}/shops/${user.shopId}/users/list">客户管理</a>
    <a type="button" class="btn btn-info btn-lg btn-block" href="${app.siteUrl}/shops/${user.shopId}/category_list">分类管理</a>
</div>
<#include "./footer.ftl" />