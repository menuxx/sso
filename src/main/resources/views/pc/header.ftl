<#include "../utils.ftl" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="description" content="菜单加工具集合">
    <meta name="keywords" content="Menuxx,菜单加,菜单加工具集合">
    <link href="${app.siteUrl}/${assets('css/bootstrap.css', app.envs)}" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="${app.siteUrl}/${assets('js/jquery.js', app.envs)}"></script>
    <script src="${app.siteUrl}/${assets('js/vue.js', app.envs)}"></script>
    <link href="${app.siteUrl}/jquery.toast/jquery.toast.min.css" rel="stylesheet">
    <script src="${app.siteUrl}/jquery.toast/jquery.toast.min.js"></script>
    <style type="text/css">
        body {
            padding-top: 60px;
        }
    </style>
    <script type="text/javascript">
        var cndUrl = '${app.cdnUrl}';
    </script>