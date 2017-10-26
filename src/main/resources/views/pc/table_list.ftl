<#include "./header.ftl" />
<script src="/js/rasterizeHTML.allinone.js" type="text/javascript"></script>
<script src="/js/jszip.js" type="text/javascript"></script>
<script src="/js/jszip-utils.js" type="text/javascript"></script>
<script src="/js/FileSaver.js" type="text/javascript"></script>
<script src="/js/scale.min.js" type="text/javascript"></script>
<style type="text/css">
    .thumbnail .caption {
        padding: 0 15px;
    }
    .thumbnail .name {
        text-align: center;
    }
    .new-table {
        margin-bottom: 5px;
    }
    .table-li {
        min-height: 272px;
    }
    .table-card {
        display: none;
    }
    .label-jump-gen-table-code {
        display: none;
    }
</style>
</head>
<body>
<canvas style="position: absolute; left: -1000px; top: -1000px;" id="toDataUrl"></canvas>
<div class="container">
    <a class="btn btn-link" id="downAllQrcode">生成并下载所有桌贴    (${shop.shopName}_的桌码.zip)</a>
    <div class="table-card">
        <div class="table-card-progress progress">
            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                <span class="sr-only">第%s张</span>
            </div>
        </div>
        <div class="well" style="text-align: center">
            <canvas id="tableCardTpl" width="1000" height="607"></canvas>
            <#--<img src="/table-card-01.png" width="1654" height="1004" alt="">-->
        </div>
    </div>
    <div class="row table-list">
        <#list tables as table>
        <div class="col-md-2 table-li" data-tableid="${table.id?string('0')}">
            <div class="thumbnail">
                <h5 class="text-center">#(${table?index + 1})</h5>
                <img class="qrcode-image" width="200" height="200" src="<#if table.wxQrcodeUrl??>${app.cdnUrl}/${table.wxQrcodeUrl}<#else>/image/yth_qrcode.jpeg</#if>" alt="桌号二维码">
                <div class="caption">
                    <h5 class="name">
                        ${table.tableName}<span class="label label-warning label-jump-gen-table-code">跳过生成</span>
                    </h5>
                    <div class="btn-group">
                        <a class="btn btn-info btn-sm table-code" role="button">生成桌码</a>
                        <a class="btn btn-danger btn-sm remove" role="button">删除</a>
                    </div>
                </div>
            </div>
        </div>
        </#list>
        <div class="col-md-2 table-li">
            <div class="thumbnail">
                <img  width="200" height="200" src="/image/yth_qrcode.jpeg" alt="桌号二维码">
                <div class="caption">
                    <div class="new-table">
                        <input id="tableNumber" name="tableNumber" value="" type="text" class="form-control input-sm" placeholder="输入桌子名称">
                    </div>
                    <p>
                        <a id="create" class="btn btn-block btn-primary input-sm" role="button">创建</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    var loadImage = function (url, callback) {
        var img = new Image()
        img.src = url
        img.crossOrigin = 'Anonymous'
        img.onload = function () {
            callback(img)
        }
    }

    var drawTableCode = function (table, logoUrl, cb) {
        var canvasEl = document.getElementById("tableCardTpl")
        var ctx = canvasEl.getContext("2d")
        var tplBgImg = new Image()
        tplBgImg.src = "/image/WechatIMG1688.png"
        tplBgImg.crossOrigin = 'Anonymous'
        tplBgImg.onload = function () {
            ctx.drawImage(tplBgImg, 0, 0, 1000, 607)
            ctx.font = "48px arial"
            ctx.fillStyle = "#F6A61E"
            ctx.fillText(table.tableName, 860, 90)
            // draw logo
            loadImage(logoUrl, function (logoImg1) {
                // top logo
                ctx.drawImage(logoImg1, 610, 44, 230, 60)
                // bottom logo
                ctx.drawImage(logoImg1, 700, 535, 230, 60)
                // qrcode
                loadImage(table.wxQrcodeUrl, function (qrcodeImage) {
                    ctx.drawImage(qrcodeImage, 105, 140, 290, 330)
                    try {
                        cb(table, canvasEl.toDataURL("image/png"))
                    } catch (e) {
                        $.toast({
                            heading: '桌贴生成遇到故障，请排除...',
                            text: e.message,
                            showHideTransition: 'slide',
                            icon: 'fail',
                            hideAfter: 5000
                        });
                    }
                })
            })

        }
    }

    $("#downAllQrcode").on('click', function () {

        $(".table-card").slideDown(600)

        var zip = new JSZip();
        zip.file("注意事项.txt", "每张桌码尺寸 1000 像素 x 607 像素(宽 x 高)");
        var img = zip.folder("桌码图片");

        $.ajax("/tables/").success(function (res) {
            var rowTables = res.data
            var workIndex = 0
            var jumpCount = 0
            var tables = rowTables.map(function (table) {
                if ( table.wxQrcodeUrl ) {
                    table.wxQrcodeUrl = cndUrl + '/' + table.wxQrcodeUrl + '?imageView2/2/m/2/w/290/h/330'
                    return table
                } else {
                    $('.table-li[data-tableid='+ table.id + '] .label-jump-gen-table-code').show()
                    jumpCount ++
                    return null
                }
            }).filter(function (item) { return item !== null })

            function doWork() {
                drawTableCode(tables[workIndex], "/image/WechatIMG1687.png", function (table, dataUrl) {
                    workIndex++
                    img.file(table.tableName + '_1000x607.png', dataUrl.replace("data:image/png;base64,", ''), {base64: true});
                    if (workIndex < tables.length) {
                        doWork()
                        // 进度条
                        $('.table-card-progress.progress .progress-bar').css({ width: ((workIndex + 1) / tables.length) * 100 + '%' })
                    } else {
                        $(".table-card").slideUp(600)
                        zip.generateAsync({ type: "blob" })
                                .then(function(content) {
                                    // see FileSaver.js
                                    saveAs(content, "${shop.shopName}_的桌码.zip");
                                });
                        $.toast({
                            heading: '桌贴生成完毕，已经下载到您的电脑...',
                            text: rowTables.length + '个桌子，其中'+ jumpCount +'个不满足需求跳过, 共生成了' + workIndex + '个桌贴',
                            showHideTransition: 'slide',
                            icon: 'success',
                            hideAfter: 5000
                        });
                    }
                })
            }
            doWork()
        })

    })

    $("#create").on('click', function () {
        var self = this
        var tableName = $.trim($("#tableNumber").val());
        if ( tableName === null || tableName.length === 0 ) {
            alert("请输入桌子名称！");
            return
        }
        $.ajax("/tables/", {
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({tableName: tableName})
        }).success(function (table) {
            $(self).parents(".table-li").before($('<div class="col-md-2 table-li" data-tableid= ' + table.id + ' >'+
                    '<div class="thumbnail">' +
                    '<img class="qrcode-image" width="200" height="200" src="/image/yth_qrcode.jpeg" alt="桌号二维码">' +
                    '<div class="caption">' +
                    '<h5 class="name"> '+ table.tableName + '</h5>' +
                    '<div class="btn-group">' +
                    '<a class="btn btn-info btn-sm table-code" role="button">生成桌码</a>' +
                    '<a class="btn btn-danger btn-sm remove" role="button">删除</a>' +
                    '</div>' +'</div>' + '</div>' + '</div>'
            ));
        })
    });

    $(".table-list").delegate('.table-code', 'click', function() {
        $.toast({
            heading: '生成中...',
            text: '请稍后，大概需要几秒钟',
            showHideTransition: 'slide',
            icon: 'success',
            hideAfter: 1000
        });
        var tableid = $(this).parents(".table-li").data('tableid')
        var self = this
        // 1. 店铺码
        // 2. 桌码
        // 3. 付款码
        // 4. 平台码
        $.ajax("/tables/createwxqrcode", {
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify({ tableId: tableid, codeType: 2 })
        }).success(function (data) {
            $.toast({
                heading: '生成完毕',
                text: '桌码ID: ' + tableid,
                showHideTransition: 'slide',
                icon: 'success',
                hideAfter: 1000
            });
            $(self).parents(".thumbnail").find(".qrcode-image").attr("src", "${app.cdnUrl}/" + data.data.fileKey)
        })
    });

    $(".table-list").delegate('.remove', 'click', function() {
        var li = $(this).parents(".table-li")
        var tableId = li.data('tableid')
        $.ajax("/tables/" + tableId, { type: 'PUT' }).success(function (res) {
            li.remove()
        })
    });



</script>

<#include "./footer.ftl" />