<#include "./header.ftl" />
    <style type="text/css">
        .statistics-tilte{
            text-align: center;
            color: #666;
        }
        .statistics-wrap{
            padding: 6px;
            list-style: none;
            border: 1px solid #ccc;
            border-radius: 6px;
            background-color: #eee;
            margin: 0;
        }
        .statistics-li{
            border:1px solid #ccc;
            background-color: #fff;
            padding: 10px;
            margin: 6px;

        }
        .statistics-date{
            background-color: #ffb700;
            color: #fff;
            text-align: center;
            border-radius: 3px;

        }
        .statistics-row{
            color: #888;
            font-size: 13px;

        }
        .account-amount{
        }
        .cus-price{
            float: right;
        }

        .order-num{
            font-size: 16px;
            color: #666;
        }

        .sprice{
            font-size: 15px;
            color: #666;
        }

        .load-more{
            text-align: center;
            text-decoration: none;
            padding: 10px;
        }

    </style>
</head>
<body>
<h3 class="statistics-tilte">交易统计表</h3>
<ul class="statistics-wrap">
    <li class="statistics-li">
        <p class="statistics-date">10月17日</p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span> <span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span><span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="order-num">订单数：39</p>
    </li>
    <li class="statistics-li">
        <p class="statistics-date">10月16日</p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span> <span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span><span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="order-num">订单数：55</p>
    </li>
    <li class="statistics-li">
        <p class="statistics-date">10月15日</p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span> <span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span><span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="order-num">订单数：89</p>
    </li>
    <li class="statistics-li">
        <p class="statistics-date">10月14日</p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span> <span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="statistics-row"><span class="account-amount">入账金额：<span class="sprice">¥ 1031.60</span></span><span class="cus-price"> 客单价：<span class="sprice">¥ 18.90</span></span></p>
        <p class="order-num">订单数：66</p>
    </li>
</ul>
<p class="load-more"><a href="#">加载更多...</a></p>
<#include "./footer.ftl" />