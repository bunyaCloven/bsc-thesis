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
			},
			'list[callback]' : {
				itemdoubletap : 'itemdoubletap'
			}
		}
	},
	crud : function(that, e, eOpts) {
		Ext.ComponentQuery.query('main')[0].push({
			xtype : 'crud',
			listCallback : that.listCallback,
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
			plugins : plugins,
			editUrl : that.editUrl,
			callback : that.listCallback
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
	},
	itemdoubletap : function(that) {
		var panel = Ext.create(that.callback);
		var id = that.getSelection()[0].internalId;
		Ext.ComponentQuery.query('main')[0].push(panel);
		Beeride.util.Ajax.load(panel, serverAddress + that.editUrl + '/' + id);
	}
});