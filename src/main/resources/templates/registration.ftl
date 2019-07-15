<#import "parts/login.ftl" as l>
<#import "/spring.ftl" as spring/>
<#import "parts/unsheader.ftl" as c>
<@c.page>
    <h1><@spring.message "registration"/></h1>
    <form action="/registration" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 inputf">
                    <#if nulogin?has_content>
                        <div class="mess" ><@spring.message "${nulogin!}"/></div>
                    </#if>

                    <#if loginerr?has_content>
                        <div class="mess" ><@spring.message "${loginerr!}"/></div>
                    </#if>
                    <label><h3><@spring.message "login"/></h3><input type="text" name="username" required/></label>
                </div>
                <div class="col-lg-12 inputf">
                    <#if passerr?has_content>
                        <div class="mess" ><@spring.message "${passerr!}"/></div>
                    </#if>
                    <label><h3><@spring.message "password"/></h3><input type="password" name="password" required/></label>
                </div>
                <div class="col-lg-12 inputf">
                    <label><h3>Age</h3><input type="number" name="age" required/></label>
                </div>
                <div class="col-lg-12 inputf">
                    <label><h3>Height</h3><input type="number" name="height" required/></label>
                </div>
                <div class="col-lg-12 inputf">
                    <label><h3>Weight</h3><input type="number" name="weight" required/></label>
                </div>
                <div class="col-lg-12 inputf">
                    <h3>Sex</h3>
                    <label><input type="radio" name="sex" value="Man" checked/>Man</label>
                    <label><input type="radio" name="sex" value="Woman"/>Woman</label>
                </div>
                <div class="col-lg-12 inputf">
                    <h3>Lifestyle</h3>
                    <label><input type="radio" name="lifeStyle" value="Sitting" checked/>Sitting</label>
                    <label><input type="radio" name="lifeStyle" value="LowActivity" />Low Activity</label>
                    <label><input type="radio" name="lifeStyle" value="NormalActivity" />Normal Activity</label>
                    <label><input type="radio" name="lifeStyle" value="HighActivity" />High Activity</label>
                    <label><input type="radio" name="lifeStyle" value="Sportsman"/>Sportsman</label>
                </div>


                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="submit" class="col-lg-6 offset-3" value="<@spring.message "submit"/>"/></div>
        </div>
    </form>
</@c.page>
