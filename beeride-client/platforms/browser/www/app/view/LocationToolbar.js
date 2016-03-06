Ext.define('Beeride.view.LocationToolbar', {
	extend : 'Ext.Toolbar',
	xtype : 'locationtoolbar',
	config : {
		items : [ {
			xtype : 'spacer'
		}, {
			iconCls : 'action',
			itemId : 'submit',
			handler : function(that) {
				var panel = that.up('panel');
				var map = panel.down('map').getMap();
				var lat = map.center.lat();
				var lng = map.center.lng();
				var button = panel.requestbutton;
				var textfield = button.up('panel').down('textfield');
				textfield.setValue(lat + ',' + lng);
				panel.up().remove(panel);
			}
		}, {
			xtype : 'spacer'
		} ]
	}
});