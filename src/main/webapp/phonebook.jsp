<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css" type="text/css" />
    <title>Phonebook</title>
</head>
<body>
    <h1>Entries</h1>
    <c:forEach var="entry" items="${entries}" >
        ${entry.fname}, ${entry.lname}, ${entry.phone}<br />
    </c:forEach>

    <h3>Create new</h3>
    <form method="POST">
        <label for="fname">First name</label>
        <input type="text" name="fname" id="fname" value="${param.fname}" />

        <label for="lname">Last name</label>
        <input type="text" name="lname" id="lname" value="${param.lname}" />

        <label for="phone">Phone</label>
        <input type="text" name="phone" id="phone" value="${param.phone}" />
        
        <label for="submit"><label>
        <input type="submit" id="submit" value="Add" />
    </form>
</body>
</html>