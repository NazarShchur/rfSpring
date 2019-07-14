<#import "parts/header.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
    <#if meals?has_content>

        <#list meals as meal>
            <table>
                <tr>
                    <td>
                        Description
                    </td>
                    <td>
                        ${meal.getDescription()}
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
                </tr>
                <#list meal.getFood() as food>
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
                    </tr>
                </#list>
            </table>
        </#list>
    <#else>
        <h1>You don`t have any meals yet</h1>
    </#if>

</@c.page>