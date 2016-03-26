Ext.define('Beeride.form.Car', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		url : serverAddress + '/cars/add',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'textfield',
			placeHolder : 'Name',
			name : 'name'
		}, {
			xtype : 'textfield',
			placeHolder : 'Brand & Model',
			name : 'brand'
		}, {
			xtype : 'numberfield',
			placeHolder : 'Number of Passengers',
			name : 'passengerCount'
		}, {
			xtype : 'textfield',
			placeHolder : 'License Plate',
			name : 'plate'
		}, {
			flex : 1
		} ]
	}
});