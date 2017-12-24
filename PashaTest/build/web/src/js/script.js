var ajaxRequest;
var limit = 100;
var start = 0;
var action = 'inactive';
alert(start);
function startAjax() {
    try {
        ajaxRequest = new XMLHttpRequest();
    } catch (e) {
        try {
            ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("Unsupported browser version");
                return false;
            }
        }
    }
}

function searchCity() {
    startAjax();
    var searchValue = document.getElementById("searchvalue");
    var url = "citys?s=" + escape(searchValue.value);

    ajaxRequest.onreadystatechange = function () {

        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("table").innerHTML =
                    this.responseText;
        }
    };
    ajaxRequest.open("GET", url, true);
    ajaxRequest.send(null);
}

function paginate(limit, start) {
    startAjax();
    alert(start);
    action = 'inactive';
    var searchValue = document.getElementById("searchvalue");
    var url = "cityp?limit=" + limit + "&start=" + start + "&s=" + escape(searchValue.value);

    //var targetTable = document.getElementById("table").tbody;
    //var tr          = document.createElement("tr");


    ajaxRequest.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var tbl = document.getElementById("tb");
            
            tbl.innerHTML += this.responseText;
            console.log(this.responseText);
            if (this.responseText === '') {
                document.getElementById('load_message').innerHTML
                        = "<input type=\"submit\" value=\"no more data\" disabled>";
                action = 'active';
            } //else {
             //   document.getElementById('load_message').innerHTML
                        //= "<input type=\"submit\" value=\"Load\" onclikc=\"doPagination()\">";
              //  action = 'inactive';
           // }*/
        }
    };

    ajaxRequest.open("GET", url, true);
    ajaxRequest.send(null);
}


function doPagination() {
    alert("working");
    active = "active";
    start = start + limit;
    alert(limit);
    setTimeout(function () {
        paginate(limit, start);
    }, 1000);
}

window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}



