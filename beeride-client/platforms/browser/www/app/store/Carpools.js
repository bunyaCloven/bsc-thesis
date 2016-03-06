Ext.define('Beeride.store.Carpools', {
	extend : 'Ext.data.Store',
	config : {
		model : 'Beeride.model.Carpool',
		proxy : {
			headers : {
				Authorization : Beeride.util.Auth.get()
			},
			extraParams : {},
			type : 'ajax',
			url : serverAddress + '/carpools/all',
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});