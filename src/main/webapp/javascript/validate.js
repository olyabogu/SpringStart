/**
 * Created with IntelliJ IDEA.
 * User: olga
 * Date: 10/3/12
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */


function validate(name, image) {
    var value = name.value.trim();
    if (value != null && value != "") {
        image.src = "images/right.gif";
        image.style.display = "inline";
    } else {
        image.src = "images/wrong.gif";
        image.style.display = "inline";
    }
}

function validateEmail(email, image) {
    var value = email.value;
    var regex = /^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/;

    if (value != null && value != "") {
        if (regex.test(value) == true) {
            image.src = "images/right.gif";
            image.style.display = "inline";
        } else {
            image.src = "images/wrong.gif";
            image.style.display = "inline";
        }
    } else {
        image.src = "images/wrong.gif";
        image.style.display = "inline";
    }

}


jQuery(document).ready(function () {
    $('input[name="lastName"]').bind('change', function (event) {

        var value = $('input[name="lastName"]').attr("value").trim();

        if (value != null && value != "") {
            $('#imageLastName').empty().html('<img src="images/right.gif" align="right" >');
            $('#imageLastName').css('display','inline');
        } else {
            $('#imageLastName').empty().html('<img src="images/wrong.gif" align="right" >');
            $('#imageLastName').css('display','inline');
        }
    })
});











