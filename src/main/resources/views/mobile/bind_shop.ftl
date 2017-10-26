<#include "./header.ftl" />
    <!-- Bootstrap -->
    <style type="text/css">
        body{
            padding: 30px;
        }

        .authorize{
            margin: 60px 0;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }
        .user-img, .logo-img {
            width: 80px;
            border: 1px solid #ccc;
            border-radius: 50%;
        }
        .authorize-txt{
            line-height: 60px;
            padding: 0 5px;
            color: #888;
        }

        .obtain{
            width: 60px;
        }

        .bind{
            margin-top: 30px;
        }

    </style>
</head>
<body>
<div class="alert alert-info" role="alert">输入店铺手机号完成绑定,从而可以在微信上查看订单和交易数据。</div>
<div class="authorize">
    <div class="user">
        <img class="user-img" src="https://wx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLDdUEpUG1AjW00aCVvtLxibQZedlKaNpKwM0spqIjfMSz43lOTYkRoiaBoR7LMjvmjUhrZUibbD1WvlQ/0">
    </div>
    <span class="authorize-txt">绑定到</span>
    <div class="yth">
        <img class="logo-img" src="http://olt6vsmtk.bkt.clouddn.com/YTH-logo.png">
    </div>
</div>
<form class="form-wrap">
    <div class="form-group">
        <input type="tel" class="form-control" placeholder="手机号">
    </div>
    <div class="input-group">
        <input type="text" class="form-control" placeholder="验证码">
        <span class="input-group-btn">
          <a class="btn btn-primary obtain" type="button">获取</a>
        </span>
    </div>
    <button type="submit" class="btn btn-block btn-primary bind">绑定</button>
</form>
<script type="text/javascript">
    var times = 0;
    $('.obtain').on('click', function(){
        if (times != 0) {
            return;
        }
        var self = this
        var timeID = setInterval(function(){
            if (times === 60) {
                clearInterval(timeID)
                $(self).html('获取')
                times = 0
                return
            }
            $(self).html(60 - times)
            times += 1;
            $(self).disable(true);
        },1000)
    })
</script>
<#include "./footer.ftl" />