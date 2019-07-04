<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h1>Hello, ${username} </h1>
    <h1>Se all users <a href="/user/allusers"> here </a></h1>
    <@l.logout/>
</@c.page>