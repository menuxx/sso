
<#include "./header.ftl" />
<#setting number_format="0">

</head>
<body>

<div class="container" id="container">

    <div class="row form-page">

        <form novalidate id="itemEditForm">
            <div class="form-group">
                <span class="required">*</span>
                <label>商品名称：</label>
                <input name="itemName" type="text" value="${item.itemName}" class="form-control">
            </div>
            <div class="form-group">
                <span class="required">*</span>
                <label>选择分类：</label>
                <select data-value-type="number" class="form-control category-select" name="categoryId">
                    <#list categories as category>
                    <option value="${category.id}">${category.categoryName}</option>
                        <#else>
                        <option>--空空如也--</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label>单位：</label>
                <input name="unit" type="text" value="<#if item.unit??>${item.unit}</#if>" class="form-control" placeholder="例如：盒、个、袋、包...">
            </div>
            <div class="form-group">
                <span class="required">*</span>
                <label>原价：</label>
                <div class="input-group">
                    <span class="input-group-addon">¥</span>
                    <input name="productPrice" type="number" data-value-type="number" value="${(item.productPrice / 100)?string('0.00')}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>折后价：</label>
                <div class="input-group">
                    <span class="input-group-addon">¥</span>
                    <input name="discountPrice" type="number" data-value-type="number" value="${(item.discountPrice / 100)?string('0.00')}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>打包计价：</label>
                <label class="checkbox-inline">
                    <input name="packageFlag" value="1" data-value-type="number" type="checkbox" data-unchecked-value="0" <#if item.packageFlag==1>checked</#if> />该商品打包时计算打包价
                </label>
            </div>

            <div class="form-group">

                <label>库存商品：</label>

                <div class="checkbox">
                    <label>
                        <input name="soldout" type="checkbox" value="1" data-value-type="number" data-unchecked-value="0" <#if item.soldout==1>checked</#if> /> 缺货
                    </label>
                    <span class="yth-help-info text-warning">(会继续显示在小程序上但不能选购)</span>
                </div>

                <div class="checkbox">
                    <label>
                        <input name="offline" type="checkbox" value="1" data-value-type="number" data-unchecked-value="0" <#if item.offline==1>checked</#if> />下架
                    </label>
                    <span class="yth-help-info text-warning">(不会继续出现在小程序上面)</span>
                </div>
            </div>

            <div class="form-group" id="fileUploadContainer">
                <label>商品图(第一张作为缩略图，最多可以传三张)：</label>
                <div class="file-choose">
                    <div class="image-list">
                        <#list item.coverImageUrls as imageUrl>
                            <div class="item-image-box">
                                <input type="hidden" name="filekeys[]" value="${imageUrl}">
                                <span class="glyphicon glyphicon-remove-circle remove-btn"></span>
                                <img class="item-image" src="${app.cdnUrl}/${imageUrl}">
                            </div>
                        </#list>
                    </div>
                    <label id="uploadBtn" class="choose-btn">
                        +<input class="choose-btn-native" type="file">
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
                <button type="submit" class="btn btn-primary btn-block">保存</button>
            </div>

            <div class="form-group">
                <a id="delete" class="btn btn-danger btn-block">删除</a>
            </div>

        </form>
    </div>
</div>

<script src="${app.siteUrl}/${assets('js/jquery.serializejson.js', app.envs)}"></script>
<#if app.envs?seq_contains('development')>
    <script src="${app.siteUrl}/${assets('js/moxie.js', app.envs)}"></script>
    <script src="${app.siteUrl}/js/plupload.dev.js"></script>
    <script src="${app.siteUrl}/js/qiniu.min.js"></script>
<#else>
    <script src="${app.siteUrl}/js/plupload.full.min.js"></script>
    <script src="${app.siteUrl}/js/qiniu.min.js"></script>
</#if>
<script src="${app.siteUrl}/${assets('js/jquery.validate.js', app.envs)}"></script>
<script src="${app.siteUrl}/${assets('js/messages_zh.js', app.envs)}"></script>
<script src="${app.siteUrl}/js/jquery.validate.bootstrap.js"></script>
<script src="${app.siteUrl}/js/zh_CN.js"></script>
<script type="text/javascript">

    var categoryId = ${item.categoryId};

    if ($('.item-image-box').length <= 3 ) {
        $("#uploadBtn").show();
    }

    // 自动选中 当前 item 的分类
    $(".category-select option").each(function (index, option) {
        if ( parseInt(option.value) === categoryId ) {
            $(".category-select").val(parseInt(option.value))
        }
    })

    $("#delete").on("click", function () {
        if ( confirm("确认删除 `${item.itemName}` 吗?") ) {
            // $.ajax('/')
        }
    })

    $("#itemEditForm").validate({
        submitHandler: function(form) {
            //https://github.com/marioizquierdo/jquery.serializeJSON
            var formData =  $(form).serializeJSON()
            formData.productPrice *= 100
            formData.discountPrice *= 100
            formData.filekeys = formData.filekeys || []
            formData.coverImages = formData.filekeys.join(":")
            formData.id = ${item.id}
            formData.corpId = ${item.corpId}

            $.ajax("/items/${item.id}", {
                type: "PUT",
                contentType: "application/json",
                data: JSON.stringify(formData)
            }).success(function(){
                alert("保存成功！")
            }).fail(function(){
                alert("保存失败！")
            })
        },
        ignore: "*:not([name])",
        rules: {
            '[name=itemName]': 'required',
            productPrice: {
                required: true,
                min: 0.01
            },
            discountPrice: {
                required: true,
                min: 0.01
            }
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
    });

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
        //log_level: 5,
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
                $('.image-list').append($('<div class="item-image-box">' +
                        '<input type="hidden" name="filekeys[]" value="'+ fileKey +'">'+
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