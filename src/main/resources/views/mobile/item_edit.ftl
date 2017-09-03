
<#include "./header.ftl" />

</head>
<body>

<div class="container" id="container">

    <div class="row form-page">

        <form novalidate id="itemEditForm" method="POST">
            <div class="form-group">
                <span class="required">*</span>
                <label>商品名称：</label>
                <input name="itemName" type="text" value="${item.itemName}" required class="form-control">
            </div>
            <div class="form-group">
                <span class="required">*</span>
                <label>选择分类：</label>
                <select class="form-control" name="categoryId">${item.categoryId}
                    <option>麻辣烫</option>
                    <option>盖浇饭</option>
                    <option>煲仔饭</option>
                    <option>凉皮</option>
                    <option>卤味</option>
                </select>
            </div>
            <div class="form-group">
                <span class="required">*</span>
                <label>单位：</label>
                <input name="unit" type="text" value="<#if item.unit??>${item.unit}</#if>" class="form-control" placeholder="例如：盒、个、袋、包...">
            </div>
            <div class="form-group">
                <span class="required">*</span>
                <label>原价：</label>
                <div class="input-group">
                    <span class="input-group-addon">¥</span>
                    <input name="productPrice" type="number" value="${item.productPrice / 100}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>折后价：</label>
                <div class="input-group">
                    <span class="input-group-addon">¥</span>
                    <input name="discountPrice" type="number" value="${item.discountPrice / 100}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>打包计价：</label>
                <label class="checkbox-inline">
                    <input name="packageFlag" checked type="checkbox" value="${item.packageFlag}">该商品打包时计算打包价
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

            <div class="form-group" id="fileUploadContainer">
                <label>上传图片：</label>
                <div class="file-choose">
                    <div class="image-list">
                        <#list item.coverImageUrls as imageUrl>
                            <div class="item-image-box" data-filekey="${imageUrl}">
                                <span class="glyphicon glyphicon-remove-circle remove-btn"></span>
                                <img class="item-image" src="${app.cdnUrl}/${imageUrl}">
                            </div>
                        </#list>
                    </div>
                    <label id="uploadBtn" class="choose-btn">
                        +<input name="file" class="choose-btn-native" type="file">
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label>商品描述：</label>
                <textarea name="itemDesc" class="form-control" rows="3">${item.itemDesc}</textarea>
            </div>

            <div class="form-group">
                <label>条形码：</label>
                <input name="barCode" type="number" value="<#if item.barCode??>${item.barCode}</#if>" class="form-control">
            </div>

            <div class="form-group">
                <label>商品编码：</label>
                <input name="itemCode" type="number" value="<#if item.itemCode??>${item.itemCode}</#if>" class="form-control">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-block">保存</button>
            </div>

        </form>
    </div>
</div>

<script src="${app.siteUrl}/js/jquery.validate.js"></script>
<script src="${app.siteUrl}/js/jquery.validate.bootstrap.js"></script>
<script src="${app.siteUrl}/js/messages_zh.js"></script>
<script src="${app.siteUrl}/js/moxie.js"></script>
<script src="${app.siteUrl}/js/plupload.dev.js"></script>
<script src="${app.siteUrl}/js/qiniu.min.js"></script>
<script src="${app.siteUrl}/js/zh_CN.js"></script>

<script type="text/javascript">

    $("#itemEditForm").validate({
        submitHandler:function(form){

            var coverImages = [];

            $('.item-image-box').each(function(i, box) {
                coverImages.push($(box).data('filekey'))
            });

            $.ajax({
                url: '/items/1',
                type: 'PUT',
                contentType: "application/json",
                data: JSON.stringify({
                    id: 1,
                    corpId: 1,
                    itemName: $('[name=itemName]').val(),
                    coverImages: coverImages.join(":"),
                    productPrice: 1,
                })
            }).done(function(data){
                alert("保存成功！")
            })
        },
        ignore: "*:not([name])",
        rules: {
            '[name=itemName]': 'required',
            '[name=productPrice]': 'required'
        }
    })

    function getDatetime(date) {
        return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" +date.getDate() + "-" + date.getHours() + "-" + date.getMinutes() + "-" + date.getSeconds() + "-" + date.getMilliseconds()
    }

    $(".image-list").delegate('.remove-btn', 'click',function(){
        $(this).parent().remove()
        if ($('.item-image-box').length <= 3 ) {
            $("#uploadBtn").show();
        }
    })

    // file upload
    var uploader = Qiniu.uploader({
        runtimes: 'html5',    //上传模式,依次退化
        browse_button: 'uploadBtn',       //上传选择的点选按钮，**必需**
        uptoken_url: '/upload/qiniu_token',            //Ajax请求upToken的Url，**强烈建议设置**（服务端提供）
        // uptoken : '', //若未指定uptoken_url,则必须指定 uptoken ,uptoken由其他程序生成
        // unique_names: true, // 默认 false，key为文件名。若开启该选项，SDK为自动生成上传成功后的key（文件名）。
        // save_key: true,   // 默认 false。若在服务端生成uptoken的上传策略中指定了 `sava_key`，则开启，SDK会忽略对key的处理
        domain: '${app.cdnUrl}',   //bucket 域名，下载资源时用到，**必需**
        get_new_uptoken: false,  // 设置上传文件的时候是否每次都重新获取新的token
        max_file_size: '3mb',           //最大文件体积限制
        max_retries: 3,                   //上传失败最大重试次数
        chunk_size: '1mb',                //分块上传时，每片的体积
        auto_start: true,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传,
        log_level: 5,
        multi_selection: false,
        // disable_statistics_report: false,
        filters: {
            max_file_size: "3mb",
            mime_types: [
                { title : "图片文件", extensions : "jpeg" },
                { title : "图片文件", extensions : "jpg" },
                { title : "图片文件", extensions : "gif" },
                { title : "图片文件", extensions : "png" }
            ]
        },
        init: {
            'FilesAdded': function(up, files) {
                plupload.each(files, function(file) {
                    console.log('FilesAdded', file)
                    // 文件添加进队列后,处理相关的事情
                });
            },
            'BeforeUpload': function(up, file) {
                // 每个文件上传前,处理相关的事情
            },
            'UploadProgress': function(up, file) {
                // 每个文件上传时,处理相关的事情
            },
            'FileUploaded': function(up, file, info) {
                var fileKey = JSON.parse(info.response).key
                var domain = up.getOption('domain')
                var fileUrl = domain + '/' + fileKey
                $('.image-list').append($('<div class="item-image-box" data-filekey="'+ fileKey +'">' +
                        '<span class="glyphicon glyphicon-remove-circle remove-btn"></span>'+
                        '<img class="item-image" src="'+ fileUrl +'">'+
                        '</div>'
                ));
                if ($('.item-image-box').length >=3 ) {
                    $("#uploadBtn").hide();
                }
            },
            'Error': function(up, err, errTip) {
                if (err.code === -600) {
                    alert('文件太大了，选一张小的吧')
                }
                //上传出错时,处理相关的事情
            },
            'UploadComplete': function() {
                //队列文件处理完毕后,处理相关的事情
            },
            'Key': function(up, file) {
                // image/xxxx
                var ext = file.type.replace("image/", "")
                return "images/item/" + getDatetime(new Date()) + '.' + ext
            }
        }
    });
</script>

<#include "./footer.ftl" />