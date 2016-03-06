Ext.define('Beeride.view.Seat', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		url : serverAddress + '/seats/remove',
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
			text : 'Remove me.'
		} ]
	}
});