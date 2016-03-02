Ext.define('Beeride.form.Signup', {
	extend : 'Ext.form.Panel',
	xtype : 'signup',
	config : {
		layout : 'vbox',
		url : serverAddress + '/signup',
		items : [ {
			xtype : 'textfield',
			name : 'username',
			placeHolder : 'username'
		}, {
			xtype : 'textfield',
			name : 'email',
			placeHolder : 'email'
		}, {
			xtype : 'passwordfield',
			placeHolder : 'password',
			name : 'password'
		}, {
			xtype : 'passwordfield',
			placeHolder : 'retype password',
			name : 'password2'
		}, {
			xtype : 'signuptoolbar'
		} ]
	}
});