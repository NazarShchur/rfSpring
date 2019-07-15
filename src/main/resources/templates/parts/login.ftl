<#import "/spring.ftl" as spring/>
<#macro logout>
    <form action="/logout" method="post">
        <input type="submit" value="<@spring.message "logout"/>"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</#macro>