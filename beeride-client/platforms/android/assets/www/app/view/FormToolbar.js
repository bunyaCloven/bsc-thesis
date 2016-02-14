Ext.define('Beeride.view.FormToolbar', {
	extend : 'Ext.Toolbar',
	xtype : 'formtoolbar',
	config : {
		items : [ {
			xtype : 'spacer'
		}, {
			iconCls : 'action',
			itemId : 'submit',
			handler : function() {
				this.up('formpanel').submit({
					params : {
						username : Beeride.util.Auth.getUsername()
					},
					success : function() {
						// TODO: destroy the form
					}
				});
			}
		}, {
			xtype : 'spacer'
		} ]
	}
});