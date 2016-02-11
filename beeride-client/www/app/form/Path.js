Ext.define('Beeride.form.Path', {
	extend : 'Ext.Panel',
	config : {
		layout : 'vbox',
		items : [ {
			xtype : 'formpanel',
			flex : 1,
			config : {
				items : [ {
					layout : 'vbox',
					xtype : 'fieldset',
					url : serverAddress + '/paths/add',
					items : [ {
						xtype : 'textfield',
						placeHolder : 'Name',
						name : 'name'
					} ]
				} ]
			}
		} ]
	}
});