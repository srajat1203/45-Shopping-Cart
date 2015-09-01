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
    <li class="list-group-item" align = "right"> Total : ${sum}</li>
  </ul>
</div>

</body>
</html>
