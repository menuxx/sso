
<#include "./header.ftl" />

</head>
<body>

<div class="container" id="container">

    <div class="btn-group btn-group-justified" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default">Left</button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default">Middle</button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default">Right</button>
        </div>
    </div>

    <div class="row form-page">

        <form novalidate method="post" action="http://upload.qiniu.com/"
              enctype="multipart/form-data">
            <div class="form-group">
                <span class="required">*</span>
                <label>商品名称：</label>
                <input type="text" value="${item.itemName}" required class="form-control">
            </div>
            <div class="form-group">
                <span class="required">*</span>
                <label>原价：</label>
                <div class="input-group">
                    <span class="input-group-addon">¥</span>
                    <input type="number" value="${item.productPrice / 100}" class="form-control">
                    <span class="input-group-addon">元</span>
                </div>
            </div>
            <div class="form-group">
                <label>折后价：</label>
                <div class="input-group">
                    <span class="input-group-addon">¥</span>
                    <input type="number" value="${item.discountPrice / 100}" class="form-control">
                    <span class="input-group-addon">元</span>
                </div>
            </div>
            <div class="form-group">
                <label>打包计价：</label>
                <label class="checkbox-inline">
                    <input type="checkbox" value="${item.packageFlag}">该商品打包时计算打包价
                </label>
            </div>
            <div class="form-group">
                <label>库存商品：</label>
                <div class="checkbox">
                    <label>
                        <input name="stock" value="${item.offline}" type="radio"> 缺货
                    </label>
                    <span class="yth-help-info text-warning">(会继续显示在小程序上但不能选购)</span>
                </div>

                <div class="checkbox">
                    <label>
                        <input name="stock" value="${item.soldout}" type="radio"> 下架
                    </label>
                    <span class="yth-help-info text-warning">(不会继续出现在小程序上面)</span>
                </div>
            </div>

            <div class="form-group">
                <label>上传图片：</label>
                <button id="startupload">开始上传</button>
                <input id="pickfiles" type="file">
                <div class="image-list"></div>
            </div>

            <div class="form-group">
                <label>商品描述：</label>
                <textarea class="form-control" rows="3">${item.itemDesc}</textarea>
            </div>

            <div class="form-group">
                <span class="required">*</span>
                <label>选择分类：</label>
                <select class="form-control">${item.categoryId}
                    <option>麻辣烫</option>
                    <option>盖浇饭</option>
                    <option>煲仔饭</option>
                    <option>凉皮</option>
                    <option>卤味</option>
                </select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-block">保存</button>
            </div>
        </form>
    </div>
</div>

<#include "./footer.ftl" />