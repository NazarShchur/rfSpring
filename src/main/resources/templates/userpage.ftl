<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <p>Hello, User</p>
    <p>Se all users <a href="/user/allusers"> here </a></p>
    <@l.logout/>
</@c.page>