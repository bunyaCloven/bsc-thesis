Ext.define('Beeride.controller.Login', {
	extend : 'Ext.app.Controller',
	config : {
		refs : [],
		control : {
			'button#login' : {
				tap : 'login'
			}
		}
	},
	login : function(that, e, eOpts) {
		var username = that.up().down('#username').getValue();
		var password = that.up().down('#password').getValue();
		if (username.length === 0 || password.length === 0) {
			Ext.Msg.alert('', 'You need to enter something', Ext.emptyFn);
			return;
		}
		that.up('formpanel').setMasked({
			xtype : 'loadmask',
			message : 'Signing In...'
		});
		Beeride.util.Auth.set(username, password);
		that.up('formpanel').submit({
			headers : {
				Authorization : Beeride.util.Auth.get()
			},
			url : serverAddress + '/login',
			method : 'POST',
			params : {
				username : username,
				password : password
			},
			success : function(form, result) {
				Ext.Msg.alert("", "Signed in successfully", Ext.emptyFn);
				Ext.ComponentQuery.query('main')[0].push(Ext.create('Beeride.view.Map'));
			},
			failure : function(form, result) {
				Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
			}
		});
	},
});