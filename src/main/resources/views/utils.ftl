<#function assets url envs>
    <#if envs?seq_contains('production') || envs?seq_contains('test')>
        <#-- min -->
        <#if url?ends_with('.js')>
            <#return url?remove_ending(".js") + '.min.js'/>
        </#if>
        <#if url?ends_with('.css')>
            <#return url?remove_ending(".css") + '.min.css'/>
        </#if>
        <#else><#return url/>
    </#if>
</#function>

<#function defaultVal is val _default>
    <#if is>
        <#return val/>
    <#else>
        <#return _default/>
    </#if>
</#function>