Ext.define('Beeride.view.Main', {
	extend : 'Ext.navigation.View',
	xtype : 'main',
	config : {
		ui : 'plain',
		navigationBar : {
			docked : 'top',
			items : [ {
				xtype : 'button',
				text : 'Log Off',
				itemId : 'logOff',
				align : 'right',
			} ]
		},
		items : {
			xtype : 'menu'
		}
	}
});