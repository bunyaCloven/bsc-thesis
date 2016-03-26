Ext.define('Beeride.view.DriverCarpool', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		scrollable : null,
		url : serverAddress + '/seats/sign',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
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
			flex : 1
		} ]
	}
});