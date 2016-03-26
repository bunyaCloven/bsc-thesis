Ext.define('Beeride.controller.Path', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'button#locate' : {
				tap : 'setLocation'
			},
			'map#seatmap' : {
				maprender : 'seatmap'
			},
			'xmap map' : {
				maprender : 'mapInit'
			}
		}
	},
	setLocation : function(that, e, eOpts) {
		Ext.ComponentQuery.query('main')[0].add({
			xtype : 'xmap',
			itemId : 'selection',
			requestbutton : that
		});
	},
	seatmap : function(that, e, eOpts) {
		var values = that.up('formpanel').down('[name="' + that.target + '"]')
				.getValue().split(',');
		that.setMapCenter({
			latitude : values[0],
			longitude : values[1]
		});
		var marker1 = new google.maps.Marker({
			position : new google.maps.LatLng(values[0], values[1]),
			map : that.getMap(),
		});
	},
	mapInit : function(that, e, eOpts) {
		//TODO: initialize the map with the location you get from cordova
	}
});