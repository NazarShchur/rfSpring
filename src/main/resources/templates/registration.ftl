<#import "parts/login.ftl" as l>
<#import "/spring.ftl" as spring/>
<#import "parts/unsheader.ftl" as c>
<@c.page>
    <h1><@spring.message "registration"/></h1>
<@l.login"/registration"></@l.login>
</@c.page>
