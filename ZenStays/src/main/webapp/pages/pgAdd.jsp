<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PG Information Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel = "stylesheet" href="pages/pgAdd.css">
</head>

<body>
    <div class="wrapper">
        <%@ include file="shared/ownerSideBar.jsp" %>
    </div>
    <div class="form-container">
        <div class="container">
            <h2 class="mb-4">PG Information Form</h2>
            <form action="PGInfoServlet" method="post">
                <div class="form-group">
                    <label for="name">PG Name</label>
                    <textarea class="form-control" id="name" name="name" rows="1" placeholder="Enter PG Name"></textarea>
                </div>
                <div class="form-group">
                    <label for="city">City</label>
                    <textarea class="form-control" id="city" name="city" rows="1" placeholder="Enter PG City"></textarea>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <textarea class="form-control" id="address" name="address" rows="2" placeholder="Enter PG address"></textarea>
                </div>
                <div class="form-group">
                    <label for="type">PG Type</label>
                    <select class="form-control" id="type" name="type">
                        <option value="">Select PG Type</option>
                        <option value="Men">Men</option>
                        <option value="Women">Women</option>
                        <option value="Co-Live">Co-Live</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="status">Status</label>
                    <textarea class="form-control" id="status" name="status" rows="1" placeholder="Enter PG status"></textarea>
                </div>
                <div class="form-group">
                    <label for="rating">Rating</label>
                    <textarea class="form-control" id="rating" name="rating" rows="1" placeholder="Enter PG rating"></textarea>
                </div>
                <div class="form-group">
                    <label for="img_url">Enter PG URL</label>
                    <textarea class="form-control" id="img_url" name="img_url" rows="1" placeholder="PG URL"></textarea>
                </div>
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>

</body>

</html>
