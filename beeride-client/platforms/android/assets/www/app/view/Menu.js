Ext.define('Beeride.view.Menu', {
	extend : 'Ext.Panel',
	xtype : 'menu',
	requires : [],
	config : {
		scrollable : null,
		items : [ {
			xtype : 'button',
			itemId : 'path',
			text : 'Path module',
			store : 'Path'
		}, {
			xtype : 'button',
			itemId : 'car',
			text : 'Car Profile',
			store : 'Car',
			deleteUrl : '/cars/delete'
		} ]
	}
});
