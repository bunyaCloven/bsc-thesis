Ext.define('Beeride.controller.Crud', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'button[store]' : {
				tap : 'crud'
			},
			'crud' : {
				initialize : 'crudInit',
				show : 'crudShow'
			}
		}
	},
	crud : function(that, e, eOpts) {
		Ext.ComponentQuery.query('main')[0].push({
			xtype : 'crud',
			deleteUrl : that.deleteUrl,
			editUrl : that.editUrl,
			itemId : that._itemId,
			store : that.store,
			paging : that.paging,
			dni : that.dni
		});
	},
	crudInit : function(that, e, eOpts) {
		if (!that.store) {
			return;
		}
		var store = Ext.data.StoreManager.lookup(that.store);
		var proxy = store.getProxy();
		proxy.setExtraParam('username', Beeride.util.Auth.getUsername());
		store.load();
		var plugins = [];
		if (that.paging) {
			plugins = [ {
				xclass : 'Ext.plugin.ListPaging',
				autoPaging : true
			} ];
		}
		that.add({
			xtype : 'list',
			itemTpl : '{name}',
			flex : 1,
			store : store,
			plugins : plugins
		});
		if (!that.dni) {
			that.add({
				xtype : 'listtoolbar',
				form : that.store
			});
		}
	},
	crudShow : function(that, e, eOpts) {
		var store = Ext.data.StoreManager.lookup(that.store);
		var proxy = store.getProxy();
		proxy.setExtraParam('username', Beeride.util.Auth.getUsername());
		store.load();
	}
});