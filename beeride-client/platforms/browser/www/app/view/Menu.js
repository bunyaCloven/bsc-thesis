Ext.define('Beeride.view.Menu', {
	extend : 'Ext.Panel',
	xtype : 'menu',
	requires : [],
	config : {
		scrollable : null,
		items : [ {
			xtype : 'button',
			text : 'For Drivers',
			handler : function() {
				var main = Ext.ComponentQuery.query('main')[0];
				main.push({
					xtype : 'panel',
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
						itemId : 'carpool',
						text : 'My Carpools',
						store : 'Carpool',
						deleteUrl : '/carpools/delete',
						editUrl : '/carpools'
					} ]
				});
			}
		}, {
			xtype : 'button',
			text : 'For Passengers',
			handler : function() {
				var main = Ext.ComponentQuery.query('main')[0];
				main.push({
					xtype : 'panel',
					items : [ {
						xtype : 'button',
						itemId : 'cars',
						text : 'Car Profiles',
						store : 'Cars',
						listCallback : 'Beeride.view.Car',
						editUrl : '/cars',
						paging : true,
						dni : true
					}, {
						xtype : 'button',
						itemId : 'carpools',
						text : 'All Carpools',
						store : 'Carpools',
						listCallback : 'Beeride.view.Carpool',
						editUrl : '/carpools',
						paging : true,
						dni : true
					}, {
						xtype : 'button',
						itemId : 'seats',
						text : 'My Carpools',
						store : 'Seats',
						listCallback : 'Beeride.view.Seat',
						editUrl : '/seats',
						paging : true,
						dni : true
					} ]
				});
			}
		} ]
	}
});
