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
			}, {
				xtype : 'panel',
				layout : 'hbox',
				items : [ {
					xtype : 'textfield',
					name : 'start',
					placeHolder : 'Start Point',
					readOnly : true,
					flex : 1
				}, {
					xtype : 'button',
					iconCls : 'locate',
					itemId : 'locate'
				} ]
			}, {
				xtype : 'panel',
				layout : 'hbox',
				items : [ {
					xtype : 'textfield',
					name : 'xend',
					placeHolder : 'End Point',
					readOnly : true,
					flex : 1
				}, {
					xtype : 'button',
					iconCls : 'locate',
					itemId : 'locate'
				} ]
			}, {
				flex : 1
			} ]
		} ]
	}
});