<div style="width: 500px; padding: 20px; border: 1px solid #ccc; background-color: #f5f5f5;">
    <div>
        <h1 style="margin-top: 0;">About</h1>
        <p>About us information will be here <span><a href="/">Read more</a></span></p>
    </div>

    <form action="${pageContext.request.contextPath}/books" method="get">
        <h1 style="">Search Site</h1>
        <label>
            <input style="width:70%; padding: 10px;" type="text" name="searchName" placeholder="Search"/>
            <button style="padding: 10px; background-color: blue; color: white" type="submit">Search</button>
        </label>
    </form>
</div>