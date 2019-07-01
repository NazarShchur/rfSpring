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
        h1{
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
        <a class="navbar-brand" href="/userpage">My Page</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
    <#nested>
    </body>
    </html>
</#macro>