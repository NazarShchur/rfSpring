<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<@w.wrapp>
    <h1 class="col-lg-12 text-center">
        <@spring.message "food.added.by.users"/>
    </h1>
    <table class="table-bordered">
        <tr>
            <td><@spring.message "food.name"/></td>
            <td><@spring.message "food.proteins"/></td>
            <td><@spring.message "food.fats"/></td>
            <td><@spring.message "food.carbohydrates"/></td>
            <td><@spring.message "food.user.id"/></td>
            <td><@spring.message "food.action"/></td>

        </tr>
        <#list usersFood as food>
            <tr>
                <td>${food.foodName}</td>
                <td>${food.protein}</td>
                <td>${food.fats}</td>
                <td>${food.carbohydrate}</td>
                <td>${food.user.id}</td>
                <td>
                    <form action="/admin/publicFood" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button type="submit" name="foodID" value="${food.id}">
                            <@spring.message "food.make.public"/>
                        </button>
                    </form>
                </td>
            </tr>
        </#list>
    </table>
</@w.wrapp>