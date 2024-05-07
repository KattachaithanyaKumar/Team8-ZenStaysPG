<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PG Information Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
    <style>
        body {
            background-color: #ffffff;
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='800' height='800' viewBox='0 0 200 200'%3E%3Cdefs%3E%3ClinearGradient id='a' gradientUnits='userSpaceOnUse' x1='88' y1='88' x2='0' y2='0'%3E%3Cstop offset='0' stop-color='%23005092'/%3E%3Cstop offset='1' stop-color='%23007cc4'/%3E%3C/linearGradient%3E%3ClinearGradient id='b' gradientUnits='userSpaceOnUse' x1='75' y1='76' x2='168' y2='160'%3E%3Cstop offset='0' stop-color='%23868686'/%3E%3Cstop offset='0.09' stop-color='%23ababab'/%3E%3Cstop offset='0.18' stop-color='%23c4c4c4'/%3E%3Cstop offset='0.31' stop-color='%23d7d7d7'/%3E%3Cstop offset='0.44' stop-color='%23e5e5e5'/%3E%3Cstop offset='0.59' stop-color='%23f1f1f1'/%3E%3Cstop offset='0.75' stop-color='%23f9f9f9'/%3E%3Cstop offset='1' stop-color='%23FFFFFF'/%3E%3C/linearGradient%3E%3Cfilter id='c' x='0' y='0' width='200%25' height='200%25'%3E%3CfeGaussianBlur in='SourceGraphic' stdDeviation='12' /%3E%3C/filter%3E%3C/defs%3E%3Cpolygon fill='url(%23a)' points='0 174 0 0 174 0'/%3E%3Cpath fill='%23000' fill-opacity='.5' filter='url(%23c)' d='M121.8 174C59.2 153.1 0 174 0 174s63.5-73.8 87-94c24.4-20.9 87-80 87-80S107.9 104.4 121.8 174z'/%3E%3Cpath fill='url(%23b)' d='M142.7 142.7C59.2 142.7 0 174 0 174s42-66.3 74.9-99.3S174 0 174 0S142.7 62.6 142.7 142.7z'/%3E%3C/svg%3E");
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-position: top left;
            font-family: 'Poppins';
        }

        .container {
            overflow: hidden;
            max-width: 500px;
            margin: 50px auto;
            margin-top: 100px;
            background-color: rgba(255, 255, 255, 0.8);
            /* Reduced opacity */
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, 0.1);
        }

        .form-group label {
            font-weight: bold;
        }

        select.form-control,
        textarea.form-control {
            appearance: none;
            border-radius: 5px;
            padding: 8px;
            width: 100%;
            margin-top: 5px;
            font-size: 16px;
        }

        /* Adjust button style */
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            padding: 5px 15px;
            font-size: 18px;
            border-radius: 5px;
            transition: all 0.3s ease;
        }
    </style>
</head>

<body>

    <div class="container">
        <h2 class="mb-4">Room Information Form</h2>
        <form action="RoomInfoServlet" method="post">
            <div class="form-group">
                <label for="availability"> Availability</label>
                <select class="form-control" id="availability" name="availability">
                    <option value="">Choose Availability</option>
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>

            <div class="form-group">
                <label for="no_of_beds">NO of Beds</label>
                <select class="form-control" id="no_of_beds" name="no_of_beds">
                    <option value="">Choose No of Beds</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
            </div>


               <% String pgId = request.getParameter("pgId"); %>
                       <input type="hidden" name="pg_id" value="<%= pgId %>">

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>

</body>

</html>