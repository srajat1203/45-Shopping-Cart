<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


    
  <h2>Login</h2>  
  <form role="form" action="Login" method = "post" >
    <div class="form-group" align = "left">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
   ${message}  
   
   
  <h2>Create User</h2>  
  <form role="form" action="CreateUser" method = "post" >
    <div class="form-group">
      <label for="pemail">Email</label>
      <input type="email" class="form-control" id="pemail" name="pemail" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pname">Name</label>
      <input type="text" class="form-control" id="pname" name="pname" placeholder="Enter name">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form> 
   
   
   <br><br>
   <form role="form" action="ProductList" method = "post">
    <button type="submit" class="btn btn-default">Only view products </button>
  </form>
   
<div class="container">
</div>

</body>
</html>