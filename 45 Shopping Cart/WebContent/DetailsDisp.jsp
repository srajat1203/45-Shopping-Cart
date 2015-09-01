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
  <div class="jumbotron">
    <h1 align = "center">${name}</h1>      
    <p>Price : ${price}</p>
    <p>Genre : ${genre}</p>
  </div>
    
  <form role="form" action = "Addtocart" method = "post">
    <div class="form-group">
      <label for="quantity">Enter quantity:</label>
      <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Enter a number">
    </div>
    <button type="submit" class="btn btn-default">Add to Cart</button>
  </form>  
    
</div>

</body>
</html>
