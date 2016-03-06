Ext.define('Beeride.form.Car', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		xtype : 'fieldset',
		url : serverAddress + '/cars/add',
		items : [ {
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
		} ]
	}
});