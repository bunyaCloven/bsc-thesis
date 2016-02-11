Ext.define('Beeride.form.Path', {
	extend : 'Ext.form.Panel',
	config : {
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Name',
				name : 'name'
			} ]
		} ]
	}
});