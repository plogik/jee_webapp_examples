<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <c:if test="${sessionScope.myname != null}">
        Hello ${myname}!
    </c:if>
</body>
</html>