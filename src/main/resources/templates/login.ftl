<#import "parts/login.ftl" as l>
<#import "parts/unsheader.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page>
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
                    <#if nulogin?has_content>
                        <div class="mess" ><@spring.message "${nulogin!}"/></div>
                    </#if>

                    <#if loginerr?has_content>
                        <div class="mess" ><@spring.message "${loginerr!}"/></div>
                    </#if>
                    <label><h3><@spring.message "login"/></h3><input type="text" name="username"/></label>
                </div>
                <div class="col-lg-12 inputf">
                    <#if passerr?has_content>
                        <div class="mess" ><@spring.message "${passerr!}"/></div>
                    </#if>
                    <label><h3><@spring.message "password"/></h3><input type="password" name="password"/></label>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="submit" class="col-lg-6 offset-3" value="<@spring.message "submit"/>"/></div>
        </div>
    </form>
    <h2><@spring.message "dont.have.acc"/><a href="/registration"> <@spring.message "registration"/></a> </h2>
</@c.page>

