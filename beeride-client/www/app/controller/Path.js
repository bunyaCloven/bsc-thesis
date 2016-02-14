Ext.define('Beeride.controller.Path', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'button#locate' : {
				tap : 'setLocation'
			},
			'map' : {
				initialize : 'mapInit'
			}
		}
	},
	setLocation : function(that, e, eOpts) {
		Ext.ComponentQuery.query('main')[0].add({
			xtype : 'panel',
			layout : 'vbox',
			items : [ {
				xtype : 'map',
				flex : 1
			}, {
				xtype : 'locationtoolbar'
			} ]
		});
	}
});