<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <h1><@spring.message "hello"/>, ${user.getUsername()} </h1>
    <h1>Age: ${user.getAge()}</h1>
    <h1>Sex: ${user.getSex()}</h1>
    <h1>Weight: ${user.getWeight()}</h1>
    <h1>Height: ${user.getHeight()}</h1>
    <h1>Lifestyle: ${user.getLifeStyle()}</h1>
    <h1>Daily Calories: ${user.getDailyCalories()}</h1>
    <#if isLimitExceeded>
        <h1>You ate ${-limit} calories over your limit</h1>
        <#else>
        <h1>You can eat ${limit} calories today</h1>
    </#if>
    <#if isAdmin>
        <h1><a href="/admin">Admin panel</a></h1>
    </#if>
    <h1><a href = "/userpage/addmeal">Create Meal</a></h1>
    <h1><a href = "/userpage/addmeal/allmeals">See all meals</a></h1>
    <h1><a href="/userpage/addfood">Add Food</a></h1>
</@c.page>