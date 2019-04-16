<html>

<head>
<title>Bank</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>
.col-sm-10 {
	width: 50%;
}

.container {
	background-color: #fbeddb;
	width: 60%;
}

.but {
	align-self: center;
}

input[type=submit] {
	width: 25%;
	background-color: rgb(211, 27, 27);
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	display: block;
    margin: 0 auto;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
</head>

<body>
	<p>
		<img src="images/xyz.png" height="50"> &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <b> <a
			href="main_index.html">Home</a></b>&nbsp; &nbsp; &nbsp; <b> About Us</b>&nbsp;
		&nbsp; &nbsp; <b>Contact </b>&nbsp; &nbsp; &nbsp; <b>Customer Care</b>

	</p>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">

			<li class="nav-item active"><a class="nav-link"
				href="create_acc.html">New Account</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="withdraw.html">Withdraw</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="Deposit.html">Deposit</a></li>
			<li class="nav-item active"><a class="nav-link "
				href="transferFund.html">Fund Transfer</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="checkbal.html">Check balance</a></li>
			<li class="nav-item active"><a class="nav-link "
				href="details.html">Details</a></li>
			<li class="nav-item active"><a class="nav-link "
				href="searchAccount.html">Search Account</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="deleteAccount.html">Delete Account</a></li>
			<li class="nav-item active"><a class="nav-link "
				href="updateAccount.html">Update Account</a></li>



		</ul>
	</nav>
	<br>
	<br>
	<center>
		<b>
			<h2>Create new Account</h2>
		</b>
	</center>
	<br>
	<div class="container ">




		<div class="container-fluid">
			<form action="Bank-Application/app/bank/home/new" method="post">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="focusedInput">Customer Name</label> <input
								class="form-control" id="focusedInput" type="text"
								name="customername">
						</div>


					</div>

					<div class="col-sm-6">
						<div class="form-group">
							<br> <label for="focusedInput">Account Type &nbsp;
								&nbsp;</label> <select name="accounttype">
								<option value="">Select</option>
								<option value="saving">Saving Account</option>
								<option value="current">Current account</option>

							</select>
						</div>
					</div>

					<div class="col-sm-6">
						<div class="form-group">
							<label for="focusedInput">Customer balance</label> <input
								class="form-control" id="focusedInput" type="text"
								name="customerbalance" maxlength="10">
						</div>



					</div>
					<br> <br> <br> <br>


					<div class="col-sm-12">
						<div class="form-group">
							<input type="submit" value="Create new account">

						</div>
					</div>

					<br>
			</form>
		</div>











		</form>
	</div>





</body>

</html>