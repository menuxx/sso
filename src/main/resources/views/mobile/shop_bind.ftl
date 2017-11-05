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
<div class="alert alert-info" role="alert">输入店铺手机号完成绑定,可以在微信上管理您的店铺。</div>
<div class="authorize">
    <div class="user">
        <img class="user-img" src="${authUserInfo.headimgurl}">
    </div>
    <span class="authorize-txt">绑定到</span>
    <div class="yth">
        <img class="logo-img" src="http://olt6vsmtk.bkt.clouddn.com/YTH-logo.png">
    </div>
</div>
<form id="bindForm" class="form-wrap">
    <div class="form-group">
        <input name="mobile" type="tel" class="form-control" placeholder="手机号">
    </div>
    <div class="input-group">
        <input name="captcha" type="text" class="form-control" placeholder="验证码">
        <span class="input-group-btn">
          <a class="btn btn-primary obtain" type="button">获取</a>
        </span>
    </div>
    <button type="submit" class="btn btn-block btn-primary bind">绑定</button>
</form>
<script type="text/javascript">

    // 发送验证码
    // post /captcha/send
    // { mobile -> String }

    function sendCaptcha(mobile) {
        $.ajax('/captcha/send', {
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ mobile: mobile })
        }).success(function(data) {
            alert('发送成功')
        }).fail(function(err) {
            alert('发送失败')
        })
    }

    // 绑定 post /auth/wx/shop_bind
    // { mobile -> String, captcha -> String }


    var src = $.trim($(".user-img").attr('src'))
    if ( src === '' ) {
        $(".user-img").attr('src', '/image/ddd.jpg')
    }


    var times = 0;
    $('.obtain').on('click', function() {
        if (times != 0) {
            return;
        }
        var self = this
        sendCaptcha($("#bindForm input[name=mobile]").val())
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
    });

    var src = $.trim($('.user-img').attr('src'));
    if(src == ""){
        $('.user-img').attr('src','/image/time.jpeg');
    }

    $("#bindForm").on('submit', function (event) {
        event.preventDefault()
        var mobile = $(this).find('[name=mobile]').val()
        var captcha = $(this).find('[name=captcha]').val()
        $.ajax('/auth/wx/shop_bind', {
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ mobile: mobile, captcha: captcha })
        }).success(function (data) {
            if (data.meta.errorCode === 0) {
                alert('绑定完成')
                location.href = '/'
            } else {
                alert(data.meta.error)
            }
        }).fail(function (err) {
            alert('绑定失败: ' + err)
        })
    })

</script>
<#include "./footer.ftl" />