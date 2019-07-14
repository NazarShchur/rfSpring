<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <#if foods?has_content>
        <h1>What did you eat?</h1>
        <#if error?has_content>
            <h2 class="error">${error}</h2>
        </#if>
        <#list foods as food>
            <form action="/userpage/addmeal" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <label><input type="submit" name="foodName" value="${food.foodName}"></label>
                <#--            <label><input type="number" required> count</label>-->
            </form>
        </#list>
        <form action="/userpage/addmeal/saveMeal" method="post">
            <label><input type="text" name ="description"required>Description</label>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <label><input type="submit" value="submit"></label>
        </form>
    </#if>

    <#if mealadded?has_content>
        <h1>${mealadded}</h1>
        <h1><a href = "/userpage/addmeal">Add new Meal</a></h1>
        <h1><a href = "/userpage/addmeal/allmeals">See all meals</a></h1>
    </#if>


</@c.page>