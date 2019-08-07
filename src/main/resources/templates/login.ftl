<#import "parts/wrapp.ftl" as w>
<#import "parts/unsheader.ftl" as c>
<#import "/spring.ftl" as spring/>
<@w.wrapp>
    <h1 class="col-lg-12 text-center"><@spring.message "login"/></h1>
    <#if error>
        <p class="col-lg-12 text-center"><@spring.message "wrong.login.password"/></p>
    </#if>
    <form class="col-lg-12 text-center regform" method="post" action="/login">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <label class="row">
       <span class="col-lg-3">
           <@spring.message "login"/>
       </span>
            <div class="col-lg-9">
                <input type="text" name="username">
            </div>
        </label>
        <label class="row">
        <span class="col-lg-3">
            <@spring.message "password"/>
        </span>
            <div class="col-lg-9">
                <input type="password" name="password">
            </div>
        </label>
        <label class="col-lg-8">
            <input type="submit" value="<@spring.message "log.in"/>">
        </label>
    </form>
</@w.wrapp>

