<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <h1><@spring.message "hello"/>, ${username} </h1>
    <h1><@spring.message "see.all.users"/><a href="/user/allusers"> <@spring.message "here"/> </a></h1>
    <h1><a href = "/userpage/addmeal">Create Meal</a></h1>
    <h1><a href = "/userpage/addmeal/allmeals">See all meals</a></h1>
</@c.page>