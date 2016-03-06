Ext.define('Beeride.controller.Path', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'button#locate' : {
				tap : 'setLocation'
			},
			'xmap' : {
				initialize : 'mapInit'
			}
		}
	},
	setLocation : function(that, e, eOpts) {
		Ext.ComponentQuery.query('main')[0].add({
			xtype : 'xmap',
			requestbutton : that
		});
	},
	mapInit : function(that, e, eOpts) {
		debugger;
		// var myOptions = {
		// zoom : 12,
		// mapTypeId : google.maps.MapTypeId.ROADMAP
		// };
		// that.map = new google.maps.Map(that.down('#map').element.dom,
		// myOptions);
		/*
		 * navigator.geolocation.getCurrentPosition(function(position) { var
		 * latlng = new google.maps.LatLng(position.coords.latitude,
		 * position.coords.longitude); var myOptions = { zoom : 12, center :
		 * latlng, mapTypeId : google.maps.MapTypeId.ROADMAP }; that.map = new
		 * google.maps.Map(that.down('#map').element.dom, myOptions); });
		 */
	}
});