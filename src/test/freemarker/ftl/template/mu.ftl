<#--这是注释-->

${name} is ${age} old!
<#switch name>
<#case "mu">
case
<#break>
<#default>
default
</#switch>

遍历list和map，l_index是list的当前下标值
<#list list as l>
${l}--${l_index}
</#list>


<#list map?keys as l >
	key:${l} value:${map[l]}
</#list>

<#--插入其它的文件-->
<#include "mu.html" />

<#--字符串特殊的显示，r为直接显示-->
${"hello \"mu\""}
${r'hell "mu"'}

<#--定义变量-->
<#assign result=true />
${result?string("yes","no")}

<#--freemarker为null时会异常，所以需要处理-->
${who?default("mu")}
<#--确保整个对象为null的处理-->
${(who.name)?default("null object")}
