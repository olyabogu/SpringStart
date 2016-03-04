/**
 * Created with IntelliJ IDEA.
 * User: olga
 * Date: 9/28/12
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */

jQuery(document).ready(function() {
    $("#orderedlist1").addClass("red");
});
$('.target').change(function() {
    alert('Handler for .change() called.');
});


Select = Class.extend({
    init: function(idElement) {
        //constructor

        this.select = jQuery('#' + idElement).append('<select/>');
    },

    addRow: function(key, value) {
        this.select.append('<option/>').attr('value', key).html(value);
    }
});

Select2 = Select.extend({
    init: function() {
        this._super('qqq');
    },

    addRow: function(key, value, func) {
        this._super(key, value);

        jQuery.bind('change', func);
    }
});

var select = new Select(1,2,3,4);

var a = [{id:1, name:'aaaa'}, {id: 2, name: 'wwww'}];


