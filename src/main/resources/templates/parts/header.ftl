<#import "/spring.ftl" as spring/>
<#import "login.ftl" as l>
<#macro page>
    <div class="myheader">
        <div class="row">
            <a href="/" class="col-lg-2 logo">Calories</a>
            <a href="/userpage" class="col-lg-2">user</a>
            <div class="col-lg-2 offset-4">
                <form method="post" action="/logout">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="<@spring.message "logout"/>">
                </form>
            </div>
            <div class="col-lg-2">
                <a href="?lang=en">ENG</a>
                <a href="?lang=ua">UA</a>
            </div>
        </div>
    </div>
</#macro>