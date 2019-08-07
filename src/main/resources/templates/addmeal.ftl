<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<@w.wrapp>
    <#if foods?has_content>
        <h1 class="col-lg-12"><@spring.message "new.meal"/></h1>
        <h2 class="col-lg-12"><@spring.message "new.meal.text"/></h2>
        <#if error?has_content>
            <h2 class="error">${error}</h2>
        </#if>
        <div class="col-lg-12">
        <form class="add_food_to_meal" action="/userpage/addmeal" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <select name="foodName">
                <option selected disabled><@spring.message "select.food"/></option>
                <#list foods as food>
                    <option value="${food.foodName}">${food.foodName}</option>
                </#list>
            </select>
            <input type="number" min="1" max="10000" name="count" required><br>
            <input class="custom_submit" type="submit" value="<@spring.message "add"/>">
        </form>
        </div>
    </#if>
    <#if isFoodInMap>
        <div class="col-lg-12">
        <form action="/userpage/addmeal/delete" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <table class="table-bordered mealtable">
                <tr>
                    <td><@spring.message "food.name"/></td>
                    <td><@spring.message "food.count"/></td>
                    <td><@spring.message "food.action"/></td>
                </tr>
               <#list currentMap.map as food, count>
                    <tr>
                        <td>
                           ${food.foodName}
                        </td>
                        <td>
                            ${count}
                        </td>
                        <td>
                            <button class="custom_submit" type="submit" name="foodName" value="${food.foodName}">
                            <@spring.message "delete.food.from.meal"/>
                            </button>
                        </td>
                    </tr>
                </#list>
                <tr>
                    <td><@spring.message "total.calories"/></td>
                    <td>${currentMap.calories}</td>
                </tr>
            </table>
        </form>
        <form class="col-lg-12" action="/userpage/addmeal/saveMeal" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <label><@spring.message "meal.description"/><input type="text" maxlength="50" name="description"></label>
            <input type="submit" class="custom_submit" value="<@spring.message "add.meal"/>">
        </form>
    </div>
    </#if>
</@w.wrapp>