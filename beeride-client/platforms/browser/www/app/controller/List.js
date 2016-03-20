Ext.define('Beeride.controller.List', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'selectfield[mystore]' : {
				initialize : 'listshow'
			},
		}
	},
	listshow : function(that) {
		that.store = Ext.data.StoreManager.lookup(that.mystore);
		that.store.currentPage = 1;
		var proxy = that.store.getProxy();
		proxy.setExtraParam('username', Beeride.util.Auth.getUsername());
		var loaded = that.store.load();
		var data = loaded.data.all;
		var payload = [];
		data.forEach(function(value) {
			payload.push({
				value : value.internalId,
				text : value.data.name
			});
		});
		that.setOptions(payload);
	}
});