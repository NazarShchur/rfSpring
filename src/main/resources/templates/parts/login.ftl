<#macro login path>

    <form action="${path}" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 inputf">
                    <div class="mess" >${nulogin!}</div>
                    <div class="mess" >${loginerr!}</div>
                    <label><h3>Login</h3><input type="text" name="username"/></label>
                </div>
                <div class="col-lg-12 inputf">
                    <div class="mess" >${passerr!}</div>
                    <label><h3>Password</h3><input type="password" name="password"/></label>
                </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
         <input type="submit" class="col-lg-6 offset-3" value="Submit"/></div>
        </div>
    </form>
</#macro>
<#macro logout>
    <form action="/logout" method="post">
        <input type="submit" style="margin-top: 40px" value="Log Out"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</#macro>