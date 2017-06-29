<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<c:forEach items="${list}" var="item">
    ${item.bookId} -- ${item.name} -- ${item.number} <br/>
</c:forEach>
</body>
</html>