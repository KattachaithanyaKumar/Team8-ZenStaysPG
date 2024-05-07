<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>PG Information</title>
        </head>

        <body>

            <div class="wrapper">
                <%@ include file="shared/ownerSideBar.jsp" %>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <h1 class="text-center mt-5">Overview</h1>
                            </div>
                        </div>
                        <div class="row justify-content-around">

                            <div
                                class="col-lg-3 box1 d-flex flex-column justify-content-center align-items-center mt-5">
                                <div class="text-center">
                                    <p>Number of PGs Created</p>
                                </div>
                                <% Integer lId=null; %>
                                    <c:forEach var="pgData" items="${pgsList}">
                                        <c:set var="lId" value="${pgsList.size()}" />
                                        <c:set var="remId" value="${20-pgsList.size()}" />
                                    </c:forEach>


                                    <div class="text-center">
                                        <p class="h2 mt-3">${lId}</p>
                                    </div>

                            </div>
                            <div
                                class="col-lg-3 box1 d-flex flex-column justify-content-center align-items-center mt-5">

                                <div class="text-center">
                                    <p>Number of PGs Remaining</p>
                                </div>
                                <div class="text-center">
                                    <p class="h2 mt-3">${remId}</p>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="row">
                <div class="col">
                    <h1 class="mt-5 text-center">List of PGs</h1>
                </div>
            </div>
            <div class="container cards mt-5 d-flex flex-column justify-content-center align-items-center">
                <div class="row ml-5">
                    <c:forEach var="pgData" items="${pgsList}">
                        <div class="col ">

                            <div class="card mb-5 text-center" style="width: 18rem;">
                                <img src="./resources/images/${pgData.imgUrl}" class="card-img-top" alt="..." style="height: 250px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.6), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
                                <div class="card-body">
                                    <h5 class="card-title">Name: ${pgData.name}</h5>
                                    <p class="card-text">City: ${pgData.city}</p>
                                    <p class="card-text">Address: ${pgData.address}</p>
                                    <p class="card-text">Type: ${pgData.type}</p>
                                    <p class="card-text">Status: ${pgData.status}</p>
                                    <p class="card-text">Rating: ${pgData.rating} <i class="lni lni-star-fill"></i></p>
                                    <a href="RoomInfoServlet?pgId=${pgData.pgId}">Add Room</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            </div>

        </body>


        </html>