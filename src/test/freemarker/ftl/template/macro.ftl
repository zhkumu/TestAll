<#macro mumacro name age=1 >
	<div>${name} have ${age} old!</div>
	<#nested/> <#--嵌套内容-->
</#macro>

<@mumacro name="mu" >
</@mumacro>

 这是普通嵌套内容
<@mumacro name="mu" age=2 >
	this is nested <#--这是普通嵌套内容-->
</@mumacro>

这是复杂嵌套内容
<@mumacro name="mu" age=2 >
	<#--也可以是复杂嵌套内容-->
	<ul>
		<#list list as l>
			<li>${l}</li>
		</#list>
	<ul>
</@mumacro>

测试宏中的局部变量
<#macro localvar>
	<#--宏中的局部变量只能在宏中使用-->
	<#local var="mu" />
	${var}
</#macro>
<@localvar />

测试宏的嵌套内容传参
<#macro paramnested  map>
	<#list map?keys as k>
	<#nested k,map[k] />
	</#list>
</#macro>
<@paramnested map=map;key,value>
	key:${key},value:${value}
</@paramnested>












