<#import "parts/login.ftl" as l>
<#import "parts/common.ftl" as c>

<@c.page>
Add new user
    ${message!}
<@l.login"/registration"></@l.login>
</@c.page>
