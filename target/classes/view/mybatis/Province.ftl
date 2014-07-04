<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h1>SSI DEMO</h1>
        <select>
            <#list provinceList as province>
                <option value="${province.PROVINCE_CODE}">${province.PROVINCE_NAME}</option>
            </#list>
        </select>
    </body>
</html>