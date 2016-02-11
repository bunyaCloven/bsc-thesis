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
		var form = Ext.create('Beeride.form.' + that.up().form);
		form.add({
			xtype : 'formtoolbar'
		});
		Ext.ComponentQuery.query('main')[0].add(form);
	}
});