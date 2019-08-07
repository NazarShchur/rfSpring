<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<#import "parts/unsheader.ftl" as c>
<@w.wrapp>
    <h1 class="col-lg-12 text-center"><@spring.message "registration"/></h1>
    <form class="col-lg-12 regform" action="/registration" method="post">

        <label class="row">
            <span class="col-lg-3"><@spring.message "login"/></span>
            <div class="col-lg-9">
                <#if nulogin??>
            <p><@spring.message "login.occupied"/></p>
                </#if>
            <#if loginerr?has_content>
                <p><@spring.message "login.regex.err}"/></p>
            </#if>
            <input type="text" name="username" required>
            </div>
        </label>

        <label class="row">
            <span class="col-lg-3"><@spring.message "password"/></span>
            <div class="col-lg-9">
<#--                <c:if test="${param.checkPassword == false}">-->
<#--                    <p><fmt:message key="password.regex.err"/></p>-->
<#--                </c:if>-->
                <input type="password" name="password" required>
            </div>
        </label>


        <label class="row">
            <span class="col-lg-3"><@spring.message "age"/></span>
            <div class="col-lg-9">
<#--                <c:if test="${param.checkAge == false}">-->
<#--                    <p><fmt:message key="age.err"/></p>-->
<#--                </c:if>-->
                <input type="number" name="age" required min="1" max="120">
            </div>
        </label>


        <label class="row">
            <span class="col-lg-3"><@spring.message "weight"/></span>
            <div class="col-lg-9">
<#--                <c:if test="${param.checkWeight == false}">-->
<#--                    <p><fmt:message key="weight.err"/></p>-->
<#--                </c:if>-->
                <input type="number" name="weight" required min="6" max="600">
            </div>
        </label>

        <label class="row">
            <span class="col-lg-3"><@spring.message "height"/></span>
            <div class="col-lg-9">
<#--                <c:if test="${param.checkHeight == false}">-->
<#--                    <p><fmt:message key="height.err"/></p>-->
<#--                </c:if>-->
                <input type="number" name="height"  required min="40" max="250">
            </div>
        </label>
        <label class="row">
            <span class="col-lg-3"><@spring.message "gender"/></span>
            <div class="col-lg-9">
                <select name="sex" required>
                    <option value="Man" selected><@spring.message "Man"/></option>
                    <option value="Woman"><@spring.message "Woman"/></option>

                </select>
            </div>
        </label>
        <label class="row">
            <span class="col-lg-3"><@spring.message "lifestyle"/></span>
            <div class="col-lg-9">
                <select name="lifeStyle" required>
                    <option value="VeryLowActivity" selected><@spring.message "VeryLowActivity"/></option>
                    <option value="LowActivity"><@spring.message "LowActivity"/></option>
                    <option value="NormalActivity"><@spring.message "NormalActivity"/></option>
                    <option value="HighActivity"><@spring.message "HighActivity"/></option>
                    <option value="VeryHighActivity"><@spring.message "VeryHighActivity"/></option>
                </select>
            </div>
        </label>
        <label class="col-lg-8"><input type="submit" value="<@spring.message "register"/>"></label>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    </form>
</@w.wrapp>
