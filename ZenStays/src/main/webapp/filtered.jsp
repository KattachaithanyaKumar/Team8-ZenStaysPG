<%@ page import="java.util.List" %>
<%@ page import="org.virtusa.zenstays.model.RoomModel" %>
<%@ page import="org.virtusa.zenstays.model.PGModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css" />
    <title>Document</title>
  </head>
  <body>
    <div class="page">
      <nav class="navbar">
        <img src="./resources/images/logo.png" alt="logo" />
        <div class="nav-links">
          <a href="#">Home</a>
          <a href="#about">About</a>
          <a href="#rooms">Rooms</a>
          <a href="#services">Services</a>
          <a href="#Contact Us">Contact Us</a>
        </div>

        <div class="nav-buttons" >
          <form action="">
            <button>Login</button>
          </form>
          <form action="PGViewAllServlet">
            <button>List your own</button>
          </form>
        </div>
      </nav>

      <div class="hero">
        <img src="./resources/images/hero_bg.png" alt="" />
        <h1>Find your dream PG now</h1>

        <form action="" class="hero-form">
          <div>
            <h4>City</h4>
            <input type="text" placeholder="where do you want to stay" />
          </div>
          <div>
            <h4>Check in</h4>
            <input type="date" placeholder="dd-mm-yy" name="" />
          </div>
          <div>
            <h4>How Many</h4>
            <input type="number" placeholder="how many will stay" />
          </div>
          <div>
            <button>Submit</button>
          </div>
        </form>
      </div>

      <form action="filter">
        <div class="listing-container">
          <div class="filters">
            <div class="filter-box">
              <h2>Rating</h2>
              <div class="rating-options">
                <input type="radio" name="rating" value="1" />
                <label for="1">1</label>
                <input type="radio" name="rating" value="2" />
                <label for="1">2</label>
                <input type="radio" name="rating" value="3" />
                <label for="1">3</label>
                <input type="radio" name="rating" value="4" />
                <label for="1">4</label>
                <input type="radio" name="rating" value="5" />
                <label for="1">5</label>
              </div>

              <h2>Facilities</h2>
              <div class="facilities">
                <div>
                  <input type="checkbox" name="food" />
                  <label for="food">food</label>
                </div>
                <div>
                  <input type="checkbox" name="wifi" />
                  <label for="wifi">wifi</label>
                </div>
                <div>
                  <input type="checkbox" name="parking" />
                  <label for="parking">parking</label>
                </div>
                <div>
                  <input type="checkbox" name="washing" />
                  <label for="washing">washing</label>
                </div>
              </div>

              <button>Submit</button>
            </div>
          </div>
          <div class="listing">

            <div class="room-listing">
              <%
                // Retrieve roomList attribute set by the servlet
                List<RoomModel> roomList = (List<RoomModel>) request.getAttribute("roomList");

                // Check if roomList is not null and not empty
                if (roomList != null && !roomList.isEmpty()) {
                    // Loop through roomList and display room information
                    for (RoomModel room : roomList) {
                      PGModel pg = room.getPg();
                %>
                        <div class="room">
                            <h2><%= pg.getName() %></h2>
                            <div class="room-details">
                              <div class="row">
                                <p><%= pg.getAddress() %></p>
                                <p><%= pg.getCity() %></p>
                              </div>
                              <p style="color: #3553d0;"><%= room.getType() %> share</p>
                              <div class="row">
                                <p><%= room.isAvailability() ? "Available" : "Not Available" %></p>
                                <p style="color: rgb(255, 115, 0);"><%= pg.getRating() %> / 5</p>
                              </div>
                              <div class="facilities-list">
                                <%
                                // Assuming pg.getFacilities() returns a list of facility names associated with the PG
                                List<String> facilities = pg.getFacilities();
                                if (facilities != null && !facilities.isEmpty()) {
                                    for (String facility : facilities) {
                                %>
                                    <p><%= facility %></p>
                                <%
                                    }
                                } else {
                                %>
                                    <p>No facilities available</p>
                                <%
                                }
                                %>
                            </div>
                            </div>
                        </div>
                <%
                    }
                } else {
                %>
                    <p>No rooms found.</p>
              <%
                }
              %>
            </div>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
