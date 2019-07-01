<#import "parts/login.ftl" as l>
<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Registration page</h1>
    <div class="mess" >${message!}</div>
<@l.login"/registration"></@l.login>
</@c.page>
