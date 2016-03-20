Ext.define('Beeride.view.Carpool', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		url : serverAddress + '/seats/sign',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'hiddenfield',
			name : 'start'
		}, {
			xtype : 'label',
			html : '<b>Name: </b>',
			name : 'name'
		}, {
			xtype : 'label',
			html : '<b>Time: </b>',
			name : 'timex',
		}, {
			xtype : 'label',
			html : '<b>Seats: </b>',
			name : 'seats'
		}, {
			xtype : 'label',
			html : '<b>Plate: </b>',
			name : 'plate'
		}, {
			xtype : 'label',
			html : '<b>Car Brand & Model: </b>',
			name : 'brand'
		}, {
			xtype : 'map',
			itemId : 'seatmap',
			disabled : 'true',
			flex : 1
		}, {
			xtype : 'button',
			itemId : 'carpoolsign',
			text : 'Sign me up!'
		} ]
	}
});