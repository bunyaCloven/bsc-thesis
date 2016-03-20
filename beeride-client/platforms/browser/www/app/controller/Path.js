Ext.define('Beeride.controller.Path', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'button#locate' : {
				tap : 'setLocation'
			},
			'map#seatmap' : {
				maprender : 'mapInit'
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
		var values = that.up('formpanel').down('[name="start"]').getValue()
				.split(',');
		that.setMapCenter({
			latitude : values[0],
			longitude : values[1]
		});
		var marker1 = new google.maps.Marker({
			position : new google.maps.LatLng(values[0], values[1]),
			map : that.getMap(),
		});
	}
});