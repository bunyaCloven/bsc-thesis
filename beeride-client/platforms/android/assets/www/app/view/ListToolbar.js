Ext.define('Beeride.view.ListToolbar', {
	extend : 'Ext.Toolbar',
	xtype : 'listtoolbar',
	config : {
		items : [ {
			xtype : 'spacer'
		}, {
			iconCls : 'add',
			itemId : 'create'
		}, {
			xtype : 'spacer'
		}, {
			iconCls : 'compose',
			itemId : 'update'
		}, {
			xtype : 'spacer'
		}, {
			iconCls : 'trash',
			itemId : 'delete'
		}, {
			xtype : 'spacer'
		} ]
	}
});