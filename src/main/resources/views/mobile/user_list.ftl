
<#list userList as user>
    <h3><#if user.nickName??>${user.nickName}<#else>无名</#if></h3>
</#list>