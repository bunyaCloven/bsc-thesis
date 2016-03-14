Ext.define('Beeride.form.Carpool', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		url : serverAddress + '/carpools/add',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'textfield',
			placeHolder : 'Name',
			name : 'name'
		}, {
			xtype : 'datetimepickerfield',
			name : 'time',
		// value : new Date()
		}, {
			xtype : 'selectfield',
			label : 'path:',
			mystore : 'Path',
			name : 'path'
		}, {
			xtype : 'selectfield',
			label : 'car:',
			mystore : 'Car',
			name : 'car'
		}, {
			flex : 1
		} ]
	}
});