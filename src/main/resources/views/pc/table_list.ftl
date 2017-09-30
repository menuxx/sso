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
</style>

</head>

<body>

<div class="container">
    <a class="btn btn-link" id="downAllQrcode">下载所有二维码</a>
    <div class="row">
    <#list tables as table>
        <div class="col-md-2" data-tableid="${table.id?string('0')}">
            <div class="thumbnail">
                <img width="200" height="200" src="/image/yth_qrcode.jpeg" alt="桌号二维码">
                <div class="caption">
                    <h5 class="name">${table.tableName}</h5>
                    <div class="btn-group">
                        <a class="btn btn-info btn-sm" role="button">显示桌码</a>
                        <a class="btn btn-danger btn-sm" role="button">删除</a>
                    </div>
                </div>
            </div>
        </div>
    </#list>
        <div class="col-md-2">
            <div class="thumbnail">
                <img width="200" height="200" src="/image/yth_qrcode.jpeg" alt="桌号二维码">
                <div class="caption">
                    <div class="new-table">
                        <input type="text" class="form-control input-sm" placeholder="输入桌子名称">
                    </div>
                    <p>
                        <a class="btn btn-block btn-primary input-sm" role="button">创建</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $("#downAllQrcode").on('click', function () {

    })
</script>

<#include "./footer.ftl" />