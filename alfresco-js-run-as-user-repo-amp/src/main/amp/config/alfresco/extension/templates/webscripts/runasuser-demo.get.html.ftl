<h1>Script is launched with the "${userid}" account</h1>

<h2>Company home</h2>
<ul>
	<#list companyhomeList as content>
		<li>${content.name}</li>
	</#list>
</ul>

<h2>Sites list</h2>
<ul>
	<#list sitesList as content>
		<li>${content.title}</li>
	</#list>
</ul>