Ext.define('Beeride.form.Cars', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		xtype : 'fieldset',
		url : serverAddress + '/cars/search',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'textfield',
			placeHolder : 'Name',
			name : 'name'
		}, {
			flex : 1
		} ]
	}
});