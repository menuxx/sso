
<#include "./header.ftl" />

<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>

<div class="container wrap" id="container">

    <div class="page-header-wrap">
        <div class="total-people">
            <p class="total-num">${userCount?string["0"]}</p>
        </div>
    </div>

    <ul class="list-group list-wrap list item-list">

    <#list userList as user>
        <li class="list-group-item yth-list-group">
            <div class="media">
                <div class="media-left media-middle">
                    <img class="media-object img-rounded item-image thumbnailAlt avatarUrl" src="<#if user.avatarUrl??>${user.avatarUrl}<#else>${app.cdnUrl}/default_image_item.jpg</#if>" alt="${user.nickName}">
                </div>
                <div class="media-body">
                    <h4 class="media-heading nickName">${user.nickName}</h4>
                    <p class="gender"><#if user.gender == 1>男<#elseif user.gender == 2>女<#else >未知</#if></p>
                </div>
                <div class="media-right media-middle">
                    <#if user.consumed == 1>
                        <p class="consumed">已消费过</p>
                    <#else>
                        <p class="consumed">未消费过</p>
                    </#if>
                </div>
            </div>
        </li>
    </#list>

    </ul>
    <a class="refresh">加载更多</a>
</div>
<script src="${app.siteUrl}/${assets('js/list.js', app.envs)}"></script>
<script>

    // 自适应容器大小
    var $content = $('.total-num');
    // 通过 zoom 来调节文字大小
    var zoom =  $content.width() / 75;
    $content.css('zoom', zoom);

    var pageNum = 2
    var options = {
        valueNames: [
            { name: 'avatarUrl', attr: 'src' },
            'nickName',
            'gender',
            'consumed',
        ],
        item: $("<div />").append($('.yth-list-group:eq(0)').clone() ).html()
    }
    var hackerList = new List('container', options, [])
    $(".refresh").on("click", function(){
        $.ajax("/shops/${user.shopId}/users/?pageNum=" + pageNum).success(function(res) {
            var list = res.data.map(function (user) {
                user.thumbnailAlt = user.nickName
                if ( !user.avatarUrl ) {
                    user.avatarUrl = '${app.cdnUrl}/default_image_item.jpg'
                }
                if(user.gender === 1){
                    user.gender = "男"
                } else if(user.gender === 2){
                    user.gender = "女"
                }else{
                    user.gender = "未知"
                }
                if(user.consumed === 1){
                    user.consumed = "已消费过"
                }else{
                    user.consumed = "未消费过"
                }
                return user
            })
            if(list.length > 0){
                hackerList.add(list)
                pageNum++
            } else{
                alert("没有更多了...")
            }
        })
    })
</script>


<#include "./footer.ftl" />

