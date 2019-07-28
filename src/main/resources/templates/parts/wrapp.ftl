<#import "footer.ftl" as f>
<#import "header.ftl" as h>
<#import "unsheader.ftl" as uh>

<#macro wrapp>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
</head>
<body>

<#if Session.SPRING_SECURITY_CONTEXT??>
    <@h.page/>
    <#else>
    <@uh.page/>
</#if>
<div class="container wrapp">
    <div class="row">
        <#nested>
    </div>
</div>
<@f.footer/>
</body>
</html>
</#macro>