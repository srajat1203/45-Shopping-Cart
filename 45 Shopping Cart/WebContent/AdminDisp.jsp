<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<h2>List of items</h2>
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
  
  <h2>User Credit</h2>
   <form class="form-inline" role="form" action = "Admin" method = "post">
    <div class="form-group">
      <label for="cremail">Email</label>
      <input type="email" class="form-control" id="cremail" name="cremail" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="amount">Amount</label>
      <input type="number" step=0.01 class="form-control" id="amount" name="amount" placeholder="Enter amount">
    </div>
    
    <button type="submit" class="btn btn-default">Give credit</button>
  </form>
</div>
  

 


</body>
</html>
