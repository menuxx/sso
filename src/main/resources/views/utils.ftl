<#function assets url envs>
    <#if envs?seq_contains('production') || envs?seq_contains('test') || envs?seq_contains('development')>
        <#-- min -->
        <#if url?ends_with('.js')>
            <#return url?remove_ending(".js") + '.min.js'/>
        </#if>
        <#if url?ends_with('.css')>
            <#return url?remove_ending(".css") + '.min.css'/>
        </#if>
    </#if>
</#function>

<#function defaultUrl val prefix _defaultUrl>
    <#if val??>
        <#return prefix + val/>
    <#else>
        <#return _defaultUrl/>
    </#if>
</#function>