/*!
 * jQuery Column Picker Plugin v0.2
 * @requires jQuery v1.3.2 or later
 *
 * Project repository: https://github.com/lingceng/jquery.column.picker
 *
 * Copyright 2012, lingceng
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://jquery.org/license
 *
 * Date: 2012-10-16
 * 
 * verson0.2
 * add option to addition select
 */

(function( $, undefined ) {

$.fn.pickout = function(option) {
  log("***in pickout***");
 
  
  var picked = option.picked;
  var add = option.add == true ? true: false;
  
  if (!picked) {
    return null;
  }

  // show referred columns
  var lines = $(this).find("tr");
  
  
  // do for every line
  lines.each(function (){
    // do for every cell
    $(this).children().each(function (i) {
      // if cell index in the array then show
      if (contains(i, picked)) {
        $(this).show();
      } else if (!option.add) {
    	$(this).hide();
      }
    });
    
  });
  
  
  
}

// whether item in array
function contains(item, array) {
  for (var i in array) {
    if (array[i] == item) {
      return true;
    }
  }

  return false;
}
function log(msg) { 
  if (window.console != null && window.console.log != null) {
	console.log(msg);
  }
}

})( jQuery );

