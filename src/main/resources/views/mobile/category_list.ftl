<#include "./header.ftl" />
<#setting number_format="000">

<div class="container">
    <div class="alert alert-info">
        分类修改与排序功能，将在近期后开发，敬请期待
    </div>
    <div class="">
        <ul class="list-group yth-categories-list">
        <#list categories as cate>
            <li class="list-group-item">
                <#if cate.categoryIcon??>
                    <img src="${cate.categoryIcon}" alt="分类图标">
                </#if>
                ${cate.categoryName}
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
    $("#submitCategory").on("submit", function (event) {
        event.preventDefault()
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
                    '</li>');
            $(".yth-categories-list").append(newCategory)
            alert("创建成功")
        }).fail(function (err) {
            alert("创建失败")
        })
    })
</script>

<#include "./footer.ftl" />