<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>

<div class="container">
  <div class="jumbotron">
    <h1 align = "center">${name}</h1>      
    <p>Price : ${price}</p>
    <p>Genre : ${genre}</p>
  </div>
    
  ${message} 
  
  <br><br><br><br><br>
  <h2>Reviews</h2>
 	
  ${form}
  
  <br><br>
  
   <table class="table">
    <thead>
      <tr>
        <th>User</th>
        <th>Comment</th>
        <th>Rating</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${users}</td>
        <td>${comts}</td>
        <td>${sts}</td>
        <td>${dates}</td>
      </tr>
      <tr>
    </tbody>
  </table>

        
    
</div>

</body>
</html>
