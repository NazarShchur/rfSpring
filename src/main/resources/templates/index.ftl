<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<@w.wrapp>
    <h1 class="col-lg-12"><@spring.message "main"/></h1>
    <div class="col-lg-6 text-center main_info border-bottom">
        <img src="/img/img1.png" alt="img1"><br>
        <img src="/img/img2.png" alt="img2">
    </div>
    <div class="col-lg-6 text-left main_info border-bottom">
        <h3><@spring.message "main.info.1"/></h3>
    </div>
    <div class="col-lg-6 text-center main_info border-bottom">
        <img src="/img/img3.png" alt="img3"><br>
    </div>
    <div class="col-lg-6 text-left main_info border-bottom">
        <h3><@spring.message "main.info.2"/></h3>
    </div>
    <div class="col-lg-6 text-center main_info ">
        <img src="/img/img4.png" alt="img4"><br>
        <img src="/img/img5.png" alt="img5">
    </div>
    <div class="col-lg-6 text-left main_info">
        <h3><@spring.message "main.info.3"/> </h3>
    </div>

</@w.wrapp>
