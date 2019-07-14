<#import "parts/login.ftl" as l>
<#import "parts/unsheader.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <h1><@spring.message "login"/></h1>
    <#if error>
        <div class="mess"><@spring.message "error"/></div>
    </#if>
    <#if logout>
        <div class="mess"><@spring.message "logged.out"/></div>
    </#if>
    <@l.login"/login"></@l.login>
    <h2><@spring.message "dont.have.acc"/><a href="/registration"> <@spring.message "registration"/></a> </h2>
</@c.page>

