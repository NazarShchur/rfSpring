<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <table>
        <tr>
            <td>Id</td>
            <td>Username</td>
            <td>Password</td>
        </tr>
        <#list users as user>

        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>

        </#list>
    </table>
</@c.page>