Ext.define('Beeride.controller.Crud', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'button#path' : {
				tap : 'crud'
			},
			'button#car' : {
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
			itemId : that._itemId,
			store : that.store
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
		that.add({
			xtype : 'list',
			itemTpl : '{name}',
			flex : 1,
			store : store
		});
		that.add({
			xtype : 'listtoolbar',
			form : that.store
		});
	},
	crudShow : function(that, e, eOpts) {
		var store = Ext.data.StoreManager.lookup(that.store);
		var proxy = store.getProxy();
		proxy.setExtraParam('username', Beeride.util.Auth.getUsername());
		store.load();
	}
});