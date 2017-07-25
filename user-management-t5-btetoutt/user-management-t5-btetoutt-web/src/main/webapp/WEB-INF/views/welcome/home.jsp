<div id="wrapper">
    <h1 id="title">Hello world!</h1>
    <p>The time on the server is ${serverTime}.</p>
             <p>
            <!-- (1) -->
            <form:form action="${pageContext.request.contextPath}/logout">
                <button type="submit">Logout</button>
            </form:form>
        </p>
</div>
