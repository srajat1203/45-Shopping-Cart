<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>

<div class="container">
<h2>List of items</h2>
<table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
      </tr>
  
    </thead>
    <tbody>
      <tr>
        <td>${inames}</td>
        <td>${iprices }</td>
        <td>${iquants}</td>
      </tr>
    </tbody>
  </table>

  <ul class="list-group">
    <li class="list-group-item"> Sub-Total : ${sum}</li>
    <li class="list-group-item"> Tax : ${tax}</li>
    <li class="list-group-item"> Credit : ${credit}</li>
    <li class="list-group-item"> Total : ${total}</li> 
  </ul>
</div>

   <br><br>
   <form role="form" action="BillingDisp.jsp" method = "post">
    <button type="submit" class="btn btn-default">Go to Billing</button>
  </form>

</body>
</html>
