<html>
<head>
    <title>${actionName}</title>
    <meta name="layout" content="main" />
</head>
<body>

    <h2>Hello ${actionName} - ${new Date()}</h2>

    <cache:block key="one">
        <div class="wow">
            ${new Date()}
        </div>
    </cache:block>
    
    <cache:block key="two">
        <div class="wow">
            ${new Date()}
        </div>
    </cache:block>
    
</body>
</html>