<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <h1>Admin Page</h1>
    <h1><@spring.message "see.all.users"/><a href="/admin/allusers"> <@spring.message "here"/> </a></h1>
    <h1><a href="/admin/foods">Confirm Foods</a></h1>
</@c.page>