ValidateClass = Class.extend({

    init:function () {
        jQuery(document).ready(function () {
            $("input").bind('change', $.proxy(validate.validateFunction, validate));
            $('input[name="emailAddress"]').bind('change', $.proxy(validate.validateFunctionEmail, validate));

        })

    },

    validateFunction:function (event) {
        var element = $(event.target);
        if ((element.attr('type') != 'submit' && 'hidden') && (element.attr('name') != ('emailAddress'))) {
            this.setNameAndValue(element);
            if (this.fieldValue != null && this.fieldValue != "") {
                this.showRightImage();
                return true;
            } else {
                this.showWrongImage();
                return false;
            }
        }
    },

    validateFunctionEmail:function (event) {
        var element = $(event.target);
        if ((element.attr('name') == ('emailAddress'))) {
            this.setNameAndValue(element);
            var regex = /^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/;

            if (this.fieldValue != null && this.fieldValue != "") {

                if ((regex.test(this.fieldValue)) == true) {
                    this.showRightImage();
                } else {
                    this.showWrongImage();
                }
            } else {
                this.showWrongImage();
            }
        }
    },

    setNameAndValue:function (element) {
            this.fieldName = element.attr('name');
            this.fieldValue = element.attr('value').trim();
    },

    showRightImage:function () {
        $('#' + this.fieldName).empty().html('<img src="images/right.gif" align="right" >');
        $('#' + this.fieldName).css('display', 'inline');
    },
    showWrongImage:function () {
        $('#' + this.fieldName).empty().html('<img src="images/wrong.gif" align="right" >');
        $('#' + this.fieldName).css('display', 'inline');
    }

});

var validate = new ValidateClass();
