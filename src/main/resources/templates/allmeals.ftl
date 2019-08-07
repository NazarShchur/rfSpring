<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<#import "parts/page.ftl" as p/>
<@w.wrapp>
    <#if page??>
        <h1 class="col-lg-12"><@spring.message "all.meal"/></h1>
<@p.pager url, page/>
        <#list page.content as meal>
            <div class="col-lg-12 align-content-center">
            <table class="table-bordered mealtable">
                <tr>
                    <td>
                        <@spring.message "meal.description"/>
                    </td>
                    <td>
                        ${meal.getDescription()} ${meal.getAddTime()}
                    </td>
                </tr>
                <tr>
                    <td>
                        <@spring.message "food.name"/>
                    </td>
                    <td>
                        <@spring.message "food.fats"/>
                    </td>
                    <td>
                        <@spring.message "food.carbohydrates"/>
                    </td>
                    <td>
                        <@spring.message "food.proteins"/>
                    </td>
                    <td>
                        <@spring.message "food.count"/>
                    </td>
                </tr>
                <#list meal.getFoodCount() as food, count>
                    <tr>
                        <td>
                            ${food.getFoodName()}
                        </td>
                        <td>
                            ${food.getFats()}
                        </td>
                        <td>
                            ${food.getProtein()}
                        </td>
                        <td>
                            ${food.getCarbohydrate()}
                        </td>
                        <td>
                            ${count}
                        </td>
                    </tr>
                </#list>
                <tr>
                    <td>
                        <@spring.message "total.calories"/>
                    </td>
                    <td>
                        ${meal.getAllCalories()}
                    </td>
                </tr>
            </table>
            <br>
            </div>
        </#list>
<@p.pager url, page/>
    </#if>

</@w.wrapp>