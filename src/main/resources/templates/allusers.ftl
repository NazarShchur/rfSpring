<#import "parts/wrapp.ftl" as w>
<#import "parts/login.ftl" as l>
<@w.wrapp>
    <table>
        <tr>
            <td>Id</td>
            <td>Username</td>
            <td>Password</td>
            <td>Age</td>
            <td>Weight</td>
            <td>Height</td>
            <td>Sex</td>
            <td>Lifestyle</td>
            <td>Daily Calories</td>
        </tr>
        <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>${user.weight}</td>
            <td>${user.height}</td>
            <td>${user.sex}</td>
            <td>${user.lifeStyle}</td>
            <td>${user.dailyCalories}</td>
        </tr>

        </#list>
    </table>
</@w.wrapp>