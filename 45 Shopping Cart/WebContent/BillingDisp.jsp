<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
<script>

    function FillBilling(f) {

        if(f.billingtoo.checked == true) {

            f.shipping_address.value = f.address.value;

        }
        if(f.billingtoo.checked == false) {

            f.shipping_address.value = "";

        }
    }   
        
        
 </script> 
</head>
<body>




<div class="container">

 <div class="jumbotron">
    <h1 align = "center">Billing</h1>      
 </div>

<br>
  <h2>Card information</h2>
  <form class="form-horizontal" role="form" action="Confirm" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">Name on Card</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="name" placeholder="Enter name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="num">Card number</label>
      <div class="col-sm-10">          
        <input type="number" class="form-control" id="num"  placeholder="Enter card number">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="address">Address</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="address" name = "address"  placeholder="Enter address">
      </div>
    </div>
   <div class="form-group">
      <label class="control-label col-sm-2" for="ccv">CCV</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="ccw"  placeholder="Enter ccv">
      </div>
    </div>
   
   
   <br>
   <h3>Shipping Address</h3>
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" onclick="FillBilling(this.form)" name="billingtoo">Same as billing address</label>
        </div>
      </div>
    </div>
   
     <div class="form-group">
      <label class="control-label col-sm-2" for="shipping_address">Address</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="shipping_address" name = "shipping_address"  placeholder="Enter shipping address">
      </div>
    </div>
   
    
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Confirm order</button>
      </div>
    </div>
  </form>
</div>





</body>
</html>
