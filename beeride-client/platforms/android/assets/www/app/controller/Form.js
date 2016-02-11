Ext.define('Beeride.controller.Form', {
	extend : 'Ext.app.Controller',
	requires : 'Ext.Map',
	config : {
		refs : {
			main : 'main'
		},
		control : {
			'button#create' : {
				tap : 'create'
			}
		}
	},
	create : function(that) {
		Ext.ComponentQuery.query('main')[0].add(Ext.create('Beeride.form.'
				+ that.up().form));
	}
});