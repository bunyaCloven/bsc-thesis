Ext.define('Beeride.view.DriverCarpool', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		url : serverAddress + '/seats/sign',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'label',
			html : 'Name: ',
			name : 'name'
		}, {
			xtype : 'label',
			html : 'Time: ',
			name : 'timex',
		}, {
			xtype : 'label',
			html : 'Seats: ',
			name : 'seats'
		}, {
			flex : 1
		} ]
	}
});