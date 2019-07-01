<#import "parts/login.ftl" as l>
<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Login Page</h1>
    <@l.login"/login"></@l.login>
    <h2>Dont have account? <a href="/registration">Register</a> </h2>
</@c.page>

