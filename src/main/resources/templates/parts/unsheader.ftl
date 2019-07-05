<#import "/spring.ftl" as spring/>
<#macro page>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>qwe</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <link rel="stylesheet" type="text/css"  href="/static/css/bootstrap-grid.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<#--        <script type="text/javascript">-->
<#--            $(document).ready(function() {-->
<#--                $("#locales").change(function () {-->
<#--                    var selectedOption = $('#locales').val();-->
<#--                    if (selectedOption !== ''){-->
<#--                        window.location.replace('locale?lang=' + selectedOption);-->
<#--                    }-->
<#--                });-->
<#--            });-->
<#--        </script>-->
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
    </style>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">Main Page</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/registration"><@spring.message "registration"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login"><@spring.message "login"/></a>
                </li>
            </ul>
        </div>

            <a href="@{locale?lang=eng}"><@spring.message "lang.eng"/></a>
            <a href="@{locale?lang=ua}"><@spring.message "lang.ukr"/></a>

    </nav>
    <#nested>
    </body>
    </html>
</#macro>