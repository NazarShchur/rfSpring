<#import "parts/wrapp.ftl" as w>
<#import "parts/unsheader.ftl" as c>
<#import "/spring.ftl" as spring/>
<@w.wrapp>
    <h1><@spring.message "login"/></h1>
    <#if error>
        <div class="mess"><@spring.message "error"/></div>
    </#if>
    <#if logout>
        <div class="mess"><@spring.message "logged.out"/></div>
    </#if>
    <form action="/login" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 inputf">



                    <label><h3><@spring.message "login"/></h3><input type="text" name="username"/></label>
                </div>
                <div class="col-lg-12 inputf">

                    <label><h3><@spring.message "password"/></h3><input type="password" name="password"/></label>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="submit" class="col-lg-6 offset-3" value="<@spring.message "log.in"/>"/></div>
        </div>
    </form>
</@w.wrapp>

