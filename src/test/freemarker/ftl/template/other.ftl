循环变量、局部变量和模板中的变更会根据作用域范围进行覆盖，而不是替换
<#global muvar="global" />
${.globals.muvar}

<#import "namespace.ftl" as others />
替换namespace文件中的变量，在使用namespace文件中的宏之前定义才有效
<#assign var="other2" in others />

<@others.namespace />
<#assign var="other"/>

${others.var}