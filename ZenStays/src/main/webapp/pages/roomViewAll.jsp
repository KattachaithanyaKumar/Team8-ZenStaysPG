<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Room Information</title>
        <style>

        body{
            overflow: hidden;
        }

        </style>


        </head>

        <body>

            <div class="wrapper">
                <%@ include file="shared/ownerSideBar.jsp"%>
            </div>
            <div class="row">
                <div class="col">
                    <h1 class="mt-5 text-center">List of Rooms</h1>
                </div>
            </div>
            <div class="container cards mt-5 d-flex flex-column justify-content-center align-items-center">
                <div class="row ml-5">
                    <c:forEach var="roomData" items="${roomList}">
                        <div class="col ">

                            <div class="card mb-5 text-center" style="width: 18rem;">

                                <div class="card-body">
                                    <h5 class="card-title">Room Id: ${roomData.roomId}</h5>
                                    <p class="card-text">Availability: ${roomData.availability}</p>
                                    <p class="card-text">Pg Id: ${roomData.pgId}</p>
                                    <p class="card-text">No of Beds: ${roomData.noOfBeds}</p>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            </div>

        </body>



        </html>