Ext.define('Beeride.form.Path', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		xtype : 'fieldset',
		url : serverAddress + '/paths/add',
		items : [ {
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				placeHolder : 'Name',
				name : 'name'
			} ]
		} ]
	}
});