<#include "./header.ftl" />
<style type="text/css">
    * {  margin:0; padding: 0; }
    body {
        width: 100%;
        padding-top: 100px;
    }
    .title {
        text-align: center;
        margin-bottom: 100px;
    }
    .login-form {
        width: 300px;
        margin: 0 auto;
    }
    .login-form .input-part input {
        width: 100%;
        border: none;
        background-color: #ffffff;
        padding: 8px 10px;
    }
    .login-form .line {
        height: 1px;
        background-color: #cccccc;
    }
    .copyright {
        width: 100%;
        font-size: 10px;
        position: fixed;
        bottom: 10px;
        text-align: center;
        color: #cccccc;
        left: 0;
    }
</style>
</head>
<body>
<div class="container">
    <h4 class="title">樱桃火统一平台(SSO)</h4>
    <form id="loginForm">
        <div class="login-form">
            <div class="input-part">
                <input type="text" name="mobile" placeholder="手机号">
            </div>
            <div class="line"></div>
            <div class="input-part">
                <input type="password" name="password">
            </div>
            <button style="display: none;">传送</button>
        </div>
    </form>
    <div class="copyright">
        <p>杭州典丰科技有限公司</p>
        <p>浙ICP 备 17006410号</p>
    </div>
</div>
<script>
    $("#loginForm").on("submit", function (event) {
        event.preventDefault()
        $.ajax("/auth/login", {
            contentType: "application/json",
            data: JSON.stringify({ mobile: $("[name=mobile]").val(), password: $("[name=password]").val() }),
            type: "POST"
        }).success(function() {
            $.toast({
                heading: '登陆成功！跳转中...',
                text: '完成',
                showHideTransition: 'slide',
                icon: 'success',
                hideAfter: 1900
            });
            setTimeout(function () {
                location.href = "/shops/list?pageSize=300"
            }, 2000)
        }).fail(function (err) {
            $.toast({
                heading: '登录出现问题',
                text: err.message,
                showHideTransition: 'fade',
                icon: 'error',
                hideAfter: 1000
            })
        })
    })
</script>
<#include "./footer.ftl" />