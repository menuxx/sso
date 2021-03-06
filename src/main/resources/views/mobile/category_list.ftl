<#include "./header.ftl" />
<#setting number_format="000">
<style type="text/css">

    .list-group-item .btn-category {
        float: right;
    }

    .btn-modify{
        padding: 0 12px;
    }

    .btn-delete{
        padding: 0 12px;
    }
    .btn-save{
        padding: 0 12px;
        display: none;
    }
    .form-input{
        width: 20%;
        height: 20px;
        padding: 0 10px;
        display: none;
    }

</style>
</head>
<body>

<div class="container">
    <div class="alert alert-info">
        分类修改与排序功能，将在近期后开发，敬请期待
    </div>
    <div class="">
        <ul class="list-group yth-categories-list">
        <#list categories as cate>
            <li class="list-group-item" data-cateid="${cate.id}">
                <#if cate.categoryIcon??>
                    <img src="${cate.categoryIcon}" alt="分类图标">
                </#if>
                <span class="category-name">${cate.categoryName}</span>
                <input type="text" class="form-control form-input" value="${cate.categoryName}">
                <div class="btn-group btn-category">
                    <a class="btn btn-link btn-modify">修改</a>
                    <a class="btn btn-link btn-save">保存</a>
                    <a class="btn btn-link btn-delete">删除</a>
                </div>
            </li>
        <#else>
            空空如也
        </#list>
        </ul>
    </div>
    <div class="list-group-item">
        <form class="form-inline" id="submitCategory">
            <div class="form-group ">
                <input type="text" name="categoryName" class="form-control" placeholder="分类名称">
            </div>
            <button class="btn btn-primary"> + 添加分类</button>
        </form>
    </div>
</div>

<script type="text/javascript">
    $("#submitCategory").on("submit", function (e) {
        e.preventDefault();
        var categoryName = $(this).find("[name=categoryName]").val()
        if (!categoryName || categoryName.length === 0) {
            return alert("分类名称不能为空哦")
        }
        $.ajax("/categories/", {
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ categoryName: categoryName })
        }).success(function (data) {
            var newCategory = $('<li class="list-group-item">' +
                    data.categoryName +
                    '<div class="btn-group btn-category">' +
                    '<a class="btn btn-link btn-modify">修改</a>' +
                    '<a class="btn btn-link btn-save">保存</a>' +
                    '<a class="btn btn-link btn-delete">删除</a>' +
                    '</div>' +
                    '</li>');
            $(".yth-categories-list").append(newCategory)
            alert("创建成功")
        }).fail(function (err) {
            alert("创建失败")
        })
    });
    $('.btn-modify').on('click', function () {
        $(this).hide();
        $(this).parent('.btn-category').find('.btn-save').show();
        $(this).parents('.list-group-item').find('.category-name').hide();
        $(this).parents('.list-group-item').find('.form-input').show();
    });

    $('.btn-save').on('click',function(){
        var formVal =  $('.form-input').val();
        $(this).hide();
        $(this).parent('.btn-category').find('.btn-modify').show();
        $(this).parents('.list-group-item').find('.form-input').hide();
        $(this).parents('.list-group-item').find('.category-name').show();
        $(this).parents('.list-group-item').find('.category-name').html(formVal);
    });

    $(".yth-categories-list").delegate('.btn-delete', 'click', function() {
        var cateid = $(this).parent('.list-group-item').data('cateid')
        $.ajax('/category/' + cateid, {
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify()
        })
        var li = $(this).parents(".list-group-item");
        li.remove();
    });



</script>

<#include "./footer.ftl" />