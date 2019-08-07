<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<@w.wrapp>
    <h1 class="col-lg-12 text-center">
        <@spring.message "add.food"/>
    </h1>
    <#if error??>
        <h2 class="col-lg-12 text-center"><@spring.message "unacceptableData"/></h2>
    </#if>
    <#if added??>
        <h2 class="col-lg-12 text-center"><@spring.message "food.added"/></h2>
    </#if>
    <form class="col-lg-12 addfood_f" method="post" action="/userpage/addfood">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <label>
            <input type="text" maxlength="30" placeholder="<@spring.message "food.name"/>" name="foodName" required>
        </label><br>
        <label>
            <input type="number" placeholder="<@spring.message "food.proteins"/>" name="protein" required>
        </label><br>
        <label>
            <input type="number" placeholder="<@spring.message "food.fats"/>" name="fats" required>
        </label><br>
        <label>
            <input type="number" placeholder="<@spring.message "food.carbohydrates"/>" name="carbohydrate" required>
        </label><br>
        <label>
            <button class="custom_submit" type="submit">
                <@spring.message "add"/>
            </button>
        </label>
    </form>
</@w.wrapp>