<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>

<div class="container">
<h2>Order History</h2>
<table class="table">
    <thead>
      <tr>
        <th>User</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      	<td>${iuemails}</td>
        <td>${inames}</td>
        <td>${iprices }</td>
        <td>${iquants}</td>
      </tr>
    </tbody>
  </table>
  </div>

 


</body>
</html>
