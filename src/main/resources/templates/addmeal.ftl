<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <#if foods?has_content>
        <h1>What did you eat?</h1>
        <#if error?has_content>
            <h2 class="error">${error}</h2>
        </#if>
        <form action="/userpage/addmeal" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <select name="foodName">
                <option selected disabled>Select Food</option>
                <#list foods as food>
                    <option value="${food.foodName}">${food.foodName}</option>
                </#list>
            </select>
            <label>gramm<input type="number" min="100" name="count" required></label>
            <input type="submit" value="add">
        </form>
    </#if>
        <#if meal?has_content>
            <form action="/userpage/addmeal/saveMeal" method="post">
                <#list meal.getFoodCount() as food, count>
                    <P>${food.getFoodName()} - ${count}</P>
                </#list>
                <label><input type="text" name="description" required>Description</label>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <label><input type="submit" value="submit"></label>
            </form>
        </#if>

    <#if mealadded?has_content>
        <h1>${mealadded}</h1>
        <h1><a href="/userpage/addmeal">Add new Meal</a></h1>
        <h1><a href="/userpage/addmeal/allmeals">See all meals</a></h1>
    </#if>
    <h1><a href="/userpage/addfood">Add Food</a></h1>
</@c.page>