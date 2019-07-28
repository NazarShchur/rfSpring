<#import "/spring.ftl" as spring/>
<#macro page>
<div class="myheader">
    <div class="row">
        <a href="/" class="col-lg-2 logo">Calories</a>
        <a href="/login" class="col-lg-2"><@spring.message "login"/></a>
        <a href="/registration" class="col-lg-2"><@spring.message "registration"/></a>
        <div class="col-lg-2 offset-4">
            <a href="?lang=en">ENG</a>
            <a href="?lang=ua">UA</a>
        </div>
    </div>
</div>
</#macro>