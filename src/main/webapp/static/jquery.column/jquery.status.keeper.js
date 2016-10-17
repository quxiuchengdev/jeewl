/*!
 * jQuery Status Keeper Plugin v0.1
 * @requires jQuery v1.3.2 or later
 * @requires jQuery Cookie Plugin v1.3
 *
 * Project repository: https://github.com/lingceng/jquery.status.keeper
 *
 * Copyright 2013, lingceng
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://jquery.org/license
 *
 * Date: 2013-01-22
 */

(function( $, undefined ) {
		
	$.fn.keep = function(name, options) {
	  var key = name || "jquerykeepstatus"; 
	  console.log('key',key);
	  options = $.extend({}, defaults, options);
	  var items = $(this);
	  console.log('jquery status', options);
	  
	  
	  // write when unload
	  $(window).unload(function () {
	  //$("#mainFrame").unload(function () {
		var checked = items.filter(":checked");
			  
		var s = [];
		checked.each(function (){
			 s.push($(this).attr(options.field));
		});
		console.log('key1',key);
		console.log('s',s);
		$.cookie(key, s, {json: true, expires: options.expires, path: options.path});
	  });
	  console.log('key2',key);
	  // read
	  var status = $.cookie(key);
	  console.log("get status cookie is", status);
	  
	  if (status == null || status == '' || typeof status == 'undefined') {
	  	  console.log("no status cookie set, return");
		  return false;
	  }
	  
	  items.each(function (){
		 var attr = $(this).attr(options.field);
		 if (contains(status, attr)) {
			 $(this).attr("checked", true);
		 } else {
			 $(this).attr("checked", false);
		 }
	  });
	  
	  return true;
	}
	
	
	var defaults = {
		field: "value",
		expires: 30
	};
	
	function contains(arr, item) {
		if (arr.indexOf(item) != -1) {
			return true;
		}
		return false;
	}
	
	
	

})( jQuery );

