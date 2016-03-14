Ext.define('Beeride.view.Login', {
	extend : 'Ext.form.Panel',
	xtype : 'login',
	requires : [ 'Beeride.view.Menu' ],
	config : {
		scrollable : null,
		items : [ {
			xtype : 'fieldset',
			title : 'Login',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Username',
				itemId : 'username'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Password',
				itemId : 'password'
			}, {
				xtype : 'button',
				itemId : 'login',
				text : 'login'
			}, {
				xtype : 'button',
				text : 'signup',
				itemId : 'signup'
			} ]
		} ]
	}
});
