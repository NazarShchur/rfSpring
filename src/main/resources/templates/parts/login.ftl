<#import "/spring.ftl" as spring/>
<#macro login path>
    <form action="${path}" method="post">
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
</#macro>
<#macro logout>
    <form action="/logout" method="post">
        <input type="submit" value="<@spring.message "logout"/>"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</#macro>