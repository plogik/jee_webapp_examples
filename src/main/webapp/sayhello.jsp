<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <c:if test="${cookie.containsKey('myname')}">
        Hello ${cookie.myname.value}!
    </c:if>
</body>
</html>