<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>


<div class="container">
  <h2>List of Products</h2>
  <ul class="list-group">
    <li class="list-group-item">${plist}</li>
  </ul>
${message}

</div>

</body>
</html>
