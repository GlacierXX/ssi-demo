<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h1>IBATIS DEMO</h1>
        <select>
            <#list provinceList as province>
                <option value="${province.provinceCode}">${province.provinceName}</option>
            </#list>
        </select>
    </body>
</html>