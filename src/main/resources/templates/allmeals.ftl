<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<#import "parts/page.ftl" as p/>
<@w.wrapp>
    <#if page?has_content>
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
                        FoodName
                    </td>
                    <td>
                        Food Fats
                    </td>
                    <td>
                        Food Carbohydrate
                    </td>
                    <td>
                        Food Protein
                    </td>
                    <td>
                        Count
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
                        Total Calories
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
    <#else>
        <h1>You don`t have any meals yet</h1>
    </#if>

</@w.wrapp>