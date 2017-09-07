
<#include "./header.ftl" />
<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>
<div class="container container-wrap">
    <a type="button" class="btn btn-info btn-lg btn-block" href="${app.siteUrl}/items/list">商品列表</a>
    <a type="button" class="btn btn-info btn-lg btn-block" href="${app.siteUrl}/shops/${user.shopId}/users/list">客户列表</a>
</div>
<#include "./footer.ftl" />