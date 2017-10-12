<#include "./header.ftl" />
<#setting number_format="000">
<script src="/js/rasterizeHTML.allinone.js" type="text/javascript"></script>
<script src="/js/jszip.js" type="text/javascript"></script>
<script src="/js/jszip-utils.js" type="text/javascript"></script>
<script src="/js/FileSaver.js" type="text/javascript"></script>
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
    .table-li{
        min-height: 272px;
    }
</style>
</head>
<body>
<div class="container">
    <a class="btn btn-link" id="downAllQrcode">下载所有二维码</a>
    <div class="row table-list">
        <#list tables as table>
        <div class="col-md-2 table-li" data-tableid="${table.id?string('0')}">
            <div class="thumbnail">
                <img class="qrcode-image" width="200" height="200" src="/image/yth_qrcode.jpeg" alt="桌号二维码">
                <div class="caption">
                    <h5 class="name">${table.tableName}</h5>
                    <div class="btn-group">
                        <a class="btn btn-info btn-sm table-code" role="button">显示桌码</a>
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
    $("#downAllQrcode").on('click', function () {
    })

    $("#create").on('click', function () {
        var tableNumber = $.trim($("#tableNumber").val());
        if (tableNumber === null || tableNumber.length === 0){
            alert("请输入桌子名称！");
            return
        }
        var self = this
        setTimeout(function () {
            var table = {
                id:10,
                tableName: 'tableName',
            }

            $(self).parents(".table-li").before($('<div class="col-md-2 table-li" data-tableid= ' + table.id + ' >'+
                    '<div class="thumbnail">' +
                    '<img class="qrcode-image" width="200" height="200" src="/image/yth_qrcode.jpeg" alt="桌号二维码">' +
                    '<div class="caption">' +
                    '<h5 class="name"> '+ table.tableName + '</h5>' +
                    '<div class="btn-group">' +
                    '<a class="btn btn-info btn-sm table-code" role="button">显示桌码</a>' +
                    '<a class="btn btn-danger btn-sm remove" role="button">删除</a>' +
                    '</div>' +'</div>' + '</div>' + '</div>'
            ));

        }, 50)
    });

    $(".table-list").delegate('.table-code', 'click', function(){
        $(this).parents(".thumbnail").find(".qrcode-image").attr("src", "/image/1.jpg")

    });

    $(".table-list").delegate('.remove', 'click', function() {
        $(this).parents(".table-li").remove()
    });



</script>

<#include "./footer.ftl" />