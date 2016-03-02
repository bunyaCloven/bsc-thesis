Ext.define('Beeride.view.SignupToolbar', {
	extend : 'Ext.Toolbar',
	xtype : 'signuptoolbar',
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
						this.up().remove(this);
						Ext.Viewport.add({
							xtype : 'login'
						});
					},
					failure : function() {
						Ext.Msg.alert("", "the data you entered is invalid");
					}
				});
			}
		}, {
			xtype : 'spacer'
		}, {
			itemId : 'quit',
			iconCls : 'delete',
			handler : function() {
				Ext.Viewport.removeAll();
				Ext.Viewport.add({
					xtype : 'login'
				});
			}
		}, {
			xtype : 'spacer'
		} ]
	}
});