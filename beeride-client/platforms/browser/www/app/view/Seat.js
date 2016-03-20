Ext.define('Beeride.view.Seat', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		url : serverAddress + '/seats/remove',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'hiddenfield',
			name : 'start'
		}, {
			xtype : 'label',
			html : 'Name: ',
			name : 'name'
		}, {
			xtype : 'label',
			html : 'Time: ',
			name : 'time',
		}, {
			xtype : 'label',
			html : 'Seats: ',
			name : 'seats'
		}, {
			xtype : 'label',
			html : 'Plate: ',
			name : 'plate'
		}, {
			xtype : 'label',
			html : 'Car Brand & Model: ',
			name : 'brand'
		}, {
			xtype : 'map',
			itemId : 'seatmap',
			disabled : 'true',
			flex : 1
		}, {
			xtype : 'button',
			itemId : 'carpoolsign',
			text : 'Remove me.'
		} ]
	}
});