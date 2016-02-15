Ext.define('Beeride.view.LocationToolbar', {
	extend : 'Ext.Toolbar',
	xtype : 'locationtoolbar',
	config : {
		items : [ {
			xtype : 'spacer'
		}, {
			iconCls : 'action',
			itemId : 'submit',
			handler : function() {
				debugger;
				// TODO:do stuff
			}
		}, {
			xtype : 'spacer'
		} ]
	}
});