<#include "./header.ftl" />
    <!-- Bootstrap -->
    <style type="text/css">
        .btn-wrap{
            width: 100%;
            padding: 10px 20px;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }
        .order-day{
            border: 1px solid #ffb700;
            width: 33%;
        }
        .order-day.active{
            border: 1px solid #ffb700;
            background-color: #ffb700;
            color: #fff;
        }
        .order-title{
            text-align: center;
            color: #666;
        }
        .order-list{
            margin: 0 10px;
            padding: 10px 10px;
            border:1px solid #ccc;
            border-radius: 6px;
            background-color: #eee;
        }
        .order-li{
            margin-top: 10px;
            list-style: none;
            border:1px solid #ccc;
            background-color: #fff;
        }

        .order-li-text{
            padding: 8px;
            margin: 0;
        }

        .order-li-date{
            border-bottom: 1px solid #ffb700;
        }

        .order-li-content{
            color: #666;
            font-size: 13px;
            font-weight: bold;
        }

        .order-number{
            float: right;
        }

        .order-price{
            font-size: 16px;
            float: right;
        }

    </style>
</head>
<body>
<h3 class="order-title">订单列表</h3>
<div class="btn-group btn-wrap" role="group">
    <a type="button" class="btn btn-default order-day active">今天</a>
    <a type="button" class="btn btn-default order-day">昨天</a>
    <a type="button" class="btn btn-default order-day">前天</a>
</div>
<ul class="order-list">
    <li class="order-li">
        <p class="order-li-text order-li-date">09月19号 23:24 <span class="order-number">20170919100011611</span></p>
        <p class="order-li-text order-li-content">测试订单 *1<br>测试订单 *1<br>茶树菇老鸭套餐 *1<span class="order-price">总计：¥10.00</span></p>
    </li>
    <li class="order-li">
        <p class="order-li-text order-li-date">09月19号 23:24 <span class="order-number">20170919100011611</span></p>
        <p class="order-li-text order-li-content">测试订单 *1<br>测试订单 *1<br>茶树菇老鸭套餐 *1<span class="order-price">总计：¥10.00</span></p>
    </li>
    <li class="order-li">
        <p class="order-li-text order-li-date">09月19号 23:24 <span class="order-number">20170919100011611</span></p>
        <p class="order-li-text order-li-content">测试订单 *1<br>测试订单 *1<br>茶树菇老鸭套餐 *1<span class="order-price">总计：¥10.00</span></p>
    </li>
    <li class="order-li">
        <p class="order-li-text order-li-date">09月19号 23:24 <span class="order-number">20170919100011611</span></p>
        <p class="order-li-text order-li-content">测试订单 *1<br>测试订单 *1<br>茶树菇老鸭套餐 *1<span class="order-price">总计：¥10.00</span></p>
    </li>
    <li class="order-li">
        <p class="order-li-text order-li-date">09月19号 23:24 <span class="order-number">20170919100011611</span></p>
        <p class="order-li-text order-li-content">测试订单 *1<br>测试订单 *1<br>茶树菇老鸭套餐 *1<span class="order-price">总计：¥10.00</span></p>
    </li>
    <li class="order-li">
        <p class="order-li-text order-li-date">09月19号 23:24 <span class="order-number">20170919100011611</span></p>
        <p class="order-li-text order-li-content">测试订单 *1<br>测试订单 *1<br>茶树菇老鸭套餐 *1<span class="order-price">总计：¥10.00</span></p>
    </li>
</ul>
<#include "./footer.ftl" />