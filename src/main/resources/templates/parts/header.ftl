<#import "/spring.ftl" as spring/>
<#import "login.ftl" as l>
<#macro page>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>qwe</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <link rel="stylesheet" type="text/css"  href="/static/css/bootstrap-grid.css">
    </head>
    <style>
        .row{
            text-align: center;
        }
        h1, h2{
            text-align: center;
        }
        input[type = submit]{
            width: 100px;
            height: 50px;
        }
        .mess{
            font-size: 20px;
            color: red;
            text-align: center;
        }
        td{
            border: 1px solid black;
            border-spacing: 0px;
            padding: 5px;
        }
        header{
            display: block;
            background-color: #138496;
        }
        .langc{
            float: right;
        }
        .langc a{
            display: inline-block;
            padding: 5px;
            text-decoration: none;
            color: white;
        }
        .logouth{
            float: right;
        }
        .mypage{
            text-decoration: none;
            color: white;
            padding-top: 10px;
            font-size: 24px;
        }
        .mypage:hover{
            background-color: #137DA1;
            color: white;
            text-decoration: none;
        }
</style>
    <header>
        <div class="container">
            <div class="row">
                <a class="col-lg-3 mypage" href="/userpage">MyPage</a>
                <div class="langc col-lg-2 offset-5">
                    <a href="?lang=ua"><@spring.message "lang.ukr"/></a>
                    <a href="?lang=eng"><@spring.message "lang.eng"/></a>
                </div>
                <div class="logouth col-lg-2"> <@l.logout/></div>
            </div>
        </div>
    </header>
    <#nested>
    </html>
</#macro>