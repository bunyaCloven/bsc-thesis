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
				ui : 'plain',
				xtype : 'button',
				itemId : 'login',
				ui : 'action',
				padding : '10px',
				text : 'login'
			} ]
		} ]
	}
});
