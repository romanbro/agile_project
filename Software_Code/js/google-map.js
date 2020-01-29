var map, destinationIcon, originIcon, bounds, geocoder, pos, markersArray, infoWindow

function initMap() {
    bounds = new google.maps.LatLngBounds;
    markersArray = [];

    destinationIcon = 'https://chart.googleapis.com/chart?' +
        'chst=d_map_pin_letter&chld=D|FF0000|000000';
    originIcon = 'https://chart.googleapis.com/chart?' +
        'chst=d_map_pin_letter&chld=O|FFFF00|000000';
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 56.4620, lng: -2.9707 },
        zoom: 12
    });
    geocoder = new google.maps.Geocoder;
    // Try HTML5 geolocation.
    infoWindow = new google.maps.InfoWindow;
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Your location found.');
            infoWindow.open(map);
            map.setCenter(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function codeAddress() {
    var service = new google.maps.DistanceMatrixService;
    var address1 = document.getElementById('address1').value;
    var address2 = document.getElementById('address2').value;
    service.getDistanceMatrix({
        origins: [pos],
        destinations: [address1, address2],
        travelMode: 'DRIVING',
        unitSystem: google.maps.UnitSystem.METRIC,
        avoidHighways: false,
        avoidTolls: false
    }, function (response, status) {
        if (status !== 'OK') {
            alert('Error was: ' + status);
        } else {
            var originList = response.originAddresses;
            var destinationList = response.destinationAddresses;
            var outputDiv = document.getElementById('output');
            outputDiv.innerHTML = '';
            deleteMarkers(markersArray);

            var showGeocodedAddressOnMap = function (asDestination, address) {
                var icon = asDestination ? destinationIcon : originIcon;
                return function (results, status) {
                    if (status === 'OK') {
                        map.fitBounds(bounds.extend(results[0].geometry.location));
                        
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location,
                            icon: icon
                        });
                        markersArray.push(marker)
                        // include a infowindow on the marker with address 
                        if(asDestination = true){
                            var infowindow = new google.maps.InfoWindow({
                                    content: address
                            });
                        } else {
                            var infowindow = new google.maps.InfoWindow({
                                content: address
                        });
                        }
                        marker.addListener('click', function () {
                            infowindow.open(map, marker);
                        });
                    } else {
                        alert('Geocode was not successful due to: ' + status);
                    }
                };
            };

            for (var i = 0; i < originList.length; i++) {
                var results = response.rows[i].elements;
                geocoder.geocode({ 'address': originList[i] },
                    showGeocodedAddressOnMap(false, originList[i]));
                for (var j = 0; j < results.length; j++) {
                    geocoder.geocode({ 'address': destinationList[j] },
                        showGeocodedAddressOnMap(true, destinationList[j]));
                    outputDiv.innerHTML += originList[i] + ' to ' + destinationList[j] +
                        ': ' + results[j].distance.text + ' in ' +
                        results[j].duration.text + '<br>';
                }
            }
        }
    });
}

function deleteMarkers(markersArray) {
    for (var i = 0; i < markersArray.length; i++) {
        markersArray[i].setMap(null);
    }
    markersArray = [];
}
