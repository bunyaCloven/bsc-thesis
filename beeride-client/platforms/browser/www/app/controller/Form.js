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
			},
			'button#update' : {
				tap : 'update'
			},
			'button#delete' : {
				tap : 'deletex'
			}
		}
	},
	create : function(that) {
		var form = Ext.create('Beeride.form.' + that.up().form);
		form.add({
			xtype : 'formtoolbar'
		});
		Ext.ComponentQuery.query('main')[0].add(form);
	},
	update : function(that) {
		var form = Ext.create('Beeride.form.' + that.up().form);
		var list = that.up('crud').down('list');
		if (!list.getSelection().length) {
			Ext.Msg.alert("", "You need to select something");
			return;
		}
		var id = list.getSelection()[0].internalId;
		var url = serverAddress + that.up('crud').editUrl + '/' + id;
		Beeride.util.Ajax.load(form, url);
		form.add({
			xtype : 'formtoolbar'
		});
		Ext.ComponentQuery.query('main')[0].add(form);
	},
	deletex : function(that) {
		var list = that.up('panel').down('list');
		if (!list.getSelection().length) {
			Ext.Msg.alert("", "you need to select something to delete");
			return;
		}
		var id = list.getSelection()[0].internalId;
		Ext.Ajax.request({
			url : serverAddress + that.up('panel').deleteUrl,
			params : {
				id : id
			},
			callback : function(tho) {
				list.getStore().load();
				list.refresh();
			}
		});
	}
});