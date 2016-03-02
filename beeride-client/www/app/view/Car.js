Ext.define('Beeride.view.Car', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		items : [ {
			xtype : 'textfield',
			disabled : true,
			name : 'name'
		}, {
			flex : 1
		} ]
	}
});