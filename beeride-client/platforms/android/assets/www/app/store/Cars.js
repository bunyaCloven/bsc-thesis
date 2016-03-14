Ext.define('Beeride.store.Cars', {
	extend : 'Ext.data.Store',
	config : {
		model : 'Beeride.model.Path',
		proxy : {
			headers : {
				Authorization : Beeride.util.Auth.get()
			},
			extraParams : {},
			type : 'ajax',
			url : serverAddress + "/cars/all",
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});