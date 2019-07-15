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
<#--    <h1>Age: ${user.getAge()}</h1>-->
    <h1><@spring.message "see.all.users"/><a href="/user/allusers"> <@spring.message "here"/> </a></h1>
    <h1><a href = "/userpage/addmeal">Create Meal</a></h1>
    <h1><a href = "/userpage/addmeal/allmeals">See all meals</a></h1>
</@c.page>