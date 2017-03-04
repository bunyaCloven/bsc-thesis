Ext.define('Beeride.view.Menu', {
	extend : 'Ext.Panel',
	xtype : 'menu',
	requires : [],
	config : {
		layout : 'vbox',
		scrollable : null,
		items : [ {
			xtype : 'button',
			text : 'For Drivers',
			flex : 1,
			handler : function() {
				var main = Ext.ComponentQuery.query('main')[0];
				main.push({
					xtype : 'panel',
					layout : 'vbox',
					items : [ {
						flex : 1,
						xtype : 'button',
						itemId : 'path',
						text : 'Path module',
						store : 'Path',
						deleteUrl : '/paths/delete',
						editUrl : '/paths'
					}, {
						flex : 1,
						xtype : 'button',
						itemId : 'car',
						text : 'My Car Profiles',
						store : 'Car',
						deleteUrl : '/cars/delete',
						editUrl : '/cars'
					}, {
						flex : 1,
						xtype : 'button',
						itemId : 'carpool',
						text : 'My Carpools',
						store : 'Carpool',
						listCallback : 'Beeride.view.DriverCarpool',
						deleteUrl : '/carpools/delete',
						doubleClickLoad : '/carpools/driverView',
						editUrl : '/carpools'
					} ]
				});
			}
		}, {
			xtype : 'button',
			text : 'For Passengers',
			flex : 1,
			handler : function() {
				var main = Ext.ComponentQuery.query('main')[0];
				main.push({
					xtype : 'panel',
					layout : 'vbox',
					items : [ {
						flex : 1,
						xtype : 'button',
						itemId : 'cars',
						text : 'Car Profiles',
						store : 'Cars',
						listCallback : 'Beeride.view.Car',
						editUrl : '/cars',
						paging : true,
						dni : true
					}, {
						flex : 1,
						xtype : 'button',
						itemId : 'carpools',
						text : 'All Carpools',
						store : 'Carpools',
						listCallback : 'Beeride.view.Carpool',
						doubleClickLoad : '/carpools',
						search : true,
						searchPage : 'Beeride.view.CarpoolFilter',
						paging : true,
						dni : true
					}, {
						flex : 1,
						xtype : 'button',
						itemId : 'seats',
						text : 'My Carpools',
						store : 'Seats',
						listCallback : 'Beeride.view.Seat',
						doubleClickLoad : '/seats',
						paging : true,
						dni : true
					} ]
				});
			}
		} ]
	}
});
