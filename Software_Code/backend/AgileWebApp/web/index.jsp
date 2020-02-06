<!DOCTYPE html>
<html lang="en">
  <head>
    <title>OBK MEDICAL</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="heart.jpg">
  </head>
  <body>


  <%--START nav--%>
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="index.html"><i class="flaticon-pharmacy"></i><span>OBK</span> Medical Institute</a>
    </div>
  </nav>
   <%--END nav--%>


  <%--START Blue Header Strip--%>
    <div class="hero-wrap" style="background-image: url('surgery1.jpg'); background-attachment:fixed;">
      <div class="overlay"></div>
        <div class="row no-gutters slider-text justify-content-center" >
          <div class="col-md-8 ftco-animate text-center">
            <div class = "test">
                <h1 class="mb-3 bread">Recovery starts here</h1>
            </div>
          </div>
        </div>
    </div>
    <%--END Blue Header Strip--%>

  <section class="ftco-section contact-section ftco-degree-bg">
    <div class="container">
      <div class="row d-flex mb-5 contact-info">
        <div class="col-md-12 mb-4">
          <h2 class="h4">About us</h2>
        </div>
        <div class="w-100"></div>
          <div class="col">
            <p class="mediumPadd">Begin your journey to recovery with us. Our website provides a service that allows you to descover the hospitals that are optimal for you and your needs, in terms of procedure, price and location. We allow you to visualize your search results on a map and table to give you a better understanding of them and allow you to make your own comparisons. All these features are designed to give you the chance to choose the best option for you.</p>
          </div>
        </div>

      <div style="padding-bottom:20px; padding-right: 8px;">
        <div class = "tab">
          <button class="tablinks" onclick = "openSearch(event, 'Code')" id="defaultOpen">Procedure code</button>
          <button class="tablinks" onclick = "openSearch(event, 'Description')">Procedure description</button>
        </div>

          
        <%--START User Input Code Form--%>
        <div id="Code" class="tabcontent">
          <p>Search by code of procedure</p>
          <form action="#"> 

            

            <div class="form-group">
              <div class="tooltip">Procedure Code: 
                <span class="tooltiptext">Enter a 3 digit number</span>
              </div>
              <span> <input type="number" class="form-control" name="procCode" placeholder="111" maxlength="3"></span>
            </div>
            <div class="form-group">
              <div class="tooltip">Location: 
                <span class="tooltiptext">Enter a state, address or zip code</span>
              </div>
              <span> <input type="address1" class="form-control" name="location" placeholder="Location"></span>
            </div>

            <p>Show results within: <span><select name="distanceFilter" class="dropDown">
              <option value="5Miles">5 miles</option>
              <option value="10Miles">10 miles</option>
              <option value="20Miles">20 miles</option>
              <option value="50Miles">50 miles</option>
              <option value="100Miles">100 miles</option>
              <option value="Anywhere">Anywhere</option>
            </select></span></p>

            <div class="row1">
              <div class="column1" style="text-align:center">
                <p>Min Price: <span id="demo"></span></p>
              </div>
              <div class="column2" >
                <div class="price-slider">
                  <input type="range" min="2000" max="3000000" value="2000" name="minPrice" class="slider" id="minPrice" step = 1000 >
                  <input type="range" min="2000" max="3000000" value="3000000" name="maxPrice" class="slider1" id="maxPrice" step = 1000>
                </div>
              </div>
              <div class="column1" style="text-align:center">
                <p>Max Price: <span id="demo1"></span></p>
              </div>
            </div>


            <div class="row">
              <div class="column">
                <p>Order results by:</p>
                <div class="form-group" >
                  <input type="radio" name="orderBy" value="closest" checked>  Distance<br> 
                  <input type="radio" name="orderBy" value="priceLowToHigh" checked>  Price : Low-High<br>
                  <input type="radio" name="orderBy" value="priceHighToLow" checked>  Price : High-Low<br>
                </div>
              </div>
              <div class="column">
                <div class="form-group" style="float:right">
                  <p class="extraPadd"></p>
                  <input type="submit" value="Search" class="btn btn-primary py-3 px-5">
                </div>
              </div>
            </div>
          </form>
        </div>
      <%--END User Input Code Form--%>
      


      <%--START User Input Description Form--%>
        <div id="Description" class="tabcontent">
          <p>Search by description of procedure</p>
          <form action="#">
            <div class="form-group" >
              <div class="tooltip">Description: 
                <span class="tooltiptext">Enter a description of your procedure</span>
              </div>
              <span> <input type="text" class="form-control" name="prodDesc" placeholder="Chest Pain"></span>
            </div>

            <div class="form-group">
              <div class="tooltip">Location: 
                <span class="tooltiptext">Enter a state, address or zip code</span>
              </div>
              <span> <input type="address1" class="form-control" name="location" placeholder="Location"></span>
            </div>

            <p>Show results within: <span><select name="distanceFilter" class="dropDown">
              <option value="5Miles">5 miles</option>
              <option value="10Miles">10 miles</option>
              <option value="20Miles">20 miles</option>
              <option value="50Miles">50 miles</option>
              <option value="100Miles">100 miles</option>
              <option value="Anywhere">Anywhere</option>
            </select></span></p>

           
            <div class="row1">
              <div class="column1" style="text-align:center">
                <p>Min Price: <span id="demo2"></span></p>
              </div>
              <div class="column2" >
                <div class="price-slider">
                  <input type="range" min="2000" max="3000000" value="2000" name="minPrice" class="slider2" id="minPrice1" step = 1000>
                  <input type="range" min="2000" max="3000000" value="3000000" name="maxPrice" class="slider3" id="maxPrice1" step = 1000>
                </div>
              </div>
              <div class="column1" style="text-align:center">
                <p>Max Price: <span id="demo3"></span></p>
              </div>
            </div>


            <div class="row">
              <div class="column">
                <div class="form-group" >
                  <p>Order results by :</p>
                  <input type="radio" name="orderBy" value="closest" checked>  Distance<br>
                  <input type="radio" name="orderBy" value="priceLowToHigh" checked>  Price : Low-High<br>
                  <input type="radio" name="orderBy" value="priceHighToLow" checked>  Price : High-Low<br>
                </div>
              </div>
              <div class="column">
                <div class="form-group" style="float:right">
                  <p class="extraPadd"></p>
                  <input type="submit" value="Search" class="btn btn-primary py-3 px-5">
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
      <%--END User Input Description Form--%>


      <%--START Output--%>
      <div class="row">
        <div class="column" style="text-align: center">
          <div id = "output"> 
            <p >Table goes here</p>
            <%--######################CODE FOR TABLE GOES HERE########################--%>
          </div>
        </div>
        <div class="column4">
          <div id="map"></div>
        </div>
      </div>
      <%--END Output--%>
    </div>
  </section>

    
    <%--START Blue Footer Strip--%>
	<section class="ftco-section-parallax">
    <div class="parallax-img d-flex align-items-center">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
            <p></p>
          </div>
        </div>
      </div>
    </div>
  </section>
  <%--END Blue Footer Strip--%>
  
  <%--START Footer--%>
  <footer>
    <div class="row">
      <div class="col-md-12 text-center">
        <p><%--Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.--%>
          Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
        <%--Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.--%></p>
      </div>
    </div>
  </footer>
  <%--END Footer--%>


  <script>
    var slider = document.getElementById("minPrice");
    var output = document.getElementById("demo");

    output.innerHTML = slider.Value;
    slider.oninput = function() {
      output.innerHTML = this.value;
    };

    var slider1 = document.getElementById("maxPrice");
    var output1 = document.getElementById("demo1");

    output1.innerHTML = slider1.value;
    slider1.oninput = function() {
      output1.innerHTML = this.value;
    };

    var output2 = document.getElementById("demo2");
    var slider2 = document.getElementById("minPrice1");

    output2.innerHTML = slider2.value;
    slider2.oninput = function() {
      output2.innerHTML = this.value;
    };

    var slider3 = document.getElementById("maxPrice1");
    var output3 = document.getElementById("demo3");

    output3.innerHTML = slider3.value;
    slider3.oninput = function() {
      output3.innerHTML = this.value;
    };
  </script>
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="js/google-map.js"></script>
  <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCodmwd7VVmMb19CaPLKQOOmm5srQDVhz4&callback=initMap"></script>
  <script src="js/main.js"></script>

  </body>
</html>