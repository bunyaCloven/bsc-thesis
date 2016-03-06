Ext.define('Beeride.view.Map', {
	extend : 'Ext.Panel',
	xtype : 'xmap',
	config : {
		layout : 'vbox',
		items : [ {
			xtype : 'map',
			itemId : 'map',
			flex : 1,
			useCurrentLocation : true
		}, {
			xtype : 'locationtoolbar'
		} ]
	}
});