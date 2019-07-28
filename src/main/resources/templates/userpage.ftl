<#import "parts/wrapp.ftl" as w>
<#import "/spring.ftl" as spring/>
<@w.wrapp>
    <div class="col-lg-12">
        <h1 class="uname"> ${user.getUsername()}</h1>
        <#if isAdmin>
            <h1>
                <a href="/admin">
                    <@spring.message "admin.page"/>
                </a>
            </h1>
        </#if>
    </div>
    <div class="col-lg-5 uphoto">

    </div>
    <div class="col-lg-7 ustats">
        <ul>
            <li>
                <@spring.message "personal.data"/>
            </li>
            <li>
                <@spring.message "age"/> : ${user.getAge()}
            </li>
            <li>
                <@spring.message "gender"/> : ${user.getAge()}
            </li>
            <li>
                <@spring.message "weight"/> : ${user.getAge()}
            </li>
            <li>
                <@spring.message "height"/> : ${user.getAge()}
            </li>
            <li>
                <@spring.message "lifestyle"/> : <@spring.message "${user.getLifeStyle()}"/>
            </li>
            <li>
                <@spring.message "daily.calories"/> : ${user.getDailyCalories()}
            </li>
            <li>
                <@spring.message "today.consumed"/> :${todayConsumed}
                <#if isLimitExceeded>
                 !
                </#if>
            </li>
        </ul>
    </div>
    <div class="profile_act col-lg-12 row">
        <a href="/userpage/addmeal" class="col-lg-4 profile_btn">
            <@spring.message "add.meal"/>
        </a>
        <a href="/userpage/addfood" class="col-lg-4 profile_btn">
            <@spring.message "add.food"/>
        </a>
        <a href="/userpage/allmeals?page=0&size=3" class="col-lg-4 profile_btn">
            <@spring.message "all.meal"/>
        </a>
    </div>
</@w.wrapp>