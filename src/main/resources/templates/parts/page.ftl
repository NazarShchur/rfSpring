<#macro pager url page>
    <ul class="pagination pagin">
        <#list 1..page.getTotalPages() as p>
            <#if (p - 1) == page.getNumber()>
                <li class="page-item active">
                    <a class="page-link" href="#" tabindex="-1">${p}</a>
                </li>
            <#else>
                <li class="page-item">
                    <a class="page-link" href="${url}?page=${p - 1}&size=3" tabindex="-1">${p}</a>
                </li>
            </#if>
        </#list>
    </ul>
</#macro>