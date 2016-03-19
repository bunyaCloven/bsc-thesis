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
			doubleClickLoad : that.doubleClickLoad,
			listCallback : that.listCallback,
			searchPage : that.searchPage,
			deleteUrl : that.deleteUrl,
			editUrl : that.editUrl,
			itemId : that._itemId,
			paging : that.paging,
			search : that.search,
			store : that.store,
			dni : that.dni
		});
	},
	crudInit : function(that, e, eOpts) {
		if (!that.store) {
			return;
		}
		var store = Ext.data.StoreManager.lookup(that.store);
		store.currentPage = 1;
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
			editUrl : that.doubleClickLoad,
			callback : that.listCallback
		});
		if (!that.dni) {
			that.add({
				xtype : 'listtoolbar',
				form : that.store
			});
		}
		if (that.search) {
			that.add({
				xtype : 'searchtoolbar',
				form : that.store,
				searchPage : that.searchPage
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