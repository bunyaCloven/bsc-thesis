Ext.define('Beeride.view.Carpool', {
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
			name : 'time',
		}, {
			flex : 1
		}, {
			xtype : 'button',
			itemId : 'carpoolsign',
			text : 'Sign me up!'
		} ]
	}
});