Ext.define('Beeride.view.Seat', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		scrollable : null,
		url : serverAddress + '/seats/remove',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'hiddenfield',
			name : 'start'
		}, {
			xtype : 'hiddenfield',
			name : 'end'
		}, {
			xtype : 'label',
			html : '<b>Name: </b>',
			name : 'name'
		}, {
			xtype : 'label',
			html : '<b>Time: </b>',
			name : 'time',
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
			xtype : 'label',
			html : '<b>Start: </b>',
		}, {
			xtype : 'map',
			itemId : 'seatmap',
			target : 'start',
			disabled : 'true',
			flex : 1
		}, {
			xtype : 'label',
			html : '<b>End: </b>',
		}, {
			xtype : 'map',
			itemId : 'seatmap',
			target : 'end',
			disabled : 'true',
			flex : 1
		}, {
			xtype : 'button',
			itemId : 'carpoolsign',
			text : 'Remove me.'
		} ]
	}
});