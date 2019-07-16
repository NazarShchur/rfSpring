<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <h1>Unconfirmed Foods</h1>
    <table>
        <tr>
            <td>FoodName</td>
            <td>Proteins</td>
            <td>Fats</td>
            <td>Carbohydrate</td>
        </tr>
        <#list foods as food>
            <tr>
            <td>${food.foodName}</td>
            <td>${food.protein}</td>
            <td>${food.fats}</td>
            <td>${food.carbohydrate}</td>
            <form action="/admin/foods/confirm" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="id" value="${food.id}">
                <td><button type="submit" name="confirm" value="true">Confirm</button></td>
                <td><button type="submit" name="confirm" value="false">Reject</button></td>
            </form>
            </tr>
        </#list>
    </table>
</@c.page>