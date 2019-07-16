<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <#if saved?has_content>
        <h1>${saved}</h1>
        <h1><a href="/userpage/addfood">Add more food</a> </h1>
        <h1><a href="/userpage/addmeal">Add meal</a></h1>
        <#else>
            <h1>Add Food</h1>
            <#if error?has_content>
                <h2>${error}</h2>
            </#if>
            <form action="/userpage/addfood" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <label>FoodName<input type="text" name="foodName" required></label>
                <label>Fats<input type="number" min="0" name="fats" step="any" required></label>
                <label>Proteins<input type="number" min="0" name="protein" step="any" required></label>
                <label>Carbohydrates<input type="number" min="0" name="carbohydrate" step="any" required></label>
                <input type="submit" value="add">
            </form>
    </#if>

</@c.page>