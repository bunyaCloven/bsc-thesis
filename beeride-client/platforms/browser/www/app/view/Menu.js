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
			store : 'Path',
			deleteUrl : '/paths/delete',
			editUrl : '/paths'
		}, {
			xtype : 'button',
			itemId : 'car',
			text : 'My Car Profiles',
			store : 'Car',
			deleteUrl : '/cars/delete',
			editUrl : '/cars'
		}, {
			xtype : 'button',
			itemId : 'cars',
			text : 'Car Profiles',
			store : 'Cars',
			paging : true,
			dni : true
		}, {
			xtype : 'button',
			itemId : 'carpool',
			text : 'My Carpools',
			store : 'Carpool'
		} ]
	}
});
