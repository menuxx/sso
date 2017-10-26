<#include "./header.ftl" />
    <style type="text/css">

        body{
            padding:60px 30px;
        }

        .ythlogo{
            width: 320px;
            text-align: center;
        }

        .form-wrap{
            margin: 60px 0;
        }

        .form-input{
            margin: 30px 0;
        }

        .btn-sub{
            display: block;
        }

        .shop-title{
            margin: 20px 0;
            color: #666;
            text-align: center;
        }

    </style>
</head>
<body>
<img class="ythlogo" src="http://olt6vsmtk.bkt.clouddn.com/ythLOGO.png">
<h3 class="shop-title">管理店铺请登录</h3>
<form class="form-horizontal form-wrap">
    <input type="number" class="form-control form-input" placeholder="手机号">
    <input type="password" class="form-control form-input" placeholder="密码">
    <a type="submit" class="btn btn-primary btn-sub" href="#">登录</a>
</form>
<#include "./footer.ftl" />