Ext.define('Beeride.store.Path', {
	extend : 'Ext.data.Store',
	config : {
		model : 'Beeride.model.Path',
		proxy : {
			headers : {
				Authorization : Beeride.util.Auth.get()
			},
			extraParams : {},
			type : 'ajax',
			url : serverAddress + "/paths",
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});